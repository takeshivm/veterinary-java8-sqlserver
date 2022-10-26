/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veterinaria;

import dao.DAOHistorialClinico;
import dao.DAOPaciente;
import dao.DAOVacuna;
import entidades.HistorialClinico;
import entidades.Vacuna;
import java.io.File;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Goku
 */
public class JFVacunas extends javax.swing.JFrame {

    private DefaultTableModel modelo = new DefaultTableModel();
    private List<HistorialClinico> historias;
    private List<Vacuna> vacunas;
    private Vacuna actual;
    
    public JFVacunas() {
        this.insertarColumnas();
        initComponents();
        this.activarControles(false);
        this.setLocationRelativeTo(null);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panVacuna = new javax.swing.JPanel();
        lblPaciente = new javax.swing.JLabel();
        cboPaciente = new javax.swing.JComboBox<>();
        lblProducto = new javax.swing.JLabel();
        txtProducto = new javax.swing.JTextField();
        lblTipoVacuna = new javax.swing.JLabel();
        txtTipoVacuna = new javax.swing.JTextField();
        lblFecha = new javax.swing.JLabel();
        lblRefuerzo = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        dchFecha = new com.toedter.calendar.JDateChooser();
        dchRefuerzo = new com.toedter.calendar.JDateChooser();
        chkEstado = new javax.swing.JCheckBox();
        panListado = new javax.swing.JPanel();
        btnListar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListado = new javax.swing.JTable();
        btnModificar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuExportarVacunas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panVacuna.setBackground(new java.awt.Color(0, 132, 141));

        lblPaciente.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblPaciente.setForeground(new java.awt.Color(255, 255, 255));
        lblPaciente.setText("Paciente");

        cboPaciente.setModel(cargarPacientes());

        lblProducto.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblProducto.setForeground(new java.awt.Color(255, 255, 255));
        lblProducto.setText("Producto");

        lblTipoVacuna.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblTipoVacuna.setForeground(new java.awt.Color(255, 255, 255));
        lblTipoVacuna.setText("Tipo de Vacuna");

        lblFecha.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(255, 255, 255));
        lblFecha.setText("Fecha");

        lblRefuerzo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblRefuerzo.setForeground(new java.awt.Color(255, 255, 255));
        lblRefuerzo.setText("Refuerzo");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        dchFecha.setDateFormatString("dd-MM-yyyy");

        dchRefuerzo.setDateFormatString("dd-MM-yyyy");

        chkEstado.setText("Estado");

