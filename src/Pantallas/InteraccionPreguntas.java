/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas;

import Acciones.Archivo;
import Acciones.Compartidas;
import Entidades.Pregunta;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Koko
 */
public class InteraccionPreguntas extends javax.swing.JFrame {

    /**
     * Creates new form InteraccionPreguntas
     */
    
    Archivo a;
    JSONArray arrPreguntas;
    List<String> respuestas;
    public ArrayList<JRadioButton> Botones;
    
    int posicion;
    int fin;
    int inicio;
    
    int numpreguntas;
    int numbuenas;
    int nummalas;
    
    String resactual;
    String tipactual;
    
    JTextField e;
    
    public InteraccionPreguntas() {
        initComponents();
        
        this.arrPreguntas = new JSONArray();
        
        this.inicio = 0;
        this.fin = 0;
        this.posicion = 0;
        
        this.numpreguntas = 0;
        this.numbuenas = 0;
        this.nummalas = 0;
        
        this.resactual = "";
        this.tipactual = "";
        
        this.respuestas = new LinkedList<String>();
        
        this.Botones = new ArrayList<>();
        
        this.a = new Archivo();
        
        this.jLabel2.setText("Unidad:" + Compartidas.nom_unidad);
        
        this.jLabel2.setHorizontalAlignment(JLabel.CENTER);
        
        this.CargarPreguntas();
        
        this.PreguntaInicio();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GRespuestas = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        ScrollRespuestas = new javax.swing.JScrollPane();
        JPanelRespuestas = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 204));

        ScrollRespuestas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Respuestas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 1, 12))); // NOI18N

        JPanelRespuestas.setLayout(new java.awt.GridLayout(0, 1));
        ScrollRespuestas.setViewportView(JPanelRespuestas);

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N

        jButton5.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/siguiente.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel11.setText("Siguiente");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
                    .addComponent(ScrollRespuestas)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ScrollRespuestas, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       // Boton Siguiente:
       this.PreguntaSiguiente();
    }//GEN-LAST:event_jButton5ActionPerformed

    
    public void CargarPreguntas(){
        
        JSONArray arrayPreguntas = this.a.arrayPreguntas();        
        if(arrayPreguntas != null){
            JSONArray arr = (JSONArray) arrayPreguntas.get(0);
            for(int i = 0; i < arr.size(); i++){                
                JSONObject user = (JSONObject) arr.get(i);
                String codu = user.get("codu").toString();
                if(codu.equals(Compartidas.codigo_unidad)){
                    String tip = user.get("tipo").toString();                    
                    String preg = user.get("preg").toString();                     
                    String r1 = user.get("r1").toString();                     
                    String r2 = user.get("r2").toString();                         
                    String r3 = user.get("r3").toString();                         
                    String r4 = user.get("r4").toString();                    
                    this.arrPreguntas.add(new Pregunta(preg, tip, r1, r2, r3, r4,codu));
                }
            }            
        }
        this.numpreguntas = this.arrPreguntas.size();
        this.fin = this.arrPreguntas.size() - 1;        
    }
    
    
    public void PreguntaInicio(){        
        if(this.arrPreguntas != null){            
            Pregunta pregunta = (Pregunta) this.arrPreguntas.get(this.posicion);
            String preg = pregunta.preg;
            this.jLabel3.setText("¿ " + preg + " ?");    
            
            if(pregunta.tipo.equals("1")){
                JLabel r = new JLabel("Escriba la respuesta correcta:");
                this.JPanelRespuestas.add(r);
                this.e = new JTextField();
                this.JPanelRespuestas.add(e);
                this.resactual = pregunta.r1;
                this.tipactual = pregunta.tipo;
            }else{
                this.respuestas.add(pregunta.r1);
                this.respuestas.add(pregunta.r2);
                this.respuestas.add(pregunta.r3);
                this.respuestas.add(pregunta.r4);
                this.resactual = pregunta.r1;
                this.tipactual = pregunta.tipo;
                Collections.shuffle(this.respuestas);
                JRadioButton nuevo;
                for(String res : this.respuestas){
                    nuevo =  new JRadioButton(res);
                    this.GRespuestas.add(nuevo);
                    this.Botones.add(nuevo);
                    this.JPanelRespuestas.add(nuevo);
                }
            }            
            this.JPanelRespuestas.updateUI();            
        }        
    }
    
    
    public void PreguntaSiguiente(){
        this.Evaluar();
        this.respuestas.clear();
        this.JPanelRespuestas.removeAll();
        if(this.fin != this.posicion){
            this.posicion++;        
        }else{
            this.CalcularNota();
            InteraccionTemas tem = new InteraccionTemas();
            tem.setLocationRelativeTo(null);
            tem.setVisible(true);
            this.dispose();
        }        
        if(this.arrPreguntas != null){            
            Pregunta pregunta = (Pregunta) this.arrPreguntas.get(this.posicion);
            String preg = pregunta.preg;
            this.jLabel3.setText("¿ " + preg + " ?");    
            
            if(pregunta.tipo.equals("1")){
                JLabel r = new JLabel("Escriba la respuesta:");
                this.JPanelRespuestas.add(r);
                JTextField e = new JTextField();
                this.JPanelRespuestas.add(e);
                this.resactual = pregunta.r1;
                this.tipactual = pregunta.tipo;
            }else{
                this.respuestas.add(pregunta.r1);
                this.respuestas.add(pregunta.r2);
                this.respuestas.add(pregunta.r3);
                this.respuestas.add(pregunta.r4);
                this.resactual = pregunta.r1;
                this.tipactual = pregunta.tipo;
                Collections.shuffle(this.respuestas);
                JRadioButton nuevo;
                for(String res : this.respuestas){
                    nuevo =  new JRadioButton(res);
                    this.GRespuestas.add(nuevo);
                    this.Botones.add(nuevo);
                    this.JPanelRespuestas.add(nuevo);
                }
            }
            
            this.JPanelRespuestas.updateUI();
        }
    } 
     
    
    public void Evaluar(){
        
        
        if(this.tipactual.equals("1")){
            String res = this.e.getText();
            this.resactual.toLowerCase();
            if(this.resactual.equals(res.toLowerCase())){
                this.Mensaje("Respuesta Correcta");
                this.numbuenas++;
            }else{
                this.Mensaje("Respuesta Incorrecta");
                this.nummalas++;
            }            
        }else{
            String res = "";
            for(JRadioButton tmp: Botones){                
                if(tmp.isSelected()){
                    res = tmp.getText();
                    break;
                }                 
            }
            this.resactual.toLowerCase();
            if(this.resactual.equals(res.toLowerCase())){
                 this.Mensaje("Respuesta Correcta");
                 this.numbuenas++;
            }else{
                this.Mensaje("Respuesta Incorrecta");
                this.nummalas++;
            }  
        }       
        
    } 
    
    
    public void Mensaje(String msg){
        JOptionPane.showMessageDialog(null, msg, "Respuesta", JOptionPane.INFORMATION_MESSAGE);
    }
    
    
    public void CalcularNota(){
        
        if(this.numpreguntas == this.numbuenas + this.nummalas){
            float nota = ((float)this.numbuenas / this.numpreguntas) * 100;
            String reco = "";
            if(nota < 80){
                reco = "reforzar el estudio de la unidad";
            }else{
                reco = "reforzar poco la unidad y luego pasar a la siguiente, felicidades por su rendimiento";
            }
            String men = "Respuestas correctas: " + this.numbuenas + "\n"
                       + "Respuestas Incorrectas: " + this.nummalas + "\n" 
                       + "Nota de la evaluacion: " + (int)nota + "\n\n" 
                       + "Se recomienta: " + reco;
            this.Mensaje(men);
        }else{
            this.Mensaje("No se completo la evaluacion");            
        }       
        
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InteraccionPreguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InteraccionPreguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InteraccionPreguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InteraccionPreguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InteraccionPreguntas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GRespuestas;
    private javax.swing.JPanel JPanelRespuestas;
    private javax.swing.JScrollPane ScrollRespuestas;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
