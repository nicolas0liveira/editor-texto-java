/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework;

import editorframework.interfaces.Editor;
import editorframework.interfaces.IAbstractFactory;
import editorframework.interfaces.ICore;
import editorframework.interfaces.IPlugin;
import editorframework.interfaces.ISerializer;
import editorframework.interfaces.IToolbox;
import editorframework.interfaces.IVerifier;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class TextPlugin implements IPlugin, IAbstractFactory{
    static final long serialVersionUID = 1L;
    
//    private TextPlugin instance;
//    
//    private TextPlugin(){  }
//    
//    public TextPlugin getInstance(){
//        if(instance == null)
//            instance = new TextPlugin();
//        return instance;
//    }
    private ICore core;
    
    
    @Override
    public boolean initialize(ICore core) {
        this.core = core;
        return true;
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
        IToolbox toolbox = new TextToolbox(this);    
        return toolbox;
    }

    @Override
    public IVerifier createVerifier() {
       return new TextVerifier();
    }

    @Override
    public ICore getCore(){
        return core;
    }
  
    @Override
    public String getPluginVendor() {
        return "Matheus Gimarães";
    }

    @Override
    public String getPluginName() {
        return "TextPlugin";
    }

    @Override
    public String getPluginVersion() {
        return ""+serialVersionUID;
    }
    
    private void showMessage(String msg){
        JOptionPane.showMessageDialog(null, msg);
    }

}
