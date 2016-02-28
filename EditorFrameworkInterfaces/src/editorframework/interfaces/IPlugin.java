/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework.interfaces;

/**
 *
 * @author aluno
 */
public interface IPlugin extends IPluginInfo {   
    public boolean initialize(ICore core);
    public ICore getCore();
    
}
