/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework.interfaces;

import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;

/**
 *
 * @author aluno
 */
public interface IUIController {
    JMenuItem addMenuItem(String menu, String menuItem);

    /**
     *
     * @param e
     */
    void btnOpenPerformed(ActionEvent e); 
}