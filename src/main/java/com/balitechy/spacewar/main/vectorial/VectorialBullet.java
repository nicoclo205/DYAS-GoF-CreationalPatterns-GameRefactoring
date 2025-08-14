package com.balitechy.spacewar.main.vectorial;

import java.awt.Color;
import java.awt.Graphics;
import com.balitechy.spacewar.main.abstractions.AbstractBullet;
import com.balitechy.spacewar.main.Game;

public class VectorialBullet extends AbstractBullet {
    
    public VectorialBullet(double x, double y, Game game) {
        super(x, y);
    }
    
    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        
        // Draw bullet as vertical lines (like in your image)
        int centerX = (int)(x + WIDTH/2);
        g.drawLine(centerX, (int)y, centerX, (int)(y + HEIGHT));
        
        // Add small horizontal lines for detail
        g.drawLine(centerX-2, (int)(y + HEIGHT/3), centerX+2, (int)(y + HEIGHT/3));
        g.drawLine(centerX-2, (int)(y + 2*HEIGHT/3), centerX+2, (int)(y + 2*HEIGHT/3));
    }
}