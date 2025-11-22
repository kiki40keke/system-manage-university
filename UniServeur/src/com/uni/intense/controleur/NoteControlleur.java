/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uni.intense.controleur;


import com.uni.intense.application.NoteDal;
import com.uni.intense.application.ServicesCours;
import com.uni.intense.domaine.Note;
import com.uni.intense.presentation.InterfaceNote;
import java.rmi.server.UnicastRemoteObject;


import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author kelly
 */
public class NoteControlleur extends UnicastRemoteObject implements InterfaceNote {

    public NoteControlleur() throws RemoteException {
        super();
    }

    
   
    @Override
    public String EnregistrerNotesNormalNote(String codeEvaluationsNormal, String Id_Etud,double notenormal) throws RemoteException {
        Note n=new Note(codeEvaluationsNormal, Id_Etud,notenormal);
        NoteDal dal=new NoteDal();
        String mes=dal.EnregistrerNotesNormal(n);
        return mes;
    }

    @Override
    public ArrayList<String> FicheNote(String codeEvaluationsNormal, String Id_Etud) throws RemoteException {
        ArrayList Fiche=new ArrayList();
            Note n=new Note();
        NoteDal dal=new NoteDal();
        dal.RechercherNote(codeEvaluationsNormal, Id_Etud, n);
        Fiche.add(n.getCodenotnormal());
        Fiche.add(n.getCodeEvaluationsNormal());
        Fiche.add(n.getId_Etud());
        Fiche.add(n.getNotenormal());
        Fiche.add(n.getDateenregnormal());
        
        return Fiche;
    }

    @Override
    public String ModifierNote(String codeEvaluationsNormal, String Id_Etud, double notenormal) throws RemoteException {
    NoteDal dal=new NoteDal();
    String message=dal.ModifierNotes(codeEvaluationsNormal, Id_Etud, notenormal);
    return message;
    }

    @Override
    public String SupprimmerNote(String codeEvaluationsNormal, String Id_Etud) throws RemoteException {
      NoteDal dal=new NoteDal();
      String message=dal.SuprimmerNotes(codeEvaluationsNormal, Id_Etud);
      return message;
    }

    @Override
    public String[][] ListerBulletin(String Nom_Opt, String codeniv, String codesession, String Id_Etud, String NomVacation, String Promotion) throws RemoteException {
  ServicesCours ser=new ServicesCours(); 
       String Id_Opt=ser.RechercherCodeOption(Nom_Opt);
        NoteDal dal=new NoteDal();
        String[][] ListerBulletin=dal.ListerBulletin(Id_Opt, codeniv, codesession, Id_Etud, NomVacation, Promotion);
        return ListerBulletin;
    }

    @Override
    public ArrayList<String> RechercherBulletin(String codeniv,String codesession, String Id_Etud) throws RemoteException {
       ArrayList<String> RechercherBulletin=new ArrayList<>();
       NoteDal dal=new NoteDal();
       RechercherBulletin=dal.RechercherBulletin(codeniv, codesession, Id_Etud);
       return RechercherBulletin;
    }
    
    
    
}
