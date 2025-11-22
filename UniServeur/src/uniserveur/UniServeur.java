/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uniserveur;


import com.uni.intense.controleur.ControlleurEtudiants;
import com.uni.intense.controleur.ControlleurPaiement;
import com.uni.intense.controleur.ControlleurUtilisateur;
import com.uni.intense.controleur.EmployerControlleur;
import com.uni.intense.controleur.EvaluationsNormalControlleur;
import com.uni.intense.controleur.NoteControlleur;
import com.uni.intense.controleur.PalmaresControlleur;
import com.uni.intense.controleur.ProfesseurControlleur;
import com.uni.intense.controleur.RmiImplementation;
import com.uni.intense.controleur.ServicesControleur;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
/**
 *
 * @author jP
 */
public class UniServeur {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException, NamingException, UnknownHostException {
        // TODO code application logic here
        System.out.println("Implementation");
        
        System.out.println("Construction de l'implementation");
          
         ControlleurEtudiants etud=new ControlleurEtudiants();
         ServicesControleur ser=new ServicesControleur();
         ProfesseurControlleur prof=new ProfesseurControlleur();
         EmployerControlleur emp=new EmployerControlleur();
         PalmaresControlleur palm=new PalmaresControlleur();
         EvaluationsNormalControlleur eval=new EvaluationsNormalControlleur();
         NoteControlleur note=new NoteControlleur();
         ControlleurUtilisateur uti=new ControlleurUtilisateur();
         ControlleurPaiement paie=new ControlleurPaiement();
             RmiImplementation img=new RmiImplementation();
       
        System.out.println("liaison avec la base de registre");
        java.rmi.registry.LocateRegistry.createRegistry(1099);
           //   liason Etudiant
        Context contetu=new InitialContext();
        contetu.bind("rmi:Etudiants:1054", etud);
                 //   liason Services
         Context contser=new InitialContext();
        contser.bind("rmi:Service:1054", ser);
//     
   // liaison Proffesseur
        Context contprof=new InitialContext();
        contprof.bind("rmi:Professeur:1054",prof);
         // liaison Employe
        Context contemp=new InitialContext();
        contemp.bind("rmi:Employe:1054",emp);
              // liaison Utilisateur
        Context contuti=new InitialContext();
        contuti.bind("rmi:Utilisateur:1054",uti);
         // liaison Palmaresse
        Context contpalm=new InitialContext();
        contpalm.bind("rmi:Palmaresse:1054",palm);
         // liaison Evaluation
        Context conteval=new InitialContext();
        conteval.bind("rmi:Evaluation:1054",eval);
        // liaison Note
                Context contnote=new InitialContext();
        contnote.bind("rmi:Note:1054",note);
              //   liason Paiement
         Context contpaie=new InitialContext();
        contpaie.bind("rmi:Paiement:1054", paie);
        
         Context contimg=new InitialContext();
        contimg.bind("rmi:Image:1054", img);
        
        System.out.println("En attente de requettes...");
        
    
        
   
    }
    
}
