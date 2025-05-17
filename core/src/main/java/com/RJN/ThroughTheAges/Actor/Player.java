package com.RJN.ThroughTheAges.Actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class Player extends PhysicsActor {
    private float speed;
    //private Sprite sprite;
    //private Body body;

    public Player (World world) {
        super(world,new Sprite(new Texture(Gdx.files.internal("Textures/Player.png"))), 60, 60);
        //TextureRegion region = new TextureRegion(new Texture(Gdx.files.internal("textures/Player.png")),500,500);
        //TextureRegion region = new TextureRegion(new Texture(Gdx.files.internal("Textures/Player.png")));
        //sprite = new Sprite(region,0,0,region.getRegionWidth(),region.getRegionHeight());
        sprite.setScale(0.5f,0.5f);
        /*setBounds(region.getRegionX(), region.getRegionY(),
            region.getRegionWidth(), region.getRegionHeight());*/
        setBounds(sprite.getX()*sprite.getScaleX(), sprite.getY()*sprite.getScaleY(),sprite.getWidth()*sprite.getScaleX(),sprite.getHeight()*sprite.getScaleY());
        //setWidth(500);
        //setHeight(500);
        speed = 5;

        //createBody(world);
    }

    protected void createBody(World world){
        // First we create a body definition
        BodyDef bodyDef = new BodyDef();
    // We set our body to dynamic, for something like ground which doesn't move we would set it to StaticBody
        bodyDef.type = BodyDef.BodyType.DynamicBody;
    // Set our body's starting position in the world
        bodyDef.position.set(300, 150);

    // Create our body in the world using our body definition
        body = world.createBody(bodyDef);

        PolygonShape polyShape = new PolygonShape();
        System.out.println("Width: "+getWidth()+", Height: "+getHeight());
        polyShape.setAsBox(getWidth()/2,getHeight()/2);

    // Create a fixture definition to apply our shape to
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = polyShape;
        fixtureDef.density = 0.001f;
        fixtureDef.friction = 0.8f;
        fixtureDef.restitution = 0f; // Make it bounce a little bit

    // Create our fixture and attach it to the body
        Fixture fixture = body.createFixture(fixtureDef);
        System.out.println("Player mass: "+body.getMass());

    // Remember to dispose of any shapes after you're done with them!
    // BodyDef and FixtureDef don't need disposing, but shapes do.
        polyShape.dispose();
    }

    //@Override
    /*public void draw (Batch batch, float parentAlpha) {
        Color color = getColor();
        batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
        //batch.draw(resgion, getX(), getY(), getOriginX(), getOriginY(),getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
        sprite.draw(batch);
    }*/

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
