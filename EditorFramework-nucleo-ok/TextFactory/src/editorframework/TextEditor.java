/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework;

import editorframework.interfaces.Editor;
import javax.swing.JComponent;
import javax.swing.JTextArea;

/**
 *
 * @author Márcio
 */
public class TextEditor extends Editor {

    @Override
    public JComponent getView() {
        JTextArea textArea = new JTextArea();
        for(String line : ((TextDocument)document).getData())
            textArea.append(line + '\n');
        return textArea;
    }
    
}
