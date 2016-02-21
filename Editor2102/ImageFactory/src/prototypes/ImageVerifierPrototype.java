/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototypes;

/**
 *
 * @author MATHEUS
 */
public class ImageVerifierPrototype extends VerifierPrototype{

    private ImageVerifierPrototype(ImageVerifierPrototype aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VerifierPrototype clonar() {
        return new ImageVerifierPrototype(this);
    }
    
}
