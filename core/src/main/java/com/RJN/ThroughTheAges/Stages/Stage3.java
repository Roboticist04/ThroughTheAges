package com.RJN.ThroughTheAges.Stages;

import com.RJN.ThroughTheAges.Main;
import com.RJN.ThroughTheAges.Props.Platform;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Stage3 extends GameStage{
    private final Texture groundTexture = new Texture(Gdx.files.internal("textures/ground.png"));

    public Stage3(Main main) {
        super(main);
        //ground
        addActor(new Platform(groundTexture,0,0,getWidth()/5,40));
    }
}
