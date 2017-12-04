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
public class Usuario implements JSONStreamAware{
    
    public String nombre;
    public String contrasenia;
    public String tipo; // 1 para adiminstrador 2 para estudiante
    public String nota;
    public String progreso;

    public Usuario(String nombre, String contrasenia, String tipo ,String nota, String progreso) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.tipo = tipo;
        this.nota = nota;
        this.progreso = progreso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
    
    
    @Override
    public void writeJSONString(Writer out) throws IOException {
        LinkedHashMap obj = new LinkedHashMap();
        obj.put("nom", this.nombre);
        obj.put("con", this.contrasenia);
        obj.put("tipo", this.tipo);
        obj.put("not", this.nota);
        obj.put("pro", this.progreso);
        JSONValue.writeJSONString(obj,out);
    }
    
    
    
    
}
