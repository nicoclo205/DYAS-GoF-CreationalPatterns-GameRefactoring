package com.balitechy.spacewar.main.factories;

import com.balitechy.spacewar.main.abstractions.AbstractPlayer;
import com.balitechy.spacewar.main.abstractions.AbstractBullet;
import com.balitechy.spacewar.main.abstractions.AbstractBackgroundRenderer;
import com.balitechy.spacewar.main.Game;

public abstract class GameElementsFactory {
    public abstract AbstractPlayer createPlayer(double x, double y, Game game);
    public abstract AbstractBullet createBullet(double x, double y, Game game);
    public abstract AbstractBackgroundRenderer createBackgroundRenderer();
}