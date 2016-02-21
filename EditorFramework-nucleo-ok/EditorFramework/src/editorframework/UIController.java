/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework;

import editorframework.interfaces.IAbstractFactory;
import editorframework.interfaces.ICore;
import editorframework.interfaces.IDocument;
import editorframework.interfaces.IDocumentController;
import editorframework.interfaces.Editor;
import editorframework.interfaces.IPlugin;
import editorframework.interfaces.ISerializer;
import editorframework.interfaces.IToolbox;
import editorframework.interfaces.IUIController;
import editorframework.interfaces.IVerifier;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author aluno
 */
public class UIController implements IUIController, ActionListener {    
   
    private ICore core;
    
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
                return null;
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
    
       
    @Override
    public void actionPerformed(java.awt.event.ActionEvent evt) {  
            //trata os eventos para o botão File -> Open
            if( evt.getSource() == fileOpen){ 
                
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

                    }
            }
          
    }
 
    @Override
    public void setEditor(Editor editor) {
        JComponent view = editor.getView();
        mainFrame.getContentPane().add(view);
        mainFrame.pack();
    }

    private MainFrame mainFrame;
    private JMenuItem fileOpen;
    ArrayList<IPlugin> loadedPlugins;
}
