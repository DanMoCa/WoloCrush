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
public class PanelClientes extends javax.swing.JPanel {

    /**
     * Creates new form PanelClientes
     */
    
    public void clearTxtFields(){
        this.jTxtFldNombres.setText("");
        this.jTxtFldApellidoM.setText("");
        this.jTxtFldApellidoP.setText("");
        this.jTxtFldEMail.setText("");
        this.jTxtFldTelefono.setText("");
    }
    
    ResultSet cli;
    Statement st;
    String nombre, apellido_p, apellido_m, email, telefono;
    
    public PanelClientes() {
        initComponents();
        cargarClientes();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    public void cargarClientes(){
        try{
            Connection conn = Conexion.GetConnection();
            try {
                st = conn.createStatement();
                cli = st.executeQuery("SELECT * FROM Clientes");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this,e.getErrorCode() + ":" + e.getMessage());
            }
            
            String [] columns ={"idCliente","Nombre","Apellido Paterno","Apellido Materno","Telefono","E-Mail"};
            
            DefaultTableModel tm = new DefaultTableModel(null,columns){
                @Override
                public boolean isCellEditable(int rowIndex, int colIndex){
                    return false;
                }
            };
            
            while(cli.next()){
                String [] row = {cli.getString(1),cli.getString(2),cli.getString(3),cli.getString(4),cli.getString(5),cli.getString(6)};
                tm.addRow(row);
            }
            jTblClientes.setModel(tm);
        }catch(SQLException e){
            Logger.getLogger(GameCrush.class.getName()).log(Level.SEVERE,null,e);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTblClientes = new javax.swing.JTable();
        jBtnInsert = new javax.swing.JButton();
        jBtnDelete = new javax.swing.JButton();
        jBtnUpdate = new javax.swing.JButton();
        jTxtFldApellidoP = new javax.swing.JTextField();
        jTxtFldApellidoM = new javax.swing.JTextField();
        jTxtFldTelefono = new javax.swing.JTextField();
        jTxtFldEMail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTxtFldNombres = new javax.swing.JTextField();

        jTblClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        jTblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTblClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTblClientes);

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

        jLabel1.setText("Nombres");

        jLabel2.setText("Apellido Paterno");

        jLabel3.setText("Apellido Materno");

        jLabel4.setText("Telefono");

        jLabel5.setText("e-mail");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTxtFldEMail)
                            .addComponent(jTxtFldTelefono)
                            .addComponent(jTxtFldApellidoM)
                            .addComponent(jTxtFldApellidoP)
                            .addComponent(jTxtFldNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jBtnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTxtFldNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTxtFldEMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtnInsert)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnUpdate)))
                .addGap(23, 23, 23))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblClientesMouseClicked
        // TODO add your handling code here:
        jBtnDelete.setEnabled(true);
        jBtnUpdate.setEnabled(true);
        
        this.jTxtFldNombres.setText(    (String)this.jTblClientes.getValueAt(jTblClientes.getSelectedRow(),1));
        this.jTxtFldApellidoP.setText(  (String)this.jTblClientes.getValueAt(jTblClientes.getSelectedRow(),2));
        this.jTxtFldApellidoM.setText(  (String)this.jTblClientes.getValueAt(jTblClientes.getSelectedRow(),3));
        this.jTxtFldTelefono.setText(   (String)this.jTblClientes.getValueAt(jTblClientes.getSelectedRow(),4));
        this.jTxtFldEMail.setText(      (String)this.jTblClientes.getValueAt(jTblClientes.getSelectedRow(),5));
    }//GEN-LAST:event_jTblClientesMouseClicked

    private void jBtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnUpdateActionPerformed
        // TODO add your handling code here
        try {
            String sql = "UPDATE clientes "
            + "SET nombres = ?, "
            + "apellido_p = ?, "
            + "apellido_m = ?, "
            + "telefono = ?, "
            + "email = ? "
            + "WHERE idClientes = ?";
            
            Connection conn = Conexion.GetConnection();
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql);

            this.nombre = jTxtFldNombres.getText();
            this.apellido_p = jTxtFldApellidoP.getText();
            this.apellido_m = jTxtFldApellidoM.getText();
            this.email = jTxtFldEMail.getText();
            this.telefono = jTxtFldTelefono.getText();
            String idCliente = (String)jTblClientes.getValueAt(jTblClientes.getSelectedRow(), 0);
            ps.setString(1, nombre);
            ps.setString(2, apellido_p);
            ps.setString(3, apellido_m);
            ps.setString(4, telefono);
            ps.setString(5, email);
            ps.setString(6, idCliente);
            
            ps.executeUpdate();

            conn.commit();
            cargarClientes();
            clearTxtFields();
            this.jBtnUpdate.setEnabled(false);
            this.jBtnDelete.setEnabled(false);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getErrorCode()+": "+e.getMessage());
        }
    }//GEN-LAST:event_jBtnUpdateActionPerformed

    private void jBtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDeleteActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "DELETE FROM gamecrush.clientes WHERE idClientes = '"+(String)jTblClientes.getValueAt(jTblClientes.getSelectedRow(), 0)+"';";
            Connection conn = Conexion.GetConnection();
            st = conn.createStatement();
            st.execute(sql);
            cargarClientes();
            clearTxtFields();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getErrorCode()+": "+e.getMessage());
        }
        jBtnDelete.setEnabled(false);
        jBtnUpdate.setEnabled(false);
    }//GEN-LAST:event_jBtnDeleteActionPerformed

    private void jBtnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnInsertActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "INSERT INTO gamecrush.clientes(nombres, apellido_p, apellido_m, telefono, email) "
            + "VALUES(?, ?, ?, ?, ?)";
            Connection conn = Conexion.GetConnection();
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql);

            nombre      = jTxtFldNombres.getText();
            apellido_p  = jTxtFldApellidoP.getText();
            apellido_m  = jTxtFldApellidoM.getText();
            email       = jTxtFldEMail.getText();
            telefono    = jTxtFldTelefono.getText();

            ps.setString(1, nombre);
            ps.setString(2, apellido_p);
            ps.setString(3, apellido_m);
            ps.setString(4, telefono);
            ps.setString(5, email);

            ps.execute();
            conn.commit();
            cargarClientes();
            clearTxtFields();
            this.jBtnUpdate.setEnabled(false);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getErrorCode()+": "+e.getMessage());
        }
    }//GEN-LAST:event_jBtnInsertActionPerformed


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
    private javax.swing.JTable jTblClientes;
    private javax.swing.JTextField jTxtFldApellidoM;
    private javax.swing.JTextField jTxtFldApellidoP;
    private javax.swing.JTextField jTxtFldEMail;
    private javax.swing.JTextField jTxtFldNombres;
    private javax.swing.JTextField jTxtFldTelefono;
    // End of variables declaration//GEN-END:variables
}
