/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework;

import editorframework.interfaces.Editor;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author MATHEUS
 */
public class ImageEditor extends Editor{   

    @Override
    public JComponent getView() {
        JTextArea textArea = new JTextArea();
        textArea.setEditable(true);

        JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        ((ImageDocument)document).getData().stream().forEach((line) -> {
            textArea.append(line + '\n');
        });
        return scrollPane;
    }
    
    
}
