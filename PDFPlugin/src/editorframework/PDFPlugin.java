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
public class PDFPlugin implements IPlugin, IAbstractFactory{
    static final long serialVersionUID = 1L;
    
//    private PDFPlugin instance;
//    
//    private PDFPlugin(){  }
//    
//    public PDFPlugin getInstance(){
//        if(instance == null)
//            instance = new PDFPlugin();
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
      return Arrays.asList("pdf");
    }

    @Override
    public Editor createEditor() {
        return new PDFEditor();
    }

    @Override
    public ISerializer createSerializer(){
        return new PDFSerializer();
    }

    @Override
    public IToolbox createToolbox() {
        IToolbox toolbox = new PDFToolbox(this);    
        return toolbox;
    }

    @Override
    public IVerifier createVerifier() {
       return new PDFVerifier();
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
        return "PDFPlugin";
    }

    @Override
    public String getPluginVersion() {
        return ""+serialVersionUID;
    }
    
    private void showMessage(String msg){
        JOptionPane.showMessageDialog(null, msg);
    }

}
