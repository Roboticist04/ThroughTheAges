package com.RJN.ThroughTheAges.Actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.*;

public class PushBox extends PhysicsActor {

    public PushBox(World world, int startX, int startY) {
        super(world, new Sprite(new Texture(Gdx.files.internal("textures/pushbox.png"))), startX, startY);
    }
}
