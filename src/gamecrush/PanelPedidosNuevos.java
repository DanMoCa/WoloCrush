/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamecrush;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DanDesktop
 */
public class PanelPedidosNuevos extends javax.swing.JPanel {

    /**
     * Creates new form PanelPedidosNuevos
     */
    public PanelPedidosNuevos() {
        initComponents();
        cargarProductos();
        cargarClienteS();
        jTablePedido.setModel(tmped);
    }

    public ResultSet cli, pro, ped, lastId, pedhas;
    public int Cant;
    boolean flagcli = false;

    public String[] columnsPed = {"id", "Producto", "Cantidad", "Precio"};
    public DefaultTableModel tmped = new DefaultTableModel(null, columnsPed) {
        @Override
        public boolean isCellEditable(int rowIndex, int colIndex) {
            return false;
        }
    };

    String columnsProd[] = {"idProducto", "Nombre", "Tipo", "Precio", "Proveedor", "Cantidad"};
    public DefaultTableModel tmprod = new DefaultTableModel(null, columnsProd) {
        @Override
        public boolean isCellEditable(int rowIndex, int colIndex) {
            return false;
        }
    };

    String[] columnsCli = {"idCliente", "Nombre", "Apellido Paterno", "Apellido Materno", "Telefono", "E-Mail"};

    DefaultTableModel tmcli = new DefaultTableModel(null, columnsCli) {
        @Override
        public boolean isCellEditable(int rowIndex, int colIndex) {
            return false;
        }
    };

