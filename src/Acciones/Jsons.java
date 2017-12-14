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

    public Jsons(){
        this.estilo = 0;
        this.usuario = "";
        this.cursos = "";
    }
    
    public Jsons(String usuario, String curso, int estilo) {
        this.estilo = estilo;
        this.usuario = usuario;        
        this.cursos = curso;
    }   
    
    
}
