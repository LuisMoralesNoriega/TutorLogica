/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

/**
 *
 * @author Koko
 */
public class Jsons implements java.io.Serializable {
    
    public int estilo;
    public String usuario;
    public String cursos;
    public String unidades;

    public Jsons(){
        this.estilo = 0;
        this.usuario = "";
        this.cursos = "";
        this.unidades = "";
    }
    
    public Jsons(String usuario, String curso, int estilo, String unidades) {
        this.estilo = estilo;
        this.usuario = usuario;        
        this.cursos = curso;
        this.unidades = unidades;
    }   
    
    
}