    public void cargarProductos() {
        try {
            String sql = "SELECT * FROM productos";
            Connection conn = Conexion.GetConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            pro = ps.executeQuery();

            while (pro.next()) {
                String[] row = {pro.getString(1), pro.getString(2), pro.getString(3), pro.getString(4), pro.getString(5), pro.getString(6)};
                tmprod.addRow(row);
            }
            jTableProductos.setModel(tmprod);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getErrorCode() + ": " + e.getMessage());
        }
    }

    public void cargarClienteS() {
        try {
            String sql = "SELECT * FROM clientes";
            Connection conn = Conexion.GetConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            cli = ps.executeQuery();

            while (cli.next()) {
                String[] row = {cli.getString(1), cli.getString(2), cli.getString(3), cli.getString(4), cli.getString(5), cli.getString(6)};
                tmcli.addRow(row);
            }
            jTableClientes.setModel(tmcli);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getErrorCode() + ":" + e.getMessage());
        }
    }

    public void cancelPedido() {
        for (int row = tmprod.getRowCount() - 1; row >= 0; row--) {
            tmprod.removeRow(row);
        }
        jLblPrecio.setText(null);
        for (int row = tmcli.getRowCount() - 1; row >= 0; row--) {
            tmcli.removeRow(row);
        }
        cargarProductos();
        cargarClienteS();
        jLblPrecio.setText(null);
        for (int row = tmped.getRowCount() - 1; row >= 0; row--) {
            tmped.removeRow(row);
        }
        jBtnAceptar.setEnabled(false);
        jBtnCancel.setEnabled(false);
        flagcli = false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProductos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePedido = new javax.swing.JTable();
        jBtnCancel = new javax.swing.JButton();
        jBtnAceptar = new javax.swing.JButton();
        jTxtFldFindCliente = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableClientes = new javax.swing.JTable();
        jLblPrecio = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTxtFldDescuento = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jBtnDesc = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jTableProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableProductos);

        jTablePedido.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTablePedido);

        jBtnCancel.setText("Cancelar Pedido");
        jBtnCancel.setEnabled(false);
        jBtnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelActionPerformed(evt);
            }
        });

        jBtnAceptar.setText("Realizar Pedido");
        jBtnAceptar.setEnabled(false);
        jBtnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAceptarActionPerformed(evt);
            }
        });

        jTxtFldFindCliente.setText("Buscar Cliente por email");
        jTxtFldFindCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTxtFldFindClienteMouseClicked(evt);
            }
        });
        jTxtFldFindCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtFldFindClienteKeyTyped(evt);
            }
        });

        jTableClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableClientesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableClientes);

        jLabel2.setText("Precio Total:");

        jLabel1.setText("Descuento");

        jBtnDesc.setText("Aplicar");
        jBtnDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDescActionPerformed(evt);
            }
        });

        jLabel3.setText("%");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane1))
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTxtFldFindCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtFldDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnDesc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnAceptar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTxtFldFindCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtnCancel)
                        .addComponent(jBtnAceptar))
                    .addComponent(jLblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(jTxtFldDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBtnDesc)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtFldFindClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtFldFindClienteKeyTyped
        // TODO add your handling code here:
        try {
            String sql = "SELECT * FROM clientes WHERE email LIKE ? ";
            Connection conn = Conexion.GetConnection();
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareCall(sql);

            ps.setString(1, "%" + this.jTxtFldFindCliente.getText() + "%");

            cli = ps.executeQuery();

            while (cli.next()) {
                String[] row = {cli.getString(1), cli.getString(2), cli.getString(3), cli.getString(4), cli.getString(5), cli.getString(6)};
                tmcli.addRow(row);
            }
            jTableClientes.setModel(tmcli);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getErrorCode() + ": " + e.getMessage());
        }
    }//GEN-LAST:event_jTxtFldFindClienteKeyTyped

    private void jTxtFldFindClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTxtFldFindClienteMouseClicked
        // TODO add your handling code here:
        jTxtFldFindCliente.setText("");
    }//GEN-LAST:event_jTxtFldFindClienteMouseClicked

    private void jTableProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProductosMouseClicked
        // TODO add your handling code here:
        try {
            Cant = Integer.parseInt(JOptionPane.showInputDialog("Cantidad"));
            String idProd, nombreProd, newcant;
            int rows, index = 0;
            Double precio, total = 0.0;
            boolean flag = false;

            rows = jTablePedido.getRowCount();

            String compare = (String) tmprod.getValueAt(jTableProductos.getSelectedRow(), 0);
            String compare2 = "";

            int i = 1;
            if (rows == 0) {
                idProd = (String) tmprod.getValueAt(jTableProductos.getSelectedRow(), 0);
                nombreProd = (String) tmprod.getValueAt(jTableProductos.getSelectedRow(), 1);
                precio = (Double.parseDouble((String) tmprod.getValueAt(jTableProductos.getSelectedRow(), 3))) * Cant;
                tmped.addRow(new Object[]{idProd, nombreProd, Cant, precio});
            } else {
                int x = 0;
                z:
                while (i <= rows) {
                    try {
                        compare2 = (String) tmped.getValueAt(x, 0);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    System.out.println(compare + " " + compare2);

                    if (compare.equals(compare2)) {
                        flag = true;
                        index = i;
                        break z;
                    } else {
                        flag = false;
                    }
                    ++i;
                    ++x;
                    ++index;
                }
                System.out.println(i);

                if (flag) {
                    if (index - 1 < rows) {
                        index--;
                        flag = false;
                        System.out.println("test " + index);
                        int updatecant = (int) tmped.getValueAt(index, 2) + Cant;
                        precio = (Double.parseDouble((String) tmprod.getValueAt(jTableProductos.getSelectedRow(), 3))) * updatecant;
                        tmped.setValueAt(updatecant, index, 2);
                        tmped.setValueAt(precio, index, 3);
                        System.out.println("test " + index);
                    }
                } else {
                    idProd = (String) tmprod.getValueAt(jTableProductos.getSelectedRow(), 0);
                    nombreProd = (String) tmprod.getValueAt(jTableProductos.getSelectedRow(), 1);
                    precio = (Double.parseDouble((String) tmprod.getValueAt(jTableProductos.getSelectedRow(), 3))) * Cant;
                    tmped.addRow(new Object[]{idProd, nombreProd, Cant, precio});
                }
            }

            int rows2 = jTablePedido.getRowCount();
            for (int j = 0; j < rows2; j++) {
                total += (Double.parseDouble(tmped.getValueAt(j, 3).toString()));
            }

            newcant = Integer.toString(Integer.parseInt((String) tmprod.getValueAt(jTableProductos.getSelectedRow(), 5)) - Cant);

            tmprod.setValueAt(newcant, jTableProductos.getSelectedRow(), 5);
            jLblPrecio.setText(total.toString());

            jBtnAceptar.setEnabled(true);
            jBtnCancel.setEnabled(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }

    }//GEN-LAST:event_jTableProductosMouseClicked

    private void jBtnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelActionPerformed
        // TODO add your handling code here:
        cancelPedido();
    }//GEN-LAST:event_jBtnCancelActionPerformed

    private void jBtnDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDescActionPerformed
        // TODO add your handling code here:
        Double total = 0.0;
        int rows2 = jTablePedido.getRowCount();
        for (int j = 0; j < rows2; j++) {
            total += (Double.parseDouble(tmped.getValueAt(j, 3).toString()));
        }
        jLblPrecio.setText(total.toString());

        Double descuento = Double.parseDouble(jTxtFldDescuento.getText());
        Double precio = Double.parseDouble(jLblPrecio.getText());
        Double porciento = (1 - (descuento / 100)) * (precio);

        jLblPrecio.setText(porciento.toString());
    }//GEN-LAST:event_jBtnDescActionPerformed

    private void jBtnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAceptarActionPerformed
        // TODO add your handling code here:

        try {

            if (flagcli) {

                //Le Codigo
                Connection connPed = Conexion.GetConnection();
                connPed.setAutoCommit(false);
                Connection connProd = Conexion.GetConnection();
                connProd.setAutoCommit(false);
                Connection connPedHas = Conexion.GetConnection();
                connPedHas.setAutoCommit(false);
                Connection connUpdate = Conexion.GetConnection();
                connUpdate.setAutoCommit(false);

                String empleado = JOptionPane.showInputDialog("Confirmar");

                String sqlEmpVerif = "SELECT idempleados FROM empleados WHERE idempleados = ?";

                String sqlUpdateProd = "UPDATE productos "
                        + "SET cantidad = cantidad - ? "
                        + "WHERE idproductos = ? ";

                String sqlNewPedido = "INSERT INTO pedidos(precio_total,clientes_idclientes,empleados_idempleados) "
                        + "VALUES( ?, ?, ?)";

                String sqlPedHas = "INSERT INTO productos_has_pedidos(productos_idProductos, pedidos_idpedidos, cantidad_pedido) "
                        + "VALUES(?, ?, ?)";

                //Verifica si existe el empleado
                PreparedStatement psConf = connPed.prepareStatement(sqlEmpVerif);
                //Actualiza las cantidades de los productos
                PreparedStatement psUpdate = connUpdate.prepareStatement(sqlUpdateProd);
                //Inserta el pedido en tabla pedidos
                PreparedStatement psProd = connProd.prepareStatement(sqlNewPedido);
                //Inserta en la tabla productos_has_pedidos
                PreparedStatement psPedHas = connPedHas.prepareStatement(sqlPedHas);

                psConf.setString(1, empleado);

                ResultSet rs = psConf.executeQuery();

                if (rs.next()) {
                    try {
                        //productos_has_pedidos(productos_idProductos, pedidos_idpedidos,cantidad_pedido)
                        psProd.setString(1, jLblPrecio.getText());
                        psProd.setString(2, (String) tmcli.getValueAt(jTableClientes.getSelectedRow(), 0));
                        psProd.setString(3, empleado);

                        psProd.execute();
                        connProd.commit();

                        String sql = "SELECT `AUTO_INCREMENT` - 1 "
                                + " FROM  INFORMATION_SCHEMA.TABLES "
                                + " WHERE TABLE_SCHEMA = 'gamecrush' "
                                + " AND   TABLE_NAME   = 'pedidos' ";
                        Connection connLast = Conexion.GetConnection();
                        PreparedStatement ps = connLast.prepareStatement(sql);
                        lastId = ps.executeQuery();
                        lastId.next();
                        String lastIdPed = lastId.getString(1);
                        System.out.println(lastIdPed);
                        
                        int rows2 = jTablePedido.getRowCount();
                        for (int j = 0; j < rows2; j++) {
                            psUpdate.setInt(1, (int) tmped.getValueAt(j, 2));
                            psUpdate.setString(2, (String) tmped.getValueAt(j, 0));

                            psUpdate.executeUpdate();
                            connUpdate.commit();

                        }
                        
                        for(int j = 0; j < rows2; j++){
                            psPedHas.setString(1, (String) tmped.getValueAt(j, 0));
                            psPedHas.setString(2, lastIdPed);
                            psPedHas.setInt(3, (int) tmped.getValueAt(j, 2));
                            
                            psPedHas.execute();
                            connPedHas.commit();
                        }
                        cancelPedido();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(this, e.getErrorCode() + ": " + e.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Empleado no encontrado");
                }

            } else {
                JOptionPane.showMessageDialog(this, "Por favor seleccione un cliente.");
            }
        } catch (SQLException | HeadlessException e) {
            System.out.println(e.getMessage());
        }
        

    }//GEN-LAST:event_jBtnAceptarActionPerformed

    private void jTableClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableClientesMouseClicked
        // TODO add your handling code here:
        flagcli = true;
    }//GEN-LAST:event_jTableClientesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAceptar;
    private javax.swing.JButton jBtnCancel;
    private javax.swing.JButton jBtnDesc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLblPrecio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableClientes;
    private javax.swing.JTable jTablePedido;
    private javax.swing.JTable jTableProductos;
    private javax.swing.JTextField jTxtFldDescuento;
    private javax.swing.JTextField jTxtFldFindCliente;
    // End of variables declaration//GEN-END:variables
}
