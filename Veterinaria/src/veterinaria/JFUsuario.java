
package veterinaria;


import dao.DAOUsuario;
import entidades.RegistroUsuario;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Goku
 */
public class JFUsuario extends javax.swing.JFrame {

    private List<RegistroUsuario> usuarios;
    
    public JFUsuario() {
        initComponents();
        this.lblMensajeError.setVisible(false);
        this.setLocationRelativeTo(null);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblMensajeError = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        lblContraseña = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lblLogin = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JButton();
        txtConstraseña = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 153));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMensajeError.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblMensajeError.setForeground(new java.awt.Color(51, 0, 0));
        lblMensajeError.setText("CONTRASEÑA / USUARIO INCONRRECTOS");
        jPanel1.add(lblMensajeError, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

        btnCancelar.setBackground(new java.awt.Color(204, 204, 204));
        btnCancelar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(0, 0, 0));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 189, 56));

        lblContraseña.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblContraseña.setText("CONTRASEÑA");
        jPanel1.add(lblContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        lblUsuario.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblUsuario.setText("USUARIO");
        jPanel1.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, -1, -1));

        txtUsuario.setBackground(new java.awt.Color(204, 255, 102));
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 149, -1));

        lblLogin.setBackground(new java.awt.Color(204, 204, 204));
        lblLogin.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblLogin.setForeground(new java.awt.Color(0, 0, 0));
        lblLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/PNG/Constraseña2.png"))); // NOI18N
        lblLogin.setText("LOGIN");
        lblLogin.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(lblLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 68));

        btnIngresar.setBackground(new java.awt.Color(204, 204, 204));
        btnIngresar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnIngresar.setForeground(new java.awt.Color(0, 0, 0));
        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 192, 56));

        txtConstraseña.setBackground(new java.awt.Color(204, 255, 102));
        jPanel1.add(txtConstraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 150, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean encontrado() throws Exception{
        DAOUsuario dao = new DAOUsuario();
        boolean encontrado = false;
        this.usuarios = dao.listar();
        JFPropietario logeado;
        //String pass = String.valueOf(this.txtConstraseña);
        for (RegistroUsuario usuario : usuarios) {
            if (usuario.getUsuario().equalsIgnoreCase(this.txtUsuario.getText())
            && usuario.getContraseña().equalsIgnoreCase(String.valueOf(this.txtConstraseña.getPassword()))) {
                encontrado = true;
                
            }else if (usuario.getUsuario().toLowerCase() != this.txtUsuario.getText().toLowerCase()
            || usuario.getContraseña().toLowerCase() != String.valueOf(this.txtConstraseña.getPassword()).toLowerCase() ) {
                encontrado = false;
            }
            
        }
        return encontrado;
       
    }
    

    
    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
    
    JFPrincipal frame; 

            frame = new JFPrincipal();
        try {
            if (encontrado()== true) {
                JOptionPane.showMessageDialog(this, "Ingreso correctamente");
                frame.setVisible(true);
                dispose();
            }else if(encontrado() == false){
                JOptionPane.showMessageDialog(this, "Ingrese los datos correctos");
                this.lblMensajeError.setVisible(true);
                this.limpiarControles();
                this.txtUsuario.requestFocusInWindow();
                
            }
        } catch (Exception ex) {
            Logger.getLogger(JFUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            frame = null;
        }

    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.limpiarControles();
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(JFUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblMensajeError;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPasswordField txtConstraseña;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    private void limpiarControles() {
        this.txtUsuario.setText("");
        this.txtConstraseña.setText("");
    }
}
