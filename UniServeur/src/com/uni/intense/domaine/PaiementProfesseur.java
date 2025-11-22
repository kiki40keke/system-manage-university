/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uni.intense.domaine;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;


public class PaiementProfesseur extends UnicastRemoteObject{
    //les atributs
    private String codeProfesseur;
    private Date DatePaiement;
    private float Montant;
   
    public PaiementProfesseur()throws RemoteException{}

    public PaiementProfesseur(String codeProfesseur, Date DatePaiement, float Montant) throws RemoteException {
        this.codeProfesseur = codeProfesseur;
        this.DatePaiement = DatePaiement;
        this.Montant = Montant;
    }

    public String getCodeProfesseur() {
        return codeProfesseur;
    }

    public void setCodeProfesseur(String codeProfesseur) {
        this.codeProfesseur = codeProfesseur;
    }

    public Date getDatePaiement() {
        return DatePaiement;
    }

    public void setDatePaiement(Date DatePaiement) {
        this.DatePaiement = DatePaiement;
    }

    public float getMontant() {
        return Montant;
    }

    public void setMontant(float Montant) {
        this.Montant = Montant;
    }
    
    
    
}
