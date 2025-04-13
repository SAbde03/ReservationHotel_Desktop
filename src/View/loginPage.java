package View;

import Component.Header;
import View.Main;
import connexion.Connexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import swing.Background;
import swing.TextField;
import swing.Button;
import swing.PasswordField;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import swing.PanelTransparent;
/**
 *
 * @author golde
 */
public class loginPage extends JFrame {
       private Animator animatorLogin;
    private Animator animatorBody;
    private boolean signIn;
    private Background background1;
    private Button cmdSignIn;
    private Header header1;
    private JButton jButton1;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private PanelTransparent panelBody;
    private JPanel panelLogin;
    private PasswordField txtPass;
    private TextField txtUser;
    
    /**
     * Creates new form loginPage
     */
    public loginPage() {
        initComponents();
//        this.setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1080, 600);
        setLocationRelativeTo(null);
        setLayout(new CardLayout());
        
       this.getContentPane().setBackground(new Color(245, 245, 245));
      
    }

    
    private void initComponents() {
        this.setBackground(Color.white);
        this.background1 = new Background();
        this.panelLogin = new JPanel();
        this.jPanel1 = new JPanel();
        this.jLabel1 = new JLabel();
        this.cmdSignIn = new Button();
        this.txtUser = new TextField();
        this.txtPass = new PasswordField();
        this.panelBody = new PanelTransparent();
        this.jScrollPane1 = new JScrollPane();
        this.jTable1 = new JTable();
        this.jButton1 = new JButton();
        this.header1 = new Header();
        this.setDefaultCloseOperation(3);

        this.background1.setLayout(new CardLayout());
        
        this.panelLogin.setOpaque(false);
        this.jPanel1.setOpaque(false);
        this.jLabel1.setHorizontalAlignment(0);
        //this.jLabel1.setIcon(new ImageIcon(this.getClass().getResource("/com/raven/icon/Marriott-International-Logo-500x281 (1).png")));
        this.cmdSignIn.setBackground(new Color(255, 0, 0));
        this.cmdSignIn.setForeground(new Color(255, 255, 255));
        this.cmdSignIn.setText("Sign In");
        this.cmdSignIn.setEffectColor(new Color(199, 196, 255));
        this.cmdSignIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                 loginPage.this.cmdSignInActionPerformed(evt);
            }
        });
        this.txtUser.setBackground(new Color(245, 245, 245));
        this.txtUser.setLabelText("User Name");
        this.txtUser.setLineColor(new Color(255, 0, 0));
        this.txtUser.setSelectionColor(new Color(255, 0, 0));
        this.txtPass.setBackground(new Color(245, 245, 245));
        this.txtPass.setLabelText("Password");
        this.txtPass.setLineColor(new Color(255, 0, 0));
        this.txtPass.setSelectionColor(new Color(255, 0, 0));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGap(20, 20, 20).addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING).addComponent(this.txtPass, -1, -1, 32767).addComponent(this.txtUser, -1, -1, 32767).addComponent(this.cmdSignIn, -1, -1, 32767).addComponent(this.jLabel1, -1, 310, 32767)).addGap(20, 20, 20)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.jLabel1).addGap(20, 20, 20).addComponent(this.txtUser, -2, -1, -2).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.txtPass, -2, -1, -2).addPreferredGap(ComponentPlacement.RELATED, 30, 32767).addComponent(this.cmdSignIn, -2, 40, -2).addContainerGap()));
        GroupLayout panelLoginLayout = new GroupLayout(this.panelLogin);
        this.panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(panelLoginLayout.createParallelGroup(Alignment.LEADING).addGroup(panelLoginLayout.createSequentialGroup().addContainerGap(427, 32767).addComponent(this.jPanel1, -2, -1, -2).addContainerGap(428, 32767)));
        panelLoginLayout.setVerticalGroup(panelLoginLayout.createParallelGroup(Alignment.LEADING).addGroup(panelLoginLayout.createSequentialGroup().addContainerGap(63, 32767).addComponent(this.jPanel1, -2, -1, -2).addContainerGap(233, 32767)));
        this.background1.add(this.panelLogin, "card2");
        this.jTable1.setModel(new DefaultTableModel(new Object[][]{{null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}}, new String[]{"Title 1", "Title 2", "Title 3", "Title 4"}));
        this.jScrollPane1.setViewportView(this.jTable1);
        this.jButton1.setText("Sign Out");
        this.jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
               loginPage.this.jButton1ActionPerformed(evt);
            }
        });
        GroupLayout panelBodyLayout = new GroupLayout(this.panelBody);
        this.panelBody.setLayout(panelBodyLayout);
        panelBodyLayout.setHorizontalGroup(panelBodyLayout.createParallelGroup(Alignment.LEADING).addGroup(panelBodyLayout.createSequentialGroup().addContainerGap().addGroup(panelBodyLayout.createParallelGroup(Alignment.LEADING).addComponent(this.jScrollPane1).addGroup(Alignment.TRAILING, panelBodyLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.jButton1))).addContainerGap()).addComponent(this.header1, -1, 1205, 32767));
        panelBodyLayout.setVerticalGroup(panelBodyLayout.createParallelGroup(Alignment.LEADING).addGroup(panelBodyLayout.createSequentialGroup().addComponent(this.header1, -2, -1, -2).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -1, 504, 32767).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.jButton1).addContainerGap()));
        this.background1.add(this.panelBody, "card3");
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.background1, -1, -1, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.background1, -1, -1, 32767));
        this.pack();
        
        this.setLocationRelativeTo(null);
    }
    
    private void cmdSignInActionPerformed(ActionEvent evt) {
        if (!this.animatorLogin.isRunning()) {
            this.signIn = true;
            String user = this.txtUser.getText().trim();
            String pass = String.valueOf(this.txtPass.getPassword());
            boolean action = true;
            if (user.equals("")) {
                this.txtUser.setHelperText("Please input user name");
                this.txtUser.grabFocus();
                action = false;
            }

            if (pass.equals("")) {
                this.txtPass.setHelperText("Please input password");
                if (action) {
                    this.txtPass.grabFocus();
                }

                action = false;
            }

            if (action) {
                this.animatorLogin.start();
                this.enableLogin(false);
            }
        }

    }

   /* private void jButton1ActionPerformed(ActionEvent evt) {
        this.signIn = false;
        this.clearLogin();
        this.animatorBody.start();
    }*/

    private void enableLogin(boolean action) {
        this.txtUser.setEditable(action);
        this.txtPass.setEditable(action);
        this.cmdSignIn.setEnabled(action);
    }

    public void clearLogin() {
        this.txtUser.setText("");
        this.txtPass.setText("");
        this.txtUser.setHelperText("");
        this.txtPass.setHelperText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    /*
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1077, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 539, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
*/      private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
       String username = txtUser.getText();
       String password = new String(txtPass.getPassword());
       String query = "SELECT * FROM utilisateur WHERE username = ? AND password = ?";
       try {
       PreparedStatement stmt = Connexion.getcnx().prepareStatement(query);
       stmt.setString(1, username);
       stmt.setString(2, password);
       ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
        this.dispose();
        new Main().setVisible(true);
        } else {
         JOptionPane.showMessageDialog(this, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        }
       catch(SQLException e) {
			System.out.println("Erreur SQL");
		}
        
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
            java.util.logging.Logger.getLogger(loginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
 
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new loginPage().setVisible(true);
            }
        });
    }

       
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
