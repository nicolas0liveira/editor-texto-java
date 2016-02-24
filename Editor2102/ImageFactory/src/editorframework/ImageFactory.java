/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework;

import editorframework.interfaces.Editor;
import editorframework.interfaces.IAbstractFactory;
import editorframework.interfaces.IEditor;
import editorframework.interfaces.ISerializer;
import editorframework.interfaces.IToolbox;
import editorframework.interfaces.IVerifier;
import java.util.ArrayList;

/**
 *
 * @author MATHEUS
 */
public class ImageFactory implements IAbstractFactory{
    
    public static ImageFactory instancia;
            
    private IEditor imageEditor;
    private ISerializer imageSerializer;
    private IToolbox imageToolbox;
    private IVerifier imageVerifier;

    protected ImageFactory() {
    }
    
    //Implementação do singleton abaixo
    public static ImageFactory getInstancia(){ 
        if(instancia == null)
            instancia = new ImageFactory();
        return instancia;
    }
    
    
    @Override
    public ArrayList<String> supportedExtensions() {
        ArrayList<String> imageExtensions = new ArrayList<>();  
        imageExtensions.add("jpg");
        imageExtensions.add("png");
        imageExtensions.add("gif");
       
        return imageExtensions;
    }

    @Override
    public Editor createEditor() {
        return new ImageEditor();
    }

    @Override
    public ISerializer createSerializer() {
       return new ImageSerializer();
    }

    @Override
    public IToolbox createToolbox() {
        return new ImageToolbox();
    }

    @Override
    public IVerifier createVerifier() {
        return new ImageVerifier();
    }
    
}
