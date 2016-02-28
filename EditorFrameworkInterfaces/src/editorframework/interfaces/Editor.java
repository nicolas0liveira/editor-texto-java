/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework.interfaces;

import javax.swing.JComponent;

/**
 *
 * @author MATHEUS
 */
public abstract class Editor {
    public abstract JComponent getView();
    protected IDocument document;
    
    public void setDocument(IDocument document){
        this.document = document;
    }
    
}
