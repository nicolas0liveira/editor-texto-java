/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework;

import editorframework.interfaces.Editor;
import editorframework.interfaces.IAbstractFactory;
import editorframework.interfaces.ISerializer;
import editorframework.interfaces.IToolbox;
import editorframework.interfaces.IVerifier;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author aluno
 */
public class DefaultTextFactory implements IAbstractFactory{
    static final long serialVersionUID = 1L;
    
    private static DefaultTextFactory instance;
    
    private DefaultTextFactory(){  }
    
    public static DefaultTextFactory getInstance(){
        if(instance == null)
            instance = new DefaultTextFactory();
        return instance;
    }


    @Override
    public List<String> supportedExtensions() {
      return Arrays.asList("txt");
    }

    @Override
    public Editor createEditor() {
        return new TextEditor();
    }

    @Override
    public ISerializer createSerializer(){
        return new TextSerializer();
    }

    @Override
    public IToolbox createToolbox() {
//        IToolbox toolbox = new TextToolbox();
        return null;
    }

    @Override
    public IVerifier createVerifier() {
       return new TextVerifier();
    }

}
