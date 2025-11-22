/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uni.intense.application;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author kelly
 */
public class ServicesCours {
          public String EnregistrerOption(String Nom_Opt){
            Random rd=new Random();
            int val=rd.nextInt(11+9999);
            String Id_Opt="Options-"+val;
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
       
        String datedujour=""+dtf.format(LocalDateTime.now());
        String mes="";
        String req="Insert into  options values('"+Id_Opt+"','"+Nom_Opt+"','"+datedujour+"')";
       int verifier=0;
       try{
           // Etablir la connection
           java.sql.Connection conect=DriverManager.getConnection("jdbc:mysql://localhost/GestionUniversite","root","");
           // creation d'un statement
           java.sql.Statement st=conect.createStatement();
               //Utiliser une methode du Statement pour executer la requete
               verifier=st.executeUpdate(req);
               if(verifier!=0){
                   mes="L'Option  a ete Creer, son Idendifiant unique est :"+Id_Opt;
               }
               
               conect.close(); st.close();
       }
       catch (SQLException e){
           mes="enregistrement echouer /n"+e.getMessage();
       }
        return mes;
    }
        
          public String EnregistrerCours(String Id_Opt,String codeniv,String codesession,String Nomcours){
            Random rd=new Random();
            int val=rd.nextInt(11+9999);
            String Id_Cours="Cours-"+val;
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
       
        String datedujour=""+dtf.format(LocalDateTime.now());
        String mes="";
        String req="Insert into  cours values('"+Id_Cours+"','"+Id_Opt+"','"+codeniv+"','"+codesession+"','"+Nomcours+"','"+datedujour+"')";
       int verifier=0;
       try{
           // Etablir la connection
           java.sql.Connection conect=DriverManager.getConnection("jdbc:mysql://localhost/GestionUniversite","root","");
           // creation d'un statement
           java.sql.Statement st=conect.createStatement();
               //Utiliser une methode du Statement pour executer la requete
               verifier=st.executeUpdate(req);
               if(verifier!=0){
                   mes="Le cours  a ete Creer, son Idendifiant unique est :"+Id_Cours;
               }
               
               conect.close(); st.close();
       }
       catch (SQLException e){
           mes="enregistrement echouer /n"+e.getMessage();
       }
        return mes;
    }
         
          
      public  ArrayList<String> remplirComboOptions()
    {
        ArrayList<String> Al=new ArrayList<String>();
        String req="select Nom_Opt from options";
        try{
            int i=0;
            Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/GestionUniversite","root","");
            Statement st=(Statement) con.createStatement();
            ResultSet rs= st.executeQuery(req);
            while(rs.next())
            {
                Al.add(rs.getString("Nom_Opt"));
                i++;
            }
            st.close(); con.close();
        }catch(SQLException ex)
        {
            
        }
        return Al;
    }
      
       public  ArrayList<String> remplirComboCours(String Id_Opt,String Niveau,String Session)
    {
        ArrayList<String> Al=new ArrayList<>();
        String req="select Nom_Cours from Cours  where Id_Opt='"+Id_Opt+"'and codeniv='"+Niveau+"'and codesession='"+Session+"'";
        try{
            int i=0;
            Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/GestionUniversite","root","");
            Statement st=(Statement) con.createStatement();
            ResultSet rs= st.executeQuery(req);
            while(rs.next())
            {
                Al.add(rs.getString("Nom_Cours"));
                i++;
            }
            st.close(); con.close();
        }catch(SQLException ex)
        {
            
        }
        return Al;
    }
       
           public  ArrayList<String> remplirComboPromotion()
    {
        ArrayList<String> Al=new ArrayList<>();
        String req="SELECT promotion from etudiant GROUP by promotion";
        try{
            int i=0;
            Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/GestionUniversite","root","");
            Statement st=(Statement) con.createStatement();
            ResultSet rs= st.executeQuery(req);
            while(rs.next())
            {
                Al.add(rs.getString("promotion"));
                i++;
            }
            st.close(); con.close();
        }catch(SQLException ex)
        {
            
        }
        return Al;
    }
        public String EnregistrerCoursSelectionner(String IdProfesseur,String Nom_Opt, String Nom_Cours,String Vacation){
            Random rd=new Random();
            String Idcours=RechercherCodeCours(Nom_Opt, Nom_Cours);
            int v=rd.nextInt(3838292);
            String CoursSelect="Cs-"+v;
        String mes="";
        String req="Insert into  CoursSelects values('"+CoursSelect+"','"+IdProfesseur+"','"+Idcours+"','"+Vacation+"')";
       int verifier=0;
       try{
           // Etablir la connection
           java.sql.Connection conect=DriverManager.getConnection("jdbc:mysql://localhost/GestionUniversite","root","");
           // creation d'un statement
           java.sql.Statement st=conect.createStatement();
               //Utiliser une methode du Statement pour executer la requete
               verifier=st.executeUpdate(req);
               if(verifier!=0){
                   mes="Le cours  a ete associer, son Idendifiant unique est :"+CoursSelect;
               }
               
               conect.close(); st.close();
       }
       catch (SQLException e){
           mes="enregistrement echouer /n"+e.getMessage();
       }
        return mes;
    }
       
