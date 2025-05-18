package com.RJN.ThroughTheAges.Actor;

import com.RJN.ThroughTheAges.Main;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Flag extends GameActor{
    private Main main;
    public Flag(float x, float y, float width, float height, Main main, Player player) {
        super(new TextureRegion(new Texture(Gdx.files.internal("textures/redSword.png"))), x, y, width, height, player);
        this.main = main;
    }
    public void act(float deltaTime){
        if(touchingPlayer){
            main.advanceStage();
        }
    }
}
