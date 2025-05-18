package com.RJN.ThroughTheAges.Actor;

import com.RJN.ThroughTheAges.Stages.GameStage;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import space.earlygrey.shapedrawer.ShapeDrawer;

public class GameActor extends Actor {
    private Sprite sprite;
    protected boolean touchingSurface;
    private final boolean drawDebug = true;

    protected GameActor(Sprite sprite, float x, float y, float xScale, float yScale){
        sprite.setX(x);
        sprite.setY(y);
        setX(x);
        setY(y);
        setWidth(sprite.getWidth());
        setHeight(sprite.getHeight());
        sprite.setScale(xScale,yScale);
        this.sprite = sprite;
    }

    public void draw(Batch batch, float parentAlpha){
        sprite.setX(getX());
        sprite.setY(getY());
        sprite.draw(batch);
        if(drawDebug){
            ShapeDrawer shape = new ShapeDrawer(batch, new TextureRegion(GameStage.whiteTexture));
            shape.rectangle(getX(),getY(),getWidth(),getHeight());
        }
    }

    public boolean collidesWith(Actor actor){
        Rectangle rect1 = new Rectangle(getX(),getY(),getWidth(),getHeight());
        Rectangle rect2 = new Rectangle(actor.getX(),actor.getY(),actor.getWidth(),actor.getHeight());
        return rect1.overlaps(rect2);
    }

    public void hit(GameActor gameActor){
        touchingSurface = true;
    }

    public void clearTouchingState(){
        touchingSurface = false;
    }
}
