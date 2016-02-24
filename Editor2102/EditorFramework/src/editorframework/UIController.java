/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework;

import editorframework.util.FilenameUtils;
import editorframework.interfaces.IAbstractFactory;
import editorframework.interfaces.ICore;
import editorframework.interfaces.Editor;
import editorframework.interfaces.IPlugin;
import editorframework.interfaces.IUIController;
import editorframework.util.FileChooserUtil;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author aluno
 */
public class UIController implements IUIController, ActionListener {

    private ICore core;
    private MainFrame mainFrame;
    private JMenuItem fileOpen;


    public UIController(ICore core) {
        this.core = core;
        mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        initComponents();
        configEvents();
    }
    
    @Override
    public JMenuItem addMenuItem(String menu, String menuItem) {
        JMenuBar menuBar = mainFrame.getJMenuBar();
        int menuCount = menuBar.getMenuCount();
        JMenu targetMenu = null;
        for (int i = 0; i < menuCount; i++)
            if (menuBar.getMenu(i).getText().equals(menu))
                targetMenu = menuBar.getMenu(i);
        if (targetMenu == null) {
            targetMenu = new JMenu(menu);
            menuBar.add(targetMenu);
        }
        int itemCount = targetMenu.getItemCount();
        for (int i = 0; i < itemCount; i++)
            if (targetMenu.getItem(i).getText().equals(menuItem))
                return targetMenu;
        JMenuItem targetMenuItem = new JMenuItem(menuItem);
        targetMenu.add(targetMenuItem);
        return targetMenuItem;
    }


    private void initComponents(){  
        fileOpen = addMenuItem("File", "Open");
    }
    
    private void configEvents(){ 
        fileOpen.addActionListener(this);
     }

    /**
    * Trata os eventos para o botão File -> Open
    */
    @Override
    public void fileOpenPerformed(ActionEvent e) {

/*
//cria o FileChooser
                    JFileChooser jFileChooser = new JFileChooser();
                    jFileChooser.setAcceptAllFileFilterUsed(false);
                    jFileChooser.setFileHidingEnabled(false);

                    //pega a lista de plugins carregados e cria um array para armazenar extensões
                    ArrayList<String> supportedExtensions = new ArrayList<>();
                    loadedPlugins = core.getPluginController().loadedPlugins();
                    
                    // Verifica se existem plugins de fabrica na lista de plugins e adiciona as extensões a lista
                    for (IPlugin plugin : loadedPlugins) {
                        if (plugin instanceof IAbstractFactory) {
                            ArrayList<String> supportedExtensionsTmp = ((IAbstractFactory) plugin).supportedExtensions();
                            if (supportedExtensionsTmp != null) {

                                for (String extension : supportedExtensionsTmp) {
                                    supportedExtensions.add(extension);
                                    jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter(extension, extension));
                                }
                            }
                            
                        }
                    }
                    
                    //Caso não sejam localizados plugins de fabrica, avisa ao usuário
                    if(supportedExtensions.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Nao existem plugins de fabrica instalados");
                    }
                    
                    //coloca a lista de extensões disponíveis
                    jFileChooser.setFileFilter(new FileNameExtensionFilter("All supported extensions", supportedExtensions.toArray(new String[supportedExtensions.size()])));
                    int option = jFileChooser.showOpenDialog(mainFrame);
                    if (option == JFileChooser.APPROVE_OPTION) {
                        File selectedFile = jFileChooser.getSelectedFile();
                        String nameSelectedFile = selectedFile.getAbsolutePath();
                                                
                        for (IPlugin plugin : loadedPlugins) {
                            if (plugin instanceof IAbstractFactory) {
                                ArrayList<String> supportedExtensionsTmp = ((IAbstractFactory) plugin).supportedExtensions();
                                if (supportedExtensionsTmp != null) {

                                    for (String extension : supportedExtensionsTmp) {
                                        if (nameSelectedFile.endsWith(extension)) {
                                            Editor editor = ((IAbstractFactory) plugin).createEditor();
                                            ISerializer serializer = ((IAbstractFactory) plugin).createSerializer();
                                            //IToolbox toolbox = ((IAbstractFactory) plugin).createToolbox();
                                            //IVerifier verifier = ((IAbstractFactory) plugin).createVerifier();

                                            JOptionPane.showMessageDialog(null, "Extensão " + extension + " aberta pelo plugin " + plugin.getClass().getSimpleName());
                                            IDocumentController documentController = core.getDocumentController();
                                            documentController.setSerializer(serializer);
                                            IDocument document = documentController.openDocument(nameSelectedFile);
                                            editor.setDocument(document);
                                            setEditor(editor);
                                            break;
                                        }
                                    }
                                }
                            }
                        }
*/



	// Stack<String> suportedExtensionsStk = new Stack<>();
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
            file  = FileChooserUtil.chooseFile(mainFrame);
        } else {
            System.out.println(suportedExtensionsMap.keySet());
            file = FileChooserUtil.chooseFile(mainFrame, getSupportedFileNameExtensionFilters(suportedExtensionsMap));
        }
       
        if(file == null) return;
        String extension = FilenameUtils.getExtension(file);
    
    //5.5) A depender do arquivo selecionado para abrir, utilizar a fábrica que tem a extensão do arquivo na lista retornada por mergedSupportedExtensions().
        IPlugin selectedPlugin = suportedExtensionsMap.get(extension);
        System.out.print("Utilizando o plugin selecionado: "+ selectedPlugin);
        selectedPlugin.initialize(core);
    
    }

    @Override
    public void setEditor(Editor editor) {
        JComponent view = editor.getView();
        mainFrame.getContentPane().add(view);
        mainFrame.pack();
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
      if(e.getSource() == fileOpen)
          fileOpenPerformed(e);
    }
}
