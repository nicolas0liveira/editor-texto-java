/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework;

import editorframework.interfaces.IDocument;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aluno
 */
public class PDFDocument implements IDocument {

    private String fileName;
    private List<String> data = new ArrayList<String>();
    
    @Override
    public boolean open(String fileName) {
        this.fileName = fileName;
        data.clear();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            for (String line; (line = reader.readLine()) != null;) {
                data.add(line);
                System.out.println(line);
            }
            /*
            String line = "";
            while(reader.readLine().isEmpty()){
                data.add(line);
                System.out.println(line);
            }
            */
            reader.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(PDFDocument.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public List<String> getData() {
        return data;
    }

}
