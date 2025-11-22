/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uni.intense.application;


import com.uni.intense.domaine.Professeur;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author kelly
 */
public class ProfesseurDal {
    
    public String EnregistrerProfesseur(Professeur Pro){
        String mes="";
        String req="Insert into  professeur values('"+Pro.getId_prof()+"','"+Pro.getMatricule_prof()+"','"+Pro.getNom_prof()+"','"+Pro.getPrenom_prof()+"','"+Pro.getSexe_prof()+"','"+Pro.getTel_prof()+"','"+Pro.getEmail_prof()+"','"+Pro.getAdresse_prof()+"',"
                + "'"+Pro.getNumrefProf()+"','"+Pro.getDateNaissance_prof()+"','"+Pro.getProfessionprof()+"','"+Pro.getEtat_prof()+"','"+Pro.getDateInscription_prof()+"','"+Pro.getUrl()+"','"+Pro.getUrldoc()+"')";
       int verifier=0;
       try{
           // Etablir la connection
           Connection conect=DriverManager.getConnection("jdbc:mysql://localhost/GestionUniversite","root","");
           // creation d'un statement
           Statement st=conect.createStatement();
               //Utiliser une methode du Statement pour executer la requete
               verifier=st.executeUpdate(req);
               if(verifier!=0){
                  // mes="Le professeur a ete embauche, son Idendifiant unique est :"+Pro.getId_prof();
                  mes=Pro.getId_prof();
               }
               
               conect.close(); st.close();
       }
       catch (SQLException e){
           mes="enregistrement echouer /n"+e.getMessage();
       }
        return mes;
    }
    
    public Professeur RechercherProfesseur(String Id_prof, Professeur Pro){
 
        //Preparer la requete
        String req="Select * from professeur where Id_prof='"+Id_prof+"'";
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
               Pro.setId_prof(rs.getString(1));
               Pro.setMatricule_prof(rs.getString(2));
               Pro.setNom_prof(rs.getString(3));
               Pro.setPrenom_prof(rs.getString(4));
               Pro.setSexe_prof(rs.getString(5));
               Pro.setTel_prof(rs.getString(6));
               Pro.setEmail_prof(rs.getString(7));
               Pro.setAdresse_prof(rs.getString(8));
               Pro.setNumrefProf(rs.getString(9));
               Pro.setDateNaissance_prof(rs.getString(10));
               Pro.setProfessionprof(rs.getString(11));
               Pro.setEtat_prof(rs.getString(12)); 
               Pro.setDateInscription_prof(rs.getString(13));
               Pro.setUrl(rs.getString(14));
               Pro.setUrldoc(rs.getString(15));
            }
             con.close(); st.close();
        }
          catch(SQLException ex)
        {
           
    }
       return Pro;
    }
     public String ModifierProfesseur( String Nom_prof,String Prenom_prof,String Tel_prof,String Email_prof,String Adresse_prof,String Etat_prof,String Id_prof  ){
        String message="";
        String req="update professeur set Nom_prof='"+Nom_prof+"',Prenom_prof='"+Prenom_prof+"',Tel_prof='"+Tel_prof+"',Email_prof='"+Email_prof+"',Adresse_prof='"+Adresse_prof+"',Etat_prof='"+Etat_prof+"' where Id_prof='"+Id_prof+"'";
        
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
    
        public String SuprimmerEtudiant( String Id_prof  ){
        String message="";
        String req="delete from professeur  where Id_prof='"+Id_prof+"'";
        
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
              
  String req="Select count(*) as nombre from professeur";
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
    public String[][] ListerProfesseur(){
        Professeur Pro=new Professeur();
                int r=nombredeligne();
              String req="select *from professeur";
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
                
              Pro.setId_prof(rs.getString(1));
               Pro.setMatricule_prof(rs.getString(2));
               Pro.setNom_prof(rs.getString(3));
               Pro.setPrenom_prof(rs.getString(4));
               Pro.setSexe_prof(rs.getString(5));
               Pro.setTel_prof(rs.getString(6));
               Pro.setEmail_prof(rs.getString(7));
               Pro.setAdresse_prof(rs.getString(8));
                Pro.setNumrefProf(rs.getString(9));
                 Pro.setDateNaissance_prof(rs.getString(10));
                  Pro.setProfessionprof(rs.getString(11));
                   Pro.setEtat_prof(rs.getString(12));   
                 
                 
               data[i][0] =      Pro.getId_prof();
             data[i][1] =   Pro.getMatricule_prof();
             data[i][2] =   Pro.getNom_prof();
              data[i][3] =  Pro.getPrenom_prof();
              data[i][4] =  Pro.getSexe_prof();
              data[i][5] =  Pro.getTel_prof();
              data[i][6] =  Pro.getEmail_prof();
              data[i][7] =  Pro.getAdresse_prof();
              data[i][8] =   Pro.getNumrefProf();
               data[i][9] =   Pro.getDateNaissance_prof();
               data[i][10] =    Pro.getProfessionprof();
                 data[i][11] =   Pro.getEtat_prof();   
        
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
       public String ModifierUrlPhoto(String Codeprof, String url){
        String message="";
        String req="update professeur set urlphoto='"+url+"' where Id_prof='"+Codeprof+"'";
        
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
               
                 message="Modification fait avec succes!";
                            
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
       public String ModifierUrldoc(String Codeprof, String url){
        String message="";
        String req="update professeur set urldoc='"+url+"' where Id_prof='"+Codeprof+"'";
        
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
               
                 message="Modification fait avec succes!";
                            
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
}
