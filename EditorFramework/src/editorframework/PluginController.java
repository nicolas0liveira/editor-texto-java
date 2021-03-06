/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework;

import editorframework.interfaces.ICore;
import editorframework.interfaces.IPlugin;
import editorframework.interfaces.IPluginController;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aluno
 */
public class PluginController implements IPluginController {

    private ICore core;
    private ArrayList<IPlugin> loadedPlugins = new ArrayList<>();

    public PluginController(ICore core) throws MalformedURLException {
        this.core = core;
        loadPlugins();
    }
    
    private void loadPlugins() throws MalformedURLException{

        loadedPlugins.clear();
        // Encontra a pasta plugins
        File currentDir = new File("./plugins");
        // Obtem todos os arquivos dentro desta pasta
        String[] plugins = currentDir.list(new PluginFileNameFilter());
        if(plugins == null) return;
        // Criar um array de URL do mesmo tamanho do anterior
        URL[] jars = new URL[plugins.length];
        // Loop para popular o array jars
        for (int i = 0; i < plugins.length; i++)
            jars[i] = (new File("./plugins/" + plugins[i])).toURI().toURL();
        // Adiciona todos os jars (plugins) no CLASSPATH
        URLClassLoader ulc = new URLClassLoader(jars);
        // Loop para inicialicao dos plugins
        IPlugin iplugin = null;
        String pluginName;
        for (String plugin : plugins) {
            if (plugin.endsWith(".jar")) {
                pluginName = plugin.split("\\.")[0];
                try {              
                    
                    //alterei para chamar o método .getInstace() ao invés do construtor padrão.
                    //Mas se o plugin não implementar esse método? Como testar uma vez que não da pra obrigar por meio da interface?
                    //Optei pela seguinte estratégia: primeiro tenta o getInstance(). Caso não de certo, tenta o newInstance()
                    Class c = Class.forName("editorframework." + pluginName, true, ulc);
                    Method factoryMethod;
                    factoryMethod = c.getDeclaredMethod("getInstance");
                    iplugin = (IPlugin) factoryMethod.invoke(null);
                    
                    loadedPlugins.add(iplugin);
                    
                } catch (ClassNotFoundException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
                    Logger.getLogger(PluginController.class.getName()).log(Level.SEVERE, null, ex);
                    try {
                        iplugin = (IPlugin) Class.forName("editorframework." + pluginName, true, ulc).newInstance();
                        loadedPlugins.add(iplugin);
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex2) {
                        Logger.getLogger(PluginController.class.getName()).log(Level.SEVERE, null, ex2);
                    }
                }
                if (iplugin != null)
                    iplugin.initialize(core);
            }
        }
    }

    @Override
    public ArrayList<IPlugin> loadedPlugins() {
        System.out.println("[DEBUG]: Plugins Carregados: " + loadedPlugins);
        try {
            loadPlugins();
        } catch (MalformedURLException ex) {
            Logger.getLogger(PluginController.class.getName()).log(Level.SEVERE, null, ex);
        }
       return loadedPlugins;
    }
}
