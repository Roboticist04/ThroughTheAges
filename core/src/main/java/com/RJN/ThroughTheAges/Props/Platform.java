package com.RJN.ThroughTheAges.Props;

import com.RJN.ThroughTheAges.Actor.GameActor;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Platform extends GameActor {

    public Platform(Texture texture, float x, float y, float width, float height) {
        super(new TextureRegion(getRepeatingTexture(texture)), x, y, width, height);
    }

    private static Texture getRepeatingTexture(Texture texture){
        texture.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);
        return texture;
    }
}
