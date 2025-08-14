package com.balitechy.spacewar.main.abstractions;

import java.awt.Graphics;

public abstract class AbstractBullet {
    protected double x;
    protected double y;
    public static final int WIDTH = 11;
    public static final int HEIGHT = 21;
    
    public AbstractBullet(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public abstract void render(Graphics g);
    
    public void tick() {
        y -= 5;
    }
    
    public double getY() { return y; }
    public double getX() { return x; }
}