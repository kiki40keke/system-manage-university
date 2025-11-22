/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uni.intense.domaine;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
/**
 *
 * @author kelly
 */
public class Professeur {
    private String Id_prof;
    private String Matricule_prof;
    private String Nom_prof;
    private String Prenom_prof;
    private String Sexe_prof;
    private String Tel_prof;
    private String Email_prof;
    private String Adresse_prof;
    private String NumrefProf;
    private String DateNaissance_prof;
    private String professionprof;
    private String Etat_prof;
   private String DateInscription_prof;
    private String Url;
    private String Urldoc;

    public Professeur() {
    }

   

    public Professeur(String Matricule_prof, String Nom_prof, String Prenom_prof, String Sexe_prof, String Tel_prof, String Email_prof, String Adresse_prof,String NumrefProf, String DateNaissance_prof, String professionprof, String Etat_prof) {
        this.Matricule_prof = Matricule_prof;
        this.Nom_prof = Nom_prof;
        this.Prenom_prof = Prenom_prof;
        this.Sexe_prof = Sexe_prof;
        this.Tel_prof = Tel_prof;
        this.Email_prof = Email_prof;
        this.Adresse_prof = Adresse_prof;
          this.NumrefProf = NumrefProf;
        this.DateNaissance_prof = DateNaissance_prof;
        this.professionprof = professionprof;
        this.Etat_prof = Etat_prof;
        
         Random rd=new Random();
        int val=rd.nextInt(111111+999999);
        String code="Prof-"+val;
            this.Id_prof = code;
          
    
         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
       
        String datedujour=""+dtf.format(LocalDateTime.now());
             this.DateInscription_prof = datedujour;
             
              this.Url=null;
                this.Urldoc = null;
              
    }

   

    public String getId_prof() {
        return Id_prof;
    }

    public void setId_prof(String Id_prof) {
        this.Id_prof = Id_prof;
    }

    public String getMatricule_prof() {
        return Matricule_prof;
    }

    public void setMatricule_prof(String Matricule_prof) {
        this.Matricule_prof = Matricule_prof;
    }

    public String getNom_prof() {
        return Nom_prof;
    }

    public void setNom_prof(String Nom_prof) {
        this.Nom_prof = Nom_prof;
    }

    public String getPrenom_prof() {
        return Prenom_prof;
    }

    public void setPrenom_prof(String Prenom_prof) {
        this.Prenom_prof = Prenom_prof;
    }

    public String getSexe_prof() {
        return Sexe_prof;
    }

    public void setSexe_prof(String Sexe_prof) {
        this.Sexe_prof = Sexe_prof;
    }

    public String getTel_prof() {
        return Tel_prof;
    }

    public void setTel_prof(String Tel_prof) {
        this.Tel_prof = Tel_prof;
    }

    public String getEmail_prof() {
        return Email_prof;
    }

    public void setEmail_prof(String Email_prof) {
        this.Email_prof = Email_prof;
    }

    public String getAdresse_prof() {
        return Adresse_prof;
    }

    public void setAdresse_prof(String Adresse_prof) {
        this.Adresse_prof = Adresse_prof;
    }

    public String getNumrefProf() {
        return NumrefProf;
    }

    public void setNumrefProf(String NumrefProf) {
        this.NumrefProf = NumrefProf;
    }

    public String getDateNaissance_prof() {
        return DateNaissance_prof;
    }

    public void setDateNaissance_prof(String DateNaissance_prof) {
        this.DateNaissance_prof = DateNaissance_prof;
    }

    public String getProfessionprof() {
        return professionprof;
    }

    public void setProfessionprof(String professionprof) {
        this.professionprof = professionprof;
    }

    public String getEtat_prof() {
        return Etat_prof;
    }

    public void setEtat_prof(String Etat_prof) {
        this.Etat_prof = Etat_prof;
    }

    public String getDateInscription_prof() {
        return DateInscription_prof;
    }

    public void setDateInscription_prof(String DateInscription_prof) {
        this.DateInscription_prof = DateInscription_prof;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }

    public String getUrldoc() {
        return Urldoc;
    }

    public void setUrldoc(String Urldoc) {
        this.Urldoc = Urldoc;
    }
   
    
}
