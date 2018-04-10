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
public class Pregunta implements JSONStreamAware {
    
    public String preg;
    public String tipo;
    public String r1;
    public String r2; 
    public String r3;
    public String r4;

    public Pregunta() {
        this.preg = "";
        this.tipo = "";
        this.r1 = "";
        this.r2 = "";
        this.r3 = "";
        this.r4 = "";
    }

    public Pregunta(String preg, String tipo, String r1, String r2, String r3, String r4) {
        this.preg = preg;
        this.tipo = tipo;
        this.r1 = r1;
        this.r2 = r2;
        this.r3 = r3;
        this.r4 = r4;
    }
      
    
    
    //Metodo para crear un objeto json
    @Override
    public void writeJSONString(Writer out) throws IOException {
        LinkedHashMap obj = new LinkedHashMap();
        obj.put("nom", this.preg);
        obj.put("codt", this.tipo);
        obj.put("codu", this.r1);
        obj.put("conO", this.r2);
        obj.put("codu", this.r3);
        obj.put("conO", this.r4);  
        JSONValue.writeJSONString(obj,out);
    }
    
    
}
