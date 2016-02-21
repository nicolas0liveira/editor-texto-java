/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework;

import editorframework.interfaces.IAbstractFactory;
import editorframework.interfaces.ICore;
import editorframework.interfaces.IPlugin;
import editorframework.interfaces.IUIController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author aluno
 */
public class UIController implements IUIController, ActionListener {

    private MainFrame mainFrame;
    private ICore core;
    private JMenuItem btnOpen;
            
    public UIController(ICore core) {
        (mainFrame = new MainFrame()).setVisible(true);
        this.core = core;
        btnOpen = addMenuItem("File", "Open");
        btnOpen.addActionListener(this);
    }
    
    @Override
    public JMenuItem addMenuItem(String menu, String menuItem) {
        JMenuBar menuBar = mainFrame.getJMenuBar();
        int menuCount = menuBar.getMenuCount();
        JMenu targetMenu = null;
        for (int i = 0; i < menuCount; i++) {
            if (menuBar.getMenu(i).getText().equals(menu)) {
                targetMenu = menuBar.getMenu(i);
            }
        }
        if (targetMenu == null) {
            targetMenu = new JMenu(menu);
            menuBar.add(targetMenu);
        }
        int itemCount = targetMenu.getItemCount();
        for (int i = 0; i < itemCount; i++) {
            if (targetMenu.getItem(i).getText().equals(menuItem)) {
                return targetMenu.getItem(i);
            }
        }
        JMenuItem targetMenuItem = new JMenuItem(menuItem);
        targetMenu.add(targetMenuItem);
        return targetMenuItem;
    }

    @Override
    public void btnOpenPerformed(ActionEvent e) {
        System.out.println("Cliquei em Open");
//        Stack<String> suportedExtensionsStk = new Stack<>();
        Map<String,IPlugin> suportedExtensionsMap = new HashMap<>();
        
    //5.1) Invocar o pluginController para obter todos os plugins 
        List<IPlugin> plugins = core.getPluginController().loadedPlugins();

    //5.2) Se o plugin for de fábrica (implementar IAbstractFactory) obter as mergedSupportedExtensions()
        for(IPlugin p : plugins ){
            if(p instanceof IAbstractFactory) {
                for(String supExt : ((IAbstractFactory) p).supportedExtensions()){
                    //5.3) Fazer o merge de todas as mergedSupportedExtensions();
                    suportedExtensionsMap.put(supExt, p);
                }
            }
        }
        
            
        /*
        //Para Treinar Java8, pode-se implementar o mesmo trecho acima, assim:
        plugins.stream().filter((p) -> (p instanceof IAbstractFactory)).forEach((p) -> {
        for(String supExt : ((IAbstractFactory) p).mergedSupportedExtensions()){
            mergedSupportedExtensions.add(supExt);
        }
        });
        */
        
    //5.4) Abrir a tela de File->Open com um filtro mostrando apenas as extensões suportadas pelos plugins.
        File file;    
        if(suportedExtensionsMap.isEmpty()){
            file  = mainFrame.chooseFile();
        } else {
            System.out.println(suportedExtensionsMap.keySet());
            file = mainFrame.chooseFile(getSupportedFileNameExtensionFilters(suportedExtensionsMap));
        }
       
        if(file == null) return;
        String extension = FilenameUtils.getExtension(file);
    
    //5.5) A depender do arquivo selecionado para abrir, utilizar a fábrica que tem a extensão do arquivo na lista retornada por mergedSupportedExtensions().
        IPlugin selectedPlugin = suportedExtensionsMap.get(extension);
        System.out.print("Utilizando o plugin selecionado: "+ selectedPlugin);
        selectedPlugin.initialize(core);
    
    }

    
    
     private  List<FileNameExtensionFilter> getSupportedFileNameExtensionFilters(Map<String,IPlugin> supportedPluginsMap) {
        List<FileNameExtensionFilter> supportedExtensions = new ArrayList<>();

        Set<String> supportedExtensionsSet = supportedPluginsMap.keySet();
        
        if(supportedExtensionsSet.isEmpty()){
            supportedExtensions.add(new FileNameExtensionFilter("Todos os Arquivos","*.*"));
        } else {
            for(String s : supportedExtensionsSet){
// TODO: obter a descrição para o filtro de alguma das interfaces (IAbstractFactory)
               supportedExtensions.add(new FileNameExtensionFilter("Arquivos com extensão "+s,s));
            }
        }

        return supportedExtensions;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource() == btnOpen)
          btnOpenPerformed(e);
    }

    
    
}
