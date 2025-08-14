package com.balitechy.spacewar.main.colorfulvectorial;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import com.balitechy.spacewar.main.abstractions.AbstractBackgroundRenderer;

public class ColorfulVectorialBackgroundRenderer extends AbstractBackgroundRenderer {
    
    @Override
    public void render(Graphics g, Canvas c) throws IOException {
        // Gradient-like background
        g.setColor(new Color(10, 10, 30));
        g.fillRect(0, 0, c.getWidth(), c.getHeight());
        
        // Add some darker blue areas
        g.setColor(new Color(20, 20, 60));
        for (int i = 0; i < c.getWidth(); i += 80) {
            g.fillRect(i, 0, 40, c.getHeight());
        }
        
        // Draw colorful grid lines
        g.setColor(new Color(0, 100, 100, 60));
        for (int i = 0; i < c.getWidth(); i += 50) {
            g.drawLine(i, 0, i, c.getHeight());
        }
        for (int i = 0; i < c.getHeight(); i += 50) {
            g.drawLine(0, i, c.getWidth(), i);
        }
        
        // Add some colorful accent lines
        g.setColor(new Color(255, 0, 255, 40));
        for (int i = 0; i < c.getWidth(); i += 100) {
            g.drawLine(i, 0, i + 50, c.getHeight());
        }

        // Draw moon/planet in upper left corner
        g.setColor(Color.CYAN);
        int moonSize = 80;
        g.drawOval(20, 20, moonSize, moonSize);
    }
}