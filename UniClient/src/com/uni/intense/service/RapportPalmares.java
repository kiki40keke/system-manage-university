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
public class RapportPalmares {

    public String  RapportPalmares(String Tbody,String NomOption, String NomCours, String NomVacation, String Promotions,String Nomsession,String Nomniveaux) throws IOException {
        
        String Head="<!DOCTYPE html>\n" +
"<html lang=\"en\">\n" +
"<head>\n" +
"    <meta charset=\"UTF-8\">\n" +
"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"    <title>Document</title>\n" +
"\n" +
"    <style>\n" +
"        body {\n" +
"               background: rgb(255, 255, 255); \n" +
"              }\n" +
"page {\n" +
"         background: white;\n" +
"         display: block;\n" +
"          margin: 0 auto;\n" +
"          margin-bottom: 0.5cm;\n" +
"          box-shadow: 0 0 0.5cm #fffefe80;\n" +
"          text-align: center;\n" +
"  }\n" +
"\n" +
"page[size=\"A4\"][layout=\"landscape\"] {\n" +
"  width: 29.7cm;\n" +
"  height: 21cm;  \n" +
"}\n" +
"table {\n" +
"  width: 90%;\n" +
"  max-width: 100%;\n" +
"  margin-bottom: 10px;\n" +
"  border: 1px solid black;\n" +
"  padding: 5px;\n" +
"}\n" +
"/*th{border: 1px solid black; padding: 10px;}*/\n" +
"th, td{border: 1px solid black; padding: 10px;}\n" +
"\n" +
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
"@media print {\n" +
"  body, page {\n" +
"    margin: 0;\n" +
"    box-shadow: 0;\n" +
"\n" +
"  }\n" +
"}\n" +
"hr {\n" +
"  box-sizing: content-box;\n" +
"  height: 0;\n" +
"  overflow: visible;\n" +
"}\n" +
"table {\n" +
"    border-collapse: collapse !important;\n" +
"  }\n" +
"  table td,\n" +
"  table th {\n" +
"    background-color: #fff !important;\n" +
"  }\n" +
"  table th,\n" +
"  table td {\n" +
"    border: 1px solid #dee2e6 !important;\n" +
"  }\n" +
"  table {\n" +
"    color: inherit;\n" +
"  }\n" +
"  table th,\n" +
"  table td,\n" +
"  table thead th,\n" +
"  table tbody + tbody {\n" +
"    border-color: #dee2e6;\n" +
"  }\n" +
"  table .thead-dark th {\n" +
"    color: inherit;\n" +
"    border-color: #dee2e6;\n" +
"  }\n" +
"\n" +
"\n" +
"    </style>\n" +
"</head>\n" +
"<body>\n" +
"    <page size=\"A4\" layout=\"landscape\"> \n" +
"        <div class=\"centered\">\n" +
"          <div ><br>\n" +
"            \n" +
"            <h1>UI</h1>\n" +
"            <h2>Universite Intense</h2>\n" +
"            <h3>Palmaresse</h3>\n" +
"            <h3>16 Bis, 4 Ave H.Christophe, Port-au-Prince</h3>\n" +
"            <hr>\n" +
"          </div>";
          String thead=" <table>\n" +
"        <tr>\n" +
"          <td>Options</td>\n" +
"          <td>"+NomOption+"</td>\n" +
"         <td>Promotions</td>\n" +
"          <td>"+Promotions+"</td>\n" +
"        </tr>\n" +
"        <tr>\n" +
"          <td>Niveau </td>\n" +
"          <td>"+Nomniveaux+"</td>\n" +
"         <td>Session</td>\n" +
"          <td>"+Nomsession+"</td>\n" +
"        </tr>\n" +
"        <tr>\n" +
"          <td>Cours</td>\n" +
"          <td>"+NomCours+"</td>\n" +
"         <td>Vacation</td>\n" +
"          <td>"+NomVacation+"</td>\n" +
"        </tr>\n" +
"      </table>\n" +
"\n" +
"      <br>\n" +
"          <table>\n" +
"             \n" +
"              <thead>\n" +
"                  <tr>\n" +
"                     <th>Code </th>\n" +
"                     <th>Nom </th>\n" +
"                     <th>Prenom </th>\n" +
"                     <th>Examen Intra </th>\n" +
"                     <th>Devoir Intra</th>\n" +
"                     <th>Examen Final</th>\n" +
"                     <th>Devoir Final</th>\n" +
"                     <th>Note Final</th>\n" +
"                     <th>Coefficient</th>   \n" +
"                  </tr>\n" +
"              </thead>\n" +
"              <tbody>";
            String footer="  </tbody>\n" +
"          </table>\n" +
"        </div>\n" +
"    </page>\n" +
"</body>\n" +
"</html>";
        String Html=Head+thead+Tbody+footer;
        //TransformerPdf2 pdf=new TransformerPdf2(Html, "Palmaresse");
return Html;
    }
    
    
}