        javax.swing.GroupLayout panVacunaLayout = new javax.swing.GroupLayout(panVacuna);
        panVacuna.setLayout(panVacunaLayout);
        panVacunaLayout.setHorizontalGroup(
            panVacunaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panVacunaLayout.createSequentialGroup()
                .addGroup(panVacunaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panVacunaLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAceptar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar))
                    .addGroup(panVacunaLayout.createSequentialGroup()
                        .addGroup(panVacunaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panVacunaLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panVacunaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panVacunaLayout.createSequentialGroup()
                                        .addComponent(lblPaciente)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cboPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panVacunaLayout.createSequentialGroup()
                                        .addGroup(panVacunaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblTipoVacuna)
                                            .addComponent(lblProducto)
                                            .addComponent(lblRefuerzo)
                                            .addComponent(lblFecha))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(panVacunaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtProducto)
                                            .addComponent(txtTipoVacuna, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                                            .addComponent(dchFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(dchRefuerzo, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(panVacunaLayout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(chkEstado)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panVacunaLayout.setVerticalGroup(
            panVacunaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panVacunaLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panVacunaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panVacunaLayout.createSequentialGroup()
                        .addGroup(panVacunaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPaciente)
                            .addComponent(cboPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panVacunaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblProducto)
                            .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panVacunaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTipoVacuna)
                            .addComponent(txtTipoVacuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lblFecha))
                    .addComponent(dchFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panVacunaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblRefuerzo)
                    .addComponent(dchRefuerzo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(chkEstado)
                .addGap(28, 28, 28)
                .addGroup(panVacunaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAceptar))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        getContentPane().add(panVacuna, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 106, -1, 370));

        panListado.setBackground(new java.awt.Color(0, 153, 153));

        btnListar.setText("Listar");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        tblListado.setModel(this.modelo);
        jScrollPane1.setViewportView(tblListado);

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panListadoLayout = new javax.swing.GroupLayout(panListado);
        panListado.setLayout(panListadoLayout);
        panListadoLayout.setHorizontalGroup(
            panListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panListadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
                    .addGroup(panListadoLayout.createSequentialGroup()
                        .addGroup(panListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panListadoLayout.createSequentialGroup()
                                .addComponent(btnNuevo)
                                .addGap(18, 18, 18)
                                .addComponent(btnModificar))
                            .addComponent(btnListar))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panListadoLayout.setVerticalGroup(
            panListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panListadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnListar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar)
                    .addComponent(btnNuevo))
                .addGap(118, 118, 118))
        );

        getContentPane().add(panListado, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, 106, -1, 370));

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 483, -1, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/img/VACUNA.png"))); // NOI18N
        jLabel1.setText("VACUNAS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 160, 60));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/img/FONDOTOTAL.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 540));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/img/FONDO.png"))); // NOI18N
        jLabel3.setText("jLabel2");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 380));

        jMenu1.setText("Archivo");

        mnuExportarVacunas.setText("Exportar reporte");
        mnuExportarVacunas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuExportarVacunasActionPerformed(evt);
            }
        });
        jMenu1.add(mnuExportarVacunas);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        this.actual = null;
        this.activarControles(true);
        this.limpiarControles();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.activarControles(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        DAOVacuna dao;
        Vacuna vac;
        
        if (this.validarDatos() == true) {
            vac = new Vacuna();
            
            vac.setProducto(this.txtProducto.getText());
            vac.setTipoVacuna(this.txtTipoVacuna.getText());
            vac.setFecha(this.dchFecha.getDate());
            vac.setRefuerzo(this.dchRefuerzo.getDate());
            vac.setHistoria(this.historias.get
                    (this.cboPaciente.getSelectedIndex()));
            vac.setEstado(this.chkEstado.isSelected());
            
            dao = new DAOVacuna();
            try {
                if (this.actual == null) {
                    dao.registrar(vac);
                }else{
                    vac.setCodigo(this.actual.getCodigo());
                    dao.actualizar(vac);
                }
                this.activarControles(false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }finally{
                vac = null;
                dao = null;
            }
        }else{
            JOptionPane.showMessageDialog(this, "Ingrese datos en todos los campos");
        }
        
    }//GEN-LAST:event_btnAceptarActionPerformed

    private boolean validarDatos(){
        boolean validar = true;
        
        if (this.txtProducto.getText().length() == 0) {
            validar = false;
        }
        if (this.txtTipoVacuna.getText().length() == 0) {
            validar = false;
        }
        if (this.dchRefuerzo.getDate() == null) {
            validar = false;
        }
        return validar;
    }
    
    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        DAOVacuna dao = new DAOVacuna();
        try {
            this.vacunas = dao.listar();
            this.llenarTabla();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }finally{
            dao = null;
        }
        
    }//GEN-LAST:event_btnListarActionPerformed

    private void llenarTabla(){
        this.modelo.setRowCount(0);
        for (Vacuna vacuna : this.vacunas) {
            this.modelo.addRow(new Object[]{
                vacuna.getNobrePaciente(),
                vacuna.getProducto(),
                vacuna.getNombreFecha(),
                vacuna.getNombreRefuerzo(),
                (vacuna.isEstado()==true?"Valido":"Nulo"),
            });
        }
    }
    
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int pos = this.tblListado.getSelectedRow();
        
        if (pos > -1) {
            this.actual = this.vacunas.get(pos);
            this.mostrarDatos();
            this.cboPaciente.setEnabled(false);
        }else{
            JOptionPane.showMessageDialog(this, "Debe seleccionar un paciente");
            this.tblListado.requestFocusInWindow();
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void impresion(){
        //String imagen = "excel\\tablaimporte.xls";
        String archivo = JOptionPane.showInputDialog("Escriba el nombre del Archivo");
        String Ruta = System.getProperty("user.dir") + "\\excel\\" + archivo + ".xls";
        File file = new File(Ruta);
        ExportarExcel excel = new ExportarExcel(tblListado,file,"tablaimporte");
        excel.export();
    }
    
    private void mnuExportarVacunasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuExportarVacunasActionPerformed
        this.impresion();
    }//GEN-LAST:event_mnuExportarVacunasActionPerformed

    private ComboBoxModel cargarPacientes(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        DAOHistorialClinico dao = new DAOHistorialClinico();
        try {
            this.historias = dao.listar("");
            this.llenarComboPacientes(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }finally{
            dao = null;
        }
            return modelo;
        }
    
    private void llenarComboPacientes(DefaultComboBoxModel modelo){
        for (HistorialClinico historia : historias) {
            modelo.addElement(historia.getPaciente().getNombre());
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
            java.util.logging.Logger.getLogger(JFVacunas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFVacunas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFVacunas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFVacunas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFVacunas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cboPaciente;
    private javax.swing.JCheckBox chkEstado;
    private com.toedter.calendar.JDateChooser dchFecha;
    private com.toedter.calendar.JDateChooser dchRefuerzo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblPaciente;
    private javax.swing.JLabel lblProducto;
    private javax.swing.JLabel lblRefuerzo;
    private javax.swing.JLabel lblTipoVacuna;
    private javax.swing.JMenuItem mnuExportarVacunas;
    private javax.swing.JPanel panListado;
    private javax.swing.JPanel panVacuna;
    private javax.swing.JTable tblListado;
    private javax.swing.JTextField txtProducto;
    private javax.swing.JTextField txtTipoVacuna;
    // End of variables declaration//GEN-END:variables

    private void mostrarDatos(){
        DAOVacuna dao = new DAOVacuna();
        try {
            this.actual = dao.leer(this.actual);
            if (this.actual != null) {
                this.cboPaciente.setSelectedIndex(
                        this.buscarHistorias(this.actual.getHistoria()));
                this.txtProducto.setText(this.actual.getProducto());
                this.txtTipoVacuna.setText(this.actual.getTipoVacuna());
                this.dchFecha.setDate(this.actual.getFecha());
                this.dchRefuerzo.setDate(this.actual.getRefuerzo());
                this.chkEstado.setSelected(this.actual.isEstado());
               
                this.activarControles(true);
            }else{
                JOptionPane.showMessageDialog(this, "No se encontro...\n "
                        + "Intentelo otra vez");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }finally{
            dao = null;
        }
    }
    
    private int buscarHistorias(HistorialClinico buscado){
        int i = 0;
        for (HistorialClinico his : this.historias) {
            if (his.getCodigo() == buscado.getCodigo()) {
                return i;
            }
            i++;
        }
        
        return -1;
    }
    
    private void insertarColumnas() {
        
        this.modelo.addColumn("Paciente");
        this.modelo.addColumn("Producto");
        this.modelo.addColumn("Fecha");
        this.modelo.addColumn("Refuerzo");
        this.modelo.addColumn("Estado");
    }
    
    private void activarControles(boolean estado) {
        
        this.panVacuna.setEnabled(estado);
        this.lblPaciente.setEnabled(estado);
        this.cboPaciente.setEnabled(estado);
        this.lblProducto.setEnabled(estado);
        this.txtProducto.setEnabled(estado);
        this.lblTipoVacuna.setEnabled(estado);
        this.txtTipoVacuna.setEnabled(estado);
        this.lblFecha.setEnabled(estado);
        this.dchFecha.setEnabled(estado);
        this.lblRefuerzo.setEnabled(estado);
        this.dchRefuerzo.setEnabled(estado);
        this.btnAceptar.setEnabled(estado);
        this.btnCancelar.setEnabled(estado);
        this.chkEstado.setEnabled(estado);
        
        this.panListado.setEnabled(!estado);
        this.btnListar.setEnabled(!estado);
        this.tblListado.setEnabled(!estado);
        this.btnNuevo.setEnabled(!estado);
        this.btnModificar.setEnabled(!estado);
        this.btnCerrar.setEnabled(!estado);
        
        if (estado == true) {
            this.cboPaciente.requestFocusInWindow();
        }else{
            this.btnListar.requestFocusInWindow();
        }
    }

    private void limpiarControles() {
        
        this.cboPaciente.setSelectedIndex(-1);
        this.txtProducto.setText("");
        this.txtTipoVacuna.setText("");
        this.dchFecha.setDate(Date.valueOf(LocalDate.now()));
        this.dchRefuerzo.setDate(Date.valueOf(LocalDate.now()));
    }

    private void eliminarDelVector(int pos) {

    }
}
