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
public class RapportListeHtmlEtudiant {
    public RapportListeHtmlEtudiant(String Tbody) throws IOException{
        String Head="<!DOCTYPE html>\n" +
"<html lang=\"en\">\n" +
"<head>\n" +
"    <meta charset=\"UTF-8\">\n" +
"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"    <style>\n" +
"        th, td{border: 1px solid black; padding: 10px;}\n" +
"caption{ background-color: #0AD; font-weight: bold;}\n" +
"div.centered \n" +
"{\n" +
"    text-align: center;\n" +
"}\n" +
"\n" +
"div.centered table \n" +
"{\n" +
"    margin: 0 auto; \n" +
"    text-align: left;\n" +
"}\n" +
"    </style>\n" +
"    <title>Document</title>\n" +
"</head>"
                ;
        
           String Thead="<body>\n" +
"    <div class=\"centered\">\n" +
"    <h1>UNASMOH</h1>\n" +
"    <h2>universite des sciences modernes d'haiti</h2>\n" +
"  \n" +
"        <table>\n" +
"          \n" +
"            <thead>\n" +
"                <tr>\n" +
"                   <th>Code </th>\n" +
"                   <th>Nom </th>\n" +
"                   <th>Prenom </th>\n" +
"                   <th>Sexe </th>\n" +
"                   <th>Telephone</th>\n" +
"                   <th>Email</th>\n" +
"                   <th>Adresse</th>\n" +
"                   <th>Date d'inscription</th>   \n" +
"                </tr>\n" +
"            </thead>\n" +
"            <tbody>";
                   
    
    String Foot="  </tbody>\n" +
"        </table>\n" +
"    </div>\n" +
"</body>\n" +
"</html> ";
        
    String HTML=Head+Thead+Tbody+Foot;
    //TransformerLandscapePdf pdf=new TransformerLandscapePdf(HTML, "ListeEtudiant");
    
        
    }
    
 
}
