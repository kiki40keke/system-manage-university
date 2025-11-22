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
public interface InterfacePalmares extends Remote {
     public String Palmaresse( String NomOption, String  NomCours, String NomVacation, String Promotions) throws RemoteException;
     public String[][] ListerPalmares(String codepalmares) throws RemoteException;
     public String RechercherCodePalmaresse(String NomOption, String NomCours, String NomVacation, String Promotions) throws RemoteException;
     public ArrayList<String> RechercherPalmares( String codepalmares) throws RemoteException;
       public String[][] ListerPalmares2()throws RemoteException;
}
