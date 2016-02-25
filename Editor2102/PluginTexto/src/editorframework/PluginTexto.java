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
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class PluginTexto implements IPlugin, IAbstractFactory{
    static final long serialVersionUID = 1L;
    
//    private PluginTexto instance;
//    
//    private PluginTexto(){  }
//    
//    public PluginTexto getInstance(){
//        if(instance == null)
//            instance = new PluginTexto();
//        return instance;
//    }
    private ICore core;
    
    @Override
    public boolean initialize(ICore core) {
        this.core = core;
        JMenuItem itemAbout = core.getUIController().addMenuItem("Help", "About PluginTexto");
        if (itemAbout != null)
            itemAbout.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    showMessage(getPluginInfo());
                }
            });
        return true;
    }

    @Override
    public List<String> supportedExtensions() {
      return Arrays.asList("txt");
    }
    
    @Override
    public String getPluginInfo(){
        return "Plugin Texto [version:"+serialVersionUID+"]";
    }

    @Override
    public Editor createEditor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ISerializer createSerializer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IToolbox createToolbox() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IVerifier createVerifier() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void showMessage(String msg){
        JOptionPane.showMessageDialog(null, msg);
    }
    
}
