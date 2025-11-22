/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uni.intense.controleur;

import com.uni.intense.application.UtilisateurDal;
import com.uni.intense.domaine.Utilisateur;
import java.rmi.server.UnicastRemoteObject;

import com.uni.intense.presentation.InterfaceUtilisateur;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author kelly
 */
public class ControlleurUtilisateur extends UnicastRemoteObject implements InterfaceUtilisateur {

    public ControlleurUtilisateur() throws RemoteException {
        super();
    }

    @Override
    public String EnregistrerUtilisateur(String codeUser,String nomUser,String motPasse) throws RemoteException {
   String message=null;
     
        UtilisateurDal dal=new UtilisateurDal ();
        String code=dal.RechercherCodeEmployer(codeUser);
        if(code!=null){
        message="Un Compte a ete deja Creer pour cet Employer";
        }
        else{
          Utilisateur Pro=new Utilisateur(codeUser, nomUser, motPasse);
         message=dal.EnregistrerUtilisateur(Pro);
        }
        return message;
    }

    @Override
    public ArrayList<String> FicheUtilisateur(String code) throws RemoteException {
        Utilisateur Pro=new Utilisateur();
         UtilisateurDal dal=new UtilisateurDal ();
         ArrayList<String> FicheUtilisateur=new ArrayList<>();
           dal.RechercherUtilisateur(code, Pro);
           FicheUtilisateur.add(Pro.getCodeUser());
         FicheUtilisateur.add(Pro.getNomUser());
         FicheUtilisateur.add(Pro.getMotPasse());
         FicheUtilisateur.add(Pro.getEtat());
         return FicheUtilisateur;
    }

    @Override
    public String[][] ListerUtilisateur() throws RemoteException {
         UtilisateurDal dal=new UtilisateurDal ();
         String[][] ListerUtilisateur=dal.ListerUtilisateur();
         return ListerUtilisateur;
         
    }

    @Override
    public String ModifierUtilisateur(String nomUtilisateur, String MotPasse, String etat, String code) throws RemoteException {
         UtilisateurDal dal=new UtilisateurDal ();
         String message=dal.ModifierUtilisateur(nomUtilisateur, MotPasse, etat, code);
         return message;
    }

    @Override
    public ArrayList<String> FicheLogin(String nomUtilisateur, String MotPasse) throws RemoteException {
     Utilisateur Pro=new Utilisateur();
         UtilisateurDal dal=new UtilisateurDal ();
         ArrayList<String> FicheLogin=new ArrayList<>();
           dal.Rechercherlogin(nomUtilisateur, MotPasse, Pro);
           FicheLogin.add(Pro.getCodeUser());
       
         FicheLogin.add(Pro.getNomUser());
         FicheLogin.add(Pro.getMotPasse());
         FicheLogin.add(Pro.getEtat());
         return FicheLogin;  
    }

    @Override
    public String EnregistrerTantative(String nomUser) throws RemoteException {
         String message = null;
           UtilisateurDal dal = new UtilisateurDal();
           message = dal.EnregistrerTantative(nomUser);
           return message;
    }

    @Override
    public int CompterTantative(String nomUtilisateur) throws RemoteException {
UtilisateurDal dal = new UtilisateurDal();
           int mes = dal.CompterTantative(nomUtilisateur);
           return mes;
    }

    @Override
    public String BloqueUtilisateur(String nomUtilisateur) throws RemoteException {
        UtilisateurDal dal = new UtilisateurDal();
           String message = dal.BloqueUtilisateur(nomUtilisateur);
           return message;
    }

   

    @Override
    public String TesteUtilisateur(String nomUtilisateur) throws RemoteException {
        UtilisateurDal dal = new UtilisateurDal();
           String mes = dal.TestUtilisateur(nomUtilisateur);
           return mes;
    }

    @Override
    public int UtilisateurBloque(String nomUtilisateur) throws RemoteException {
       UtilisateurDal dal = new UtilisateurDal();
           int mes = dal.UtilisateurBloque(nomUtilisateur);
           return mes;
    }

    @Override
    public String EnregistrerConnexion(String CodeUser, String NomUser) throws RemoteException {
            UtilisateurDal dal = new UtilisateurDal();
            String mes = dal.EnregistrerConnexion(CodeUser, NomUser);
           return mes;
    }

    @Override
    public int CompterConnexion(String CodeUser) throws RemoteException {
           UtilisateurDal dal = new UtilisateurDal();
           int mes = dal.CompterConnexion(CodeUser);
           return mes;
    }

    @Override
    public String ModifierNomUtilisateur(String nomUtilisateur, String code) throws RemoteException {
      UtilisateurDal dal = new UtilisateurDal();
            String mes = dal.ModifierNomUtilisateur(nomUtilisateur, code);
           return mes;
    }

    @Override
    public String ModifierPassUtilisateur(String MotPasse, String code) throws RemoteException {
         UtilisateurDal dal = new UtilisateurDal();
            String mes = dal.ModifierPassUtilisateur(MotPasse, code);
           return mes;
    }

    @Override
    public String SupprimerTentative(String NomUser) throws RemoteException {
           UtilisateurDal dal = new UtilisateurDal();
            String mes = dal.SupprimerTentative(NomUser);
           return mes;
    }
    
}
