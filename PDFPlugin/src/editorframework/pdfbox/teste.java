/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework.pdfbox;

/**
 *
 * @author MATHEUS
 */
public class teste {
     public static void main(String[] args) {
        OpenTextPDF otp = new OpenTextPDF();
        System.out.print(otp.openPDF("D:\\testfile.pdf"));
        
    }
    
}
