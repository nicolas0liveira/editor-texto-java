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
public interface IEditor {
    public abstract JComponent getView();
    public void setDocument(IDocument document);
    
}
