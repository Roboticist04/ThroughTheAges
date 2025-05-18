package com.RJN.ThroughTheAges.Actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import java.awt.*;

public class Player extends GameActor {
    //private Sprite sprite;
    private static float speed = 2.75f;
    private static final float jumpStrength = 6f;
    private float yVelocity;
    private float xVelocity;
    private float lefVelocity;
    private float rightVelocity;
    private Rectangle bounds;
    private boolean onGround;
    private Vector2 position;
    private Vector2 velocity;
    private Sprite sprite;
    private Vector2 pointA, pointB;
    private boolean movingToB;
    //private Body body;

    public Player () {
        super(new TextureRegion(new Texture(Gdx.files.internal("Textures/Player.png"))),20, 20,29.4f,59.7f);
        //super(world,new Sprite(new Texture(Gdx.files.internal("Textures/Player.png"))), 60, 60,0.3f,0.3f);
        //Texture texture = new Texture("textures/Player.png");
        //setBounds(sprite.getX()*sprite.getScaleX(), sprite.getY()*sprite.getScaleY(),sprite.getWidth()*sprite.getScaleX(),sprite.getHeight()*sprite.getScaleY());
        yVelocity = 0;
        xVelocity = 0;

        this.sprite = new Sprite(new Texture("Textures/Player.png"));
        this.position = new Vector2(100, 100); // Starting position
        this.velocity = new Vector2(0, 0);
        this.speed = 200; // Adjust speed as needed
        this.onGround = false;
        this.bounds = new Rectangle((int ) position.x, (int)position.y, (int)sprite.getWidth(), (int)sprite.getHeight());
    }

    public void moveUp(){
        //setY(getY()+speed);
        //body.applyLinearImpulse(0f,speed,getX()-(getWidth()/2),getY()-(getHeight()/2),true);
        if(touchingSurface){
            setY(getY()+5);
            yVelocity = jumpStrength;
            touchingSurface = false;
        }
    }

    public void moveLeft(){
        //setX(getX()-speed);
        lefVelocity += touchingSurface ? speed:(0.25f*speed);
    }

    public void moveRight(){
        //setX(getX()+speed);
        rightVelocity += touchingSurface ? speed:(0.25f*speed);
    }

    public void act(float deltaTime){
        if(!touchingSurface) {
            setY(getY() + yVelocity);
            yVelocity -= 0.1f;
        }
        else{
            yVelocity = 0;
        }
        setX(getX()-lefVelocity);
        setX(getX()+rightVelocity);
        lefVelocity = Math.max(0, lefVelocity-(touchingSurface ? 1.75f:1.25f));
        rightVelocity = Math.max(0, rightVelocity-(touchingSurface ? 1.75f:1.25f));
        //xVelocity = xVelocity+((xVelocity<0 ? (touchingSurface ? 0.2f:0.1f):(touchingSurface ? -0.2f:-0.1f)));
    }
    public void update(float deltaTime) {
        position.add(velocity.x * deltaTime, velocity.y * deltaTime);

        if (position.epsilonEquals(pointB, 1f)) {
            movingToB = false;
            velocity.scl(-1); // Reverse direction
        } else if (position.epsilonEquals(pointA, 1f)) {
            movingToB = true;
            velocity.scl(-1); // Reverse direction
        }

        bounds.setPosition(position.x, position.y);
        sprite.setPosition(position.x, position.y);
    }
    public Rectangle getBounds() {
        return bounds;
    }
    public void render(SpriteBatch batch) {
        sprite.draw(batch);
    }
    public com.badlogic.gdx.math.Rectangle getBoundingRectangle() {
        return sprite.getBoundingRectangle();
    }
}
