/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Component;
import swing.ImageAvatar;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;


public class Header extends JPanel {
    private ImageAvatar imageAvatar1;

    public Header() {
        this.initComponents();
    }

    private void initComponents() {
        this.imageAvatar1 = new ImageAvatar();
        this.setBackground(new Color(157, 153, 255));
        this.imageAvatar1.setBorderSize(1);
        this.imageAvatar1.setBorderSpace(0);
        //this.imageAvatar1.setImage(new ImageIcon(this.getClass().getResource("icon/e1786e79b5287e0d6bca2104a8540e5a.png")));
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(844, 32767).addComponent(this.imageAvatar1, -2, 42, -2).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.imageAvatar1, -1, 38, 32767).addContainerGap()));
    }
}
