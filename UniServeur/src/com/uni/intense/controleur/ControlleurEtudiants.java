/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uni.intense.controleur;

import com.uni.intense.domaine.Etudiants;
import com.uni.intense.application.EtudiantsDal;
import com.uni.intense.application.NoteDal;
import com.uni.intense.application.PaiementDal;
import com.uni.intense.application.ServicesCours;
import com.uni.intense.presentation.IEtudiants;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.ArrayList;
/**
 *
 * @author jP
 */
public class ControlleurEtudiants extends UnicastRemoteObject implements IEtudiants{
     public ControlleurEtudiants()throws RemoteException{super();}

    @Override
    public String EnregistrerEtudiant(String Nom, String Prenom, String Sexe, String DateNaiss, String Nif, String Adresse, String Email, String Phone,
            String NomResponsable, String PhoneResponsable, String Vacation, String NomOption) throws RemoteException {
       String message;
        Etudiants Etu=new Etudiants(); 
        EtudiantsDal etd=new EtudiantsDal();
            String req1="Select Id_Etud,Nom_Etud,Prenom_Etud,sexe,datNaiss,nif,adresse,email,phone,nomResponsable,numeroRefference,NomVacation,Nom_Opt"
                    + ",promotion,codeniv from Etudiant natural join options where nif='"+Nif+"' and Nom_Opt='"+NomOption+"'";
        String req2="Select Id_Etud,Nom_Etud,Prenom_Etud,sexe,datNaiss,nif,adresse,email,phone,nomResponsable,numeroRefference,NomVacation,Nom_Opt,promotion,codeniv"
                + " from Etudiant natural join options where nif='"+Nif+"' and NomVacation='"+Vacation+"'";

        etd.RechercherNifEudiant(req1, Etu);
         String code1=Etu.getCodeEtud();
        etd.RechercherNifEudiant(req2, Etu); 
         String code2=Etu.getCodeEtud();
          
         if(code1!=null){
          message="Cet Etudiant est deja inscrit dans la meme option nous avons pu l'indentifier grace a son nif";
          }
           
       else if(code2!=null){
          message="Cet Etudiant est deja inscrit dans une autre option de la meme vacation, veulleiz chnagez la vacation nous avons pu l'indentifier grace a son nif";
          }
     
       else{
         //  message="li ka enskri";
        ServicesCours ser =new ServicesCours();
        String Idop=     ser.RechercherCodeOption(NomOption);
        Etudiants Etud=new Etudiants(Nom,Prenom,Sexe,DateNaiss,Nif,Adresse,Email,Phone,NomResponsable,PhoneResponsable,Vacation,Idop);
       
       message=  etd.EnregistreEtudiant(Etud);
       }
       
      return  message;
    }

    @Override
    public ArrayList<String> FicheEtudiant(String CodeEtud) throws RemoteException {
        ArrayList Fiche=new ArrayList();
          Etudiants Etud=new Etudiants();
           EtudiantsDal etd=new EtudiantsDal();
           
           etd.RechercherEudiant(CodeEtud,Etud);
           Fiche.add(Etud.getCodeEtud());
           Fiche.add(Etud.getNom());
           Fiche.add(Etud.getPrenom());
           Fiche.add(Etud.getSexe());
           Fiche.add(Etud.getDateNaiss());
           String nif= Etud.getNif();
           Fiche.add(nif);
           Fiche.add(Etud.getAdresse());
           Fiche.add(Etud.getEmail());
           String phone= Etud.getPhone();
           Fiche.add(phone);
           
           Fiche.add(Etud.getNomResponsable());
           String phoneRes=Etud.getPhoneResponsable();
           Fiche.add(phoneRes);
           
           Fiche.add(Etud.getVacation());
           Fiche.add(Etud.getNomOption());
           Fiche.add(Etud.getPromotion());
           Fiche.add(Etud.getNiveau());
           Fiche.add(Etud.getUrl());
          
          return Fiche;
    }


    @Override
    public String SupprimmerEtudiant(String CodeEtud) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[][] ListerEtudiant() throws RemoteException {
        EtudiantsDal etd=new EtudiantsDal();
        String[][] ListerEtudiant=etd.ListerEtudiant();
        return ListerEtudiant;
    }

