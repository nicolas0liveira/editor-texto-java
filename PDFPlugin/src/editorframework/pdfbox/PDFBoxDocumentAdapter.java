/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework.pdfbox;

import editorframework.interfaces.IDocument;

/**
 *
 * @author nicolas
 */
public class PDFBoxDocumentAdapter extends PDFBoxDocumentAdaptee /*implements IDocument*/{
    
    public boolean open(String fileName){ 
        return true;
    }

//    @Override
    public boolean close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
    public boolean save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
