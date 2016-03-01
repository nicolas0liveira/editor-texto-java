/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework;

import editorframework.interfaces.Editor;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author MATHEUS
 */
public class PDFEditor extends Editor{   

    @Override
    public JComponent getView() {
        JPanel documentPanel = new JPanel();
        Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        documentPanel.setBounds((screenSize.width-700)/2, (screenSize.height-600)/2, 700, 600);
        
        JScrollPane documentScroller = new JScrollPane(documentPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        documentScroller.setViewportView( documentPanel );
         
        
        ((PDFDocument)document).getData();
        JLabel picLabel = new JLabel(new ImageIcon(bi));
        
//        InputStream in = new ByteArrayInputStream();
//        BufferedImage bImageFromConvert = ImageIO.read(in);
//        scrollPane.getViewport().add(picLabel);
            
       
        return documentScroller;
    }
    
//    private void updateTitle() {
//        setTitle( "PDFBox - " + currentFilename + " ("+(currentPage+1)+"/"+numberOfPages+")");
//    }
    
}
