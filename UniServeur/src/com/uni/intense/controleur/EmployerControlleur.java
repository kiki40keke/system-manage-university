/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uni.intense.controleur;

import com.uni.intense.application.EmployerDal;
import com.uni.intense.application.ProfesseurDal;
import com.uni.intense.domaine.Employe;
import com.uni.intense.domaine.Professeur;
import java.rmi.server.UnicastRemoteObject;

import com.uni.intense.presentation.InterfaceEmployer;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author kelly
 */
public class EmployerControlleur extends UnicastRemoteObject implements InterfaceEmployer {

    public EmployerControlleur() throws RemoteException {
        super();
    }
    
    

    @Override
    public String EnregistrerEmployer(String nom, String prenom, String sexe, String nif, String adresse, String telephone, String email, String dateNaissance, String statut, String fonction, int salaire) throws RemoteException {
         Employe Pro=new Employe(nom, prenom, sexe, nif, adresse, telephone, email, dateNaissance, statut, fonction, salaire);
        EmployerDal Prodal=new EmployerDal();
     String message=  Prodal.EnregistrerEmployer(Pro);
     return message;
    }

    @Override
    public ArrayList<String> FicheEmployer(String code) throws RemoteException {
         Employe Pro=new Employe();
             ArrayList Fiche=new ArrayList();
                 EmployerDal Prodal=new EmployerDal();
                 Prodal.RechercherEmployer(code, Pro);
                 Fiche.add(Pro.getCode());
                 Fiche.add(Pro.getNom());
                 Fiche.add(Pro.getPrenom());
                 Fiche.add(Pro.getSexe());
                 Fiche.add(Pro.getNif());
                 Fiche.add(Pro.getAdresse());
                  Fiche.add(Pro.getTelephone());
                 Fiche.add(Pro.getEmail());
                
                 Fiche.add(Pro.getDateNaissance());
                 Fiche.add(Pro.getStatut());
                 Fiche.add(Pro.getFonction());
                 Fiche.add(Pro.getSalaire());
                 Fiche.add(Pro.getUrl());
                 Fiche.add(Pro.getUrldoc());
                 return Fiche;
    }

    @Override
    public String[][] ListerEmployer() throws RemoteException {
 EmployerDal Prodal=new EmployerDal();
 String[][] ListerEmployer=Prodal.ListerEmployer();
 return ListerEmployer;
    }

    @Override
    public String ModifierEmployer(String nom, String prenom, String telephone, String email, String adresse, String Statut,int salaire, String code) throws RemoteException {
        EmployerDal Prodal=new EmployerDal();
      String message=  Prodal.ModifierEmployer(nom, prenom, telephone, email, adresse, Statut,salaire, code);
      return message;
    }

    @Override
    public ArrayList<String> remplirCombofonction() throws RemoteException {
 EmployerDal Prodal = new EmployerDal();
            ArrayList Fiche = new ArrayList();
            Fiche = Prodal.remplirCombofonction();
            return Fiche;
        
    }

    @Override
    public ArrayList<String> recherchersalaire(String nomfonction) throws RemoteException {
      EmployerDal Prodal = new EmployerDal();
            ArrayList Fiche = new ArrayList();
            Fiche = Prodal.recherchersalaire(nomfonction);
            return Fiche;
    }

    @Override
    public String ModifierUrlPhoto(String Codeprof, String url) throws RemoteException {
        EmployerDal Prodal = new EmployerDal();
     return   Prodal.ModifierUrlPhoto(Codeprof, url);
    }

    @Override
    public String ModifierUrldoc(String Codeprof, String url) throws RemoteException {
        EmployerDal Prodal = new EmployerDal();
     return   Prodal.ModifierUrldoc(Codeprof, url);
    }
    
}
