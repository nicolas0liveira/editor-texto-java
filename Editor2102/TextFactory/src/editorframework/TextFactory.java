package editorframework;

import editorframework.interfaces.Editor;
import editorframework.interfaces.IAbstractFactory;
import editorframework.interfaces.IEditor;
import editorframework.interfaces.ISerializer;
import editorframework.interfaces.IToolbox;
import editorframework.interfaces.IVerifier;
import java.util.ArrayList;
import java.util.List;


public class TextFactory implements IAbstractFactory{
    
    public static TextFactory instancia;
    
    private IEditor textEditor;
    private ISerializer textSerializer;
    private IToolbox textToolbox;
    private IVerifier textVerifier;

    protected TextFactory() {
    }

    
    //Implementação do singleton abaixo
    public static TextFactory getInstancia(){ 
        if(instancia == null)
            instancia = new TextFactory();
        return instancia;
    }
    
    
    @Override
    public ArrayList<String> supportedExtensions() {
       ArrayList<String> l = new ArrayList<>();  
       l.add("txt");
       
       return l;
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
    public IToolbox createToolbox() {
         return new TextToolbox();
    }

    @Override
    public IVerifier createVerifier() {
        return new TextVerifier();
    }
    
}
