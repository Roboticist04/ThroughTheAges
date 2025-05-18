package com.RJN.ThroughTheAges.Actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Player extends GameActor {
    //private Sprite sprite;
    private static final float speed = 5f;
    private static final float jumpHeight = 200;
    private boolean canJump;
    //private Body body;

    public Player () {
        super(new TextureRegion(new Texture(Gdx.files.internal("Textures/Player.png"))),20, 20);
        canJump = false;
        //super(world,new Sprite(new Texture(Gdx.files.internal("Textures/Player.png"))), 60, 60,0.3f,0.3f);
        //Texture texture = new Texture("textures/Player.png");
        //setBounds(sprite.getX()*sprite.getScaleX(), sprite.getY()*sprite.getScaleY(),sprite.getWidth()*sprite.getScaleX(),sprite.getHeight()*sprite.getScaleY());
    }

    public void moveUp(){
        //setY(getY()+speed);
        //body.applyLinearImpulse(0f,speed,getX()-(getWidth()/2),getY()-(getHeight()/2),true);
        if(touchingSurface){
            setY(getY()+jumpHeight);
        }
    }

    public void moveLeft(){
        setX(getX()-speed);
    }

    public void moveRight(){
        setX(getX()+speed);
    }

    public void act(float deltaTime){
        if(!touchingSurface) {
            setY(getY() - 100 * deltaTime);
        }
    }
}
