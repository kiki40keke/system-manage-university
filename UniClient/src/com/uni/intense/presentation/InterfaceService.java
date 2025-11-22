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
public interface InterfaceService extends Remote {
      public String EnregistrerOption(String Nom_Opt) throws RemoteException;
      public String EnregistrerCours(String Nom_Opt,String codeniv,String codesession,String Nomcours) throws RemoteException;
    public  ArrayList<String> remplirComboOptions() throws RemoteException;
      public  ArrayList<String> remplirComboCours(String Nom_Opt,String Niveau,String Session) throws RemoteException;
       public String EnregistrerCoursSelectionner(String IdProfesseur,String Nom_Opt, String Nom_Cours,String Vacation)throws RemoteException;
        public String[] remplirlisetecours(String Id_prof)throws RemoteException;
        public String[][] ListerOptions() throws RemoteException;
           public  String[][] ListerCours() throws RemoteException;
            public String InformationCoursSelect(String codecs) throws RemoteException;
                public String SuprimmerAttributionCours(String codecs) throws RemoteException;
                 public  ArrayList<String> remplirComboPromotion() throws RemoteException;
}


