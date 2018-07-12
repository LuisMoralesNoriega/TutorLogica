/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.html.simpleparser.HTMLWorker; 
import com.itextpdf.text.html.simpleparser.StyleSheet;
import com.itextpdf.text.pdf.PdfWriter; 
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Koko
 */
public class Impresiones {

    Archivo a;
    
    Document document;
    
    public Impresiones() {
        this.a = new Archivo();
    }
    
    
    public void Imprimir(String unidad){
        
        try {
            
            this.document = new Document(PageSize.A4); 
            PdfWriter pdfWriter = PdfWriter.getInstance(this.document, new FileOutputStream("Unidad "+ unidad +".pdf")); 
            
            this.document.open(); 
            this.document.addAuthor("Luis Aroldo Morales Noriega"); 
            this.document.addCreator("Tutor Logica de Sistemas"); 
            this.document.addCreationDate(); 
            this.document.addTitle("Unidad "+ unidad); 

            
            JSONArray arrayTemas = this.a.arrayTemas();        
            if(arrayTemas != null){
                JSONArray arr = (JSONArray) arrayTemas.get(0);
                for(int i = 0; i < arr.size(); i++){                
                    JSONObject user = (JSONObject) arr.get(i);
                    String codu = user.get("codu").toString();
                    if(codu.equals(Compartidas.codigo_unidad)){
                        String conO = user.get("conO").toString();       
                        
                        String htmlString = this.a.ParserHTML(conO);
                        htmlString = htmlString.replace("file:/", "");

                        this.ParserHTML(htmlString);                        
                    }
                }            
            }
    
            this.document.close(); 
            
            this.a.Alerta("Se a creado PDF de la unidad " + unidad + " CORRECTAMENTE!!");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public void ImprimirTodo(){
        
        try {
            
            this.document = new Document(PageSize.A4); 
            PdfWriter pdfWriter = PdfWriter.getInstance(this.document, new FileOutputStream("Logica de Sistemas.pdf")); 
            
            this.document.open(); 
            this.document.addAuthor("Luis Aroldo Morales Noriega"); 
            this.document.addCreator("Tutor Logica de Sistemas"); 
            this.document.addCreationDate(); 
            this.document.addTitle("Logica de Sistemas"); 

            
            JSONArray arrayTemas = this.a.arrayTemas();        
            if(arrayTemas != null){
                JSONArray arr = (JSONArray) arrayTemas.get(0);
                for(int i = 0; i < arr.size(); i++){                
                    JSONObject user = (JSONObject) arr.get(i);
                    String conO = user.get("conO").toString();       

                    String htmlString = this.a.ParserHTML(conO);
                    htmlString = htmlString.replace("file:/", "");

                    this.ParserHTML(htmlString);
                }            
            }
    
            this.document.close(); 
            
            this.a.Alerta("Se a creado PDF del curso CORRECTAMENTE!!");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        
    
    //Metodo para parsear el html y poner la ruta absoluta de las imagenes del curso
    public String ParserHTML(String phtml) throws DocumentException{
    
        String nueva = "";     //nuevo html   
        org.jsoup.nodes.Document doc = Jsoup.parse(phtml); //parsear html 
        Elements ele = doc.getAllElements();  //seleccionamos etiqueta img   
        List listado = new List(true);
        boolean haylis = false;
        boolean tarea = false;
        for (Element elemento : ele) {
            try {
                String etiqueta = elemento.tagName();    
                
                switch (etiqueta){
                    case "h1":
                        //poner funte al titulo
                        Font fh1= new Font();
                        fh1.setSize(30);
                        fh1.setColor(BaseColor.RED);
                        fh1.setStyle(Font.BOLD);
                        if(elemento.text().contains("Tarea")){
                            tarea = true;
                        }
                        Paragraph ph1 = new Paragraph(elemento.text(),fh1);                        
                        ph1.setAlignment(1); // con 1 centra el texto                        
                        this.document.add(ph1);
                        
                        break;
                        
                    case "h2":
                       //poner funte al titulo
                        Font fh2= new Font();
                        fh2.setSize(25);
                        fh2.setColor(BaseColor.BLUE);
                        fh2.setStyle(Font.BOLD);
                        
                        Paragraph ph2 = new Paragraph(elemento.text(),fh2);                        
                        ph2.setAlignment(3); // con 1 centra el texto                        
                        this.document.add(ph2);
                        
                        break;
                        
                    case "p":
                         //poner funte al titulo
                        Font fp= new Font();
                        fp.setSize(15);
                        fp.setColor(BaseColor.BLACK);
                        
                        Paragraph pp2 = new Paragraph(elemento.text(),fp);                        
                        pp2.setAlignment(4); // con 1 centra el texto                        
                        this.document.add(pp2);
                        
                        
                        
                        break;
                        
                    case "img":
                        
                        Image imagen = Image.getInstance(elemento.attr("src"));
                        imagen.setAlignment(1);
                        document.add(imagen);
                        
                        break;
                        
                    default:
                        // System.out.println("No entro");
                }
            } catch (DocumentException ex) {
                Logger.getLogger(Impresiones.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Impresiones.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
        nueva = doc.toString(); // devolvemos el nuevo html        
        return nueva;
    }
    
    
    
}
