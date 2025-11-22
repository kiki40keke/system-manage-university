/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uni.intense.application;


import com.uni.intense.domaine.Utilisateur;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author kelly
 */
public class UtilisateurDal {
     public String EnregistrerUtilisateur(Utilisateur Pro){
        String mes="";
        String req="Insert into  utilisateur values('"+Pro.getCodeUser()+"','"+Pro.getNomUser()+"','"+Pro.getMotPasse()+"','"+Pro.getEtat()+"','"+Pro.getDateenreg()+"')";
       int verifier;
       
       try{
           // Etablir la connection
           Connection conect=DriverManager.getConnection("jdbc:mysql://localhost/GestionUniversite","root","");
           // creation d'un statement
           Statement st=conect.createStatement();
               //Utiliser une methode du Statement pour executer la requete
               verifier=st.executeUpdate(req);
               if(verifier!=0){
                  
                   mes="L'Utilisateur a ete Creer, son Idendifiant unique est :"+Pro.getCodeUser();
               }
               
               conect.close(); st.close();
       }
       catch (SQLException e){
           mes="enregistrement echouer /n"+e.getMessage();
       }
        return mes;
    }
     
     public Utilisateur RechercherUtilisateur(String code, Utilisateur Pro){
 
        //Preparer la requete
        String req="Select * from utilisateur where code='"+code+"'";
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
               Pro.setCodeUser(rs.getString(1));
               Pro.setNomUser(rs.getString(2));
               Pro.setMotPasse(rs.getString(3));
               Pro.setEtat(rs.getString(4));
               
            }
             con.close(); st.close();
        }
          catch(SQLException ex)
        {
           
    }
       return Pro;
    }
     
     public Utilisateur Rechercherlogin(String nomUtilisateur,String MotPasse, Utilisateur Pro){
 
        //Preparer la requete
        String req="Select * from utilisateur where nomUtilisateur='"+nomUtilisateur+"' and  MotPasse='"+MotPasse+"'";
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
               Pro.setCodeUser(rs.getString(1));
               Pro.setNomUser(rs.getString(2));
               Pro.setMotPasse(rs.getString(3));
               Pro.setEtat(rs.getString(4));
                //System.out.println("dal "+rs.getString(1));
            }
            else{
           // System.out.println("li pa bon ");
            }
             con.close(); st.close();
        }
          catch(SQLException ex)
        {
           // System.out.println(""+ex.getMessage());
           
    }
       return Pro;
    }
       public String RechercherCodeEmployer(String code){
       String IdOption=null;
        //Preparer la requete
       String req="select code from  utilisateur where code='"+code+"'";
 
         try
        {
            //Etablir la connexion
            java.sql.Connection con =DriverManager.getConnection("jdbc:mysql://localhost/GestionUniversite","root","");
            //Creer Statement
            java.sql.Statement st=con.createStatement();
            //Executer la requete
            //Creer un objet de type ResultSet
            ResultSet rs=st.executeQuery(req);
            if(rs.next())
            {
        
                IdOption=rs.getString("code"); 
                System.out.println("li jwenn li se :"+ IdOption);
               
            }
            
            else{
                   System.out.println("li pa  jwenn li se :"+ IdOption);
            }
            
          //  System.out.println("Nom option: "+ Nom_Opt );
           con.close(); st.close();
        }
          catch(SQLException ex)
        {
           
    }
       return IdOption;
    }
     
     public String ModifierUtilisateur( String nomUtilisateur,String MotPasse,String etat,String code){
        String message="";
        String req="update utilisateur set nomUtilisateur='"+nomUtilisateur+"',MotPasse='"+MotPasse+"',etat='"+etat+"' where code='"+code+"'";
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
    
     //
        public String SuprimmerUtilisateur( String code  ){
        String message="";
        String req="delete from utilisateur  where code='"+code+"'";
        
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
        
          public int nombredeligne(){
               int t=0;
              
  String req="Select count(*) as nombre from utilisateur";
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
    public String[][] ListerUtilisateur(){
        Utilisateur Pro=new Utilisateur();
                int r=nombredeligne();
               String req="Select * from utilisateur";
               int t=0;
               String data[][] = new String[r][12];
              
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
                
            Pro.setCodeUser(rs.getString(1));
               Pro.setNomUser(rs.getString(2));
               Pro.setMotPasse(rs.getString(3));
               Pro.setEtat(rs.getString(4));
              
                 
                 
               data[i][0] =      Pro.getCodeUser();
             data[i][1] =   Pro.getNomUser();
             data[i][2] =   Pro.getMotPasse();
              data[i][3] =  Pro.getEtat();
            
        
        i++;

            }
             
            //Fermer la connexion
            con.close();st.close();
        }
        catch(SQLException ex)
        {
            
        }
        return data;
   }
    
    //
        public String TestUtilisateur(String nomUtilisateur){
       String codecs=null;
        //Preparer la requete
   String req = "Select * from utilisateur where nomUtilisateur='" + nomUtilisateur + "'";
    // String req="select Id_Cours from Cours natural join options where Nom_Opt='Genie Electronique' and Nom_Cours='Analyse Numerique'";
         try
        {
            //Etablir la connexion
            java.sql.Connection con =DriverManager.getConnection("jdbc:mysql://localhost/GestionUniversite","root","");
            //Creer Statement
            java.sql.Statement st=con.createStatement();
            //Executer la requete
            //Creer un objet de type ResultSet
            ResultSet rs=st.executeQuery(req);
            if(rs.next())
            {
        
                codecs=rs.getString(2); 
               // System.out.println("li jwenn li se :"+ IdOption);
               
            }
            
            else{
                  // System.out.println("li pa  jwenn li se :"+ IdOption);
            }
            con.close(); st.close(); 
          //  System.out.println("Nom option: "+ Nom_Opt );
          
        }
          catch(SQLException ex)
        {
             System.out.println(ex.getMessage() );
    }
       return codecs;
    }
    
    //
             public String EnregistrerTantative(String nomUtilisateur){
        String message="";
                String req = "Insert into tantative(NomUser) values('" + nomUtilisateur + "')";
        
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
           
              
              //
                     public int CompterTantative(String nomUtilisateur){
               int t=0;
              
  String req = "Select count(*) as nombre from tantative where NomUser='" + nomUtilisateur + "'";
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
                     //
                      public int UtilisateurBloque(String nomUtilisateur){
               int t=0;
              
                  String req = "Select etat from utilisateur where nomUtilisateur='" + nomUtilisateur + "'";

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
                 int nom = rs.getInt("etat");
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
                     //
                     
                 public String BloqueUtilisateur(String nomUtilisateur){
        String message="";
                      String req = "update utilisateur set etat='0' where nomUtilisateur='" + nomUtilisateur + "'";

        
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
                 
                 //
                  public String EnregistrerConnexion(String CodeUser,String NomUser){
        String mes="";
           DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String datedujour=""+dtf.format(LocalDateTime.now());
        
        String req="Insert into  connexion values('"+CodeUser+"','"+NomUser+"','"+datedujour+"')";
       int verifier;
       
       try{
           // Etablir la connection
           Connection conect=DriverManager.getConnection("jdbc:mysql://localhost/GestionUniversite","root","");
           // creation d'un statement
           Statement st=conect.createStatement();
               //Utiliser une methode du Statement pour executer la requete
               verifier=st.executeUpdate(req);
               if(verifier!=0){
                  
                   mes="Connexion Enregistrer, son Idendifiant unique est :"+CodeUser;
               }
               
               conect.close(); st.close();
       }
       catch (SQLException e){
           mes="enregistrement echouer /n"+e.getMessage();
       }
        return mes;
    }
                  //
                    public int CompterConnexion(String CodeUser){
               int t=0;
              
  String req = "Select count(*) as nombre from connexion where code='" + CodeUser + "'";
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
      
                     public String ModifierNomUtilisateur( String nomUtilisateur,String code){
        String message="";
        String req="update utilisateur set nomUtilisateur='"+nomUtilisateur+"' where code='"+code+"'";
        
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
                     
                     //
                       public String ModifierPassUtilisateur( String MotPasse,String code){
        String message="";
        String req="update utilisateur set MotPasse='"+MotPasse+"' where code='"+code+"'";
     
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
                 //
                       
                        public String SupprimerTentative(String NomUser){
        String message="";
        String req="delete from  tantative where NomUser='"+NomUser+"'";
        
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
                     
    
}
