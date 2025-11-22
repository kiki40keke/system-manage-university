/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uni.intense.controleur;

import com.uni.intense.application.ServicesCours;
import com.uni.intense.presentation.InterfaceService;
import java.rmi.server.UnicastRemoteObject;


import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author kelly
 */
public class ServicesControleur extends UnicastRemoteObject implements InterfaceService {
public ServicesControleur() throws RemoteException{
    super();
}
    @Override
    public ArrayList<String> remplirComboOptions() {
     ArrayList<String> Al;
    ServicesCours ser=new ServicesCours();
   Al= ser.remplirComboOptions();
    return Al;
    }

    @Override
    public ArrayList<String> remplirComboCours(String Nom_Opt,String Niveau,String Session) throws RemoteException {
      ArrayList<String> Al;
    ServicesCours ser=new ServicesCours();
    String Id_Opt=ser.RechercherCodeOption(Nom_Opt);
   Al= ser.remplirComboCours(Id_Opt, Niveau, Session);
    return Al;
    }

    @Override
    public String EnregistrerCoursSelectionner(String IdProfesseur,String Nom_Opt, String Nom_Cours,String Vacation) throws RemoteException {
      String message="";
        ServicesCours ser=new ServicesCours();
   String Idcours=ser.RechercherCodeCours(Nom_Opt, Nom_Cours);
     if("nada".equals(Idcours)){
         
       message="ce cours n'existe pas";
       }
     else{
        String codecs=ser.RechercherAttributionCours(Idcours, Vacation);
        if(codecs==null){
        message=ser.EnregistrerCoursSelectionner(IdProfesseur, Nom_Opt, Nom_Cours,Vacation);
        }
        else{
               message="il extiste deja un professeur qui dispense ce cours dans la meme option et dans la  meme vacation";
        }
      
     }
   
   
   
   return message;
    }

   

    @Override
    public String[] remplirlisetecours(String Id_prof) throws RemoteException {
       ServicesCours ser=new ServicesCours();
       String [] bd=ser.remplirlisetecours(Id_prof);
       return bd;
    }

    @Override
    public String EnregistrerOption(String Nom_Opt) throws RemoteException {
            String message;
        ServicesCours ser=new ServicesCours(); 
       String Verfif=ser.RechercherCodeOption(Nom_Opt);
       if(  !"nada".equals(Verfif)){
       message="Il existe deja un option qui le meme nom";
       }
       else{
        message=ser.EnregistrerOption(Nom_Opt);
       }
       return message;
    }

    @Override
    public String EnregistrerCours(String Nom_Opt, String codeniv, String codesession,String Nomcours) throws RemoteException {
      String message;
        ServicesCours ser=new ServicesCours(); 
       String Verfif=ser.RechercherCodeCours(Nom_Opt, Nomcours);
        if(!"nada".equals(Verfif)){
       message="Il existe deja un Cours qui a le meme nom";
       }
        else{
       String Id_Opt=ser.RechercherCodeOption(Nom_Opt); 
        message=ser.EnregistrerCours(Id_Opt, codeniv, codesession, Nomcours);
        }
       return message;
    }

    @Override
    public String[][] ListerOptions() throws RemoteException {
        ServicesCours ser=new ServicesCours(); 
        String[][] ListerOptions=ser.ListerOptions();
        return ListerOptions;
    }

    @Override
    public String[][] ListerCours() throws RemoteException {
           ServicesCours ser=new ServicesCours(); 
        String[][] ListerCours=ser.ListerCours();
        return ListerCours;
    }

    @Override
    public String InformationCoursSelect(String codecs) throws RemoteException {
                 ServicesCours ser=new ServicesCours(); 
                 String mes=ser.InformationCoursSelect(codecs);
                 return  mes;
    }

    @Override
    public String SuprimmerAttributionCours(String codecs) throws RemoteException {
          ServicesCours ser=new ServicesCours(); 
          String mes=ser.SuprimmerAttributionCours(codecs);
          return mes;
    }

    @Override
    public ArrayList<String> remplirComboPromotion() throws RemoteException {
     ArrayList<String> Al;
    ServicesCours ser=new ServicesCours();
   Al= ser.remplirComboPromotion();
    return Al;
    }

    
   
    
}
