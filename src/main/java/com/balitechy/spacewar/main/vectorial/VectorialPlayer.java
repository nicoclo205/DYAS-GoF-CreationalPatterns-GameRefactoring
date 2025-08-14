package com.balitechy.spacewar.main.vectorial;

import java.awt.Color;
import java.awt.Graphics;
import com.balitechy.spacewar.main.abstractions.AbstractPlayer;
import com.balitechy.spacewar.main.Game;

public class VectorialPlayer extends AbstractPlayer {
    private Game game;
    
    public VectorialPlayer(double x, double y, Game game) {
        super(x, y);
        this.game = game;
    }
    
    @Override
public void render(Graphics g) {
    g.setColor(Color.BLACK);
    
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
    g.drawPolygon(xPoints, yPoints, 3);
    
}
    
    public Game getGame() {
        return game;
    }
}