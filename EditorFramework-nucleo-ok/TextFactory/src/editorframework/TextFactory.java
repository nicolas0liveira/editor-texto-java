/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework;

import editorframework.interfaces.IAbstractFactory;
import editorframework.interfaces.ICore;
import editorframework.interfaces.Editor;
import editorframework.interfaces.IPlugin;
import editorframework.interfaces.ISerializer;
import editorframework.interfaces.IToolbox;
import editorframework.interfaces.IVerifier;
import java.util.ArrayList;

/**
 *
 * @author Márcio
 */
public class TextFactory implements IAbstractFactory, IPlugin{



    public TextFactory() {
        textExtensions.add("txt");
    }
    
    
    @Override
    public ArrayList<String> supportedExtensions() {
        
        return textExtensions;
    }

    @Override
    public Editor createEditor() {
       return new TextEditor(); 
    }

    @Override
    public ISerializer createSerializer() {
        return new TextSerializer();     
    }

    @Override
    public IVerifier createVerifier() {
       return new TextVerifier();     
    }

     @Override
    public IToolbox createToolbox() {
        return new TextToolbox(); 
    }

    @Override
    public boolean initialize(ICore core) {
    return true;
    }

   
 private ArrayList<String> textExtensions = new ArrayList<>();
}
