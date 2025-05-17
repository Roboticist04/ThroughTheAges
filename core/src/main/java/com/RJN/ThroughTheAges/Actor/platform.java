package com.RJN.ThroughTheAges.Actor;

import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class platform extends Actor {

    private int width;
    private int height;
    private int lX;
    private int lY;

    public platform(int aWidth, int aHeight, int aLX, int aLY) {

    }

    public void draw(Graphics g) {
       // g.drawRect(lX, lY, width, height);
    }

    public int getlY() {
        return lY;
    }

    public void setlY(int lY) {
        this.lY = lY;
    }

    public int getlX() {
        return lX;
    }

    public void setlX(int lX) {
        this.lX = lX;
    }

    @Override
    public int getHeight() {        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
