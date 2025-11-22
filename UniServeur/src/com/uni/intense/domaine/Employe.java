/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uni.intense.domaine;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



public class Employe extends Personne{
    //Les attributs 
    private  String Fonction;
    private  int salaire;
    private  String DateEmbauche;
    private String Urldoc;
    
      public Employe(){}
      
    public Employe(String nom,String prenom,String sexe,String nif,String adresse,String telephone,String email,String dateNaissance,String statut,String fonction,int salaire){
        super(nom,prenom,sexe,nif,adresse,telephone,email,dateNaissance,statut);
        this.Fonction=fonction;
        this.salaire=salaire;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String datedujour=""+dtf.format(LocalDateTime.now());
             this.DateEmbauche = datedujour;
                 this.Urldoc=null;
    }
    

   
    public String getFonction() {
        return Fonction;
    }

   
    public void setFonction(String Fonction) {
        this.Fonction = Fonction;
    }

    
    public int getSalaire() {
        return salaire;
    }

   
    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }

    
    public String getDateEmbauche() {
        return DateEmbauche;
    }

  
    public void setDateEmbauche(String DateEmbauche) {
        this.DateEmbauche = DateEmbauche;
    }

    public String getUrldoc() {
        return Urldoc;
    }

    public void setUrldoc(String Urldoc) {
        this.Urldoc = Urldoc;
    }
    

   
    
    
    
}
