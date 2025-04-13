/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swing;
import javax.swing.JPanel;

public class Background extends JPanel {
    private float animate;
    private int header = 50;
    private boolean showPaint;

    public boolean isShowPaint() {
        return this.showPaint;
    }

    public void setShowPaint(boolean showPaint) {
        this.showPaint = showPaint;
    }

    public float getAnimate() {
        return this.animate;
    }

    public void setAnimate(float animate) {
        this.animate = animate;
        this.repaint();
    }

    private float easeOutQuint(float x) {
        return (float)(1.0 - Math.pow((double)(1.0F - x), 5.0));
    }

    private float easeInOutCirc(float x) {
        double v = (double)x < 0.5 ? (1.0 - Math.sqrt(1.0 - Math.pow((double)(2.0F * x), 2.0))) / 2.0 : (Math.sqrt(1.0 - Math.pow((double)(-2.0F * x + 2.0F), 2.0)) + 1.0) / 2.0;
        return (float)v;
    }

    public Background() {
        this.setOpaque(false);
    }
}