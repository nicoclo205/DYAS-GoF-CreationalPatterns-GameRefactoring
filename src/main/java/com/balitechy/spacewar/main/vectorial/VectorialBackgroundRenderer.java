package com.balitechy.spacewar.main.vectorial;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import com.balitechy.spacewar.main.abstractions.AbstractBackgroundRenderer;

public class VectorialBackgroundRenderer extends AbstractBackgroundRenderer {
    
    @Override
    public void render(Graphics g, Canvas c) throws IOException {
        // Fill background with black
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, c.getWidth(), c.getHeight());
        
        // Draw moon/planet in upper left corner
        g.setColor(Color.BLACK);
        int moonSize = 80;
        g.drawOval(20, 20, moonSize, moonSize);
    }
}