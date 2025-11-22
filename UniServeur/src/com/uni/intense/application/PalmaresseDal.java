/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uni.intense.application;


import com.uni.intense.domaine.Employe;
import com.uni.intense.domaine.Palmaresse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author kelly
 */
public class PalmaresseDal {
    
    public String EnregistrerPalmares(Palmaresse Pro){
        String mes="";
        String req="Insert into  palmares values('"+Pro.getCodepalmares()+"','"+Pro.getId_Opt()+"','"+Pro.getId_Cours()+"','"+Pro.getNomVacation()+"','"+Pro.getCoeficienttotal()+"','"+Pro.getPromotion()+"','"+Pro.getDatepalmares()+"')";
       int verifier=0;
       try{
           // Etablir la connection
           Connection conect=DriverManager.getConnection("jdbc:mysql://localhost/GestionUniversite","root","");
           // creation d'un statement
           Statement st=conect.createStatement();
               //Utiliser une methode du Statement pour executer la requete
               verifier=st.executeUpdate(req);
               if(verifier!=0){
                   mes="Le Palmares a ete Creer, son Idendifiant unique est :"+Pro.getCodepalmares();
               }
               
               conect.close(); st.close();
       }
       catch (SQLException e){
           mes="enregistrement echouer /n"+e.getMessage();
       }
        return mes;
    }
    
        public String RechercherCodePlamares(String Id_Opt, String Id_Cours, String NomVacation, String Promotion){
       String Codepalmares=null;
        //Preparer la requete
       String req="select Codepalmares from palmares where Id_Opt='"+Id_Opt+"' and Id_Cours='"+Id_Cours+"' and NomVacation='"+NomVacation+"' and Promotion='"+Promotion+"'";
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
        
                Codepalmares=rs.getString("Codepalmares"); 
                System.out.println("li jwenn li se :"+ Codepalmares);
               
            }
            
            else{
                   System.out.println("li pa  jwenn li se :"+ Codepalmares);
            }
            
