/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas;

import Acciones.Archivo;
import Acciones.Compartidas;
import Entidades.Tema;
import java.io.IOException;
import java.io.StringWriter;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Koko
 */
public class AgregarTema extends javax.swing.JFrame {

    
    Archivo a;
    boolean insertado;
    /**
     * Creates new form AgregarTema
     */
    public AgregarTema() {
        initComponents();
        this.a = new Archivo();
        this.insertado = false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jtxNum = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtxNom = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel2.setText("Agregar Tema");

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel6.setText("Ingrese los Siguientes Datos");

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel1.setText("No. Tema:");

        jtxNum.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jtxNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxNumActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel3.setText("Nombre:");

        jtxNom.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jtxNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxNomActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jButton2)
                .addGap(47, 47, 47)
                .addComponent(jButton3)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtxNom, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(32, 32, 32)
                        .addComponent(jtxNum, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(56, 56, 56))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtxNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtxNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtxNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxNumActionPerformed

    private void jtxNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxNomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxNomActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Boton de Guardar Tema:

        String nombre = jtxNom.getText();
        String num = jtxNum.getText();
        
        if(nombre.equals("")){
            this.Alerta("Debe Ingresar un Nombre de Tema");  
            return;
        }else if(num.equals("")){
            this.Alerta("Debe Ingresar un Numero de Tema");
            return;
        }
        
        
        try {
            int temp = Integer.parseInt(num);
        } catch (Exception e) {
            this.Alerta("Ingrese un numero Entero en el campo No. Tema");
            this.jtxNum.setText("");
            return;
        }
                
        JSONArray arrayTemas = this.a.arrayTemas();
        JSONArray nuevo = new JSONArray();
        
        if(arrayTemas == null){
            nuevo.add(new Tema(nombre,num,Compartidas.codigo_unidad,""));     
            this.insertado = true;
        }
        
        boolean entro = false;
        
        if(arrayTemas != null){
            JSONArray arr = (JSONArray) arrayTemas.get(0);
            for(int i = 0; i < arr.size(); i++){                
                int nsig = 0;
                JSONObject user = (JSONObject) arr.get(i);
                JSONObject sig = null;
                if(i+1 != arr.size()){
                    sig = (JSONObject) arr.get(i+1);   
                }
                
                if(sig != null){
                    String cods = sig.get("codt").toString();
                    nsig = Integer.parseInt(cods);
                }
                
                String nom = user.get("nom").toString();
                String codt = user.get("codt").toString();                
                String codu = user.get("codu").toString();
                String con = user.get("con").toString();
                
                int cod = Integer.parseInt(codt); 
                
                if(codu.equals(Compartidas.codigo_unidad)){
                    if(!num.equals(codt)){                        
                        int n = Integer.parseInt(num);

                        if(n < cod && !insertado){
                            nuevo.add(new Tema(nombre,num,Compartidas.codigo_unidad,""));
                            nuevo.add(new Tema(nom,codt,codu,con));
                            insertado = true;
                            entro = true;
                        }else if( cod < n && n < nsig ){
                            nuevo.add(new Tema(nom,codt,codu,con));
                            nuevo.add(new Tema(nombre,num,Compartidas.codigo_unidad,""));
                            insertado = true;
                            entro = true;
                        }else{
                            nuevo.add(new Tema(nom,codt,codu,con));
                        }

                    }else{
                        this.Alerta("El Tema ya EXISTE!!");
                        return;
                    }
                
                }else{
                    nuevo.add(new Tema(nom,codt,codu,con));                
                }
                
                
                                                
            }
        }
        
        if(!entro && !insertado){
            nuevo.add(new Tema(nombre,num,Compartidas.codigo_unidad,""));
        }
              
        this.Alerta("Tema Creado");
        StringWriter out = new StringWriter();
        
        try {
            nuevo.writeJSONString(out);
        } catch (IOException ex) {
            ex.printStackTrace();
        }       
        
        this.a.EscribirTemas(out.toString());
        System.out.println("TEMAS: " + out);
        
        EdicionUnidad eu = new EdicionUnidad();
        eu.setLocationRelativeTo(null);
        eu.setVisible(true);
        this.dispose();
        
        
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Bonton cancelar:
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    
    public void Alerta(String msg){
        JOptionPane.showMessageDialog(null, msg, "Agregar Tema", JOptionPane.WARNING_MESSAGE);
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
            java.util.logging.Logger.getLogger(AgregarTema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarTema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarTema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarTema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarTema().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jtxNom;
    private javax.swing.JTextField jtxNum;
    // End of variables declaration//GEN-END:variables

    private class a {

        public a() {
        }
    }
}
