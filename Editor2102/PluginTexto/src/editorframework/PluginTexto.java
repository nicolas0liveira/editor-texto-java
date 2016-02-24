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
import java.util.ArrayList;
import javax.swing.JMenuItem;

/**
 *
 * @author aluno
 */
public class PluginTexto implements IPlugin, IAbstractFactory{

    @Override
    public boolean initialize(ICore core) {
        JMenuItem itemAbout = core.getUIController().addMenuItem("Help", "About PluginTexto");
        if (itemAbout != null)
            itemAbout.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    System.out.println(getPluginName());
                }
            });

        return true;
    }

    @Override
    public ArrayList<String> supportedExtensions() {
        ArrayList<String>  a = new ArrayList<String> ();
        a.add("txt");
      return a;
    }
    
    @Override
    public String getPluginName(){
        return "{[PluginTexto],[v1.0.0]}";
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
    
}
