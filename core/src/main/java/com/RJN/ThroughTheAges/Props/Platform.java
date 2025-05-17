package com.RJN.ThroughTheAges.Props;

import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.World;

public class Platform extends StaticCollidableProp {

    public Platform(World world, int x, int y, Texture texture) {
        super(world, new Sprite(texture), x, y);
    }
}
