/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uni.intense.application;


import com.uni.intense.domaine.Paiement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;


/**
 *
 * @author kelly
 */
public class PaiementDal {
     public String EnregistrerPaiement(Paiement Pro){
        String mes="";
        String req="Insert into  Paiment values('"+Pro.getCodepc()+"','"+Pro.getId_Opt()+"', '"+Pro.getFraisInscription()+"','"+Pro.getFraisDentres()+"','"+Pro.getFraisSession()+"','"+Pro.getDateenreg()+"')";
       int verifier=0;
      
       try{
           // Etablir la connection
           Connection conect=DriverManager.getConnection("jdbc:mysql://localhost/GestionUniversite","root","");
           // creation d'un statement
           Statement st=conect.createStatement();
               //Utiliser une methode du Statement pour executer la requete
               verifier=st.executeUpdate(req);
               if(verifier!=0){
                  
              
                           mes="Cette Modalite de paiement a ete Enregiter pour Cette Option, son Idendifiant unique est :"+Pro.getCodepc();
                      
               }
               
               conect.close(); st.close();
       }
       catch (SQLException e){
           mes="enregistrement echouer /n"+e.getMessage();
       }
        return mes;
    }
     
     public Paiement RechercherPaiement(String codepc, Paiement Pro){
 
        //Preparer la requete
        String req="Select *  from Paiment  where codepc='"+codepc+"'";
         try
        {
            //Etablir la connexion
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost/GestionUniversite","root","");
            //Creer Statement
            Statement st=con.createStatement();
            //Executer la requete
            //Creer un objet de type ResultSet
            ResultSet rs=st.executeQuery(req);
            if(rs.next())
            {
               Pro.setCodepc(rs.getString(1));
               Pro.setId_Opt(rs.getString(2));
               Pro.setFraisInscription(rs.getDouble(3));
               Pro.setFraisDentres(rs.getDouble(4));
               Pro.setFraisSession(rs.getDouble(5));
               Pro.setDateenreg(rs.getString(6));
           
            }
             con.close(); st.close();
        }
          catch(SQLException ex)
        {
           
    }
       return Pro;
    }
     public Paiement RechercherPaiement2(String Id_Opt, Paiement Pro){
 
        //Preparer la requete
        String req="Select *  from Paiment  where Id_Opt='"+Id_Opt+"'";
         try
        {
            //Etablir la connexion
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost/GestionUniversite","root","");
            //Creer Statement
            Statement st=con.createStatement();
            //Executer la requete
            //Creer un objet de type ResultSet
            ResultSet rs=st.executeQuery(req);
            if(rs.next())
            {
               Pro.setCodepc(rs.getString(1));
               Pro.setId_Opt(rs.getString(2));
               Pro.setFraisInscription(rs.getDouble(3));
               Pro.setFraisDentres(rs.getDouble(4));
               Pro.setFraisSession(rs.getDouble(5));
               Pro.setDateenreg(rs.getString(6));
           
            }
             con.close(); st.close();
        }
          catch(SQLException ex)
        {
           
    }
       return Pro;
    }
     public String ModifierPaiement(String codepc,double fraisInscription, double fraisDentres, double fraisSession){
        String message="";
        String req="update Paiment set fraisInscription='"+fraisInscription+"',fraisDentres='"+fraisDentres+"',fraisSession='"+fraisSession+"' where codepc='"+codepc+"'";
         int verifier2=0;
           int verifye=0;
               try
        {
            //Etablir la connexion
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/GestionUniversite","root","");
            //Creation d'un Statement
            Statement st=con.createStatement();
            //Utiliser une methode du Statement pour executer la requete
            verifye=st.executeUpdate(req);
            if(verifye!=0)
            {
               
                 message="Modification reussi";
      
                            
            }
            //Fermer la connexion et le Statement
            con.close();st.close();
        }
        catch(SQLException ex)
        {
            message="Modification echoue  \t"+ex.getMessage();
           
        } 
    return  message;
    }
     