         public String SuprimmerAttributionCours( String codecs){
        String message="";
        String req="delete from CoursSelects  where codecs='"+codecs+"'";
        
           int verifye=0;
               try
        {
            //Etablir la connexion
            java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost/GestionUniversite","root","");
            //Creation d'un Statement
            java.sql.Statement st=con.createStatement();
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
              
                 public int nombredeligne(String Id_prof){
               int t=0;
              
  String req="Select count(*) as nombre from CoursSelects where Id_prof='"+Id_prof+"'";
    //Preparer la requete
     
        try
        {
            //Etablir la connexion
            java.sql.Connection con =DriverManager.getConnection("jdbc:mysql://localhost/GestionUniversite","root","");
            //Creer Statement
            java.sql.Statement st=con.createStatement();
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
    
    public String[] remplirlisetecours(String Id_prof){
      
                int r=nombredeligne(Id_prof);
                //   String req="select Id_Cours from CoursSelects where Id_prof='"+Id_prof+"'";
                  String req="SELECT codecs from CoursSelects where Id_prof='"+Id_prof+"'";
                   
               int t=0;
               String data[] = new String[r];
              
    //Preparer la requete
      
        try
        {
            //Etablir la connexion
            java.sql.Connection con =DriverManager.getConnection("jdbc:mysql://localhost/GestionUniversite","root","");
            //Creer Statement
            java.sql.Statement st=con.createStatement();
            //Executer la requete
            //Creer un objet de type ResultSet
            ResultSet rs=st.executeQuery(req);
            int i=0;
            while(rs.next())
            {
                 
              data[i]=rs.getString("codecs");
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
      public String InformationCoursSelect(String codecs){
       String IdCours=null;
        //Preparer la requete
       String req="SELECT C.Nom_Cours,Cs.Vacations,O.Nom_Opt  from CoursSelects Cs, Cours C,options O\n" +
"where O.Id_Opt=C.Id_Opt and C.Id_Cours=Cs.Id_Cours and Cs.codecs='"+codecs+"'";
 
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
        
              String Nomcours=rs.getString(1);
                String Vacations=rs.getString(2);
                  String NomOptions=rs.getString(3);
                  
                  IdCours="Options : "+NomOptions+"\n Cours : "+Nomcours+" \n Vacation : "+Vacations;
               
            }
            
            else{
                 System.out.println("li pa  jwenn li se :"+ IdCours);
            }
            
//            System.out.println("Nom option: "+ Nom_Opt );
//            System.out.println("Nom cours: "+ Nom_Cours );
 con.close(); st.close();
        }
          catch(SQLException ex)
        {
           
    }
       return IdCours;
    }
    
    public String RechercherCodeCours(String Nom_Opt, String Nom_Cours){
       String IdCours="nada";
    String Id_Opt=    RechercherCodeOption(Nom_Opt);
        //Preparer la requete
       String req="select Id_Cours from Cours where Id_Opt='"+Id_Opt+"' and Nom_Cours='"+Nom_Cours+"'";
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
        
                IdCours=rs.getString("Id_Cours"); 
                System.out.println("li jwenn li se :"+ IdCours);
               
            }
            
            else{
                 System.out.println("li pa  jwenn li se :"+ IdCours);
            }
            
            System.out.println("Nom option service: "+ Nom_Opt+ " "+Id_Opt );
            System.out.println("Nom cours service: "+ Nom_Cours );
 con.close(); st.close();
        }
          catch(SQLException ex)
        {
           
    }
       return IdCours;
    }
    public String RechercherAttributionCours(String Id_Cours,String Vacations){
       String codecs=null;
        //Preparer la requete
       String req="select codecs from  CoursSelects where Id_Cours='"+Id_Cours+"' and Vacations='"+Vacations+"'";
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
        
                codecs=rs.getString("codecs"); 
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
           
    }
       return codecs;
    }
    
  
    public String RechercherCodeOption(String Nom_Opt){
       String IdOption="nada";
        //Preparer la requete
       String req="select Id_Opt from  options where Nom_Opt='"+Nom_Opt+"'";
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
        
                IdOption=rs.getString("Id_Opt"); 
               // System.out.println("li jwenn li se :"+ IdOption);
               
            }
            
            else{
                  // System.out.println("li pa  jwenn li se :"+ IdOption);
            }
            
          //  System.out.println("Nom option: "+ Nom_Opt );
           con.close(); st.close();
        }
          catch(SQLException ex)
        {
           
    }
       return IdOption;
    }
    
