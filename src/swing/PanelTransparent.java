/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swing;
import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class PanelTransparent extends JPanel {
    private float alpha = 1.0F;

    public void setAlpha(float alpha) {
        this.alpha = alpha;
        this.repaint();
    }

    public PanelTransparent() {
        this.setOpaque(false);
    }

    public void paint(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D)grphcs;
        g2.setComposite(AlphaComposite.getInstance(3, this.alpha));
        super.paint(grphcs);
    }
}
