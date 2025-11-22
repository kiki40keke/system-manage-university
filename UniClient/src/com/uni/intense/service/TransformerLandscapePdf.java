/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uni.intense.service;
import java.io.File;
import java.io.IOException;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.events.Event;
import com.itextpdf.kernel.events.IEventHandler;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfName;
import com.itextpdf.kernel.pdf.PdfNumber;
import com.itextpdf.kernel.pdf.PdfWriter;

import com.itextpdf.styledxmlparser.css.media.MediaDeviceDescription;
import com.itextpdf.styledxmlparser.css.media.MediaType;

/**
 *
 * @author kelly
 */
public final class TransformerLandscapePdf {
      public static final PdfNumber PORTRAIT = new PdfNumber(0);
    public static final PdfNumber LANDSCAPE = new PdfNumber(90);
    public static final PdfNumber INVERTEDPORTRAIT = new PdfNumber(180);
    public static final PdfNumber SEASCAPE = new PdfNumber(270);
     public  void TransformerLandscapePdf(String HTML,String Id_Etu)throws IOException{
        String DEST = "C:src/"+Id_Etu+".pdf";
        
        
        	File file = new File(DEST);
		file.getParentFile().mkdirs();
                createPdf(HTML, DEST);
                 ServiceInterNet nt=new ServiceInterNet();
                int se=  nt.OpenNavigator(DEST);
                  System.out.println("Rapport Pdf Effectuer, nom du fichier: "+Id_Etu);
                  
        
    }
    
    	public void createPdf(String html, String dest) throws IOException {

 PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));
 pdfDoc.setTagged();
    PageSize pageSize = PageSize.A4.rotate();
    pdfDoc.setDefaultPageSize(pageSize);
      ConverterProperties properties = new ConverterProperties();
  //  properties.setBaseUri(baseUri);
    MediaDeviceDescription mediaDeviceDescription
        = new MediaDeviceDescription(MediaType.SCREEN);
    mediaDeviceDescription.setWidth(pageSize.getWidth());
    properties.setMediaDeviceDescription(mediaDeviceDescription);
  

		HtmlConverter.convertToPdf(html, pdfDoc,properties);
	}
        
        



 private static class PageOrientationsEventHandler implements IEventHandler {
        private PdfNumber orientation = PORTRAIT;

        public void setOrientation(PdfNumber orientation) {
            this.orientation = orientation;
        }

        @Override
        public void handleEvent(Event currentEvent) {
            PdfDocumentEvent docEvent = (PdfDocumentEvent) currentEvent;
            docEvent.getPage().put(PdfName.Rotate, orientation);
        }
    }
}