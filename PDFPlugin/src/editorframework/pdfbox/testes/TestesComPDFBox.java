/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework.pdfbox.testes;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.apache.pdfbox.PDFReader;
import org.apache.pdfbox.pdfviewer.PDFPagePanel;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

/**
 *
 * @author MATHEUS
 */
public class TestesComPDFBox {
    
    public static void testarPDFREaderDoPDFBox() throws IOException {
        PDFReader reader = new PDFReader(); //o pdfbox já possui uma aplicação com interface. É bom que ajuda no entendimento de como o pdfbox funciona
        reader.setVisible(true);
    }
    
    public static void transformarPDFemImagem() throws IOException {

//OPCAO 1 transformar o pdfpage em bufered image, e exibir no JFrame normal
        PDDocument document = PDDocument.load(new File("./simple.pdf"));
        List<PDPage> allPages = document.getDocumentCatalog().getAllPages();

        PDPage firstPage = allPages.get(0);
        BufferedImage bi = firstPage.convertToImage();
        File outputfile = new File("image.jpg");
        ImageIO.write(bi, "jpg", outputfile);

    }
    
    
    
    public static void exibirPDFEmUmJFrame() throws IOException {
        File PDFPath = new File("./simple.pdf");
        PDDocument inputPDF = PDDocument.load(PDFPath);
        List<PDPage> allPages = inputPDF.getDocumentCatalog().getAllPages();
        
        PDPage testPage = (PDPage) allPages.get(0);

        JFrame testFrame = new JFrame();
        testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PDFPagePanel pdfPanel = new PDFPagePanel();
        pdfPanel.setPage(testPage);
        testFrame.add(pdfPanel);
        testFrame.setBounds(40, 40, pdfPanel.getWidth(), pdfPanel.getHeight());
        testFrame.setVisible(true);
        pdfPanel.validate();
//        inputPDF.close();
       
    }
    
    
     public static void exibirPDFemImagemNoJComponent() throws IOException {
        PDDocument document = PDDocument.load(new File("./simple.pdf"));
        List<PDPage> allPages = document.getDocumentCatalog().getAllPages();

        PDPage firstPage = allPages.get(0);
        BufferedImage bi = firstPage.convertToImage();
        
        JFrame testFrame = new JFrame();
        testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JScrollPane scrollPane = new JScrollPane(); 
        JLabel picLabel = new JLabel(new ImageIcon(bi));
        scrollPane.getViewport().add(picLabel);
        testFrame.add(scrollPane);
        testFrame.setVisible(true);
        testFrame.pack();

    }
     
     public static void main(String[] args) throws IOException {
//        OpenTextPDF otp = new OpenTextPDF();
//        System.out.print(otp.openPDF("./testfile.pdf"));

//        exibirPDFEmUmJFrame();
//        transformarPDFemImagem(); 
//        exibirPDFemImagemNoJComponent();
        testarPDFREaderDoPDFBox();




    }
    
}
