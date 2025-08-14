package com.balitechy.spacewar.main.factories;

import com.balitechy.spacewar.main.abstractions.AbstractPlayer;
import com.balitechy.spacewar.main.abstractions.AbstractBullet;
import com.balitechy.spacewar.main.abstractions.AbstractBackgroundRenderer;
import com.balitechy.spacewar.main.vectorial.VectorialPlayer;
import com.balitechy.spacewar.main.vectorial.VectorialBullet;
import com.balitechy.spacewar.main.vectorial.VectorialBackgroundRenderer;
import com.balitechy.spacewar.main.Game;

public class VectorialElementsFactory extends GameElementsFactory {
    
    @Override
    public AbstractPlayer createPlayer(double x, double y, Game game) {
        return new VectorialPlayer(x, y, game);
    }
    
    @Override
    public AbstractBullet createBullet(double x, double y, Game game) {
        return new VectorialBullet(x, y, game);
    }
    
    @Override
    public AbstractBackgroundRenderer createBackgroundRenderer() {
        return new VectorialBackgroundRenderer();
    }
}