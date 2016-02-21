/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework.interfaces;

import java.util.ArrayList;

/**
 *
 * @author MATHEUS
 */
public interface IAbstractFactory {
    ArrayList<String> supportedExtensions();
    
    public IEditor createEditor();
    public ISerializer createSerializer();
    public IToolbox createToolbox();
    public IVerifier createVerifier();
        
    
    
}
