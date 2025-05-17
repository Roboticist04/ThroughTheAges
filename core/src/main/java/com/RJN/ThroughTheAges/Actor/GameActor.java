package com.RJN.ThroughTheAges.Actor;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class GameActor extends Actor {
    private Sprite sprite;

    protected GameActor(Sprite sprite, float x, float y, float xScale, float yScale){
        sprite.setX(x);
        sprite.setY(y);
        sprite.setScale(xScale,yScale);
        this.sprite = sprite;
    }

    public void draw(Batch batch, float parentAlpha){
        sprite.draw(batch);
    }

    public boolean collidesWith(Actor actor){
        Rectangle rect1 = new Rectangle(getX(),getY(),getWidth(),getHeight());
        Rectangle rect2 = new Rectangle(actor.getX(),actor.getY(),actor.getWidth(),actor.getHeight());
        return rect1.overlaps(rect2);
    }
}
