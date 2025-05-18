package com.RJN.ThroughTheAges.Actor;

import com.RJN.ThroughTheAges.Stages.GameStage;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import space.earlygrey.shapedrawer.ShapeDrawer;

public class GameActor extends Actor {
    //private Sprite sprite;
    private TextureRegion texture;
    protected boolean touchingSurface;
    private static final boolean drawDebug = true;

    protected GameActor(TextureRegion region, float x, float y, float width, float height){
        //setX(x);
        //setY(y);
        setBounds(x,y,width,height);
        this.texture = region;
    }

    protected GameActor(TextureRegion region, float x, float y){
        this(region,x,y,region.getRegionWidth(),region.getRegionHeight());
    }

    public void draw(Batch batch, float parentAlpha){
        batch.draw(texture,getX(),getY(),getWidth(),getHeight());
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
