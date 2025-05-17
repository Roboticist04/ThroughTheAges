package com.RJN.ThroughTheAges.Actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class Player extends Actor {
    TextureRegion region;
    private int speed;

    public Player () {
        region = new TextureRegion(new Texture(Gdx.files.internal("textures/redSword.png")));
        setBounds(region.getRegionX(), region.getRegionY(),
            region.getRegionWidth(), region.getRegionHeight());
        speed = 5;
        addListener(new InputListener(){

        });
    }

    @Override
    public void draw (Batch batch, float parentAlpha) {
        Color color = getColor();
        batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
        batch.draw(region, getX(), getY(), getOriginX(), getOriginY(),
            getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
    }

    public void moveUp(){
        setY(getY()+speed);
    }

    public void moveDown(){
        setY(getY()-speed);
    }

    public void moveLeft(){
        setY(getX()+speed);
    }

    public void moveRight(){
        setY(getX()-speed);
    }
}
