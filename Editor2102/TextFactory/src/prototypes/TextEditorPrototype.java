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
public class TextEditorPrototype extends EditorPrototype{

    private TextEditorPrototype(TextEditorPrototype aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EditorPrototype clonar() {
        return new TextEditorPrototype(this);
    }
    
}
