/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

import Entidades.Curso;
import Pantallas.Registro;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Koko
 */
public class Archivo {
    
    
    public String ruta;
    File ar;

    //Constructor de la aplicacion
    public Archivo(){   
        File a = new File(".");
        if(a.getAbsolutePath().contains("dist")){
            this.ruta = a.getAbsolutePath() + "\\Archivo\\datos.bin";  
        }else{
            this.ruta = a.getAbsolutePath() + "\\src\\Archivo\\datos.bin";
        }          
    }
    
    
    // <editor-fold desc="Codigo de Loguin">
    
    //Metodo para alertas del programa
    public void Alerta(String msg){
        JOptionPane.showMessageDialog(null, msg, "Loguin", JOptionPane.WARNING_MESSAGE);
    }
    
    //Metodo para escribir una cadena dentro del archivo binario
    public void EscribirUsuarios(String usuario){        
        ObjectOutputStream salida = null;
        try{
            String cursos = this.ObtenerCursos();
            int estilo = this.ObtenerEstilo();
            String unidades = this.ObtenerUnidades();
            String temas = this.ObtenerTemas();
            salida = new ObjectOutputStream(new FileOutputStream(ruta));            
            salida.writeObject(new Jsons(usuario,cursos,estilo,unidades,temas));
            salida.close();
        }catch(FileNotFoundException ex){
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }catch(IOException ex){
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                salida.close();
            }catch(IOException ex){
                Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }
    
    //Metodo para leer el archivo binario
    public void LeerBinario(){
        try{
            FileInputStream ficheroEntrada = new FileInputStream(ruta);
            ObjectInputStream objetoEntrada = new ObjectInputStream(ficheroEntrada);
            // se leen dos objetos de la clase Persona
            Jsons p1 = (Jsons)objetoEntrada.readObject();
            // se cierra el flujo de objetos objetoEntrada
            objetoEntrada.close();
            System.out.println("Json De USUARIOS \n");
            System.out.println(p1.usuario);
        }catch (FileNotFoundException e) {
            System.out.println("¡El fichero no existe!");
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        };    
    }
           
    //Obtener usuarios registrados
    public String ObtenerUsuarios(){
        try{
            FileInputStream ficheroEntrada = new FileInputStream(ruta);
            ObjectInputStream objetoEntrada = new ObjectInputStream(ficheroEntrada);
            // se leen dos objetos de la clase Persona
            Jsons p1 = (Jsons)objetoEntrada.readObject();
            // se cierra el flujo de objetos objetoEntrada
            objetoEntrada.close();
            return p1.usuario;
        }catch (FileNotFoundException e) {
            System.out.println("¡El fichero no existe!");
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        };
        return "";        
    }
                
    //Metodo para obtener array de usuarios registrados
    public JSONArray arrayUsers(){        
        try {            
            JSONParser parser = new JSONParser();
            String usuarios = this.ObtenerUsuarios();
            if(usuarios.equals("")){
                return null;
            }
            Object obj  = parser.parse(usuarios);
            JSONArray array = new JSONArray();
            array.add(obj);
            return array;              
        } catch (ParseException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return null;
    }
    
    // </editor-fold>
    
    
    // <editor-fold desc="Codigo Configuracion de Estilo">
    
    //Metodo para escribir una cadena dentro del archivo binario
    public void EscribirEstilo(int pestilo){     
        //Guardamos el nuevo json
        ObjectOutputStream salida = null;
        try{
            String usuarios = this.ObtenerUsuarios();
            String cursos = this.ObtenerCursos();
            String unidades = this.ObtenerUnidades();
            String temas = this.ObtenerTemas();
            salida = new ObjectOutputStream(new FileOutputStream(ruta));     
            salida.writeObject(new Jsons(usuarios,cursos,pestilo,unidades,temas));
            salida.close();
        }catch(FileNotFoundException ex){
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }catch(IOException ex){
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                salida.close();
            }catch(IOException ex){
                Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }
    
    //Metodo para obtener el estilo de la aplicacion
    public int ObtenerEstilo(){        
        //objeto json nuevo
        int estilo = 0;
        //obtenemos el objeto
        try{
            FileInputStream ficheroEntrada = new FileInputStream(ruta);
            ObjectInputStream objetoEntrada = new ObjectInputStream(ficheroEntrada);
            // se leen dos objetos de la clase Persona
            Jsons p1 = (Jsons)objetoEntrada.readObject();
            // se cierra el flujo de objetos objetoEntrada
            estilo = p1.estilo;
        }catch (FileNotFoundException e) {
            System.out.println("¡El fichero no existe!");
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        };      
        return estilo;              
    }
    
    
    // </editor-fold>
    
    
    // <editor-fold desc="Codigo Para Cursos">
        
    public void EscribirCurso(String curso){
           ObjectOutputStream salida = null;
        try{
            String usuarios = this.ObtenerUsuarios();
            int estilo = this.ObtenerEstilo();
            String unidades = this.ObtenerUnidades();
            String temas = this.ObtenerTemas();
            salida = new ObjectOutputStream(new FileOutputStream(ruta));            
            salida.writeObject(new Jsons(usuarios,curso,estilo,unidades,temas));
            salida.close();
        }catch(FileNotFoundException ex){
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }catch(IOException ex){
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                salida.close();
            }catch(IOException ex){
                Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
      }
                
    //Metodo para obtener array de cursos registrados    
    public JSONArray arrayCurso(){        
        try {            
            JSONParser parser = new JSONParser();
             String cursos = this.ObtenerCursos();
            if(cursos.equals("")){
                return null;
            }
            Object obj  = parser.parse(this.ObtenerCursos());            
            JSONArray array = new JSONArray();
            array.add(obj);
            return array;              
        } catch (ParseException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return null;
    }  
    
    //Obtener json de curso
    public String ObtenerCursos(){
        try{
            FileInputStream ficheroEntrada = new FileInputStream(ruta);
            ObjectInputStream objetoEntrada = new ObjectInputStream(ficheroEntrada);
            // se leen dos objetos de la clase Persona
            Jsons p1 = (Jsons)objetoEntrada.readObject();
            // se cierra el flujo de objetos objetoEntrada
            objetoEntrada.close();
            return p1.cursos;
        }catch (FileNotFoundException e) {
            System.out.println("¡El fichero no existe!");
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        };
        return "";        
    }
        
    //Metodo para obtener cursos
    public void ObtenerCurso(){
        
        JSONArray Curso = this.arrayCurso();       
               
        if(Curso != null){
            JSONArray arr = (JSONArray) Curso.get(0);
            for(int i = 0; i < arr.size(); i++){                
                JSONObject user = (JSONObject) arr.get(i);
                String nom = user.get("nom").toString();
                String cod = user.get("cod").toString();
                Compartidas.curso = nom;
                Compartidas.codigo_curso = cod;
            }
        }            
    }   
          
    //Metodo para crear curso
    public void CrearCurso(){
        
        JSONArray nuevo = new JSONArray();
           
        nuevo.add(new Curso("Logica de Sistemas", "0795"));
                
        StringWriter out = new StringWriter();
        
        try {
            nuevo.writeJSONString(out);
        } catch (IOException ex) {
            ex.printStackTrace();
        }       
        
        this.EscribirCurso(out.toString());
        System.out.println(out);
        
    } 
    
    //Metodo para actualizar curso
    public void ActualizarCurso(String curso, String codigo){
        
        JSONArray nuevo = new JSONArray();
           
        nuevo.add(new Curso(curso, codigo));
                
        StringWriter out = new StringWriter();
        
        try {
            nuevo.writeJSONString(out);
        } catch (IOException ex) {
            ex.printStackTrace();
        }       
        
        this.EscribirCurso(out.toString());
        System.out.println(out);
               
    } 
            
    // </editor-fold>
    
    
    // <editor-fold desc="Codigo para Unidades">
    
    //Metodo para escribir una cadena dentro del archivo binario
    public void EscribirUnidades(String unidades){        
        ObjectOutputStream salida = null;
        try{
            String usuarios = this.ObtenerUsuarios();
            String cursos = this.ObtenerCursos();
            int estilo = this.ObtenerEstilo();
            String temas = this.ObtenerTemas();
            salida = new ObjectOutputStream(new FileOutputStream(ruta));            
            salida.writeObject(new Jsons(usuarios,cursos,estilo,unidades,temas));
            salida.close();
        }catch(FileNotFoundException ex){
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }catch(IOException ex){
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                salida.close();
            }catch(IOException ex){
                Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }
    
    //Obtener json de curso
    public String ObtenerUnidades(){
        try{
            FileInputStream ficheroEntrada = new FileInputStream(ruta);
            ObjectInputStream objetoEntrada = new ObjectInputStream(ficheroEntrada);
            // se leen dos objetos de la clase Persona
            Jsons p1 = (Jsons)objetoEntrada.readObject();
            // se cierra el flujo de objetos objetoEntrada
            objetoEntrada.close();
            return p1.unidades;
        }catch (FileNotFoundException e) {
            System.out.println("¡El fichero no existe!");
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        };
        return "";        
    }
    
    //Metodo para obtener array de cursos registrados    
    public JSONArray arrayUnidades(){        
        try {            
            JSONParser parser = new JSONParser();
            String unidades = this.ObtenerUnidades();
            if(unidades.equals("") || (unidades == null)){
                return null;
            }
            Object obj  = parser.parse(unidades);            
            JSONArray array = new JSONArray();
            array.add(obj);
            return array;              
        } catch (ParseException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return null;
    }  
        
         
    // </editor-fold>
    
    
    // <editor-fold desc="Codigo para Temas">
    
    //Metodo para escribir una cadena dentro del archivo binario
    public void EscribirTemas(String temas){        
        ObjectOutputStream salida = null;
        try{
            String usuarios = this.ObtenerUsuarios();
            String cursos = this.ObtenerCursos();
            int estilo = this.ObtenerEstilo();
            String unidades = this.ObtenerUnidades();
            salida = new ObjectOutputStream(new FileOutputStream(ruta));            
            salida.writeObject(new Jsons(usuarios,cursos,estilo,unidades,temas));
            salida.close();
        }catch(FileNotFoundException ex){
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }catch(IOException ex){
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                salida.close();
            }catch(IOException ex){
                Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }
    
    //Obtener json de temas
    public String ObtenerTemas(){
        try{
            FileInputStream ficheroEntrada = new FileInputStream(ruta);
            ObjectInputStream objetoEntrada = new ObjectInputStream(ficheroEntrada);
            // se leen dos objetos de la clase Persona
            Jsons p1 = (Jsons)objetoEntrada.readObject();
            // se cierra el flujo de objetos objetoEntrada
            objetoEntrada.close();
            return p1.temas;
        }catch (FileNotFoundException e) {
            System.out.println("¡El fichero no existe!");
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        };
        return "";        
    }
    
    //Metodo para obtener array de temas   
    public JSONArray arrayTemas(){        
        try {            
            JSONParser parser = new JSONParser();
            String temas = this.ObtenerTemas();
            if(temas.equals("") || (temas == null)){
                return null;
            }
            Object obj  = parser.parse(temas);            
            JSONArray array = new JSONArray();
            array.add(obj);
            return array;              
        } catch (ParseException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return null;
    }  
    
    
    // </editor-fold>


}
