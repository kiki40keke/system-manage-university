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
public interface InterfaceEmployer extends Remote {
    
     public String EnregistrerEmployer(String nom,String prenom,String sexe,String nif,String adresse,String telephone,String email,String dateNaissance,String statut,String fonction,int salaire)throws RemoteException; 
       public ArrayList<String> FicheEmployer(String code) throws RemoteException; 
       public String[][] ListerEmployer() throws RemoteException; 
        public String ModifierEmployer(String nom,String prenom,String telephone,String email,String adresse,String Statut,int salaire, String code)throws RemoteException; 
         public  ArrayList<String> remplirCombofonction() throws RemoteException;
                public  ArrayList<String> recherchersalaire(String nomfonction) throws RemoteException;
                 public String ModifierUrlPhoto(String Codeprof, String url) throws RemoteException;
                   public String ModifierUrldoc(String Codeprof, String url) throws RemoteException;
}
