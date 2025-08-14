package com.balitechy.spacewar.main.colorfulvectorial;

import java.awt.Color;
import java.awt.Graphics;
import com.balitechy.spacewar.main.abstractions.AbstractBullet;
import com.balitechy.spacewar.main.Game;

public class ColorfulVectorialBullet extends AbstractBullet {
    private Color bulletColor;
    private static Color[] colors = {Color.RED, Color.YELLOW, Color.GREEN, Color.CYAN, Color.MAGENTA};
    private static int colorIndex = 0;
    
    public ColorfulVectorialBullet(double x, double y, Game game) {
        super(x, y);
        // Cycle through colors for each bullet
        bulletColor = colors[colorIndex % colors.length];
        colorIndex++;
    }
    
    @Override
    public void render(Graphics g) {
        // MISMA FORMA que el vectorial, pero con colores
        
        // Draw bullet as vertical lines (igual que vectorial)
        g.setColor(bulletColor);
        int centerX = (int)(x + WIDTH/2);
        g.drawLine(centerX, (int)y, centerX, (int)(y + HEIGHT));
        
        // Add small horizontal lines for detail (igual que vectorial)
        g.drawLine(centerX-2, (int)(y + HEIGHT/3), centerX+2, (int)(y + HEIGHT/3));
        g.drawLine(centerX-2, (int)(y + 2*HEIGHT/3), centerX+2, (int)(y + 2*HEIGHT/3));
    }
}