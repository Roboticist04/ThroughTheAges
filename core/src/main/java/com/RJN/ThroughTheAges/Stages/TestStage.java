package com.RJN.ThroughTheAges.Stages;

import com.RJN.ThroughTheAges.Props.Platform;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class TestStage extends GameStage {
    //private PushBox pushBox;
    private Platform platform;

    public TestStage(World world){
        super(new FitViewport(1920,1080),world);
        //addActor(new Player());
        //pushBox = new PushBox(world,500,50);
        platform = new Platform( new Texture(Gdx.files.internal("textures/ground.png")),1000,600, 50, 50);
        //addActor(pushBox);
        //addActor(player);
        addActor(platform);

    }



    public void act(){

    }


}