     public String RechercherNomOptions(String Id_Opt){
       String IdOption="nada";
        //Preparer la requete
       String req="select Nom_Opt from  options where Id_Opt='"+Id_Opt+"'";
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
        
                IdOption=rs.getString("Nom_Opt"); 
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
           
    }
       return IdOption;
    }
     public String RechercherCours(String Id_Cours){
       String IdOption="nada";
        //Preparer la requete
       String req="select Nom_Cours from  cours where Id_Cours='"+Id_Cours+"'";
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
        
                IdOption=rs.getString("Nom_Cours"); 
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
           
    }
       return IdOption;
    }
    // lister cours
     public int nombredeligneoptions(String req){
               int t=0;
              
 // String req="select count(*) as nombre from etudiant natural join NotesNormal where codeEvaluationsNormal='"+codeEvaluationsNormal+"'";
    //Preparer la requete
   

        try
        {
            //Etablir la connexion
            java.sql.Connection con =DriverManager.getConnection("jdbc:mysql://localhost/GestionUniversite","root","");
            //Creer Statement
            java.sql.Statement st=con.createStatement();
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
        
          public String[][] ListerOptions(){
               String req1="select Count(*) as nombre from options ";
                int r=nombredeligneoptions(req1);
           //   String req="select Id_Etud,Nom_Etud,Prenom_Etud,notenormal from etudiant natural join NotesNormal where codeEvaluationsNormal='"+codeEvaluationsNormal+"'";
           String req="select * from options ";
           int t=0;
               String data[][] = new String[r][2];
              
    //Preparer la requete
        try
        {
            //Etablir la connexion
            java.sql.Connection con =DriverManager.getConnection("jdbc:mysql://localhost/GestionUniversite","root","");
            //Creer Statement
            java.sql.Statement st=con.createStatement();
            //Executer la requete
            //Creer un objet de type ResultSet
            ResultSet rs=st.executeQuery(req);
            int i=0;
            while(rs.next())
            {
                
               String Id_Opt =rs.getString(1);
               String Nom_Opt =rs.getString(2);
        

        data[i][0] = Id_Opt;
       data[i][1] = Nom_Opt;

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
          public String[][] ListerCours(){
               String req1="select Count(*) as nombre from cours ";
                int r=nombredeligneoptions(req1);
           //   String req="select Id_Etud,Nom_Etud,Prenom_Etud,notenormal from etudiant natural join NotesNormal where codeEvaluationsNormal='"+codeEvaluationsNormal+"'";
           String req="select Id_Cours,Id_Opt,codeniv,codesession,Nom_Cours from cours  order by Id_Opt ";
           int t=0;
               String data[][] = new String[r][4];
              
    //Preparer la requete
        try
        {
            //Etablir la connexion
            java.sql.Connection con =DriverManager.getConnection("jdbc:mysql://localhost/GestionUniversite","root","");
            //Creer Statement
            java.sql.Statement st=con.createStatement();
            //Executer la requete
            //Creer un objet de type ResultSet
            ResultSet rs=st.executeQuery(req);
            int i=0;
            while(rs.next())
            {
                

               String Id_Opt =rs.getString(2);
            String Nom_Opt=    RechercherNomOptions(Id_Opt);
               String codeniv =rs.getString(3);
               String codesession =rs.getString(4);
               String Nom_Cours =rs.getString(5);
           
        data[i][0] = Nom_Cours;
       data[i][1] = Nom_Opt;
       data[i][2] = codeniv;
       data[i][3] = codesession;
       
      
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
}
