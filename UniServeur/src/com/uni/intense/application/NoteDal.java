/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uni.intense.application;



import com.uni.intense.domaine.Note;
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
public class NoteDal {
    
    public String EnregistrerNotesNormal(Note N){
         String mes="";
    
        
        String req="Insert into  NotesNormal values('"+N.getCodenotnormal()+"','"+N.getCodeEvaluationsNormal()+"','"+N.getId_Etud()+"','"+N.getNotenormal()+"','"+N.getDateenregnormal()+"')";
       int verifier=0;
       try{
           // Etablir la connection
           Connection conect=DriverManager.getConnection("jdbc:mysql://localhost/GestionUniversite","root","");
           // creation d'un statement
           Statement st=conect.createStatement();
               //Utiliser une methode du Statement pour executer la requete
               verifier=st.executeUpdate(req);
               if(verifier!=0){
                
                   mes="La note a ete Creer, son Idendifiant unique est :"+N.getCodenotnormal();
                  
               }
               
               conect.close(); st.close();
       }
       catch (SQLException e){
           mes="enregistrement echouer /n"+e.getMessage();
       }
        return mes;
    }
    
    public Note RechercherNote(String codeEvaluationsNormal, String Id_Etud, Note N){
      
        //Preparer la requete
        String req="Select * from NotesNormal where codeEvaluationsNormal='"+codeEvaluationsNormal+"' and Id_Etud='"+Id_Etud+"'";
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
              N.setCodenotnormal(rs.getString(1));
               N.setCodeEvaluationsNormal(rs.getString(2));
               N.setId_Etud(rs.getString(3));
               N.setNotenormal(Double.valueOf( rs.getString(4)));
               N.setDateenregnormal(rs.getString(5));
               
            }
             con.close(); st.close();
        }
          catch(SQLException ex)
        {
           
    }
       return N;
    }
    
    public String ModifierNotes(String codeEvaluationsNormal, String Id_Etud,double notenormal){
        String message="";
        String req="update NotesNormal set notenormal='"+notenormal+"' where codeEvaluationsNormal='"+codeEvaluationsNormal+"' and Id_Etud='"+Id_Etud+"'";
        
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
    
        public String SuprimmerNotes( String codeEvaluationsNormal, String Id_Etud){
        String message="";
        String req="delete from NotesNormal  where codeEvaluationsNormal='"+codeEvaluationsNormal+"' and Id_Etu='"+Id_Etud+"'";
        
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
    
        
          // lister 
        public int nombredeligne(String Id_Opt,String codeniv,String codesession,String Id_Etud){
               int t=0;
              
 // String req="select count(*) as nombre from etudiant natural join NotesNormal where codeEvaluationsNormal='"+codeEvaluationsNormal+"'";
    //Preparer la requete
            String req = "select Count(*) as nombre from cours where codeniv='" + codeniv + "' and codesession='" + codesession + "' and Id_Opt in(select Id_Opt from etudiant where Id_Etud='" + Id_Etud + "')";

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
        
          public String[][] ListerBulletin(String Id_Opt,String codeniv,String codesession,String Id_Etud,String NomVacation, String Promotion){
       
                int r=nombredeligne(Id_Opt, codeniv, codesession, Id_Etud);
           //   String req="select Id_Etud,Nom_Etud,Prenom_Etud,notenormal from etudiant natural join NotesNormal where codeEvaluationsNormal='"+codeEvaluationsNormal+"'";
            String req = "select Id_Cours,Nom_Cours from cours where codeniv='" + codeniv + "' and codesession='" + codesession + "' and Id_Opt in(select Id_Opt from etudiant where Id_Etud='" + Id_Etud + "')"; 

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
                
               String Id_Cours =rs.getString(1);
               String Nom_Cours =rs.getString(2);
          String note=RechercherCodePlamares(Id_Opt, Id_Cours, NomVacation, Promotion, Id_Etud);
           String notereprise="......";
          String notereprise2="......";
          

        data[i][0] = Nom_Cours;
       data[i][1] = note;
       data[i][2] = "100";
       data[i][3] = notereprise;
       data[i][4] = notereprise2;
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
          
          
            public String RechercherCodePlamares(String Id_Opt, String Id_Cours, String NomVacation, String Promotion,String Id_Etud){
       String Codepalmares=null;
       String note="0";
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
                System.out.println("li jwenn li codepalmares la  se :"+ Codepalmares);
                 String reqnote="select notenormal from NotesNormal natural join EvaluationsNormal  where codepalmares='"+Codepalmares+"' and TypesNormal='Intra' \n" +
"and  DescriptionsNormal='Examen'  and Id_Etud='"+Id_Etud+"'";
String noteexamenintra=RechercherNotes(reqnote);
                        if(noteexamenintra==null){
                       noteexamenintra="0.0";
                    }  
                        
                        reqnote="select notenormal from NotesNormal natural join EvaluationsNormal  where codepalmares='"+Codepalmares+"' and TypesNormal='Intra' \n" +
"and  DescriptionsNormal='Devoir'  and Id_Etud='"+Id_Etud+"'";
String notedevoirintra=RechercherNotes(reqnote);
                        if(notedevoirintra==null){
                       notedevoirintra="0.0";
                    } 
                        
                           reqnote="select notenormal from NotesNormal natural join EvaluationsNormal  where codepalmares='"+Codepalmares+"' and TypesNormal='Final' \n" +
"and  DescriptionsNormal='Examen'  and Id_Etud='"+Id_Etud+"'";
String noteexamenfinal=RechercherNotes(reqnote);
                        if(noteexamenfinal==null){
                       noteexamenfinal="0.0";
                    } 
                        
           
                        
                        reqnote="select notenormal from NotesNormal natural join EvaluationsNormal  where codepalmares='"+Codepalmares+"' and TypesNormal='Final' \n" +
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
                         note=String.valueOf(i_val);
               
            }
            
            else{
                   System.out.println("li pa  jwenn li se :"+ Codepalmares);
            }
       con.close(); st.close();      
          
        }
          catch(SQLException ex)
        {
           
    }
       return note;
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
               System.out.println("li jwenn li se :"+ nombre);
               
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
           
           //
            public String RechercherSommation(String reqnote){
       String nombre="0";
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
        
                nombre=rs.getString("nombre"); 
              System.out.println("li somme  li vre se :"+ nombre+ reqnote);
              if(nombre==null){
              nombre="0";
              }
               
            }
            
            else{
                 System.out.println("li pa note la  jwenn li se :\n"+ reqnote);
            }
            
          con.close(); st.close(); 
        }
          catch(SQLException ex)
        {
            System.out.println("li pa note la  jwenn li se :\n"+ ex.getMessage());
    }
       return nombre;
    }
           //
            public ArrayList<String> RechercherBulletin( String codeniv,String codesession,String Id_Etud){
             ArrayList<String> Al=new ArrayList<>();
       String message=null;
        //Preparer la requete
       String req="select O.Nom_Opt,E.NomVacation,E.Promotion,S.NomSession,N.Niveau,E.Nom_Etud,E.Prenom_Etud,E.Id_Etud,O.Id_Opt " +
    "from Options O,Cours C,Sessionx S,Niveaux N ,Etudiant E " +
    "where  N.codeniv=C.codeniv and S.codesession=C.codesession  " +
    "and   C.codeniv='"+codeniv+"' and C.codesession='"+codesession+"' and  C.Id_Opt=O.Id_Opt  " +
    " and O.Id_Opt=E.Id_Opt and E.Id_Etud='"+Id_Etud+"' ";
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
                   String req1 = "select SUM(N.notenormal) as nombre  from NotesNormal N,Cours C,etudiant E,Palmares P,EvaluationsNormal S  where\n" +
    " N.codeEvaluationsNormal=S.codeEvaluationsNormal and  S.codepalmares= P.codepalmares and   C.Id_Cours=P.Id_Cours  and \n" +
    " P.NomVacation=E.NomVacation and E.Id_Etud=N.Id_Etud and    C.codeniv='" + codeniv + "' and C.codesession='" + codesession + "' and P.Id_Opt='" + rs.getString("Id_Opt") + "'  and N.Id_Etud='" + Id_Etud + "'";
             String Sommenote=RechercherSommation(req1);
                    String req2 = "select count(*) as nombre from cours  where Id_Opt='" + rs.getString("Id_Opt") + "'  and codeniv='" + codeniv + "' and codesession='" + codesession + "' ;";
               String Nombrecours=RechercherSommation(req2);
             double nombre=Double.parseDouble(Nombrecours);
             double total=nombre*100;
             String total2=String.valueOf(total);
             double Sommenote2=Double.parseDouble(Sommenote);
             double moyenne=Sommenote2*10/total;
             String moyenne2=String.valueOf(moyenne);
                Al.add(rs.getString(1));
                //System.out.println(rs.getString(1));
                Al.add(rs.getString(2));
      //  System.out.println(rs.getString(2));
                Al.add(rs.getString(3));
          //       System.out.println(rs.getString(3));
                Al.add(rs.getString(4));
           //      System.out.println(rs.getString(4));
                Al.add(rs.getString(5));
            //     System.out.println(rs.getString(5));
                Al.add(rs.getString(6));
             //    System.out.println(rs.getString(6));
                Al.add(rs.getString(7));
              //   System.out.println(rs.getString(7));
                 Al.add(rs.getString(8));
               //   System.out.println(rs.getString(8));
                Al.add(Sommenote);
               //  System.out.println(Sommenote);
                   Al.add(total2);
                   //     System.out.println(total2);
               Al.add(moyenne2);
                   // System.out.println(moyenne2);
            
            
               
            }
            
            else {
                System.out.println("kk voye");
            }
            
        con.close(); st.close();   
        }
          catch(SQLException ex)
              
        {
           message="enregistrement echouer /n"+ex.getMessage();
            System.out.println(message);
    }
       return Al;
    }   
            //
            public int RechercherBulletin2( String codeniv,  String Id_Etud, String NomVacation, String Promotion){
 String solde=null;
    int nombre = 0;
        //Preparer la requete
            String req = "select Id_Cours,Id_Opt from cours where codeniv='" + codeniv + "'  and Id_Opt in(select Id_Opt from etudiant where Id_Etud='" + Id_Etud + "')";
         try
        {   
            //Etablir la connexion
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost/GestionUniversite","root","");
            //Creer Statement
            Statement st=con.createStatement();
            //Executer la requete
            //Creer un objet de type ResultSet
            ResultSet rs=st.executeQuery(req);
             int i = 0;
                
                while (rs.next())
                {   
                    String Id_Cours = rs.getString(1);
                    String Id_Opt = rs.getString(2);
                    System.out.println(Id_Cours);
                    String note = RechercherCodePlamares(Id_Opt, Id_Cours, NomVacation, Promotion, Id_Etud);
                    int note2 = Integer.parseInt(note);

                   if(note2<65){
                       nombre++;
                       System.out.println(nombre);
                   }
                    i++;
   
                }
             con.close(); st.close();
        }
          catch(SQLException ex)
            
        {
           solde=ex.getMessage();  
    }
                  System.out.println(solde); 
       return nombre;
    }
}
