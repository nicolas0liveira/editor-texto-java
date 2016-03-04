/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework.pdfbox;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

/**
 *
 * @author aluno
 */
public class PDFBoxDocumentAdaptee {
    private PDDocument document = null;
    private int currentPage = 0;
    private String currentFilename;
    private int numberOfPages = 0;
    
    public PDDocument openPDF(String currentFilename) {
        try {
            document = parseDocument(currentFilename);
            currentPage = 0;
            numberOfPages = (getAllPages() !=null)?getAllPages().size():0;
            return document;
        } catch (IOException ex) {
            Logger.getLogger(OpenTextPDFAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }     
        return null;
    }
    
    private static PDDocument parseDocument( String filename)throws IOException {
        PDDocument document = PDDocument.load(filename);
        if( document.isEncrypted() ){
            try{
                document.decrypt( "" );
            }
            catch( org.apache.pdfbox.exceptions.CryptographyException e )  {
                e.printStackTrace();
            }
        }

        return document;
    }
    
    public List<PDPage> getAllPages(){
        return (document == null)? null:document.getDocumentCatalog().getAllPages();
    }
   
    public int getNumberOfPages(){
        return numberOfPages;
    }
    
    public int getCurrentPage(){
        return currentPage;
    }

    private String getCurrentFilename(){
        return currentFilename;
    }
    
    private int nextPage() {
        if (currentPage < numberOfPages-1) 
            return ++currentPage;
        return currentPage;
    }
    
    private int previousPage() {
        if (currentPage > 0 )
            return --currentPage;
        return currentPage;
    }
    
}
