package com.RJN.ThroughTheAges.Actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Player extends GameActor {
    //private Sprite sprite;
    private static final float speed = 5f;
    //private Body body;

    public Player () {
        super(new Sprite(new Texture(Gdx.files.internal("Textures/Player.png"))),20, 20, 0.3f, 0.3f);
        //super(world,new Sprite(new Texture(Gdx.files.internal("Textures/Player.png"))), 60, 60,0.3f,0.3f);
        //Texture texture = new Texture("textures/Player.png");
        //setBounds(sprite.getX()*sprite.getScaleX(), sprite.getY()*sprite.getScaleY(),sprite.getWidth()*sprite.getScaleX(),sprite.getHeight()*sprite.getScaleY());
    }

    public void moveUp(){
        //setY(getY()+speed);
        //body.applyLinearImpulse(0f,speed,getX()-(getWidth()/2),getY()-(getHeight()/2),true);
    }

    public void moveLeft(){
        setX(getX()-speed);
    }

    public void moveRight(){
        setX(getX()+speed);
    }

}
