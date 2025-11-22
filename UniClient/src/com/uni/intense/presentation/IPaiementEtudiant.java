/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uni.intense.presentation;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;


/**
 *
 * @author AP
 */
public interface IPaiementEtudiant extends Remote{
       
        public String enregistrerPaiementEtud(String codeProf,Date datePaiement,float montant,String niveau) throws RemoteException;
        public Object RechercherPaiementEtud(String code) throws RemoteException;
        public String ModifierPaiementEtud(String codeProf,Date datePaiement,float montant,String niveau) throws RemoteException;
        public String SupprimmerPaiementEtud(String code) throws RemoteException;

}