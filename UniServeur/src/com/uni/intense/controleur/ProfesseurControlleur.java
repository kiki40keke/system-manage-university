/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uni.intense.controleur;


import com.uni.intense.application.ProfesseurDal;
import com.uni.intense.domaine.Professeur;
import com.uni.intense.presentation.InterfaceProfesseur;
import java.rmi.server.UnicastRemoteObject;


import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author kelly
 */
public class ProfesseurControlleur extends UnicastRemoteObject implements InterfaceProfesseur {
    
    public ProfesseurControlleur() throws RemoteException{
        super();
    }

    @Override
    public String EnregistrerProfesseur(String Matricule_prof, String Nom_prof, String Prenom_prof, String Sexe_prof, String Tel_prof, String Email_prof, String Adresse_prof,String NumrefProf, String DateNaissance_prof, String professionprof, String Etat_prof) throws RemoteException {
       Professeur Pro=new Professeur(Matricule_prof, Nom_prof, Prenom_prof, Sexe_prof, Tel_prof, Email_prof, Adresse_prof, NumrefProf, DateNaissance_prof, professionprof, Etat_prof);
       ProfesseurDal Prodal=new ProfesseurDal();
     String message=  Prodal.EnregistrerProfesseur(Pro);
     return message;
    }

    @Override
    public ArrayList<String> FicheProfesseur(String Id_prof) throws RemoteException {
     ArrayList Fiche=new ArrayList();
     Professeur Pro=new Professeur();
            ProfesseurDal Prodal=new ProfesseurDal();
            Prodal.RechercherProfesseur(Id_prof, Pro);
            Fiche.add(Pro.getId_prof());
                 Fiche.add(Pro.getMatricule_prof());
                      Fiche.add(Pro.getNom_prof());
                           Fiche.add(Pro.getPrenom_prof());
                                Fiche.add(Pro.getSexe_prof());
                                     Fiche.add(Pro.getTel_prof());
                                          Fiche.add(Pro.getEmail_prof());
                                               Fiche.add(Pro.getAdresse_prof());
                                               Fiche.add(Pro.getNumrefProf());
                                               Fiche.add(Pro.getDateNaissance_prof());
                                               Fiche.add(Pro.getProfessionprof());
                                               Fiche.add(Pro.getEtat_prof());
                                               Fiche.add(Pro.getUrl());
                                               Fiche.add(Pro.getUrldoc());
     
     return Fiche;
    }

    @Override
    public String[][] ListerProfesseur() throws RemoteException {
        ProfesseurDal Prodal=new ProfesseurDal(); 
        String[][] ListerProfesseur=Prodal.ListerProfesseur();
       return ListerProfesseur;
    }

    @Override
    public String ModifierProfesseur(String Nom_prof, String Prenom_prof, String Tel_prof, String Email_prof, String Adresse_prof,String Etat_prof, String Id_prof) throws RemoteException {
       ProfesseurDal Prodal=new ProfesseurDal(); 
       String Message=Prodal.ModifierProfesseur(Nom_prof, Prenom_prof, Tel_prof, Email_prof, Adresse_prof, Etat_prof, Id_prof);
       return Message;
    }

    @Override
    public String ModifierUrlPhoto(String Codeprof, String url) throws RemoteException {
     ProfesseurDal Prodal=new ProfesseurDal(); 
    return Prodal.ModifierUrlPhoto(Codeprof, url);
    }

    @Override
    public String ModifierUrldoc(String Codeprof, String url) throws RemoteException {
        ProfesseurDal Prodal=new ProfesseurDal(); 
    return Prodal.ModifierUrldoc(Codeprof, url);
    }
    
}
