/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package completo.semana13.vista;

import completo.semana13.controller.EstudianteController;
import completo.semana13.model.Estudiante;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author mrperez
 */
public class JfrmEstudiante extends javax.swing.JFrame {

    /**
     * Creates new form JfrmEstudiante
     */
    DefaultTableModel modeloDatos = new DefaultTableModel();
    public EstudianteController estudianteController;
    public Estudiante selectEstudiante;
    public JfrmEstudiante() {
        initComponents();
        setLocationRelativeTo(null);
        estudianteController = new EstudianteController();
        selectEstudiante= new Estudiante();
        crearDataModel();
        listarDatos();
    }



public void crearDataModel() {
        //crear columnas de la tabla

        ArrayList<Object> columnas = new ArrayList<>();
        columnas.add("id");
        columnas.add("Nombre");
        columnas.add("Apellido");
        columnas.add("Direccion");
        columnas.add("Telefono");

        for (Object tmp : columnas) {
            modeloDatos.addColumn(tmp);
        }

        jTableListaEstudiante.setModel(modeloDatos);
    }

public void limpiarDatamodel() {
        DefaultTableModel modelo = (DefaultTableModel) jTableListaEstudiante.getModel();

        while (modelo.getRowCount() > 0) {
            for (int i = 0; i < modelo.getRowCount(); i++) {
                modelo.removeRow(i);
            }
        }

    }

public void listarDatos() {
        //agregar registros
        ArrayList<Estudiante> list = null;
        limpiarDatamodel();
        list = (ArrayList<Estudiante>) estudianteController.getListEstudiante();
        Object[] fila = new Object[jTableListaEstudiante.getColumnCount()];
        for (int i = 0; i < list.size(); i++) {
            fila[0] = list.get(i).getId();
            fila[1] = list.get(i).getNombre();
            fila[2] = list.get(i).getApellido();
            fila[3] = list.get(i).getDireccion();
            fila[4] = list.get(i).getTelefono();
            modeloDatos.addRow(fila);
        }
    }


public void listarDatosapellido() {
        //agregar registros
        ArrayList<Estudiante> list = null;
        limpiarDatamodel();
        list = (ArrayList<Estudiante>) estudianteController.getListEstudianteapellido();
        Object[] fila = new Object[jTableListaEstudiante.getColumnCount()];
        for (int i = 0; i < list.size(); i++) {
            fila[0] = list.get(i).getId();
            fila[1] = list.get(i).getNombre();
            fila[2] = list.get(i).getApellido();
            fila[3] = list.get(i).getDireccion();
            fila[4] = list.get(i).getTelefono();
            modeloDatos.addRow(fila);
        }

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txbusqueda = new javax.swing.JTextField();
        Buscar = new javax.swing.JButton();
        Actualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListaEstudiante = new javax.swing.JTable();
        jLfiltrona = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CRUD JAVA & POSTGRESS - REGISTRAR,MODIFICAR Y BUSCAR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setText("Nuevo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Eliminar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txbusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txbusquedaActionPerformed(evt);
            }
        });

        Buscar.setText("Buscar");
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });

        Actualizar.setText("Actualizar");
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });

        jTableListaEstudiante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "Direccion", "Telefono"
            }
        ));
        jTableListaEstudiante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableListaEstudianteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableListaEstudiante);

        jLfiltrona.setText("Filtro por Nombre o Apellido");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(Actualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Buscar))
                    .addComponent(jLfiltrona, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLfiltrona)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(txbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Buscar)
                    .addComponent(Actualizar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JfrmDialogoEstudiante nuevo = new JfrmDialogoEstudiante(this, true);
        nuevo.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        estudianteController.eliminarUsuario(selectEstudiante); // TODO add your handling code here:
        listarDatos();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTableListaEstudianteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListaEstudianteMouseClicked
       
        int selectedRowIndex = jTableListaEstudiante.getSelectedRow();
        TableModel model = jTableListaEstudiante.getModel();
        selectEstudiante.setId(Integer.parseInt(model.getValueAt(selectedRowIndex, 0).toString()));
        selectEstudiante.setNombre(model.getValueAt(selectedRowIndex, 1).toString());
        selectEstudiante.setApellido(model.getValueAt(selectedRowIndex, 2).toString());
        selectEstudiante.setDireccion(model.getValueAt(selectedRowIndex, 3).toString());
        selectEstudiante.setTelefono(model.getValueAt(selectedRowIndex, 4).toString());
    
    }//GEN-LAST:event_jTableListaEstudianteMouseClicked
    
    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
        
        int data = 0;
        JfrmDialogoEstudianteActualizar nuevo = new JfrmDialogoEstudianteActualizar(this,true);
        data =  selectEstudiante.getId();
        if(data >= 1){
        nuevo.setVisible(true);
        }else{
         JOptionPane.showMessageDialog(null,"Estudiante no selecionado");
    }//GEN-LAST:event_ActualizarActionPerformed
}   
    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed

           DefaultTableModel model = (DefaultTableModel) jTableListaEstudiante.getModel();
           model.setRowCount(0);
           listarDatosapellido();
  
          
         
      
    }//GEN-LAST:event_BuscarActionPerformed

    private void txbusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txbusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txbusquedaActionPerformed

    
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
            java.util.logging.Logger.getLogger(JfrmEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JfrmEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JfrmEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JfrmEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JfrmEstudiante().setVisible(true);
            }
        });
    }
    
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton Actualizar;
    public static javax.swing.JButton Buscar;
    public static javax.swing.JButton jButton1;
    public static javax.swing.JButton jButton2;
    public static javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLfiltrona;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel2;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTableListaEstudiante;
    public static javax.swing.JTextField txbusqueda;
    // End of variables declaration//GEN-END:variables
}
