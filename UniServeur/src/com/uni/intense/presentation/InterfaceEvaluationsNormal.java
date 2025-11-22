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
public interface InterfaceEvaluationsNormal extends Remote {
      public String EnregistrerEvaluation(String Codepalmares, String TypesNormal, String DescriptionsNormal, int CoeficientNormal) throws RemoteException;
          public ArrayList<String> RechercherEvaluation( String codeEvaluationsNormal) throws RemoteException;
          public String[][] ListerNotes(String codeEvaluationsNormal) throws RemoteException;
          public String[][] ListerEvaluation()throws RemoteException;
           public String RechercherCodeEvaluation( String Codepalmares, String TypesNormal, String DescriptionsNormal) throws RemoteException;
      
    
}
