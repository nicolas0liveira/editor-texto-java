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
    private ISerializer serializer;
}
