/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uni.intense.service;
import java.io.File;
import javax.swing.filechooser.FileFilter;
/**
 *
 * @author kelly
 */
public class DocFilterJava extends FileFilter{
  
   private final static String Pdfdoc = "pdf";
  
    @Override
    public boolean accept(File f) {
       if (f.isDirectory()) {
         return true;
      }

      String extension = getExtension(f);
      if (extension != null) {
           return extension.equals(Pdfdoc);
      }
      return false;
    }

    @Override
    public String getDescription() {
       return "Pdf  Uniquement ";
    }
    
      String getExtension(File f) {
      String ext = null;
      String s = f.getName();
      int i = s.lastIndexOf('.');
   
      if (i > 0 &&  i < s.length() - 1) {
         ext = s.substring(i+1).toLowerCase();
      }
      return ext;
   }
}
