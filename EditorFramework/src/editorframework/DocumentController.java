/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework;

import editorframework.interfaces.IDocument;
import editorframework.interfaces.IDocumentController;
import editorframework.interfaces.ISerializer;

/**
 *
 * @author aluno
 */
public class DocumentController implements IDocumentController {

    private ISerializer serializer;
    
    @Override
    public void setSerializer(ISerializer serializer) {
        this.serializer = serializer;
    }

    @Override
    public IDocument openDocument(String fileName) {
        if (serializer != null)
            return serializer.openDocument(fileName);
        return null;
    }

    @Override
    public boolean saveDocument() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean closeDocument() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    
}
