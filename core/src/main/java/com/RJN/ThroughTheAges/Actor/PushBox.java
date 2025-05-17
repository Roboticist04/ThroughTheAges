package com.RJN.ThroughTheAges.Actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class PushBox extends Actor {
    private static final Texture texture = new Texture(Gdx.files.internal("1WhitePixel.png"));
    public void drawBox(Batch batch) {
        batch.draw(texture,getX(),getY());
    }

}
