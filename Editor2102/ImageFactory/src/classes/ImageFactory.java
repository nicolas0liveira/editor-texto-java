/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

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
        ArrayList<String> l = new ArrayList<>();  
        l.add("jpg");
        l.add("png");
        l.add("gif");
       
        return l;
    }

    @Override
    public IEditor createEditor() {
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
