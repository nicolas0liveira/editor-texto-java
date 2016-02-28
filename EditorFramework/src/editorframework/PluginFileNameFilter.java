/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework;

import java.io.File;
import java.io.FilenameFilter;

/**
 *
 * @author 02246149592
 */
public class PluginFileNameFilter implements FilenameFilter {

    @Override
    public boolean accept(File dir, String name) {
        return !name.startsWith(".")?true:false;
    }
    
}
