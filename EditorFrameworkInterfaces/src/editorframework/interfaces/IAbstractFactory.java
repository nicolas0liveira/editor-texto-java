/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework.interfaces;

import java.util.List;

/**
 *
 * @author MATHEUS
 */
public interface IAbstractFactory {
    public List<String> supportedExtensions();
    public abstract Editor createEditor();
    public abstract ISerializer createSerializer();
    public abstract IVerifier createVerifier();
    public abstract IToolbox createToolbox();
//    public abstract IAbstractFactory getInstance();

}