          public int EnregistrerAncien(String codepc,String Id_Opt, String Dateenreg,double fraisInscription, double fraisDentres, double fraisSession){
       int va=0;
              String message="";
           DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String datedujour=""+dtf.format(LocalDateTime.now());
        String req="Insert into  AncienPaiment values('"+codepc+"','"+Id_Opt+"','"+fraisInscription+"','"+fraisDentres+"','"+fraisSession+"','"+Dateenreg+"','"+datedujour+"')";
         int verifier2=0;
           int verifye=0;
               try
        {
            //Etablir la connexion
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/GestionUniversite","root","");
            //Creation d'un Statement
            Statement st=con.createStatement();
            //Utiliser une methode du Statement pour executer la requete
            verifye=st.executeUpdate(req);
            if(verifye!=0)
            {
               
                 message="enreg reussi";
                 System.out.println(message);
                 va=1;
                            
            }
            
            else{va=0;}
            //Fermer la connexion et le Statement
            con.close();st.close();
        }
        catch(SQLException ex)
        {
            message="Modification echoue  \t"+ex.getMessage();
             System.out.println(message);
           va=0;
        } 
    return  va;
    }
          
           public int EnregistrerComptePaiement(String Id_Etud,String Id_Opt,double fraisInscription, double fraisDentres, double fraisSession){
       int va=0;
       double solde=0;
              String message="";
              Random rd =new Random();
              int val=rd.nextInt(111+99999);
              String codecompte="Compte-"+val;
           DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String datedujour=""+dtf.format(LocalDateTime.now());
        String req="Insert into  ComptePaiment values('"+codecompte+"','"+Id_Opt+"','"+Id_Etud+"','"+fraisInscription+"','"+fraisDentres+"','"+fraisSession+"','"+solde+"','"+datedujour+"')";
         int verifier2=0;
           int verifye=0;
               try
        {
            //Etablir la connexion
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/GestionUniversite","root","");
            //Creation d'un Statement
            Statement st=con.createStatement();
            //Utiliser une methode du Statement pour executer la requete
            verifye=st.executeUpdate(req);
            if(verifye!=0)
            {
               
                 message="enreg reussi";
                 System.out.println(message);
                 va=1;
                            
            }
            
            else{va=0;}
            //Fermer la connexion et le Statement
            con.close();st.close();
        }
        catch(SQLException ex)
        {
            message="Modification echoue  \t"+ex.getMessage();
             System.out.println(message);
           va=0;
        } 
    return  va;
    }
    
        public String SuprimmerPaiement( String codepc  ){
        String message="";
        String req="delete from Paiment  where codepc='"+codepc+"'";
        
           int verifye=0;
               try
        {
            //Etablir la connexion
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/GestionUniversite","root","");
            //Creation d'un Statement
            Statement st=con.createStatement();
            //Utiliser une methode du Statement pour executer la requete
            verifye=st.executeUpdate(req);
            if(verifye!=0)
            {
                 message="Suppression reussi";
            }
            //Fermer la connexion et le Statement
            con.close();st.close();
        }
        catch(SQLException ex)
        {
            message="Suppression echoue  \t"+ex.getMessage();
           
        } 
    return  message;
    }
       
         public String ModifierMontant(String CodeCompte, double solde)
    {
        String mesaj="";
         //Preparer la requete
        String req="Update ComptePaiment set solde='"+solde+"' where CodeCompte='"+CodeCompte+"'";
        int verifye=0;
        try
        {
            //Etablir la connexion
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/GestionUniversite","root","");
            //Creer Statement
            Statement st=con.createStatement();
            verifye=st.executeUpdate(req);
            if(verifye!=0)
            {
                mesaj="Compte Modifier";     
            }
             con.close(); st.close();
        }catch(SQLException ex)
        {
            mesaj="M gen pwoblem"+ex.getMessage();
         
        }
        return mesaj;
    }


