/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package editorframework.pdfbox.testes;

import editorframework.interfaces.IDocument;
import org.apache.pdfbox.pdfviewer.PageWrapper;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import javax.swing.JPanel;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.PDFReader;

public class PDFReaderAdaptor extends PDFReader /*implements IDocument*/{


    private PDDocument document = null;
    private List<PDPage> pages= null;
    private int currentPage = 0;
    private int numberOfPages = 0;
    private String currentFilename = null;
    
   
    public PDFReaderAdaptor()  {    }


    private int getCurrentPage(){
        return currentPage+1;
    }
    private int getNumberOfPages(){
        return numberOfPages;
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

    

    private void openPDFFile(String file) throws Exception
    {
        if( document != null ) {
            document.close();
        }
        
        InputStream input = null;
        File f = new File( file );
        input = new FileInputStream(f);
        document = parseDocument( input );
        pages = document.getDocumentCatalog().getAllPages();
        numberOfPages = pages.size();
        currentFilename = f.getAbsolutePath();
        currentPage = 0;
    }
    
    private JPanel showPage(int pageNumber) throws IOException {
            PageWrapper wrapper = new PageWrapper( this );
            wrapper.displayPage( (PDPage)pages.get(pageNumber) );
            
            return wrapper.getPanel();       
    }

    private static PDDocument parseDocument( InputStream input )throws IOException {
        PDDocument document = PDDocument.load( input );
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

//    @Override
    public boolean open(String fileName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
    public boolean save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
//    @Override
    public boolean close(){
        try {
            if( document != null ) {
                document.close();
            }
        }
        catch( IOException io ){
             Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, io);
        }
        return true;
    }
}