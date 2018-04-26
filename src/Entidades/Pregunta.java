/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Acciones.Compartidas;
import java.io.IOException;
import java.io.Writer;
import java.util.LinkedHashMap;
import org.json.simple.JSONStreamAware;
import org.json.simple.JSONValue;

/**
 *
 * @author Koko
 */
public class Pregunta implements JSONStreamAware {
    
    public String preg;
    public String tipo;
    public String r1;
    public String r2; 
    public String r3;
    public String r4;

    public String getPreg() {
        return preg;
    }

    public void setPreg(String preg) {
        this.preg = preg;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getR1() {
        return r1;
    }

    public void setR1(String r1) {
        this.r1 = r1;
    }

    public String getR2() {
        return r2;
    }

    public void setR2(String r2) {
        this.r2 = r2;
    }

    public String getR3() {
        return r3;
    }

    public void setR3(String r3) {
        this.r3 = r3;
    }

    public String getR4() {
        return r4;
    }

    public void setR4(String r4) {
        this.r4 = r4;
    }

    public String getCodigoU() {
        return codigoU;
    }

    public void setCodigoU(String codigoU) {
        this.codigoU = codigoU;
    }
    public String codigoU;

    public Pregunta() {
        this.preg = "";
        this.tipo = "";
        this.r1 = "";
        this.r2 = "";
        this.r3 = "";
        this.r4 = "";
        this.codigoU = Compartidas.codigo_unidad;
    }

        
    //Constructor para pregunta tipo 4 respuestas
    public Pregunta(String preg, String tipo, String r1, String r2, String r3, String r4, String uni) {
        this.preg = preg;
        this.tipo = tipo;
        this.r1 = r1;
        this.r2 = r2;
        this.r3 = r3;
        this.r4 = r4;
        this.codigoU = uni;
    }
      
        
    //Metodo para crear un objeto json
    @Override
    public void writeJSONString(Writer out) throws IOException {
        LinkedHashMap obj = new LinkedHashMap();
        obj.put("preg", this.preg);
        obj.put("tipo", this.tipo);
        obj.put("r1", this.r1);
        obj.put("r2", this.r2);
        obj.put("r3", this.r3);
        obj.put("r4", this.r4);         
        obj.put("codu", this.codigoU);
        JSONValue.writeJSONString(obj,out);
    }
    
    
}