        public String enregTransfert(String CodeCompte, double momtant)
    {
           DateFormat format= new SimpleDateFormat("YYYY/MM/dd");
                Date data=new Date();
        String dataf=format.format(data);
       
        Random rd=new Random();
        int val=rd.nextInt(9999);
          String tran="Tr-"+val;
        
        
        String mesaj="";
         //Preparer la requete
        String req="Insert into  TransacrionsEtudiants values('"+tran+"','"+CodeCompte+"','"+momtant+"','"+dataf+"')";
        int verifye=0;
        try
        {
            //Etablir la connexion
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/GestionUniversite","root","");
            //Creer Statement
            Statement st=con.createStatement();
            verifye=st.executeUpdate(req);
            if(verifye!=0)
            {
                mesaj="Transactions Enregistrer";
                 
            }
             con.close(); st.close();
        }catch(SQLException ex)
        {
            mesaj="M gen pwoblem"+ex.getMessage();
            
        }
        return mesaj;
    }
        
         public String RechercherCodeCompte(String Id_Etud){
 String CodeCompte=null;
        //Preparer la requete
        String req="Select CodeCompte  from ComptePaiment  where Id_Etud='"+Id_Etud+"'";
         try
        {
            //Etablir la connexion
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost/GestionUniversite","root","");
            //Creer Statement
            Statement st=con.createStatement();
            //Executer la requete
            //Creer un objet de type ResultSet
            ResultSet rs=st.executeQuery(req);
            if(rs.next())
            {
             CodeCompte=rs.getString("CodeCompte");
            }
             con.close(); st.close();
        }
          catch(SQLException ex)
        {
           
    }
       return CodeCompte;
    }
         
              public String RechercherSolde(String CodeCompte){
 String solde=null;
        //Preparer la requete
        String req="Select solde  from ComptePaiment  where CodeCompte='"+CodeCompte+"'";
         try
        {
            //Etablir la connexion
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost/GestionUniversite","root","");
            //Creer Statement
            Statement st=con.createStatement();
            //Executer la requete
            //Creer un objet de type ResultSet
            ResultSet rs=st.executeQuery(req);
            if(rs.next())
            {
             solde=rs.getString("solde");  
            }
             con.close(); st.close();
        }
          catch(SQLException ex)
            
        {
           solde=ex.getMessage();  
    }
                  System.out.println(solde); 
       return solde;
    }
    public String RechercherSommation(String Id_Etud){
 String solde=null;
        //Preparer la requete
        String req="Select sum(FraisInscription+fraisDentres+FraisSession+FraisSession) as solde  from ComptePaiment  where Id_Etud='"+Id_Etud+"'";
         try
        {
            //Etablir la connexion
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost/GestionUniversite","root","");
            //Creer Statement
            Statement st=con.createStatement();
            //Executer la requete
            //Creer un objet de type ResultSet
            ResultSet rs=st.executeQuery(req);
            if(rs.next())
            {
             solde=rs.getString("solde");
            }
             con.close(); st.close();
        }
          catch(SQLException ex)
            
        {
           solde=ex.getMessage();  
    }
                  System.out.println(solde); 
       return solde;
    }
    
     public String RechercherFrais(String Id_Etud){
 String solde=null;
        //Preparer la requete
        String req= "Select FraisSession  from ComptePaiment  where Id_Etud='" + Id_Etud + "'";
         try
        {
            //Etablir la connexion
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost/GestionUniversite","root","");
            //Creer Statement
            Statement st=con.createStatement();
            //Executer la requete
            //Creer un objet de type ResultSet
            ResultSet rs=st.executeQuery(req);
            if(rs.next())
            {
             solde=rs.getString("FraisSession");
            }
             con.close(); st.close();
        }
          catch(SQLException ex)
            
        {
           solde=ex.getMessage();  
    }
                  System.out.println(solde); 
       return solde;
    }
        
