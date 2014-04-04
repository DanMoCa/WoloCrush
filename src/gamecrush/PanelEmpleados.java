/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gamecrush;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DanDesktop
 */
public class PanelEmpleados extends javax.swing.JPanel {

    /**
     * Creates new form PanelEmpleados
     */
    
    public void clearTxtFields(){
        this.jTxtFldNombre.setText("");
        this.jTxtFldApellidoM.setText("");
        this.jTxtFldApellidoP.setText("");
        this.jTxtFldPuesto.setText("");
        this.jTxtFldTelefono.setText("");
    }
    ResultSet emp;
    Statement st;
    String idemp,nombre,apellido_p,apellido_m,telefono,idpuesto;
    Validacion val = new Validacion();
    
    public PanelEmpleados() {
        
        
        initComponents();
        cargarEmpleados();
        System.out.println(jTblEmpleados.getRowCount());
        val.validateIdPuesto(this.jTxtFldPuesto);
        this.jTxtFldPuesto.setDocument(new jTxtFldLimit(1));
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    public void cargarEmpleados(){
        try {
            
            Connection conn = Conexion.GetConnection();
            try {
                st = conn.createStatement();
                emp = st.executeQuery("SELECT * FROM Empleados");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, e.getErrorCode() + ": " + e.getMessage());
            }
            
            String [] columns ={"idEmpleado","nombre","apellido_p","apellido_m","telefono","idPuesto"} ;
            
            DefaultTableModel tm = new DefaultTableModel(null,columns);
            
            while(emp.next()){
                String [] row = {emp.getString(1),emp.getString(2),emp.getString(3),emp.getString(4),emp.getString(5),emp.getString(6)};
                tm.addRow(row);
            }
            
            jTblEmpleados.setModel(tm);
        } catch (SQLException e) {
            Logger.getLogger(GameCrush.class.getName()).log(Level.SEVERE,null,e);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTxtFldNombre = new javax.swing.JTextField();
        jTxtFldApellidoP = new javax.swing.JTextField();
        jTxtFldApellidoM = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTxtFldTelefono = new javax.swing.JTextField();
        jTxtFldPuesto = new javax.swing.JTextField();
        jBtnInsert = new javax.swing.JButton();
        jBtnDelete = new javax.swing.JButton();
        jBtnUpdate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblEmpleados = new javax.swing.JTable();

        jLabel1.setText("Nombre");

        jLabel2.setText("Apellido Paterno");

        jLabel3.setText("Apellido Materno");

        jLabel4.setText("Telefono");

        jLabel5.setText("Puesto");

        jBtnInsert.setText("Insert");
        jBtnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnInsertActionPerformed(evt);
            }
        });

        jBtnDelete.setText("Delete");
        jBtnDelete.setEnabled(false);
        jBtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDeleteActionPerformed(evt);
            }
        });

        jBtnUpdate.setText("Update");
        jBtnUpdate.setEnabled(false);
        jBtnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnUpdateActionPerformed(evt);
            }
        });

        jTblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTblEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTblEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTblEmpleados);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTxtFldNombre)
                            .addComponent(jTxtFldApellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jTxtFldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtFldApellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtFldPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnInsert)
                    .addComponent(jBtnDelete)
                    .addComponent(jBtnUpdate))
                .addContainerGap(118, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTxtFldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTxtFldApellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTxtFldApellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTxtFldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtnInsert)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnUpdate)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtFldPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(12, 12, 12))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnInsertActionPerformed
        // TODO add your handling code here:
        try {
            Connection conn = Conexion.GetConnection();
            nombre      = jTxtFldNombre.getText();
            apellido_p  = jTxtFldApellidoP.getText();
            apellido_m  = jTxtFldApellidoM.getText();
            telefono    = jTxtFldTelefono.getText();
            idpuesto    = jTxtFldPuesto.getText();
            
            st = conn.createStatement();
            st.execute("INSERT INTO gamecrush.empleados(nombre,apellido_p,apellido_m,telefono,puesto_idpuesto) VALUES('"+nombre+"','"+apellido_p+"','"+apellido_m+"','"+telefono+"','"+idpuesto+"');");
            cargarEmpleados();
            clearTxtFields();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getErrorCode() +": "+e.getMessage());
        }
    }//GEN-LAST:event_jBtnInsertActionPerformed

    private void jBtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDeleteActionPerformed
        // TODO add your handling code here:
        try {
            Connection conn = Conexion.GetConnection();
            st = conn.createStatement();
            
            st.execute("DELETE FROM gamecrush.empleados WHERE idEmpleados = '"+(String)jTblEmpleados.getValueAt(jTblEmpleados.getSelectedRow(), 0)+"';");
            cargarEmpleados();
            clearTxtFields();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getErrorCode()+": "+e.getMessage());
        }
        
        jBtnDelete.setEnabled(false);
    }//GEN-LAST:event_jBtnDeleteActionPerformed

    private void jTblEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblEmpleadosMouseClicked
        // TODO add your handling code here:
        jBtnDelete.setEnabled(true);
        jBtnUpdate.setEnabled(true);
        
        this.jTxtFldNombre.setText(     (String)this.jTblEmpleados.getValueAt(jTblEmpleados.getSelectedRow(), 1));
        this.jTxtFldApellidoP.setText(  (String)this.jTblEmpleados.getValueAt(jTblEmpleados.getSelectedRow(), 2));
        this.jTxtFldApellidoM.setText(  (String)this.jTblEmpleados.getValueAt(jTblEmpleados.getSelectedRow(), 3));
        this.jTxtFldTelefono.setText(   (String)this.jTblEmpleados.getValueAt(jTblEmpleados.getSelectedRow(), 4));
        this.jTxtFldPuesto.setText(     (String)this.jTblEmpleados.getValueAt(jTblEmpleados.getSelectedRow(), 5));
    }//GEN-LAST:event_jTblEmpleadosMouseClicked

    private void jBtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnUpdateActionPerformed
        // TODO add your handling code here:|
        try {
            String sql ="UPDATE empleados "
                    + "SET nombre = ?, "
                    + "apellido_p = ?, "
                    + "apellido_m = ?, "
                    + "telefono = ?, "
                    + "Puesto_idPuesto = ? "
                    + "WHERE idEmpleados = ? ";
            Connection conn = Conexion.GetConnection();
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql);
            
            
            st = conn.createStatement();
            this.nombre = jTxtFldNombre.getText();
            this.apellido_p = jTxtFldApellidoP.getText();
            this.apellido_m = jTxtFldApellidoM.getText();
            this.telefono = jTxtFldTelefono.getText();
            this.idpuesto = jTxtFldPuesto.getText();
            String idemp = (String)jTblEmpleados.getValueAt(jTblEmpleados.getSelectedRow(), 0);
            ps.setString(1, nombre);
            ps.setString(2, apellido_p);
            ps.setString(3, apellido_m);
            ps.setString(4, telefono);
            ps.setString(5, idpuesto);
            ps.setString(6, idemp);
            
            ps.executeUpdate();
            conn.commit();
            
            cargarEmpleados();
            clearTxtFields();
            this.jBtnUpdate.setEnabled(false);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getErrorCode()+": "+e.getMessage());
        }
    }//GEN-LAST:event_jBtnUpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnDelete;
    private javax.swing.JButton jBtnInsert;
    private javax.swing.JButton jBtnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTblEmpleados;
    private javax.swing.JTextField jTxtFldApellidoM;
    private javax.swing.JTextField jTxtFldApellidoP;
    private javax.swing.JTextField jTxtFldNombre;
    private javax.swing.JTextField jTxtFldPuesto;
    private javax.swing.JTextField jTxtFldTelefono;
    // End of variables declaration//GEN-END:variables
}
