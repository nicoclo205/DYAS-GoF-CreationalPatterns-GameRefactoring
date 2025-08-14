package com.balitechy.spacewar.main.colorfulvectorial;

import java.awt.Color;
import java.awt.Graphics;
import com.balitechy.spacewar.main.abstractions.AbstractPlayer;
import com.balitechy.spacewar.main.Game;

public class ColorfulVectorialPlayer extends AbstractPlayer {
    private Game game;
    
    public ColorfulVectorialPlayer(double x, double y, Game game) {
        super(x, y);
        this.game = game;
    }
    
    @Override
    public void render(Graphics g) {
        // MISMA FORMA que el vectorial, pero con colores
        
        int triangleWidth = WIDTH / 2;  
        int startX = (int)(x + WIDTH/4); 
        
        int[] xPoints = {
            (int)(x + WIDTH/2),           
            startX,                      
            startX + triangleWidth        
        };
        int[] yPoints = {
            (int)(y),                    
            (int)(y + HEIGHT),            
            (int)(y + HEIGHT)            
        };
        
        // Fill triangle with cyan
        g.setColor(Color.CYAN);
        g.fillPolygon(xPoints, yPoints, 3);
        
        // Outline in blue
        g.setColor(Color.BLUE);
        g.drawPolygon(xPoints, yPoints, 3);
        
    
    }
    
    public Game getGame() {
        return game;
    }
}