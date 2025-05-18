package com.RJN.ThroughTheAges.Stages;

import com.RJN.ThroughTheAges.Props.Platform;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.FitViewport;

import static com.badlogic.gdx.Gdx.graphics;

public class TestStage extends GameStage {
    //private PushBox pushBox;
    private Platform platform;
    private Platform ground;

    public TestStage(World world){
        super(new FitViewport(1920,1080),world);
        //addActor(new Player());
        //pushBox = new PushBox(world,500,50);
        platform = new Platform( new Texture(Gdx.files.internal("textures/ground.png")),1000,200, 50, 30);
        //addActor(pushBox);
        //addActor(player);
        addActor(platform);
        ground = new Platform(new Texture(Gdx.files.internal("textures/ground.png")), 0, 0, graphics.getWidth(), 20);
        addActor(ground);
    }



    public void act(){

    }


}
