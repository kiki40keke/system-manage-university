/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uni.intense.controleur;


import com.uni.intense.application.PalmaresseDal;
import com.uni.intense.application.ServicesCours;
import com.uni.intense.domaine.Palmaresse;
import com.uni.intense.presentation.InterfacePalmares;
import java.rmi.server.UnicastRemoteObject;


import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author kelly
 */


public class PalmaresControlleur extends UnicastRemoteObject implements InterfacePalmares {

    public PalmaresControlleur() throws RemoteException {
        super();
    }
    
    
    @Override
    public String Palmaresse(String NomOption, String  NomCours, String NomVacation, String Promotion) throws RemoteException {
     ServicesCours ser =new ServicesCours();
        String message;
     
        String Idop=     ser.RechercherCodeOption(NomOption);
     
       String Nomc= ser.RechercherCodeCours(NomOption, NomCours);
           
           
        Palmaresse pa=new   Palmaresse(Idop, Nomc, NomVacation, Promotion);
        
        
       PalmaresseDal pad=new PalmaresseDal();
        message=     pad.RechercherCodePlamares(Idop, Nomc, NomVacation, Promotion);
                  System.out.println("le code est :" + message);
        if(message!=null){
        message ="il existe deja un palmares pour le meme option,cours,vacation,Promotion";
        
        }
        else{
        message=  pad.EnregistrerPalmares(pa);
        }

       

      
      return message;
        
    }

    @Override
    public String[][] ListerPalmares(String codepalmares) throws RemoteException {
            PalmaresseDal pad=new PalmaresseDal();
            String [][] liste=pad.ListerPalmares(codepalmares);
            return liste;
    }

    @Override
    public String RechercherCodePalmaresse(String NomOption, String NomCours, String NomVacation, String Promotions) throws RemoteException {
      ServicesCours ser =new ServicesCours();
        
     
        String Idop=     ser.RechercherCodeOption(NomOption);
        
       String Nomc= ser.RechercherCodeCours(NomOption, NomCours);
             
           
        Palmaresse pa=new   Palmaresse(Idop, Nomc, NomVacation, Promotions);
        
        
       PalmaresseDal pad=new PalmaresseDal();
     String    message=     pad.RechercherCodePlamares(Idop, Nomc, NomVacation, Promotions);
              //    System.out.println("le code est :" + message);
         return message;
    }

    @Override
    public ArrayList<String> RechercherPalmares(String codepalmares) throws RemoteException {
        ArrayList<String> Al=new ArrayList<>();
        PalmaresseDal pad=new PalmaresseDal();
        Al=pad.RechercherPalmares(codepalmares);
        return Al;
    }

    @Override
    public String[][] ListerPalmares2() throws RemoteException {
          PalmaresseDal pad=new PalmaresseDal();
          String[][] Palmares=pad.ListerPalmares2();
          return Palmares;
    }
    
}
