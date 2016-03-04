/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework;

import editorframework.interfaces.Editor;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

/**
 *
 * @author MATHEUS
 */
public class PDFEditor extends Editor {   
//TODO: Avaliar implementar Observer para ficar observando o documento e atualizar, caso a página mude, por exemplo
   
    @Override
    public JComponent getView() {
        
        JScrollPane scrollPane = new JScrollPane(); 
        JLabel picLabel = new JLabel(new ImageIcon(((PDFDocument)document).getData()));
        scrollPane.getViewport().add(picLabel);
       
        return scrollPane;
    }
    
//    private void updateTitle() {
//        setTitle( "PDFBox - " + currentFilename + " ("+(currentPage+1)+"/"+numberOfPages+")");
//    }
    
}
