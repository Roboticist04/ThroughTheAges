package com.RJN.ThroughTheAges.Actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class PushBox extends Actor {
    private int speed;

    private TextureRegion region;

    public PushBox() {
        region = new TextureRegion(new Texture(Gdx.files.internal("pushbox.png")));
        setBounds(region.getRegionX(), region.getRegionY(),
            region.getRegionWidth(), region.getRegionHeight());
    }

    public void drawBox(Batch batch) {
        batch.draw(region, getX(), getY());
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void moveLeft()  {
        setY(getX()+speed);
    }

    public void moveRight() {
        setY(getX()-speed);
    }

}

