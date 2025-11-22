/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uni.intense.service;
import java.io.File;
import com.itextpdf.html2pdf.HtmlConverter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;


/**
 *
 * @author kelly
 */
public final class TransformerPortraitPdf  {
    public int  TransformerPortraitPdf(String HTML,String code){
        int verif=0;
      String DEST = "C:src/"+code+".pdf";
        	File file = new File(DEST);
		file.getParentFile().mkdirs();
             int mola=   createPdf(HTML, DEST);
             if(mola==1){
                   verif=1;
                  ServiceInterNet nt=new ServiceInterNet();
                int se=  nt.OpenNavigator(DEST);
                if(se==1){
                verif=2;
                }
                
             } 
          return verif;
    }
    
    	public int createPdf(String html, String dest)  {
            int v=0;
        try {
            HtmlConverter.convertToPdf(html, new FileOutputStream(dest));
            v=1;
        } catch (FileNotFoundException ex) {
           // Logger.getLogger(TransformerPortraitPdf.class.getName()).log(Level.SEVERE, null, ex);
           v=0;
        }
        return v;
	}
    
    
}
