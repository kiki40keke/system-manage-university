/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uni.intense.presentation;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author jP
 */
public interface IEtudiants extends Remote{
 //
   public String EnregistrerEtudiant( String Nom, String Prenom, String Sexe,String DateNaiss, String Nif, String Adresse, String Email, String Phone,String NomResponsable,String PhoneResponsable,String Vacation,String NomOption)throws RemoteException; 
   public ArrayList<String> FicheEtudiant(String CodeEtud) throws RemoteException; 
   public String ModifierEtudiant(String CodeEtud, String Nom,String Prenom,String adresse,String email,String phone,String nomResponsable,String numeroRefference)throws RemoteException;
   public String SupprimmerEtudiant(String CodeEtud )throws RemoteException;
   // pati ou bezwen an 
   public String[][] ListerEtudiant() throws RemoteException;
      public String ReinscrireEtud(String Niv,String CodeEtud)throws RemoteException;
       public int verifierpaie(String Niv, String CodeEtud,String session)throws RemoteException;
        public String ModifierUrlPhoto(String CodeEtud, String url)throws RemoteException;
}
