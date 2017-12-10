/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

import Pantallas.Registro;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import org.json.simple.JSONArray;
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
    public void EscribirBinario(String cadena){        
        ObjectOutputStream salida = null;
        try{
            salida = new ObjectOutputStream(new FileOutputStream(ruta));     
            salida.writeObject(new Jsons(cadena));
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
            Object obj  = parser.parse(this.ObtenerUsuarios());
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
        //objeto json nuevo
        Jsons nuevo = new Jsons();
        nuevo.estilo = pestilo;
        //obtenemos el objeto
        try{
            FileInputStream ficheroEntrada = new FileInputStream(ruta);
            ObjectInputStream objetoEntrada = new ObjectInputStream(ficheroEntrada);
            // se leen dos objetos de la clase Persona
            Jsons p1 = (Jsons)objetoEntrada.readObject();
            // se cierra el flujo de objetos objetoEntrada
            nuevo.usuario = p1.usuario;
        }catch (FileNotFoundException e) {
            System.out.println("¡El fichero no existe!");
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        };        
        
        
        //Guardamos el nuevo json
        ObjectOutputStream salida = null;
        try{
            salida = new ObjectOutputStream(new FileOutputStream(ruta));     
            salida.writeObject(nuevo);
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
}
