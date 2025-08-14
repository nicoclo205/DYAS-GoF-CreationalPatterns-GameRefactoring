package com.balitechy.spacewar.main.sprite;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import com.balitechy.spacewar.main.abstractions.AbstractBullet;
import com.balitechy.spacewar.main.Game;

public class SpriteBullet extends AbstractBullet {
    private BufferedImage image;
    
    public SpriteBullet(double x, double y, Game game) {
        super(x, y);
        image = game.getSprites().getImage(35, 52, WIDTH, HEIGHT);
    }
    
    @Override
    public void render(Graphics g) {
        g.drawImage(image, (int) x, (int) y, null);
    }
}