/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework.interfaces;

import java.io.Serializable;

/**
 *
 * @author aluno
 */
public interface IDocument<T> {
    public abstract boolean open(String fileName);
    public abstract boolean close();
    public abstract boolean save();
    public abstract T getData();
}
