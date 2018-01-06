/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas;

import Acciones.Archivo;
import Acciones.Compartidas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JLabel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Koko
 */
public class General extends javax.swing.JFrame implements ActionListener {

    public ArrayList<JButton> Botones;
    public Archivo a;
    
    /**
     * Creates new form General
     */
    public General() {
        initComponents();
        if(!Compartidas.admin){
            this.jMenuItem3.disable();
        }else{
            this.jMenuItem1.disable();
        }
        
        this.jLabel8.setText(Compartidas.curso);
        this.jLabel2.setHorizontalAlignment(JLabel.CENTER);
        this.jLabel8.setHorizontalAlignment(JLabel.CENTER);
        
        this.a = new Archivo();
        this.Botones = new ArrayList<>();
        
        this.MostrarUnidades();
        
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
        jLabel8 = new javax.swing.JLabel();
        ScrollUnidades = new javax.swing.JScrollPane();
        JPanelUnidades = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("General");

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel2.setText("Bienvenido");

        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N

        ScrollUnidades.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Unidades", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 2, 12))); // NOI18N

        JPanelUnidades.setLayout(new java.awt.GridLayout(0, 1));
        ScrollUnidades.setViewportView(JPanelUnidades);

        jMenuBar1.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N

        jMenu1.setText("Archivo");
        jMenu1.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N

        jMenuItem3.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jMenuItem3.setText("Administrar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem1.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jMenuItem1.setText("Cerrar Sesion");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Acerca de");
        jMenu2.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N

        jMenuItem2.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jMenuItem2.setText("Creditos");
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ScrollUnidades))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollUnidades, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // Boton Cerrar sesion:
        Loguin log = new Loguin();
        log.setLocationRelativeTo(null);
        log.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // Boton para regresar al administrador
        if(Compartidas.admin){
            Administrador admin = new Administrador();
            admin.setLocationRelativeTo(null);
            admin.setVisible(true);            
            this.dispose();
        }     
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    
    public void MostrarUnidades(){ 
        
        this.JPanelUnidades.removeAll();
        
        JSONArray arrayUnidades = this.a.arrayUnidades();
        
         if(arrayUnidades != null){
            JSONArray arr = (JSONArray) arrayUnidades.get(0);
            for(int i = 0; i < arr.size(); i++){                
                JSONObject user = (JSONObject) arr.get(i);
                String nom = user.get("nom").toString();
                String codu = user.get("codu").toString();    
                JButton nuevo =  new JButton(codu + ". " + nom);
                nuevo.setActionCommand(codu + "." + nom); 
                nuevo.addActionListener(this);
                this.Botones.add(nuevo);
                this.JPanelUnidades.add(nuevo);                                
            }
        }
        this.JPanelUnidades.updateUI();
    }
    
    public void actionPerformed(ActionEvent e) {
               
        String[] uni = e.getActionCommand().toString().split(Pattern.quote("."));
        
        
        Compartidas.codigo_unidad = uni[0];
        Compartidas.nom_unidad = uni[1];
        
        InteraccionTemas it = new InteraccionTemas();
        it.setLocationRelativeTo(null);
        it.setVisible(true);
        this.dispose();
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
            java.util.logging.Logger.getLogger(General.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(General.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(General.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(General.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new General().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanelUnidades;
    private javax.swing.JScrollPane ScrollUnidades;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    // End of variables declaration//GEN-END:variables
}
