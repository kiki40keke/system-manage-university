/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uni.intense.service;

import java.io.IOException;

/**
 *
 * @author kelly
 */
public class RapportHtmlEtudiant {
    public RapportHtmlEtudiant (String Id_Etu,String Nom_Etu, String Prenom_Etu, String Sexe_Etud, String Tel_Etud, String Email_Etu, String Adresse_Etu) throws IOException{
        String Head="<!DOCTYPE html>\n" +
"<html lang=\"en\">\n" +
"<head>\n" +
"    <meta charset=\"UTF-8\">\n" +
"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"    <title>Document</title>\n" +
"    <style>\n" +
"        th, td{border: 1px solid black; padding: 10px;}\n" +
"caption{ background-color: #0AD; font-weight: bold;}\n" +
"    </style>\n" +
"</head>";
        String Body="<body>\n" +
"    <center>\n" +
"    <p style=\"text-align: center;\">\n" +
"     <h1>Rapport</h1>\n" +
"   \n" +
"\n" +
"   \n" +
"     <table >\n" +
"        <caption>Information Sur L'etudiant</caption>\n" +
"        <tr>\n" +
"            <td>ID</td>\n" +
"            <td>"+Id_Etu+"</td>\n" +
"        </tr>\n" +
"        <tr>\n" +
"            <td>Nom</td>\n" +
"            <td>"+Nom_Etu+"</td>\n" +
"         </tr> \n" +
"          <tr>\n" +
"            <td>Prenom</td>\n" +
"            <td>"+Prenom_Etu+"</td>\n" +
"          </tr>\n" +
"         <tr>\n" +
"            <td>Sexe</td>\n" +
"            <td>"+Sexe_Etud+"</td>\n" +
"         </tr>\n" +
"         <tr>\n" +
"            <td>Tel</td>\n" +
"            <td>"+Tel_Etud+"</td>\n" +
"         </tr>\n" +
"         <tr>\n" +
"            <td>Email</td>\n" +
"            <td>"+Email_Etu+"</td>\n" +
"         </tr>\n" +
"         <tr>\n" +
"            <td>Adresse</td>\n" +
"            <td>"+Adresse_Etu+"</td>\n" +
"\n" +        
"      </table>\n" +
"    </p>\n" +
"</center>\n" +
"</body>\n" +
"</html>";
        
         String HTML=Head+Body;
       //  TransformerLandscapePdf pdf=new TransformerLandscapePdf(HTML, Id_Etu);
    }
}
