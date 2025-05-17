package com.RJN.ThroughTheAges.Actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Player extends Actor {
    private Sprite sprite;
    private static final int speed = 15;
    //private Body body;

    public Player () {
        //super(world,new Sprite(new Texture(Gdx.files.internal("Textures/Player.png"))), 60, 60,0.3f,0.3f);
        sprite = new Sprite(new Texture("textures/Player.png"));
        setBounds(sprite.getX()*sprite.getScaleX(), sprite.getY()*sprite.getScaleY(),sprite.getWidth()*sprite.getScaleX(),sprite.getHeight()*sprite.getScaleY());
    }

    public void moveUp(){
        setY(getY()+speed);
        //body.applyLinearImpulse(0f,speed,getX()-(getWidth()/2),getY()-(getHeight()/2),true);
    }

    public void moveLeft(){

    }

    public void moveRight(){
        setX(getX()+speed);
    }

}
