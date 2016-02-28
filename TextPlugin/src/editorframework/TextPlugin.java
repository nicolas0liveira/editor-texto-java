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
public class TextPlugin implements IPlugin, IAbstractFactory {
    static final long serialVersionUID = 1L;
    
//     Abstract Factory como singleton, não entendi o que deveria ser singleton. 
//     Se o plugin deveria possuir uma fábrica singleton, ou ele mesmo seria uma fábrica singleton, já que implementa IAbstractFactory??
//     Implementei o plugin que contem uma fábrica singleton de componentes (deixei comentada) e implementei o singleton no proprio plugin
//      uma vez que ele implementa IAbstractFactory
    

//TODO: Reavaliar a necessidade do DefaultTextFactory. Acho que ele pode ser removido sem problemas,...
//A não ser que se deseje delegar a responsabilidade de criar os objetos para uma fábrica especializada, 
//e o IPlugin trate de outras questões gerais e contenha uma fabrica que gera os componentes 
    //(O lado bom dessa abordagem é que basta trocar a fabrica para mudar os componentes do plugin)
    private IAbstractFactory factory = DefaultTextFactory.getInstance();
    
    private static TextPlugin instance = new TextPlugin();
    private ICore core;

    private TextPlugin(){ } 
    
    public static TextPlugin getInstance(){
        return instance;
    }
    
    
    @Override
    public boolean initialize(ICore core) {
        this.core = core;
        return true;
    }

    @Override
    public List<String> supportedExtensions() {
//      return factory.supportedExtensions();
      return Arrays.asList("txt");
    }

    @Override
    public Editor createEditor() {
//        return factory.createEditor();
        return new TextEditor();
    }

    @Override
    public ISerializer createSerializer(){
//        return factory.createSerializer();
        return new TextSerializer();
    }

    @Override
    public IToolbox createToolbox() {
        //TODO: Ver a melhor forma de passar o IPlugin pro toolbox. 
        //O IToolbox deve controlar toda a regra de seus próprios componentes? Ou o UIController deve possuir tal responsabilidade?  
        IToolbox toolbox = new TextToolbox(this);  
        
//        return factory.createToolbox();
        return toolbox;
    }

    @Override
    public IVerifier createVerifier() {
//       return factory.createVerifier();
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
