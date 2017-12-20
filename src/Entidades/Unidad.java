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
public class Unidad implements JSONStreamAware{
    
    public String nombre;
    public String codigoUnidad;
    public String codigoCurso;
    public String nota;
    public String progreso;

    public Unidad() {
        this.nombre = "";
        this.codigoUnidad = "";
        this.codigoCurso = "";
        this.progreso = "";
        this.nota = "";
    }

    
    public Unidad(String nombre, String codigoUnidad, String codigoCurso, String nota, String progreso) {
        this.nombre = nombre;
        this.codigoUnidad = codigoUnidad;
        this.codigoCurso = codigoCurso;
        this.progreso = progreso;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoUnidad() {
        return codigoUnidad;
    }

    public void setCodigoUnidad(String codigoUnidad) {
        this.codigoUnidad = codigoUnidad;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }
    
    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
    
    public String getProgreso() {
        return progreso;
    }

    public void setProgreso(String progreso) {
        this.progreso = progreso;
    }

    
     //Metodo para crear un objeto json
    @Override
    public void writeJSONString(Writer out) throws IOException {
        LinkedHashMap obj = new LinkedHashMap();
        obj.put("nom", this.nombre);
        obj.put("codu", this.codigoUnidad);
        obj.put("codc", this.codigoCurso);
        obj.put("not", this.nota);
        obj.put("pro", this.progreso);
        JSONValue.writeJSONString(obj,out);
    }
    
    
}
