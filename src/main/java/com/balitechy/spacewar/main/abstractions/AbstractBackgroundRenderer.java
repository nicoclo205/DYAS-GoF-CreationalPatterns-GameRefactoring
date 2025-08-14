package com.balitechy.spacewar.main.abstractions;

import java.awt.Canvas;
import java.awt.Graphics;
import java.io.IOException;

public abstract class AbstractBackgroundRenderer {
    public abstract void render(Graphics g, Canvas c) throws IOException;
}