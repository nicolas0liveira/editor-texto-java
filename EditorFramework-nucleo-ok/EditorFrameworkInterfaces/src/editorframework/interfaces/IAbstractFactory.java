/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework.interfaces;

import java.util.ArrayList;

/**
 *
 * @author Márcio
 */
public interface IAbstractFactory {
    
    ArrayList<String> supportedExtensions();
    public abstract Editor createEditor();
    public abstract ISerializer createSerializer();
    public abstract IVerifier createVerifier();
    public abstract IToolbox createToolbox();

}
