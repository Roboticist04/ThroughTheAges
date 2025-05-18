package com.RJN.ThroughTheAges.Actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Player extends GameActor {
    //private Sprite sprite;
    private static final float speed = 2f;
    private static final float jumpStrength = 6f;
    private static final float maxHorizontalSpeed = 5f;
    private float yVelocity;
    private float lefVelocity;
    private float rightVelocity;
    //private Body body;

    public Player () {
        super(new TextureRegion(new Texture(Gdx.files.internal("Textures/Player.png"))),20, 20,29.4f,59.7f);
        //super(world,new Sprite(new Texture(Gdx.files.internal("Textures/Player.png"))), 60, 60,0.3f,0.3f);
        //Texture texture = new Texture("textures/Player.png");
        //setBounds(sprite.getX()*sprite.getScaleX(), sprite.getY()*sprite.getScaleY(),sprite.getWidth()*sprite.getScaleX(),sprite.getHeight()*sprite.getScaleY());
        yVelocity = 0;
        lefVelocity = 0;
        rightVelocity = 0;
    }

    public void moveUp(){
        //setY(getY()+speed);
        //body.applyLinearImpulse(0f,speed,getX()-(getWidth()/2),getY()-(getHeight()/2),true);
        if(!mayMoveDown){
            setY(getY()+5);
            yVelocity = jumpStrength;
            mayMoveUp = true;
        }
    }

    public void moveLeft(){
        //setX(getX()-speed);
        lefVelocity += touchingSurface ? speed:(0.5f*speed);
        lefVelocity = Math.min(lefVelocity,maxHorizontalSpeed);
    }

    public void moveRight(){
        //setX(getX()+speed);
        rightVelocity += touchingSurface ? speed:(0.5f*speed);
        rightVelocity = Math.min(rightVelocity,maxHorizontalSpeed);
    }

    public void act(float deltaTime){
        if((yVelocity<=0.1 && mayMoveDown)||(yVelocity>0&&mayMoveUp)) {
            setY(getY() + yVelocity);
            yVelocity -= 0.1f;
        }
        else{
            yVelocity = 0;
        }

        if (mayMoveRight) {
            setX(getX()+rightVelocity);
            rightVelocity = Math.max(0, rightVelocity-(touchingSurface ? 0.8f:0.5f));
        }
        else{
            rightVelocity = 0;
        }

        if(mayMoveLeft) {
            setX(getX() - lefVelocity);
            lefVelocity = Math.max(0, lefVelocity - (touchingSurface ? 0.8f : 0.5f));
        }
        else{
            lefVelocity = 0;
        }

        //xVelocity = xVelocity+((xVelocity<0 ? (touchingSurface ? 0.2f:0.1f):(touchingSurface ? -0.2f:-0.1f)));
    }
}
