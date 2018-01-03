/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.IOException;
import java.io.Writer;
import java.util.LinkedHashMap;
import org.json.simple.JSONStreamAware;
import org.json.simple.JSONValue;

/**
 *
 * @author Koko
 */
public class Tema implements JSONStreamAware{
    
    public String nombre;
    public String codigoT;
    public String codigoU;
    public String contenidoO;
    public String contenidoM;

    
    public Tema() {
        this.nombre = "";
        this.codigoT = "";
        this.codigoU = "";
        this.contenidoO = "<html>\n"
                          + "<body>\n"
                          + "<h1>Esto es un TITULO!</h1>\n"
                          + "<h2>Esto es un Sub Titulo</h2>\n"
                          + "<p>Esto es un parrafo justificado</p>\n<br>\n"
                          + "<center>\n"
                          + "<img src=\"ImagenesCurso/Logica.png\" />\n"
                          + "</center>\n"
                          + "</body>\n"
                          + "</html>";       
        
        this.contenidoM =   "<html>\n" +
                            " <head></head>\n" +
                            " <body> \n" +
                            "  <h1>Esto es un TITULO!</h1> \n" +
                            "  <h2>Esto es un Sub Titulo</h2> \n" +
                            "  <p>Esto es un parrafo justificado</p> \n" +
                            "  <br> \n" +
                            "  <center> \n" +
                            "   <img src=\"file:/C:/Users/Koko/Documents/U/EPS/Apps/Escritorio/Tutor/build/classes/ImagenesCurso/Logica.png\"> \n" +
                            "  </center>  \n" +
                            " </body>\n" +
                            "</html>";
    }
    
    public Tema(String nombre, String codigoT, String codigoU) {
        this.nombre = nombre;
        this.codigoT = codigoT;
        this.codigoU = codigoU;
        this.contenidoO = "<html>\n"
                          + "<body>\n"
                          + "<h1>Esto es un TITULO!</h1>\n"
                          + "<h2>Esto es un Sub Titulo</h2>\n"
                          + "<p>Esto es un parrafo justificado</p>\n<br>\n"
                          + "<center>\n"
                          + "<img src=\"ImagenesCurso/Logica.png\" />\n"
                          + "</center>\n"
                          + "</body>\n"
                          + "</html>";       
        
        this.contenidoM =   "<html>\n" +
                            " <head></head>\n" +
                            " <body> \n" +
                            "  <h1>Esto es un TITULO!</h1> \n" +
                            "  <h2>Esto es un Sub Titulo</h2> \n" +
                            "  <p>Esto es un parrafo justificado</p> \n" +
                            "  <br> \n" +
                            "  <center> \n" +
                            "   <img src=\"file:/C:/Users/Koko/Documents/U/EPS/Apps/Escritorio/Tutor/build/classes/ImagenesCurso/Logica.png\"> \n" +
                            "  </center>  \n" +
                            " </body>\n" +
                            "</html>";
        
    }
    
    public Tema(String nombre, String codigoT, String codigoU, String conO, String conM) {
    
        this.nombre = nombre;
        this.codigoT = codigoT;
        this.codigoU = codigoU;
        this.contenidoO = conO;
        this.contenidoM = conM;
    }
        
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoT() {
        return codigoT;
    }

    public void setCodigoT(String codigoT) {
        this.codigoT = codigoT;
    }

    public String getCodigoU() {
        return codigoU;
    }

    public void setCodigoU(String codigoU) {
        this.codigoU = codigoU;
    }

    public String getContenidoO() {
        return contenidoO;
    }

    public void setContenidoO(String contenidoO) {
        this.contenidoO = contenidoO;
    }

    public String getContenidoM() {
        return contenidoM;
    }

    public void setContenidoM(String contenidoM) {
        this.contenidoM = contenidoM;
    }
    
    //Metodo para crear un objeto json
    @Override
    public void writeJSONString(Writer out) throws IOException {
        LinkedHashMap obj = new LinkedHashMap();
        obj.put("nom", this.nombre);
        obj.put("codt", this.codigoT);
        obj.put("codu", this.codigoU);
        obj.put("conO", this.contenidoO);        
        obj.put("conM", this.contenidoM);
        JSONValue.writeJSONString(obj,out);
    }
    
    
    
    
}
