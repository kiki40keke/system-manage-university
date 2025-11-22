/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uniclient;

import com.alee.laf.WebLookAndFeel;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatAllIJThemes;
import com.formdev.flatlaf.intellijthemes.FlatArcIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatCyanLightIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatDarkFlatIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatGrayIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatLightFlatIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatMaterialDesignDarkIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatSolarizedDarkContrastIJTheme;
import com.uni.intense.presentation.InterfaceNote;
import com.uni.intense.service.TransfererFichier;
import com.uni.intense.vue.FenMenuUniv;
import com.uni.intense.vue.login;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Scanner;
import javax.swing.UIManager;

/**
 *
 * @author jP
 */
public class UniClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NamingException, RemoteException, UnknownHostException, Exception {
        // TODO code application logic here
   try
    {
    // look and feel Flat
       FlatLightFlatIJTheme.setup();

      //   look and feel beauty
   //     org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
    //   UIManager.put("RootPane.setupButtonVisible", false);
       //  look and feel web 
     //   WebLookAndFeel.install ();
    }
    catch(Exception e)
    {
       // TODO exception
    }


////        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FenMenuUniv().setVisible(true);
        });

 
        
       
    }
    
   
}
