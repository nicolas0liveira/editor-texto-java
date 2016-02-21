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
public class ImageFactory implements IAbstractFactory, IPlugin{

     
     
    public ImageFactory() {
        imageExtensions.add("jpg");
        imageExtensions.add("png");
        imageExtensions.add("gif");      
    }

    
    @Override
    public ArrayList<String> supportedExtensions() {
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
    public IVerifier createVerifier() {
    return new ImageVerifier();    
    }
    
    @Override
    public IToolbox createToolbox() {
        return new ImageToolbox();   
    }

    @Override
    public boolean initialize(ICore core) {
        return true;
    }

    private ArrayList<String> imageExtensions = new ArrayList<>();
    
}
