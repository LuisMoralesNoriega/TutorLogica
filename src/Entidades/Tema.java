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
    public String contenido;

    public Tema() {
        this.nombre = "";
        this.codigoT = "";
        this.codigoU = "";
        this.contenido = "";
    }

    
    public Tema(String nombre, String codigoT, String codigoU, String contenido) {
        this.nombre = nombre;
        this.codigoT = codigoT;
        this.codigoU = codigoU;
        this.contenido = contenido;
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

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
    //Metodo para crear un objeto json
    @Override
    public void writeJSONString(Writer out) throws IOException {
        LinkedHashMap obj = new LinkedHashMap();
        obj.put("nom", this.nombre);
        obj.put("codt", this.codigoT);
        obj.put("codu", this.codigoU);
        obj.put("con", this.contenido);
        JSONValue.writeJSONString(obj,out);
    }
    
    
    
    
}
