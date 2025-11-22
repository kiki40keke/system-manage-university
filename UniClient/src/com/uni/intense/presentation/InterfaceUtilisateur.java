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
public interface InterfaceUtilisateur extends Remote {
    
       public String EnregistrerUtilisateur(String codeUser,String nomUser,String motPasse) throws RemoteException; 
       public ArrayList<String> FicheUtilisateur(String code) throws RemoteException; 
       public String[][] ListerUtilisateur() throws RemoteException; 
       public String ModifierUtilisateur(String nomUtilisateur, String MotPasse, String etat, String code) throws RemoteException; 
       public ArrayList<String> FicheLogin(String nomUtilisateur,String MotPasse) throws RemoteException;
       public  String TesteUtilisateur(String nomUtilisateur) throws RemoteException;
       public  String EnregistrerTantative(String nomUser)throws RemoteException;
       public  int CompterTantative(String nomUtilisateur)throws RemoteException;
       public  String BloqueUtilisateur(String nomUtilisateur)throws RemoteException;
       public   int UtilisateurBloque(String nomUtilisateur)throws RemoteException;
       public String EnregistrerConnexion(String CodeUser,String NomUser)throws RemoteException;
       public int CompterConnexion(String CodeUser)throws RemoteException;
        public String ModifierNomUtilisateur( String nomUtilisateur,String code)throws RemoteException;
        public String ModifierPassUtilisateur( String MotPasse,String code)throws RemoteException;
            public   String SupprimerTentative(String NomUser)throws RemoteException;
}