    @Override
    public String ModifierEtudiant(String CodeEtud, String Nom,String Prenom,String adresse,String email,String phone,String nomResponsable,String numeroRefference) throws RemoteException {
          EtudiantsDal etd=new EtudiantsDal();
     String message=  etd.ModifierEtudiant(CodeEtud, Nom, Prenom, adresse, email, phone, nomResponsable, numeroRefference);
      return  message;
    }

    @Override
    public String ReinscrireEtud(String Niv, String CodeEtud) throws RemoteException {
    //To change body of generated methods, choose Tools | Templates.
           
               Etudiants Etud = new Etudiants();
               EtudiantsDal etd = new EtudiantsDal();

               etd.RechercherEudiant(CodeEtud, Etud);
               String nomvacation = Etud.getVacation();
               String promotion = Etud.getPromotion();
      String message=null;
               NoteDal d=new NoteDal();
               int nombre = d.RechercherBulletin2(Niv,CodeEtud,nomvacation,promotion);

               if (nombre >= 3)
               {
                   message = "L'etudiant n'est pas admissible pour passer au niveau superieur car il a un maximum de 3 reprises ";
               }
               else
               {
                   // message = "L'etudiant est  admissible pour passer au niveau superieur car il a un minimum de 3 reprises " +nombre;
                      int nivs=Integer.parseInt(Niv);

                      if (nivs < 5)
                      {
                       PaiementDal dal = new PaiementDal();
                          String codeCompte = dal.RechercherCodeCompte(CodeEtud);
                          if (codeCompte != null)
                          {
                              double Solde = Double.parseDouble(dal.RechercherSolde(codeCompte));
                              double Totalfrais = Double.parseDouble(dal.RechercherSommation(CodeEtud)) * nivs;
                              int ses2 = Integer.parseInt(dal.RechercherFrais(CodeEtud));

                              if (Solde < Totalfrais)
                              {
                                  double reste = Totalfrais - Solde;
                                  message = "L'etudiant ne peut pas inscrire au niveau superieur car il a une balance de " + reste;
                              }

                              else if (Solde == Totalfrais)
                              {
                                  //double reste=Totalfrais-Solde;
                                  // message="L'etudiant est aquite car il a une balance de "+reste;

                                  int nivs2 = nivs + 1;
                                  String niv3 = String.valueOf(nivs2); 

                             
                                  message = etd.ReinscrireEtud(niv3, CodeEtud);
                              }



                          }

                          else
                          {
                              message = "Ce Compte n'existe pas";
                          }
                      }
                      else
                      {
                          message = "Cette Etudiant est deja au niveau 5";

                      }
               }
       return message; 
    }

    @Override
    public int verifierpaie(String Niv, String CodeEtud, String session) throws RemoteException {
  int permis = 0;
               //To change body of generated methods, choose Tools | Templates.
               String message = "";
               int nivs = Integer.parseInt(Niv);
               int ses = Integer.parseInt(session);
               
                   PaiementDal dal = new PaiementDal();
                   String codeCompte = dal.RechercherCodeCompte(CodeEtud);
                   if (codeCompte != null)
                   {
                       double Solde = Double.parseDouble(dal.RechercherSolde(codeCompte));
                       double Totalfrais = Double.parseDouble(dal.RechercherSommation(CodeEtud)) * nivs;
                       int ses2 = Integer.parseInt(dal.RechercherFrais(CodeEtud));
                       if(ses==2){
                           if (Solde < Totalfrais)
                           {
                               double reste = Totalfrais - Solde;
                               message = "L'etudiant ne peut pas inscrire au niveau superieur car il a une balance de " + reste;
                               permis = 0;
                           }

                           else if (Solde >= Totalfrais)
                           {
                               permis = 1;
                           }
                       }

                       else if(ses==1){
                      
                         
                           if (Solde < Totalfrais-ses2)
                           {
                               double reste = Totalfrais - Solde;
                               message = "L'etudiant ne peut pas inscrire au niveau superieur car il a une balance de " + reste;
                               permis = 0;
                           }

                           else if (Solde >= Totalfrais-ses2)
                           {
                               permis = 1;
                           }
                       
                       }
                      



                   }

                   else
                   {
                       permis = 2;
                       message = "Ce Compte n'existe pas";
                   }
               
              

               return permis;
    }

    @Override
    public String ModifierUrlPhoto(String CodeEtud, String url) throws RemoteException {
       EtudiantsDal dal=new EtudiantsDal();
      String g= dal.ModifierUrlPhoto(CodeEtud, url);
       return g;
    }

  

   
}
