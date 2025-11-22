/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uni.intense.controleur;

import com.uni.intense.application.EtudiantsDal;
import com.uni.intense.application.PaiementDal;
import com.uni.intense.application.ServicesCours;
import com.uni.intense.domaine.Etudiants;
import com.uni.intense.domaine.Paiement;
import java.rmi.server.UnicastRemoteObject;

import com.uni.intense.presentation.InterfacePaiement;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author kelly
 */
public class ControlleurPaiement extends UnicastRemoteObject implements InterfacePaiement {

    public ControlleurPaiement() throws RemoteException {
        super();
    }

    @Override
    public String EnregistrerPaiement(String Nom_Opt, double fraisInscription, double fraisDentres, double fraisSession) throws RemoteException {
  String message="";
        ServicesCours ser =new ServicesCours();
        String Idop=     ser.RechercherCodeOption(Nom_Opt);
        System.out.println(Nom_Opt);
        System.out.println(Idop);
          Paiement pai=new Paiement();
          
        PaiementDal dal=new PaiementDal();
         dal.RechercherPaiement2(Idop, pai);
         String codepc=pai.getCodepc();
         if(codepc==null){
              Paiement paie=new Paiement(Idop, fraisInscription, fraisDentres, fraisSession);
             message=dal.EnregistrerPaiement(paie);
         }
         else{
             System.out.println(codepc);
         message="Une modalide de cette Option existe deja vous pouvez la modifier";
         }
   return message;
    }

    @Override
    public ArrayList<String> FichePaiement(String codepc) throws RemoteException {
   ArrayList Fiche=new ArrayList();
    ServicesCours ser =new ServicesCours();
         Paiement paie=new Paiement();
        PaiementDal dal=new PaiementDal();
        dal.RechercherPaiement(codepc, paie);
        Fiche.add(paie.getCodepc());
        String Id_Opt=paie.getId_Opt();
        String Nom_Opt=ser.RechercherNomOptions(Id_Opt);
        Fiche.add(Nom_Opt);
        System.out.println(paie.getCodepc());
        Fiche.add(paie.getFraisInscription());
        Fiche.add(paie.getFraisDentres());
        Fiche.add(paie.getFraisSession());
        Fiche.add(paie.getDateenreg());
        
        return Fiche;
        
    }

    @Override
    public String[][] ListerPaiement() throws RemoteException {
         PaiementDal dal=new PaiementDal();
         String[][] ListerPaiement=dal.ListerPaiement();
         return ListerPaiement;
    }

    @Override
    public String ModifierPaiement(String Nom_Opt, String Dateenreg, double fraisInscription, double fraisDentres, double fraisSession) throws RemoteException {
        String message="";
        ServicesCours ser =new ServicesCours();
    String Id_Opt=ser.RechercherCodeOption(Nom_Opt);   
             Paiement paie=new Paiement();
        PaiementDal dal=new PaiementDal();
     
         dal.RechercherPaiement2(Id_Opt, paie);
         String codepc2=paie.getCodepc();
         String Id_Opt2=paie.getId_Opt();
         double fraisInscription2=paie.getFraisInscription();
         double fraisDentres2 =paie.getFraisDentres();
         double fraisSession2=paie.getFraisSession();
         String Dateenreg2=paie.getDateenreg();
         
         
        int verif=dal.EnregistrerAncien(codepc2, Id_Opt2, Dateenreg2, fraisInscription2, fraisDentres2, fraisSession2);
        if(verif==1){
          message=dal.ModifierPaiement(codepc2, fraisInscription, fraisDentres, fraisSession);
        }
        
        else{
        message="modification echouer";
        }
            
             return message;
    }

