/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework.pdfbox;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.apache.pdfbox.PDFReader;
import org.apache.pdfbox.pdfviewer.PDFPagePanel;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDPage;

/**
 *
 * @author MATHEUS
 */
public class teste {
     public static void main(String[] args) throws IOException {
//        OpenTextPDF otp = new OpenTextPDF();
//        System.out.print(otp.openPDF("./testfile.pdf"));


PDFReader reader = new PDFReader();
//reader.

// JPanel documentPanel = new JPanel();
// JScrollPane documentScroller = new JScrollPane();
 
//File PDFPath = new File("./testfile.pdf");
//PDDocument inputPDF = PDDocument.load(PDFPath);
//inputPDF.get
        
        InputStream input = new FileInputStream(new File("./testfile.pdf"));
	PDDocument pddoc = PDDocument.load(input);
	PDDocumentCatalog pddocC = pddoc.getDocumentCatalog();
        List pages = pddocC.getAllPages();
        PDPage page = (PDPage) pages.get(0);
        pddoc.close();


//exibir um pdf em um painel
//
//File PDFPath = new File("./testfile.pdf");
//PDDocument inputPDF = PDDocument.load(PDFPath);
//List<PDPage> allPages = inputPDF.getDocumentCatalog().getAllPages();
//inputPDF.close();
//PDPage testPage = (PDPage)allPages.get(0);
//
//JFrame testFrame = new JFrame();
//testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//PDFPagePanel pdfPanel = new PDFPagePanel();
//pdfPanel.setPage(testPage);
//testFrame.add(pdfPanel);
//testFrame.setBounds(40, 40, pdfPanel.getWidth(), pdfPanel.getHeight());
//testFrame.setVisible(true);
        
    }
    
}
