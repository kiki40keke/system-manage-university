/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uni.intense.service;

/**
 *
 * @author kelly
 */
public class ServiceReseau {
    private final String Rmi= "rmi://127.0.0.1/";
     private String Etudiant;
     private String Service;
 private String Professeur;
  private String Employe;
   private String Utilisateur;
    private String Palmaresse;
     private String Evaluation;
      private String Note;
       private String Paiement;
        private String Image;

    public ServiceReseau() {
        this.Etudiant = Rmi+"Etudiants:1054";
        this.Service = Rmi+"Service:1054";
        this.Professeur =Rmi+"Professeur:1054";
        this.Employe = Rmi+"Employe:1054";
        this.Utilisateur = Rmi+"Utilisateur:1054";
        this.Palmaresse = Rmi+"Palmaresse:1054";
        this.Evaluation = Rmi+"Evaluation:1054";
        this.Note = Rmi+"Note:1054";
        this.Paiement = Rmi+"Paiement:1054";
        this.Image = Rmi+"Image:1054";
    }

    public String getEtudiant() {
        return Etudiant;
    }

    public void setEtudiant(String Etudiant) {
        this.Etudiant = Etudiant;
    }

    public String getService() {
        return Service;
    }

    public void setService(String Service) {
        this.Service = Service;
    }

    public String getProfesseur() {
        return Professeur;
    }

    public void setProfesseur(String Professeur) {
        this.Professeur = Professeur;
    }

    public String getEmploye() {
        return Employe;
    }

    public void setEmploye(String Employe) {
        this.Employe = Employe;
    }

    public String getUtilisateur() {
        return Utilisateur;
    }

    public void setUtilisateur(String Utilisateur) {
        this.Utilisateur = Utilisateur;
    }

    public String getPalmaresse() {
        return Palmaresse;
    }

    public void setPalmaresse(String Palmaresse) {
        this.Palmaresse = Palmaresse;
    }

    public String getEvaluation() {
        return Evaluation;
    }

    public void setEvaluation(String Evaluation) {
        this.Evaluation = Evaluation;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }

    public String getPaiement() {
        return Paiement;
    }

    public void setPaiement(String Paiement) {
        this.Paiement = Paiement;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }
    


   
    
}
