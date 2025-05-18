package com.RJN.ThroughTheAges.Stages;

import com.RJN.ThroughTheAges.Actor.Flag;
import com.RJN.ThroughTheAges.Actor.MovingPlatform;
import com.RJN.ThroughTheAges.Main;
import com.RJN.ThroughTheAges.Props.Platform;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Stage4 extends GameStage {
    private static final Texture groundTexture = new Texture(Gdx.files.internal("textures/ground.png"));
    private static final Texture platformTexture = new Texture(Gdx.files.internal("textures/platform.png"));
    private static final Texture statueTexture = new Texture(Gdx.files.internal("textures/statue.png"));

    public Stage4(Main main) {
        super(main);
        backgroundTexture = new Texture(Gdx.files.internal("textures/Stage4Backdrop.png"));

        addActor(new Platform(groundTexture, 0, -20, getWidth() / 4.0f, 60));
        addActor(new Platform(groundTexture, getWidth() / 1.5f, -20, getWidth(), 60));
        addActor(new Platform(platformTexture, getWidth() / 4.0f + 200, 80, 128, 28));
        addActor(new Platform(platformTexture, getWidth() / 1.5f - 300, 175, 128, 28));
        addActor(new Platform(platformTexture, getWidth() / 4.0f + 200, 300, 128, 28));
        addActor(new Platform(platformTexture, getWidth() / 1.5f - 300, 425, 128, 28));
        addActor(new Platform(platformTexture, getWidth() / 1.5f, statueTexture.getHeight() / 2f + 60, statueTexture.getWidth() / 2f, 28));
        addActor(new Platform(statueTexture, getWidth() / 1.5f, 40, statueTexture.getWidth() / 2f, statueTexture.getHeight() / 2f));
        addActor(new Flag(getWidth() / 1.2f, 40, 64, 64, main, player));

        //addActor(new MovingPlatform(getWidth() / 4.0f + 100, 200, 80, 28, 100, 0));
        //addActor(new MovingPlatform(getWidth() / 1.5f - 200, 300, 128, 28, 0, 50));
    }

    @Override
    public void dispose() {
        super.dispose();
        groundTexture.dispose();
        statueTexture.dispose();
        platformTexture.dispose();
    }
}