          public int nombredelignepaiement(){
               int t=0;
              
  String req="Select count(*) as nombre from Paiment";
    //Preparer la requete
     
        try
        {
            //Etablir la connexion
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost/GestionUniversite","root","");
            //Creer Statement
            Statement st=con.createStatement();
            //Executer la requete
            //Creer un objet de type ResultSet
            ResultSet rs=st.executeQuery(req);
            int i=0;
            if(rs.next())
            {
              //data = new String[i][3];
                 int nom = rs.getInt("nombre");
      t=nom;

            }
             
            //Fermer la connexion
            con.close();st.close();
        }
        catch(SQLException ex)
        {
            
        }
        return t;
   }
    public String[][] ListerPaiement(){
        Paiement Pro=new Paiement();
                int r=nombredelignepaiement();
               String req="Select P.codepc, O.Nom_Opt, P.FraisInscription,P.fraisDentres,P.FraisSession from Paiment P,Options O where P.Id_Opt=O.Id_Opt";
               int t=0;
               String data[][] = new String[r][5];
              
    //Preparer la requete
      
        try
        {
            //Etablir la connexion
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost/GestionUniversite","root","");
            //Creer Statement
            Statement st=con.createStatement();
            //Executer la requete
            //Creer un objet de type ResultSet
            ResultSet rs=st.executeQuery(req);
            int i=0;
            while(rs.next())
            {
                
            Pro.setCodepc(rs.getString(1));
               Pro.setId_Opt(rs.getString(2));
               
               Pro.setFraisInscription(rs.getDouble(3));
               Pro.setFraisDentres(rs.getDouble(4));
               Pro.setFraisSession(rs.getDouble(5));
             
                 
                 
               data[i][0] = Pro.getCodepc();
                data[i][1] = Pro.getId_Opt();
             data[i][2] = String.valueOf(Pro.getFraisInscription()) ;
         data[i][3] = String.valueOf(Pro.getFraisDentres()) ;
           data[i][4] = String.valueOf(Pro.getFraisSession()) ;
            
         
        
        i++;

            }
             
            //Fermer la connexion
            con.close();st.close();
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return data;
   }
    
    
    public int nombredelignepancien(String req){
               int t=0;
              
 
    //Preparer la requete
     
        try
        {
            //Etablir la connexion
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost/GestionUniversite","root","");
            //Creer Statement
            Statement st=con.createStatement();
            //Executer la requete
            //Creer un objet de type ResultSet
            ResultSet rs=st.executeQuery(req);
            int i=0;
            if(rs.next())
            {
              //data = new String[i][3];
                 int nom = rs.getInt("nombre");
      t=nom;

            }
             
            //Fermer la connexion
            con.close();st.close();
        }
        catch(SQLException ex)
        {
            
        }
        return t;
   }
    public String[][] ListerAncienPaiement(String req,String req1){
        Paiement Pro=new Paiement();
                int r=nombredelignepancien(req1);
            
               int t=0;
               String data[][] = new String[r][6];
              
    //Preparer la requete
      
        try
        {
            //Etablir la connexion
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost/GestionUniversite","root","");
            //Creer Statement
            Statement st=con.createStatement();
            //Executer la requete
            //Creer un objet de type ResultSet
            ResultSet rs=st.executeQuery(req);
            int i=0;
            while(rs.next())
            {
                
            Pro.setCodepc(rs.getString(1));
               Pro.setId_Opt(rs.getString(2));
                System.out.println(rs.getString(2));
               Pro.setFraisInscription(rs.getDouble(3));
               Pro.setFraisDentres(rs.getDouble(4));
               Pro.setFraisSession(rs.getDouble(5));
              Pro.setDateenreg(rs.getString(6));
                 
                 
               data[i][0] = Pro.getCodepc();
                data[i][1] = Pro.getId_Opt();
             data[i][2] = String.valueOf(Pro.getFraisInscription()) ;
         data[i][3] = String.valueOf(Pro.getFraisDentres()) ;
           data[i][4] = String.valueOf(Pro.getFraisSession()) ;
            data[i][5] = Pro.getDateenreg();
         
        
        i++;

            }
             
            //Fermer la connexion
            con.close();st.close();
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return data;
   }
       public int nombredelignetransactions(){
               int t=0;
              
  String req="Select count(*) as nombre from TransacrionsEtudiants";
    //Preparer la requete
     
        try
        {
            //Etablir la connexion
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost/GestionUniversite","root","");
            //Creer Statement
            Statement st=con.createStatement();
            //Executer la requete
            //Creer un objet de type ResultSet
            ResultSet rs=st.executeQuery(req);
            int i=0;
            if(rs.next())
            {
              //data = new String[i][3];
                 int nom = rs.getInt("nombre");
      t=nom;

            }
             
            //Fermer la connexion
            con.close();st.close();
        }
        catch(SQLException ex)
        {
            
        }
        return t;
   }
    public String[][] Listertransactions(){
     
                int r=nombredelignetransactions();
               String req="Select * from TransacrionsEtudiants";
               int t=0;
               String data[][] = new String[r][4];
              
    //Preparer la requete
      
        try
        {
            //Etablir la connexion
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost/GestionUniversite","root","");
            //Creer Statement
            Statement st=con.createStatement();
            //Executer la requete
            //Creer un objet de type ResultSet
            ResultSet rs=st.executeQuery(req);
            int i=0;
            while(rs.next())
            {
                
         String codetrans=rs.getString(1);
         String codecompte=rs.getString(2);
         String montant=rs.getString(3);
         String dateeng=rs.getString(4);
             
                 
                 
               data[i][0] = codetrans;
               data[i][1] = codecompte;
               data[i][2] = montant;
               data[i][3] = dateeng;
         
        
        i++;

            }
             
            //Fermer la connexion
            con.close();st.close();
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return data;
   }
    //
     public int nombredelignetransactionsEtudiant(String IdEtud){
               int t=0;
              

    //Preparer la requete
        String req="select  count(*) as nombre from transacrionsetudiants where CodeCompte In(select CodeCompte from comptepaiment where Id_Etud='"+IdEtud+"')";
        try
        {
            //Etablir la connexion
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost/GestionUniversite","root","");
            //Creer Statement
            Statement st=con.createStatement();
            //Executer la requete
            //Creer un objet de type ResultSet
            ResultSet rs=st.executeQuery(req);
            int i=0;
            if(rs.next())
            {
              //data = new String[i][3];
                 int nom = rs.getInt("nombre");
      t=nom;

            }
             
            //Fermer la connexion
            con.close();st.close();
        }
        catch(SQLException ex)
        {
            
        }
        return t;
   }
    public String[][] ListertransactionsEtudiant(String IdEtud){
     
                int r=nombredelignetransactionsEtudiant(IdEtud);
               String req="select *from transacrionsetudiants where CodeCompte In(select CodeCompte from comptepaiment where Id_Etud='"+IdEtud+"')";
               int t=0;
               String data[][] = new String[r][4];
              
    //Preparer la requete
      
        try
        {
            //Etablir la connexion
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost/GestionUniversite","root","");
            //Creer Statement
            Statement st=con.createStatement();
            //Executer la requete
            //Creer un objet de type ResultSet
            ResultSet rs=st.executeQuery(req);
            int i=0;
            while(rs.next())
            {
                
         String codetrans=rs.getString(1);
         String codecompte=rs.getString(2);
         String montant=rs.getString(3);
         String dateeng=rs.getString(4);
             
                 
                 
               data[i][0] = codetrans;
               data[i][1] = codecompte;
               data[i][2] = montant;
               data[i][3] = dateeng;
         
        
        i++;

            }
             
            //Fermer la connexion
            con.close();st.close();
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return data;
   }
     
}