          con.close(); st.close(); 
        }
          catch(SQLException ex)
        {
           
    }
       return Codepalmares;
    }
     
        public String RechercherPlamares( String Codepalmares, Palmaresse Pal){
       String message=null;
        //Preparer la requete
       String req="select  *from palmares where Codepalmares='"+Codepalmares+"'";
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
               Pal.setCodepalmares(rs.getString(1));
               Pal.setId_Opt(rs.getString(2));
               Pal.setId_Cours(rs.getString(3));
               Pal.setNomVacation(rs.getString(4));
               Pal.setCoeficienttotal(rs.getInt(5));
               Pal.setPromotion(rs.getString(6));
               Pal.setDatepalmares(rs.getString(7));
            }
            
          con.close(); st.close();
            
          
        }
          catch(SQLException ex)
              
        {
           message="enregistrement echouer /n"+ex.getMessage();
    }
       return message;
    }  
        
        // lister
           public int nombredeligne2(){
               int t=0;
              
    //Preparer la requete
         String req="select count(*) as nombre from palmares";
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
        
          public String[][] ListerPalmares2(){
    
                int r=nombredeligne2();
           //   String req="select Id_Etud,Nom_Etud,Prenom_Etud,notenormal from etudiant natural join NotesNormal where codeEvaluationsNormal='"+codeEvaluationsNormal+"'";
              String req="select *from palmares";
           int t=0;
               String data[][] = new String[r][7];
              System.out.println(r);
    //Preparer lSa requete
      
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
              
               String Codepalmares=rs.getString(1);
              String Id_Opt=rs.getString(2);
               String Id_Cours=rs.getString(3);
               String NomVacation=rs.getString(4);
               int Coeficienttotal=rs.getInt(5);
               String Promotion=rs.getString(6);
               String Datepalmares=rs.getString(7);
               
               ServicesCours ser=new ServicesCours();
               String NomOptions=ser.RechercherNomOptions(Id_Opt);
               String Nomcours =ser.RechercherCours(Id_Cours);
               
            data[i][0] = Codepalmares;  
             data[i][1] = NomOptions;     
              data[i][2] = Nomcours;     
               data[i][3] = NomVacation;     
                data[i][4] = String.valueOf( Coeficienttotal);     
                 data[i][5] = Promotion;     
                  data[i][6] = Datepalmares;     
                  System.out.println(Nomcours);
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
          
         
        
        public int nombredeligne(String codepalmares){
               int t=0;
              
 // String req="select count(*) as nombre from etudiant natural join NotesNormal where codeEvaluationsNormal='"+codeEvaluationsNormal+"'";
    //Preparer la requete
     String req="select count(*) as nombre  from Etudiant E,Palmares P \n" +
"where E.promotion=P.promotion and  E.NomVacation=P.NomVacation  and E.Id_Opt=P.Id_Opt \n" +
" and codepalmares='"+codepalmares+"'";
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
        
          public String[][] ListerPalmares(String codepalmares){
       
                int r=nombredeligne(codepalmares);
           //   String req="select Id_Etud,Nom_Etud,Prenom_Etud,notenormal from etudiant natural join NotesNormal where codeEvaluationsNormal='"+codeEvaluationsNormal+"'";
          String req = "select E.Id_Etud,E.Nom_Etud,E.Prenom_Etud from Etudiant E,Palmares P,Cours C,nivoetudiants N  \n" +
"where N.codeniv=C.codeniv and  C.Id_Cours=P.Id_Cours and  N.Id_Etud=E.Id_Etud and E.promotion=P.promotion and  E.NomVacation=P.NomVacation  and E.Id_Opt=P.Id_Opt \n" +
" and codepalmares='" + codepalmares + "'";
           int t=0;
               String data[][] = new String[r][9];
              
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
                
               String Id_Etud =rs.getString(1);
               
              String  Nom_Etud=rs.getString(2);
               String Prenom_Etud=rs.getString(3);
                     String reqnote="select notenormal from NotesNormal natural join EvaluationsNormal  where codepalmares='"+codepalmares+"' and TypesNormal='Intra' \n" +
"and  DescriptionsNormal='Examen'  and Id_Etud='"+Id_Etud+"'";
String noteexamenintra=RechercherNotes(reqnote);
                        if(noteexamenintra==null){
                       noteexamenintra="0.0";
                    }  
                        
                        reqnote="select notenormal from NotesNormal natural join EvaluationsNormal  where codepalmares='"+codepalmares+"' and TypesNormal='Intra' \n" +
"and  DescriptionsNormal='Devoir'  and Id_Etud='"+Id_Etud+"'";
String notedevoirintra=RechercherNotes(reqnote);
                        if(notedevoirintra==null){
                       notedevoirintra="0.0";
                    } 
                        
                           reqnote="select notenormal from NotesNormal natural join EvaluationsNormal  where codepalmares='"+codepalmares+"' and TypesNormal='Final' \n" +
"and  DescriptionsNormal='Examen'  and Id_Etud='"+Id_Etud+"'";
String noteexamenfinal=RechercherNotes(reqnote);
                        if(noteexamenfinal==null){
                       noteexamenfinal="0.0";
                    } 
                        
           
                        
                        reqnote="select notenormal from NotesNormal natural join EvaluationsNormal  where codepalmares='"+codepalmares+"' and TypesNormal='Final' \n" +
"and  DescriptionsNormal='Devoir'  and Id_Etud='"+Id_Etud+"'";
String notedevoirfinal=RechercherNotes(reqnote);
                        if(notedevoirfinal==null){
                       notedevoirfinal="0.0";
                    } 
                        
                        
                        double noteexamenintra2=Double.valueOf(noteexamenintra);
                        double notedevoirintra2=Double.valueOf(notedevoirintra);
                           double noteexamenfinal2=Double.valueOf(noteexamenfinal);
                              double notedevoirfinal2=Double.valueOf(notedevoirfinal);
                        double notefinal=noteexamenintra2+notedevoirintra2+noteexamenfinal2+notedevoirfinal2;
                        
                            int i_val = (int) Math.round(notefinal);
                        String note=String.valueOf(i_val);
                       String CoeficientNormal="100";
                       //
                         if(noteexamenintra=="0.0"){
                       noteexamenintra="-";
                    }  
                          if(notedevoirintra=="0.0"){
                       notedevoirintra="-";
                    } 
                            if(noteexamenfinal=="0.0"){
                       noteexamenfinal="-";
                    } 
                      if(notedevoirfinal=="0.0"){
                       notedevoirfinal="-";
                    } 
//      
        data[i][0] = Id_Etud;
        data[i][1] = Nom_Etud;
        data[i][2] = Prenom_Etud;
        data[i][3] = noteexamenintra;
        data[i][4] = notedevoirintra;
        data[i][5] = noteexamenfinal;
        data[i][6] = notedevoirfinal;
          data[i][7] = note;
        data[i][8] = CoeficientNormal;
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
          
           public String RechercherNotes(String reqnote){
       String nombre=null;
        //Preparer la requete
    // String req="select Id_Cours from Cours natural join options where Nom_Opt='Genie Electronique' and Nom_Cours='Analyse Numerique'";
         try
        {
            //Etablir la connexion
            java.sql.Connection con =DriverManager.getConnection("jdbc:mysql://localhost/GestionUniversite","root","");
            //Creer Statement
            java.sql.Statement st=con.createStatement();
            //Executer la requete
            //Creer un objet de type ResultSet
            ResultSet rs=st.executeQuery(reqnote);
            if(rs.next())
            {
        
                nombre=rs.getString("notenormal"); 
             //  System.out.println("li jwenn li se :"+ nombre);
               
            }
            
            else{
               //   System.out.println("li pa note la  jwenn li se :\n"+ reqnote);
            }
            
           con.close(); st.close();
        }
          catch(SQLException ex)
        {
           
    }
       return nombre;
    }
           
          public ArrayList<String> RechercherPalmares( String codepalmares){
             ArrayList<String> Al=new ArrayList<String>();
       String message=null;
        //Preparer la requete
       String req="select O.Nom_Opt,C.Nom_Cours,P.NomVacation,P.Promotion,S.NomSession,N.Niveau\n" +
"from Options O,Cours C,palmares P,Sessionx S,Niveaux N \n" +
"where O.Id_Opt=P.Id_Opt and N.codeniv=C.codeniv and S.codesession=C.codesession  \n" +
"and C.Id_Cours=P.Id_Cours and P.codepalmares='"+codepalmares+"'";
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
                Al.add(rs.getString(1));
                Al.add(rs.getString(2));
                Al.add(rs.getString(3));
                Al.add(rs.getString(4));
                Al.add(rs.getString(5));
                Al.add(rs.getString(6));
            }
          con.close(); st.close();   
          
        }
          catch(SQLException ex)
              
        {
           message="enregistrement echouer /n"+ex.getMessage();
    }
       return Al;
    }      
}
