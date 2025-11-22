/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uni.intense.service;
import com.uni.intense.presentation.RmiInterface;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author kelly
 */
public class TransfererFichier {
    ServiceReseau ser=new ServiceReseau();



    public String EnvoyerFichier(String filename,String filename1,String Code){
        String url=null;
        try {
           
            Context cont=new InitialContext();
            RmiInterface mato=(RmiInterface) cont.lookup(ser.getImage());

            File clientpathfile = new File(filename);
            byte [] mydata=new byte[(int) clientpathfile.length()];
            FileInputStream in=new FileInputStream(clientpathfile);
            System.out.println("uploading to server...");
            in.read(mydata, 0, mydata.length);
            mato.uploadFileToServer(mydata, "src//resources//"+filename1, (int) clientpathfile.length(),Code);
            
            in.close();
             url="src//resources//"+Code;
        //    url=url1.replace("//", "//");
          
        } catch (NamingException | IOException ex) {
            Logger.getLogger(TransfererFichier.class.getName()).log(Level.SEVERE, null, ex);
            url=null;
        }
          return url;
    }
    
  public  void recevoirFichier(String serverpath){
       
      try {
            
            Context cont=new InitialContext();
            RmiInterface mato=(RmiInterface) cont.lookup(ser.getImage());
            byte [] mydata = mato.downloadFileFromServer(serverpath);
            System.out.println("downloading..."+serverpath);
            File clientpathfile = new File(serverpath);
          try (FileOutputStream out = new FileOutputStream(clientpathfile)) {
              out.write(mydata);
              out.flush();
          }
        } catch (NamingException | IOException ex) {
            Logger.getLogger(TransfererFichier.class.getName()).log(Level.SEVERE, null, ex);
}
  
      
  }
  
  
 public void effacerFichierServer(String serverpath){
        try {
           
            Context cont=new InitialContext();
            RmiInterface mato=(RmiInterface) cont.lookup(ser.getImage());
            	boolean bool = mato.removeDirectoryOrFile(serverpath);
				 System.out.println("directory deleted :" + bool);
        } catch (NamingException | RemoteException ex) {
            Logger.getLogger(TransfererFichier.class.getName()).log(Level.SEVERE, null, ex);
        }
  }
 
 public void effacerFichierClient(String serverpath){
 File serverpathdir = new File(serverpath);
		boolean r= serverpathdir.delete();
 }
 
 public String[] listFiles(String serverpath){
       File serverpathdir = new File(serverpath);
		return serverpathdir.list();
    }
    
    
    
}
