/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.uni.intense.presentation;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author kelly
 */
public interface InterfacePaiement extends Remote {
      public String EnregistrerPaiement(String Nom_Opt, double fraisInscription, double fraisDentres, double fraisSession) throws RemoteException;
      public ArrayList<String> FichePaiement(String codepc) throws RemoteException;
        public ArrayList<String> FichePaiement2(String Nom_Opt) throws RemoteException;
       public String[][] ListerPaiement() throws RemoteException; 
        public String ModifierPaiement(String Nom_Opt,String Dateenreg,double fraisInscription, double fraisDentres, double fraisSession)throws RemoteException; 
           public String enregTransfert(String Id_Etud, double momtant)throws RemoteException; 
           public String[][] ListerAncienPaiement() throws RemoteException; 
          public String[][] ListerAncienPaiementparopt(String NomOptions) throws RemoteException; 
            public String[][] Listertransactions()throws RemoteException; 
             public String[][] ListertransactionsEtudiant(String IdEtud)throws RemoteException;  
         
}
