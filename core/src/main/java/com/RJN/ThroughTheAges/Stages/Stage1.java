package com.RJN.ThroughTheAges.Stages;

import com.RJN.ThroughTheAges.Actor.Flag;
import com.RJN.ThroughTheAges.Main;
import com.RJN.ThroughTheAges.Props.Platform;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;

import static com.badlogic.gdx.Gdx.graphics;

public class Stage1 extends GameStage {
    private Platform ground;
    private Flag flag;
    private final Texture groundTex = new Texture(Gdx.files.internal("textures/ground.png"));

    public Stage1(Main main){
        //super(new FitViewport(1920,1080));
        //super (new FillViewport(1920,1080));
        ground = new Platform(groundTex, 0, -20, graphics.getWidth(), 60);
        addActor(ground);
        addActor(new Platform(groundTex,200,100,100,30));
        addActor(new Platform(groundTex,400,250,100,30));
        addActor(new Platform(groundTex,900,350,100,30));
        addActor(new Platform(groundTex,1250,475,100,30));
        addActor(new Platform(groundTex, 1800, 275,100,30));
        flag = new Flag(1830,315,40,40,main);
        addActor(flag);
    }
}
