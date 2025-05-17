package com.RJN.ThroughTheAges.Actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class PushBox extends Actor {
    private int X;
    private int Y;
    private int speed;
}private static final Texture texture = new Texture(Gdx.files.internal("1WhitePixel.png"));
    public void drawBox(Batch batch) {
        batch.draw(texture,getX(),getY());
    }

    public int getX() {
        return X;
    }
    public int getY() {
        return Y;
    }
    public void setX(int aX) {
        X = aX;
    }
    public void setY(int aY) {
        Y = aY;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /*public boolean touching() {
        if () {
            return true;
        }
        else {
            return false;
        }
    }*/

    public void moveLeft()  {
        setY(getX()+speed);
    }

    public void moveRight() {
        setY(getX()-speed);
    }

}
