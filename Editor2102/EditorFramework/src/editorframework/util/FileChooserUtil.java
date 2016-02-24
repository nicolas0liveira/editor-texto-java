/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework.util;

import java.awt.Component;
import java.io.File;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author 
 */
public class FileChooserUtil {

     /**
     * Shows the file chooser
     * @return a selected file
     */
    public static File chooseFile(Component parent) {
        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showOpenDialog(parent);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile();
        }
        return null;
    }
    /**
     * Shows the file chooser
     * @param filters
     * @return a selected file
     */
    public static File chooseFile(Component parent, FileNameExtensionFilter... filters) {
        JFileChooser chooser = new JFileChooser();
        for (FileNameExtensionFilter filter : filters) {
            chooser.addChoosableFileFilter(filter);
        }

        int returnVal = chooser.showOpenDialog(parent);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile();
        }
        return null;
    }
    
    public static File chooseFile(Component parent, List<FileNameExtensionFilter> filters) {
        JFileChooser chooser = new JFileChooser();
        for (FileNameExtensionFilter filter : filters) {
            chooser.addChoosableFileFilter(filter);
        }

        int returnVal = chooser.showOpenDialog(parent);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile();
        }
        return null;
    }
}
