/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework.pdfbox.testes;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.swing.JFrame;
import org.apache.pdfbox.pdfviewer.PDFPagePanel;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;


public class MyPDFBox extends PDFPagePanel {
    public MyPDFBox() throws IOException {
    }
    private void init() {
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            final PDDocument doc = PDDocument.load(new File("./simple.pdf"));
            List<PDPage> allPages = doc.getDocumentCatalog().getAllPages();
            PDPage page = (PDPage) allPages.get(1);
            setPage(page);
            jFrame.setBackground(Color.DARK_GRAY);
            setLayout(new FlowLayout());
            jFrame.add(this);
            jFrame.setBounds(40, 40, getWidth() + 100, getHeight() + 50);
            jFrame.setVisible(true);
            jFrame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    try {
                        doc.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            });
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        //doc.close();
    }
    public static void main(String[] args) throws IOException {
        MyPDFBox PDFBox = new MyPDFBox();
        PDFBox.init();
    }
}
