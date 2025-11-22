/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uni.intense.domaine;


import java.util.Random;


public class Personne{
    //les atributs
    private String Code;
    private String Nom;
    private String Prenom;
    private String Sexe;
    private String Nif;
    private String Adresse;
    private String Telephone;
    private String email;
    private String DateNaissance;
    private String Statut;
    private String Url;
   
    //constructeur par defaut
    public Personne(){}
    //constructeur normal de la classe
    public Personne(String nom,String prenom,String sexe,String nif,String adresse,String telephone,String email,String dateNaissance,String statut){
        
        this.Nom=nom;
        this.Prenom=prenom;
        this.Sexe=sexe;
        this.Nif=nif;
        this.Adresse=adresse;
        this.Telephone=telephone;
        this.email=email;
        this.DateNaissance=dateNaissance;
        this.Statut=statut;
        Random rd=new Random();
        int val=rd.nextInt(111+99999);
        String code=nom.substring(0, 2)+prenom.substring(0,2)+"-"+val;
        this.Code=code;
        this.Url=null;
    
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public String getSexe() {
        return Sexe;
    }

    public void setSexe(String Sexe) {
        this.Sexe = Sexe;
    }

    public String getNif() {
        return Nif;
    }

    public void setNif(String Nif) {
        this.Nif = Nif;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String Telephone) {
        this.Telephone = Telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateNaissance() {
        return DateNaissance;
    }

    public void setDateNaissance(String DateNaissance) {
        this.DateNaissance = DateNaissance;
    }

    public String getStatut() {
        return Statut;
    }

    public void setStatut(String Statut) {
        this.Statut = Statut;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }
    
    
    
}
