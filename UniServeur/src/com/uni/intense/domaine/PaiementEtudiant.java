/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uni.intense.domaine;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;


public class PaiementEtudiant extends UnicastRemoteObject{
    //les atributs
    private String codeEtudiant;
    private Date DatePaiement;
    private float Montant;
    private String Niveau;
   
    public PaiementEtudiant()throws RemoteException{}

    public PaiementEtudiant(String codeEtudiant, Date DatePaiement, float Montant, String Niveau) throws RemoteException {
        this.codeEtudiant = codeEtudiant;
        this.DatePaiement = DatePaiement;
        this.Montant = Montant;
        this.Niveau=Niveau;
    }

    public String getNiveau() {
        return Niveau;
    }

    public void setNiveau(String Niveau) {
        this.Niveau = Niveau;
    }
   

    public String getCodeEtudiant() {
        return codeEtudiant;
    }

    public void setCodeEtudiant(String codeEtudiant) {
        this.codeEtudiant = codeEtudiant;
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
