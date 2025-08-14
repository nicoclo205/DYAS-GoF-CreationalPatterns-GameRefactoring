package com.balitechy.spacewar.main.sprite;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import com.balitechy.spacewar.main.abstractions.AbstractPlayer;
import com.balitechy.spacewar.main.Game;

public class SpritePlayer extends AbstractPlayer {
    private BufferedImage image;
    private Game game;
    
    public SpritePlayer(double x, double y, Game game) {
        super(x, y);
        this.game = game;
        image = game.getSprites().getImage(219, 304, WIDTH, HEIGHT);
    }
    
    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.drawImage(image, (int) x, (int) y, null);
    }
    
    public Game getGame() {
        return game;
    }
}