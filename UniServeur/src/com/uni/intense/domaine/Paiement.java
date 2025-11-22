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
public class Paiement {
    private String codepc;
    private String  Id_Opt;
   private double  fraisInscription;
  private double  fraisDentres;
   private double  fraisSession;
   private String  Dateenreg;

    public Paiement() {
    }

    public Paiement(String Id_Opt, double fraisInscription, double fraisDentres, double fraisSession) {    
        this.codepc = "Paie-"+Id_Opt;
        this.Id_Opt = Id_Opt;
        this.fraisInscription = fraisInscription;
        this.fraisDentres = fraisDentres;
        this.fraisSession = fraisSession;
         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String datedujour=""+dtf.format(LocalDateTime.now());
        this.Dateenreg = datedujour;
    }

    public String getCodepc() {
        return codepc;
    }

    public void setCodepc(String codepc) {
        this.codepc = codepc;
    }

    public String getId_Opt() {
        return Id_Opt;
    }

    public void setId_Opt(String Id_Opt) {
        this.Id_Opt = Id_Opt;
    }

    public double getFraisInscription() {
        return fraisInscription;
    }

    public void setFraisInscription(double fraisInscription) {
        this.fraisInscription = fraisInscription;
    }

    public double getFraisDentres() {
        return fraisDentres;
    }

    public void setFraisDentres(double fraisDentres) {
        this.fraisDentres = fraisDentres;
    }

    public double getFraisSession() {
        return fraisSession;
    }

    public void setFraisSession(double fraisSession) {
        this.fraisSession = fraisSession;
    }

    public String getDateenreg() {
        return Dateenreg;
    }

    public void setDateenreg(String Dateenreg) {
        this.Dateenreg = Dateenreg;
    }
   
   
}
