package com.RJN.ThroughTheAges.Stages;

import com.RJN.ThroughTheAges.Actor.Flag;
import com.RJN.ThroughTheAges.Main;
import com.RJN.ThroughTheAges.Props.Platform;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Stage3 extends GameStage{
    private final Texture groundTexture = new Texture(Gdx.files.internal("textures/ground.png"));
    private final Texture platformTexture = new Texture(Gdx.files.internal("textures/platform.png"));

    public Stage3(Main main) {
        super(main);
        //ground
        addActor(new Platform(groundTexture,0,0,getWidth()/5,40));
        addActor(new Platform(groundTexture,getWidth()/1.2f,0,getWidth()-(getWidth()/1.2f),40));

        //Platforms
        addActor(new Platform(platformTexture,getWidth()/5+100,180,128,32));
        addActor(new Platform(platformTexture,getWidth()/5+100,360,128,32));
        addActor(new Platform(platformTexture,getWidth()/5+100,540,128,32));
        addActor(new Platform(platformTexture,1000,600,128,32));

        //Flag
        addActor(new Flag(getWidth()/1.1f,40,64,64,main));
    }

    public void dispose(){
        super.dispose();
        groundTexture.dispose();
        platformTexture.dispose();
    }
}
