package GiaoDien;
import javax.swing.*;
import java.awt.*;
public class BlurPanel extends JPanel {
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Create a translucent color (adjust the alpha value as needed)
        Color translucentColor = new Color(255, 255, 255, 200);

        // Fill the panel with the translucent color
        g.setColor(translucentColor);
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}
