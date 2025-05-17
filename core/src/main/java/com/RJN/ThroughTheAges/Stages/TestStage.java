package com.RJN.ThroughTheAges.Stages;

import com.RJN.ThroughTheAges.Actor.PushBox;
import com.RJN.ThroughTheAges.Props.Platform;
import com.RJN.ThroughTheAges.Props.StaticCollidableProp;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.FitViewport;
import space.earlygrey.shapedrawer.ShapeDrawer;

import static com.badlogic.gdx.Gdx.graphics;

public class TestStage extends GameStage {
    private PushBox pushBox;
    private StaticCollidableProp platform;

    public TestStage(World world){
        super(new FitViewport(1920,1080),world);
        //addActor(new Player());
        pushBox = new PushBox(world,500,50);
        platform = new Platform(world, 1000,600,new Texture(Gdx.files.internal("textures/ground.png")));
        addActor(pushBox);
        addActor(player);
        addActor(platform);

    }



    public void act(){

    }


}
