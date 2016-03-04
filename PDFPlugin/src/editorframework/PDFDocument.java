/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework;

import editorframework.interfaces.IDocument;
import editorframework.pdfbox.PDFBoxDocumentAdaptee;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aluno
 */
public class PDFDocument implements IDocument<BufferedImage> {
    
    private PDFBoxDocumentAdaptee adaptee;
   
    public PDFDocument(){
        this.adaptee = new PDFBoxDocumentAdaptee();
    }
    
    public PDFDocument(PDFBoxDocumentAdaptee adaptee){
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

    @Override
    public boolean close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
