/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uni.intense.controleur;
import com.uni.intense.presentation.RmiInterface;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
/**
 *
 * @author kelly
 */
public class RmiImplementation extends UnicastRemoteObject implements RmiInterface{


  public RmiImplementation()throws RemoteException{
      
      super();
      File storageDir = new File ("src//resources");
		storageDir.mkdir();
  
  }
    @Override
    public void uploadFileToServer(byte[] mybyte, String serverpath, int length,String Code) throws RemoteException {
     int var=0;
        try {
    		File serverpathfile = new File(serverpath);
         try (FileOutputStream out = new FileOutputStream(serverpathfile)) {
             byte [] data=mybyte;
             
             out.write(data);
             out.flush();
         }
                var=1;
                System.out.println("Done writing data...");
	 
		} catch (IOException e) {
			
			e.printStackTrace();
                        var=0;
		}
        
        if(var==1){
        
              Path oldFile  = Paths.get(serverpath);
  
        try {
            Files.move(oldFile, oldFile.resolveSibling(Code));
            System.out.println("File Successfully Rename");
        }
        catch (IOException e) {
            System.out.println("operation failed");
        }
        }
    }

    @Override
    public byte[] downloadFileFromServer(String servername) throws RemoteException {
       	int var=0;
        byte [] mydata;	
        
		
			File serverpathfile = new File(servername);			
			mydata=new byte[(int) serverpathfile.length()];
                      try{
			FileInputStream in;
                        var=1;
                      }
                      catch(Exception e){
                          System.out.println("File not Exist");
                      var=0;
                      }
                      if(var==1){
                          FileInputStream in;
			try {
				in = new FileInputStream(serverpathfile);
				try {
					in.read(mydata, 0, mydata.length);
				} catch (IOException e) {
					
					//e.printStackTrace();
				}						
				try {
					in.close();
				} catch (IOException e) {
				
					//e.printStackTrace();
				}
				
			} catch (FileNotFoundException e) {
				
				//e.printStackTrace();
			}
                        
                      }
                        
                       
                
                
                
			return mydata;
    }

    @Override
    public String[] listFiles(String serverpath) throws RemoteException {
       File serverpathdir = new File(serverpath);
		return serverpathdir.list();
    }

    @Override
    public boolean createDirectory(String serverpath) throws RemoteException {
      File serverpathdir = new File(serverpath);
		return serverpathdir.mkdir();
    }

    @Override
    public boolean removeDirectoryOrFile(String serverpath) throws RemoteException {
      try{
        File serverpathdir = new File(serverpath);
		return serverpathdir.delete();
      }
      catch(Exception e){
      return false;
      }
    }
    
}
