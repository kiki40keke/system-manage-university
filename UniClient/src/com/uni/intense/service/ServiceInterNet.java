/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uni.intense.service;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;
import java.util.regex.Pattern;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author kelly
 */
public class ServiceInterNet {

  
  public  String envoyerEmail(String content,String email,String Sujet)
    {
        String message="Email Envoye avec Succes";
        Properties props= new Properties();
        props.put("mail.smtp.auth",true);
        
        props.put("mail.smtp.starttls.enable","true");
        
        props.put("mail.smtp.host","smtp.gmail.com");
        
        props.put("mail.smtp.port","25");
        
        Session session= Session.getInstance(props,new javax.mail.Authenticator()
        {
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication("rosalvoricardo45@gmail.com","hydzmvohzhrkjsjh");
            }
        }     
        );
        try{
        
        Message mes= new MimeMessage(session);
        
        mes.setFrom(new InternetAddress("rosalvoricardo45@gmail.com"));
        mes.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
        mes.setSubject(Sujet);
       // mes.setText("Test,Sces Info 3eme Annee rue 4, Ou wel mache papa!!");
        mes.setContent(
            content,
             "text/html");
        Transport.send(mes);
        }catch(MessagingException ex)
        {
            message="Une erreur est survenue veuillez reesayer";
          System.out.println("ou gen yon ti problem wi fre !!!"+ex.getMessage());
        }
        return message;
    }
  
  public int OpenNavigator(String Url){
int a=0;
File fichier = new File(Url) ;
// On vérifie que la classe Desktop soit bien supportée : 
if (Desktop.isDesktopSupported()) { 
    // On récupère l'instance du desktop : 
    Desktop desktop = Desktop.getDesktop(); 
    // On vérifie que la fonction open est bien supportée : 
    if (desktop.isSupported(Desktop.Action.OPEN)) { 
        // Et on lance l'application associé au fichier pour l'ouvrir : 
        try { 
	    desktop.open(fichier); 
            a=1;
        } catch (IOException ex) {  
            // Gestion de l'erreur.  
            
        } 
    } 
}
return a;
  }
  
  //
  public  boolean isValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";
                              
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
public String NameComputer(){
    String  nomHote=null;
      try {
          InetAddress ip = InetAddress.getLocalHost();
            nomHote = (String) ip.getHostAddress();
        //  System.out.print("Mon adresse IP est: ");
        //  System.out.println(ip.getHostAddress());
         // System.out.print("Mon pc est: ");
          //System.out.println(ip.getHostName());
      } catch (UnknownHostException ex) {
          //Logger.getLogger(ServiceInterNet.class.getName()).log(Level.SEVERE, null, ex);
          nomHote=null;
      }
      
      return nomHote;
}

}
