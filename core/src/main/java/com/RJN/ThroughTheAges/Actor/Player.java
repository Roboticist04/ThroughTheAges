package com.RJN.ThroughTheAges.Actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

public class Player extends PhysicsActor {
    //private Sprite sprite;
    //private Body body;

    public Player (World world) {
        super(world,new Sprite(new Texture(Gdx.files.internal("Textures/Player.png"))), 60, 60,0.3f,0.3f);
        setBounds(sprite.getX()*sprite.getScaleX(), sprite.getY()*sprite.getScaleY(),sprite.getWidth()*sprite.getScaleX(),sprite.getHeight()*sprite.getScaleY());
    }

    public void moveUp(){
        //setY(getY()+speed);
        //body.applyLinearImpulse(0f,speed,getX()-(getWidth()/2),getY()-(getHeight()/2),true);
        //Nasty Hack
            body.applyForceToCenter(new Vector2(0, 500000000), true);
    }

    public void moveLeft(){
        body.applyForceToCenter(-50000,0,true);
    }

    public void moveRight(){
        //setX(getX()+speed);
        body.applyForceToCenter(50000,0,true);
    }
}
