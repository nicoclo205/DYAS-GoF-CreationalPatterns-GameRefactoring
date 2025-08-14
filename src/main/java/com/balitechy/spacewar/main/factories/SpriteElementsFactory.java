package com.balitechy.spacewar.main.factories;

import com.balitechy.spacewar.main.abstractions.AbstractPlayer;
import com.balitechy.spacewar.main.abstractions.AbstractBullet;
import com.balitechy.spacewar.main.abstractions.AbstractBackgroundRenderer;
import com.balitechy.spacewar.main.sprite.SpritePlayer;
import com.balitechy.spacewar.main.sprite.SpriteBullet;
import com.balitechy.spacewar.main.sprite.SpriteBackgroundRenderer;
import com.balitechy.spacewar.main.Game;

public class SpriteElementsFactory extends GameElementsFactory {
    
    @Override
    public AbstractPlayer createPlayer(double x, double y, Game game) {
        return new SpritePlayer(x, y, game);
    }
    
    @Override
    public AbstractBullet createBullet(double x, double y, Game game) {
        return new SpriteBullet(x, y, game);
    }
    
    @Override
    public AbstractBackgroundRenderer createBackgroundRenderer() {
        return new SpriteBackgroundRenderer();
    }
}