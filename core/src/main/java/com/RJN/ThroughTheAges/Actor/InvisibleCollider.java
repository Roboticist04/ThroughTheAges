package com.RJN.ThroughTheAges.Actor;

import com.RJN.ThroughTheAges.Stages.GameStage;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import space.earlygrey.shapedrawer.ShapeDrawer;

public class InvisibleCollider extends GameActor{
    public InvisibleCollider(float x, float y, float width, float height) {
        super(null, x, y, width, height);
    }
    public void draw(Batch batch, float deltaTime){
        if(drawDebug){
            ShapeDrawer shape = new ShapeDrawer(batch, new TextureRegion(GameStage.whiteTexture));
            shape.rectangle(getX(),getY(),getWidth(),getHeight());
        }
    }
}
