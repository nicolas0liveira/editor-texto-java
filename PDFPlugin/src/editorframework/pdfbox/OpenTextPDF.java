/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework.pdfbox;

/**
 *
 * @author MATHEUS
 */
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;

/**
 *
 * @author MATHEUS
 */

public class OpenTextPDF {

    public boolean openPDF(String pdfFilename) {
        //openPDF(fileName);
        PDDocument document = null;
        try {
            document = PDDocument.load(new File(pdfFilename));
            return true;
        } catch (IOException ex) {
            Logger.getLogger(OpenTextPDFAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }     
        return false;
    }
}
