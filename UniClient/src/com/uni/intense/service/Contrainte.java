/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uni.intense.service;

/**
 *
 * @author kelly
 */
public class Contrainte {
    public void isletter (java.awt.event.KeyEvent evt){
 // TODO add your handling code here:
          char c=evt.getKeyChar();

            char tiret = '-';
            char apos = '\'';

            if (Character.isLetter(c))
            {
              
            }
//            else if (Character.isDefined(c))
//            {
//               evt.consume();
//            }

            else if (tiret == (c))
            {
               
            }
            else if (apos == (c))
            {
             
            }
            else if (Character.isSpaceChar(c))
            {
              
            }

            else { evt.consume();   }
        
        
        
}
    public void isletterdigit (java.awt.event.KeyEvent evt){
 // TODO add your handling code here:
          char c=evt.getKeyChar();

            char tiret = '-';
      

            if (Character.isLetterOrDigit(c))
            {
              
            }
//            else if (Character.isDefined(c))
//            {
//               evt.consume();
//            }

            else if (tiret == (c))
            {
               
            }
           
            else if (Character.isSpaceChar(c))
            {
              
            }

            else { evt.consume();   }
        
        
        
}
}
