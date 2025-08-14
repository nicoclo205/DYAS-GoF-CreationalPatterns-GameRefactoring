package com.balitechy.spacewar.main.factories;

import com.balitechy.spacewar.main.abstractions.AbstractPlayer;
import com.balitechy.spacewar.main.colorfulvectorial.ColorfulVectorialBackgroundRenderer;
import com.balitechy.spacewar.main.colorfulvectorial.ColorfulVectorialBullet;
import com.balitechy.spacewar.main.colorfulvectorial.ColorfulVectorialPlayer;
import com.balitechy.spacewar.main.abstractions.AbstractBullet;
import com.balitechy.spacewar.main.abstractions.AbstractBackgroundRenderer;
import com.balitechy.spacewar.main.Game;

public class ColorfulVectorialElementsFactory extends GameElementsFactory {
    
    @Override
    public AbstractPlayer createPlayer(double x, double y, Game game) {
        return new ColorfulVectorialPlayer(x, y, game);
    }
    
    @Override
    public AbstractBullet createBullet(double x, double y, Game game) {
        return new ColorfulVectorialBullet(x, y, game);
    }
    
    @Override
    public AbstractBackgroundRenderer createBackgroundRenderer() {
        return new ColorfulVectorialBackgroundRenderer();
    }
}
