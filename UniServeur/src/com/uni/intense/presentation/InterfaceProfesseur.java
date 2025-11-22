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
public interface InterfaceProfesseur extends Remote {
    public String EnregistrerProfesseur(String Matricule_prof, String Nom_prof, String Prenom_prof, String Sexe_prof, String Tel_prof, String Email_prof, String Adresse_prof,String NumrefProf, String DateNaissance_prof, String professionprof, String Etat_prof) throws RemoteException;
      public ArrayList<String> FicheProfesseur(String Id_prof) throws RemoteException; 
       public String[][] ListerProfesseur() throws RemoteException; 
        public String ModifierProfesseur( String Nom_prof,String Prenom_prof,String Tel_prof,String Email_prof,String Adresse_prof,String Etat_prof,String Id_prof)throws RemoteException; 
  public String ModifierUrlPhoto(String Codeprof, String url) throws RemoteException;
    public String ModifierUrldoc(String Codeprof, String url) throws RemoteException;
}
