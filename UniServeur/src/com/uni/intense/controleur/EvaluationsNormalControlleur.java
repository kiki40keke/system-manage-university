/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uni.intense.controleur;


import com.uni.intense.application.EvaluationsNormalDal;
import com.uni.intense.application.PalmaresseDal;
import com.uni.intense.domaine.EvaluationsNormal;
import com.uni.intense.domaine.Palmaresse;
import com.uni.intense.presentation.InterfaceEvaluationsNormal;
import java.rmi.server.UnicastRemoteObject;


import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author kelly
 */
public class EvaluationsNormalControlleur extends UnicastRemoteObject implements InterfaceEvaluationsNormal {

    public EvaluationsNormalControlleur() throws RemoteException {
        super();
    }

    @Override
    public String EnregistrerEvaluation(String Codepalmares, String TypesNormal, String DescriptionsNormal, int CoeficientNormal) throws RemoteException {
        String message="";
    Palmaresse pal=new Palmaresse();
        PalmaresseDal palm=new PalmaresseDal();
        palm.RechercherPlamares(Codepalmares, pal);
        String gett=pal.getCodepalmares();
              
        if (gett!=null){
            
       
           EvaluationsNormal eval=new EvaluationsNormal(Codepalmares, TypesNormal, DescriptionsNormal, CoeficientNormal);
       EvaluationsNormalDal evd=new EvaluationsNormalDal();
     String Nombre=  evd.RechercherSommationcoef(Codepalmares);
        String CodeEvaluation= evd.RechercherCodeEvaluation(Codepalmares, TypesNormal, DescriptionsNormal);
        String Nom_Cours=evd.RechercherNomcours(Codepalmares);
                String Nom_Opt=evd.RechercherNomOption(Codepalmares);
        
        if(CodeEvaluation!=null){
           message=" Concernant le cours "+Nom_Cours+ " de l'option "+Nom_Opt +
                   "\n il existe deja une Evaluation qui est de type " +TypesNormal +" et de description "+ DescriptionsNormal+ 
                   " \n Veuillez changez le type ou la description";
        }
  else   if(Nombre==null){
        // System.out.println("nombre la null");
       String  messaga=  evd.EnregistrerEvaluation(eval);
                Nombre=  evd.RechercherSommationcoef(Codepalmares);
                String plus="\n votre total de coefficiente pour le cours de " +Nom_Cours+" dans l'option "+Nom_Opt+"  est : "+Nombre+" sur 100";
                message=messaga+plus;
     }
     else{
           int coefficient=Integer.parseInt(Nombre);
     int reste=100-coefficient;
     
     if(reste>= CoeficientNormal){
        // System.out.println("li ka pase");
        String  messaga=  evd.EnregistrerEvaluation(eval);
                Nombre=  evd.RechercherSommationcoef(Codepalmares);
                String plus="\n votre total de coefficiente pour le cours de " +Nom_Cours+" dans l'option "+Nom_Opt+"  est : "+Nombre+" sur 100";
                message=messaga+plus;
     }
     else{
  //   System.out.println("li pa  ka pase");
     message="vous avez deja enregistrer plusieurs evaluations le coefficient restant est : " +reste;
     }
     
    
     }
   
     
    
        }
        else {
        message="le code du Palmaresse est introuvable";
        }
       
     
          
       return message;
    }

    @Override
    public ArrayList<String> RechercherEvaluation(String codeEvaluationsNormal) throws RemoteException {
      ArrayList<String> Al=new ArrayList<>();
        EvaluationsNormalDal dal=new EvaluationsNormalDal();
        Al=dal.RechercherEvaluation(codeEvaluationsNormal);
        return Al;
    }

    @Override
    public String[][] ListerNotes(String codeEvaluationsNormal) throws RemoteException {
           EvaluationsNormalDal dal=new EvaluationsNormalDal();
           String data[][] = dal.ListerNotes(codeEvaluationsNormal);
           return data;
           
    }

    @Override
    public String[][] ListerEvaluation() throws RemoteException {
        EvaluationsNormalDal dal=new EvaluationsNormalDal();
           String data[][] = dal.ListerEvaluation();
           return data;
    }

    @Override
    public String RechercherCodeEvaluation(String Codepalmares, String TypesNormal, String DescriptionsNormal) throws RemoteException {
  EvaluationsNormalDal dal=new EvaluationsNormalDal();
  String CodeEvaluation=dal.RechercherCodeEvaluation(Codepalmares, TypesNormal, DescriptionsNormal);
  return CodeEvaluation;
    }
    
}
