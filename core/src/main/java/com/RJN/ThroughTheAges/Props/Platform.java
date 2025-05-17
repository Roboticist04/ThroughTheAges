package com.RJN.ThroughTheAges.Props;

import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Platform extends Actor {

    public Platform(World world, int x, int y, Texture texture, float width, float height) {
        //super(world, new Sprite(getRepeatingTexture(texture)), x, y, (width/texture.getWidth()),(height/texture.getHeight()));
    }

    public Platform(World world, int x, int y, Texture texture){
        //super(world,new Sprite(getRepeatingTexture(texture)), x, y);
    }

    private static Texture getRepeatingTexture(Texture texture){
        texture.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);
        return texture;
    }
}
