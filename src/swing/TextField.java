package swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class TextField extends JTextField {
    private final Animator animator;
    private boolean animateHinText = true;
    private float location;
    private boolean show;
    private boolean mouseOver = false;
    private String labelText = "Label";
    private String helperText = "";
    private int spaceHelperText = 15;
    private Color lineColor = new Color(3, 155, 216);

    public String getHelperText() {
        return this.helperText;
    }

    public void setHelperText(String helperText) {
        this.helperText = helperText;
        this.repaint();
    }

    public String getLabelText() {
        return this.labelText;
    }

    public void setLabelText(String labelText) {
        this.labelText = labelText;
    }

    public Color getLineColor() {
        return this.lineColor;
    }

    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }

    public TextField() {
        this.setBorder(new EmptyBorder(20, 3, 23, 3));
        this.setSelectionColor(new Color(76, 204, 255));
        this.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent me) {
                TextField.this.mouseOver = true;
                TextField.this.repaint();
            }

            public void mouseExited(MouseEvent me) {
                TextField.this.mouseOver = false;
                TextField.this.repaint();
            }
        });
        this.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent fe) {
                TextField.this.showing(false);
            }

            public void focusLost(FocusEvent fe) {
                TextField.this.showing(true);
            }
        });
        TimingTarget target = new TimingTargetAdapter() {
            public void begin() {
                TextField.this.animateHinText = TextField.this.getText().equals("");
            }

            public void timingEvent(float fraction) {
                TextField.this.location = fraction;
                TextField.this.repaint();
            }
        };
        this.animator = new Animator(300, target);
        this.animator.setResolution(0);
        this.animator.setAcceleration(0.5F);
        this.animator.setDeceleration(0.5F);
    }

    private void showing(boolean action) {
        if (this.animator.isRunning()) {
            this.animator.stop();
        } else {
            this.location = 1.0F;
        }

        this.animator.setStartFraction(1.0F - this.location);
        this.show = action;
        this.location = 1.0F - this.location;
        this.animator.start();
    }

    public void paint(Graphics grphcs) {
        super.paint(grphcs);
        Graphics2D g2 = (Graphics2D)grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
        int width = this.getWidth();
        int height = this.getHeight();
        if (this.mouseOver) {
            g2.setColor(this.lineColor);
        } else {
            g2.setColor(new Color(150, 150, 150));
        }

        g2.fillRect(2, height - this.spaceHelperText - 1, width - 4, 1);
        this.createHintText(g2);
        this.createLineStyle(g2);
        this.createHelperText(g2);
        g2.dispose();
    }

    private void createHintText(Graphics2D g2) {
        Insets in = this.getInsets();
        g2.setColor(new Color(150, 150, 150));
        FontMetrics ft = g2.getFontMetrics();
        Rectangle2D r2 = ft.getStringBounds(this.labelText, g2);
        double height = (double)(this.getHeight() - in.top - in.bottom);
        double textY = (height - r2.getHeight()) / 2.0;
        double size;
        if (this.animateHinText) {
            if (this.show) {
                size = (double)(18.0F * (1.0F - this.location));
            } else {
                size = (double)(18.0F * this.location);
            }
        } else {
            size = 18.0;
        }

        g2.drawString(this.labelText, in.right, (int)((double)in.top + textY + (double)ft.getAscent() - size));
    }

    private void createLineStyle(Graphics2D g2) {
        if (this.isFocusOwner()) {
            double width = (double)(this.getWidth() - 4);
            int height = this.getHeight() - this.spaceHelperText;
            g2.setColor(this.lineColor);
            double size;
            if (this.show) {
                size = width * (double)(1.0F - this.location);
            } else {
                size = width * (double)this.location;
            }

            double x = (width - size) / 2.0;
            g2.fillRect((int)(x + 2.0), height - 2, (int)size, 2);
        }

    }

    private void createHelperText(Graphics2D g2) {
        if (this.helperText != null && !this.helperText.equals("")) {
            Insets in = this.getInsets();
            int height = this.getHeight() - 15;
            g2.setColor(new Color(255, 76, 76));
            Font font = this.getFont();
            g2.setFont(font.deriveFont(0, (float)(font.getSize() - 1)));
            FontMetrics ft = g2.getFontMetrics();
            Rectangle2D r2 = ft.getStringBounds(this.labelText, g2);
            double textY = (15.0 - r2.getHeight()) / 2.0;
            g2.drawString(this.helperText, in.right, (int)((double)(height + ft.getAscent()) - textY));
        }

    }

    public void setText(String string) {
        if (!this.getText().equals(string)) {
            this.showing(string.equals(""));
        }

        super.setText(string);
    }
}