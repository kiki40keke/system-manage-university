/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.uni.intense.presentation;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author kelly
 */
public interface InterfaceNote extends Remote{
    public String EnregistrerNotesNormalNote(String codeEvaluationsNormal, String Id_Etud,double notenormal) throws RemoteException;
     public ArrayList<String> FicheNote(String codeEvaluationsNormal, String Id_Etud) throws RemoteException; 
      public String ModifierNote(String codeEvaluationsNormal, String Id_Etud,double notenormal)throws RemoteException;
   public String SupprimmerNote(String codeEvaluationsNormal, String Id_Etud)throws RemoteException;
   public String[][] ListerBulletin(String Nom_Opt,String codeniv,String codesession,String Id_Etud,String NomVacation, String Promotion)throws RemoteException;
    public ArrayList<String> RechercherBulletin( String codeniv,String codesession,String Id_Etud) throws RemoteException;
    
}
