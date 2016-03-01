/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework;

import editorframework.interfaces.IDocumentController;
import editorframework.interfaces.IPlugin;
import editorframework.interfaces.IToolbox;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author MATHEUS
 */
//TODO XXX: Implementar usando Bridge
public class PDFToolbox implements IToolbox{
    private IPlugin plugin;
 
    public PDFToolbox(IPlugin plugin){
        this.plugin = plugin;   
    }

    @Override
    public IToolbox initialize() { 
        buildSaveItem();
        buildNextAndPreviewsItems();
        buildAboutItem();
        return this;
    }
     
    private void buildSaveItem(){
        //monta menu Save
        IDocumentController documentController = plugin.getCore().getDocumentController();
        
        JMenuItem itemSave = plugin.getCore().getUIController().addMenuItem("Edit", "Save");
        if (itemSave != null)
            itemSave.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    JOptionPane.showMessageDialog(null, "Saves function is not implemented yet");
                    documentController.saveDocument();
                }
            });
    }
    
    
    private void buildNextAndPreviewsItems(){
        IDocumentController documentController = plugin.getCore().getDocumentController();
        
        JMenuItem nextPageItem = plugin.getCore().getUIController().addMenuItem("Edit", "Next Page");
        if (nextPageItem != null)
            nextPageItem.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
//                    documentController.closeDocument();
                }
            });
        
        
        
                
        //monta menu Next Page
        JMenuItem previousPageItem = plugin.getCore().getUIController().addMenuItem("Edit", "Previous Page");
        if (nextPageItem != null)
            nextPageItem.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
//                    documentController.closeDocument();
                }
            });
    }
    
    

    private void buildAboutItem(){
         //monta menu About
        StringBuilder sb = new StringBuilder()
        .append("Plugin Info")
        .append("\nPlugin Name: "+plugin.getPluginName())
        .append("\nPlugin Vendor: " + plugin.getPluginVendor())
        .append("\nPlugin Version: " + plugin.getPluginVersion());
         
         
        JMenuItem itemAbout = plugin.getCore().getUIController().addMenuItem("Help", "About PDFPlugin");
        if (itemAbout != null)
            itemAbout.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    JOptionPane.showMessageDialog(null, sb.toString(),"Plugin Info", JOptionPane.INFORMATION_MESSAGE);
                }
            });

    }

    @Override
    public void setPlugin(IPlugin plugin) {
        this.plugin = plugin;
    }
}

