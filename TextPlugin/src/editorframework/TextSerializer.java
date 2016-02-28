/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework;

import editorframework.interfaces.IDocument;
import editorframework.interfaces.ISerializer;

/**
 *
 * @author MATHEUS
 */
public class TextSerializer implements ISerializer{  

    @Override
    public IDocument openDocument(String fileName) {
        IDocument document = new TextDocument();
        document.open(fileName);
        return document;
    }
    
    
}
