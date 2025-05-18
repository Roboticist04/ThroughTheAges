package com.RJN.ThroughTheAges.Stages;

import com.RJN.ThroughTheAges.Actor.Flag;
import com.RJN.ThroughTheAges.Main;
import com.RJN.ThroughTheAges.Props.Platform;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.FitViewport;

import static com.badlogic.gdx.Gdx.graphics;

public class Stage1 extends GameStage {
    //private PushBox pushBox;
    private Platform platform;
    private Platform ground;
    private Flag flag;

    public Stage1(Main main){
        super(new FitViewport(1920,1080));
        platform = new Platform( new Texture(Gdx.files.internal("textures/ground.png")),1000,200, 50, 30);
        addActor(platform);
        ground = new Platform(new Texture(Gdx.files.internal("textures/ground.png")), 0, 0, graphics.getWidth(), 20);
        addActor(ground);
        flag = new Flag(1010,221,40,40,main);
        addActor(flag);
    }
}
