/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import editorframework.interfaces.IVerifier;

/**
 *
 * @author MATHEUS
 */
public class ImageVerifier implements IVerifier{

    @Override
    public void exibirInfo() {
        System.out.println("Image Verifier");
    }
    
}