    @Override
    public ArrayList<String> FichePaiement2(String Nom_Opt) throws RemoteException {
     ArrayList Fiche=new ArrayList();
    ServicesCours ser =new ServicesCours();
    String Id_Opt=ser.RechercherCodeOption(Nom_Opt);
         Paiement paie=new Paiement();
        PaiementDal dal=new PaiementDal();
        dal.RechercherPaiement2(Id_Opt, paie);
        Fiche.add(paie.getCodepc());
        Id_Opt=paie.getId_Opt();
         Nom_Opt=ser.RechercherNomOptions(Id_Opt);
        Fiche.add(Nom_Opt);
        System.out.println(paie.getCodepc());
        Fiche.add(paie.getFraisInscription());
        Fiche.add(paie.getFraisDentres());
        Fiche.add(paie.getFraisSession());
        Fiche.add(paie.getDateenreg());
        
        return Fiche;
    }

    @Override
    public String enregTransfert(String Id_Etud, double momtant) throws RemoteException {
        String message="";
            Etudiants Etud=new Etudiants();
           EtudiantsDal etd=new EtudiantsDal();
           etd.RechercherEudiant(Id_Etud,Etud);
           Id_Etud=Etud.getCodeEtud();
          if(Id_Etud!=null){
          PaiementDal dal=new PaiementDal();
          String CodeCompte=dal.RechercherCodeCompte(Id_Etud);  
          if(CodeCompte!=null){
              String Niv=Etud.getNiveau();
             int nivs=Integer.parseInt(Niv);
               double Solde=Double.valueOf( dal.RechercherSolde(CodeCompte));
    double Totalfrais=Double.valueOf(dal.RechercherSommation(Id_Etud))*nivs;
    if(Solde==Totalfrais){
    message="La reglementation de paiement pour cette eleve est terminer";
    }
   
    else   if(Solde<Totalfrais){
        double reste=Totalfrais-Solde;
        if(momtant<reste){
        dal.enregTransfert(CodeCompte, momtant);
         
             double montant3=Solde+momtant;
              dal.ModifierMontant(CodeCompte, montant3);
              message="Ce depot A ete Enregestre avec Succes";
        }
        
        else{
         message="Ce Montant est trop eleve Car la balance de cet etudiant pour son niveau actuelle est de "+reste;
        }

    }
        
    else{message="Une Erreur de paiemnt";} 
             
          }
          else{
            message="Ce Compte n'existe pas";
          }
          }
          
          else{
          message="Le code de cet etudiant est incorrect";
          }
           System.out.println(message);
           return message;
    }

    @Override
    public String[][] ListerAncienPaiement() throws RemoteException {
         String req1="Select count(*) as nombre from ancienpaiment";
            String req="Select P.codepc, O.Nom_Opt, P.FraisInscription,P.fraisDentres, P. FraisSession, P.dateenregmodif from AncienPaiment P,Options O where P.Id_Opt=O.Id_Opt";
     PaiementDal dal=new PaiementDal();
     String[][] ListerAncienPaiement=dal.ListerAncienPaiement(req, req1);
     return ListerAncienPaiement;
    }

    @Override
    public String[][] ListerAncienPaiementparopt(String NomOptions) throws RemoteException {
             ServicesCours ser =new ServicesCours();
    String Id_Opt=ser.RechercherCodeOption(NomOptions);  
        //System.out.println(Id_Opt);
        String req1="Select count(*) as nombre from ancienpaiment where Id_Opt='"+Id_Opt+"'";
            String req="Select P.codepc, O.Nom_Opt, P.FraisInscription,P.fraisDentres, P. FraisSession, P.dateenregmodif from AncienPaiment P,Options O where P.Id_Opt=O.Id_Opt and P.Id_Opt='"+Id_Opt+"' ";
     PaiementDal dal=new PaiementDal();
     String[][] ListerAncienPaiement=dal.ListerAncienPaiement(req, req1);
     return ListerAncienPaiement;
    }

    @Override
    public String[][] Listertransactions() throws RemoteException {
    PaiementDal dal=new PaiementDal();
         String[][] ListerPaiement=dal.Listertransactions();
         return ListerPaiement;
    }

    @Override
    public String[][] ListertransactionsEtudiant(String IdEtud) throws RemoteException {
        PaiementDal dal=new PaiementDal();
         String[][] ListerPaiement=dal.ListertransactionsEtudiant(IdEtud);
         return ListerPaiement;
    }
    
}
