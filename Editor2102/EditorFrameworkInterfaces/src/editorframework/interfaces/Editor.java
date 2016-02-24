/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework.interfaces;


/**
 *
 * @author Márcio
 */
public abstract class Editor implements IEditor{
    protected IDocument document;
    
    public void setDocument(IDocument document){
        this.document = document;
    }
    
}
