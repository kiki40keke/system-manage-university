/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.uni.intense.presentation;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.rmi.*;
import java.rmi.registry.*;
/**
 *
 * @author kelly
 */
public interface RmiInterface extends Remote{
    public void uploadFileToServer(byte[] mybyte, String serverpath, int length,String Code) throws RemoteException;
	public byte[] downloadFileFromServer(String servername) throws RemoteException;
	public String[] listFiles(String serverpath) throws RemoteException;
	public boolean createDirectory(String serverpath) throws RemoteException;
	public boolean removeDirectoryOrFile(String serverpath) throws RemoteException;
}
