package com.RJN.ThroughTheAges;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import space.earlygrey.shapedrawer.ShapeDrawer;

import static com.badlogic.gdx.Gdx.graphics;

public class TestStage extends Stage {
    private static final Texture whiteTexture = new Texture(Gdx.files.internal("textures/1WhitePixel.png"));

    public void draw(){
        super.draw();
        getBatch().begin();
        ShapeDrawer shapeDrawer = new ShapeDrawer(getBatch(), new TextureRegion(whiteTexture));
        shapeDrawer.setColor(new Color(0,0,1,1));
        shapeDrawer.filledRectangle(0,0,graphics.getWidth(),graphics.getHeight());
        getBatch().end();
    }
}
