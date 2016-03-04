/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework;

import editorframework.pdfbox.PDFBoxDocumentAdaptee;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author aluno
 */

//Esse link tem um exemplo legal do adapter...http://www.programcreek.com/2011/09/java-design-pattern-adapter/
public class PDFDocumentAdapter extends PDFDocument {
    private PDFBoxDocumentAdaptee adaptee;
   
    public PDFDocumentAdapter(PDFBoxDocumentAdaptee adaptee){
        this.adaptee = adaptee;
    }
    
    
    @Override
     public boolean open(String fileName){
        adaptee.openPDF(fileName);
        return true;
    }
  
    @Override
    public BufferedImage getData() {
        try {
            return adaptee.getAllPages().get(0).convertToImage();
        } catch (IOException ex) {
            Logger.getLogger(PDFDocumentAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    
    
}
