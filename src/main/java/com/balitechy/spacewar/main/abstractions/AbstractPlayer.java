package com.balitechy.spacewar.main.abstractions;

import java.awt.Graphics;

public abstract class AbstractPlayer {
    protected double x;
    protected double y;
    protected double velX;
    protected double velY;
    
    public static final int WIDTH = 56;
    public static final int HEIGHT = 28;
    
    public AbstractPlayer(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public abstract void render(Graphics g);
    
    public void tick() {
        x += velX;
        y += velY;
        
        if(x <= 0) x = 0;
        if(x >= (640 - WIDTH)) x = (640 - WIDTH);
        if(y <= 0) y = 0;
        if(y >= (480 - HEIGHT)) y = (480 - HEIGHT);
    }
    
    public double getX() { return x; }
    public void setX(double x) { this.x = x; }
    public double getY() { return y; }
    public void setY(double y) { this.y = y; }
    public void setVelX(double velX) { this.velX = velX; }
    public void setVelY(double velY) { this.velY = velY; }
}