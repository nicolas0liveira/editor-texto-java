/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework;

import editorframework.interfaces.ICore;
import editorframework.interfaces.IDocumentController;
import editorframework.interfaces.IPluginController;
import editorframework.interfaces.IUIController;

/**
 *
 * @author aluno
 */
public class Core implements ICore {
    private IUIController uiController;
    private IDocumentController documentController;
    private IPluginController pluginController;

    public Core() throws Exception {
        uiController = new UIController(this);
        documentController = new DocumentController();
        pluginController = new PluginController(this);
    }

    @Override
    public IUIController getUIController() {
        return uiController;
    }

    @Override
    public IDocumentController getDocumentController() {
        return documentController;
    }

    @Override
    public IPluginController getPluginController() {
        return pluginController;
    }
    
  
}

/*2013116038

Page 4

Planilha de Notas - 2015.2

Erro de runtime:

java.lang.ClassNotFoundException: editorframework.TextFactory

Os plugins não estão corretamente empacotados, como voce testou?

Outro erro de runtime:

java.lang.NullPointerException em PluginController.java, linha 34

Plugins inseridos hard-coded no método loadedPlugins()

Porque você usou um Map para o supportedExtensions() ?*/
