/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.html.simpleparser.HTMLWorker; 
import com.itextpdf.text.html.simpleparser.StyleSheet;
import com.itextpdf.text.pdf.PdfWriter; 
import java.io.FileOutputStream;
import java.io.StringReader;
import javax.swing.text.html.HTMLEditorKit;

/**
 *
 * @author Koko
 */
public class Impresiones {

    Archivo a;
    public Impresiones() {
        this.a = new Archivo();
    }
    
    
    public void Imprimir(){
        
        try {
            
            Document document = new Document(PageSize.A4); 
            PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream("plantilla.pdf")); 
            document.open(); 
            document.addAuthor("Persona creadora"); 
            document.addCreator("Software generador"); 
            document.addCreationDate(); 
            document.addTitle("Titulo del documento"); 
            
            
            HTMLEditorKit kit = new HTMLEditorKit();            
            StyleSheet styleSheet = new StyleSheet();
            
            styleSheet.loadTagStyle("body", "font", "Comic Sans MS");
            styleSheet.loadTagStyle("h1", "color", "#ff0000");
//            styleSheet.addRule("body {color:#000; font-family:Comic Sans MS,cursive,sans-serif; margin: 4px; }");
//            styleSheet.addRule("h1 {color: #ff0000; text-align: center;}"); // Titulos
//            styleSheet.addRule("h2 {color: #007FFD; text-align: left; }"); // Sub titulos
//            styleSheet.addRule("p {color: #000000; text-align: justify; }"); // contenido
            
            HTMLWorker htmlWorker = new HTMLWorker(document);
            htmlWorker.setStyleSheet(styleSheet);
            String str = "<html>\n"
                          + "<body>\n"
                          + "<h1>Esto es un TITULO!</h1>\n"
                          + "<h2>Esto es un Sub Titulo</h2>\n"
                          + "<p>Esto es un parrafo justificado</p>\n<br>\n"
                          + "<center>\n"
                          + "<img src=\"ImagenesCurso/Logica.png\" />\n"
                          + "</center>\n"
                          + "</body>\n"
                          + "</html>";
            
            String htmlString = this.a.ParserHTML(str);
            htmlString = htmlString.replace("file:/", "");
            htmlWorker.parse(new StringReader(htmlString)); 
            document.close(); 
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
    }
    
    
    
}
