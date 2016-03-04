/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework.pdfbox;

import editorframework.interfaces.IDocument;

public class OpenTextPDFAdapter extends OpenTextPDF implements IDocument<String>{

    @Override
    public boolean open(String pdfFilename){
        try{
            openPDF(pdfFilename);
            return true;
        }
        catch(Exception e){
        }
        return false;
    }

    @Override
    public boolean close() {
        //closePDF(fileName);
        return false;
    }

    @Override
    public boolean save() {
        //savePDF(filename);
        return false;
    }

    @Override
    public String getData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
