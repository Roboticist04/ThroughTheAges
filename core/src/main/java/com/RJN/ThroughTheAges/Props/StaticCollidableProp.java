package com.RJN.ThroughTheAges.Props;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class StaticCollidableProp extends Actor {
    protected World world;
    protected Sprite sprite;
    protected Body body;

    protected StaticCollidableProp(World world, Sprite sprite, int x, int y){
        this.world = world;
        sprite.setX(x);
        sprite.setY(y);
        setScale(sprite.getScaleX(),sprite.getScaleY());
        setX(x);
        setY(y);
        setBounds(x*getScaleX(),y*getScaleY(),sprite.getWidth()*getScaleX(),sprite.getHeight()*getScaleY());
        this.body = defineBody(world);
        this.sprite = sprite;
        body.setTransform(x+(0.5f*getWidth()),y+(0.5f*getHeight()),getRotation());
        //this.sprite.setScale(getScaleX(),getScaleY());
    }

    protected StaticCollidableProp(World world, Sprite sprite, int startX, int startY, float xScale, float yScale){
        //sprite.setScale(xScale,yScale);
        this(world,setSpriteScale(sprite,xScale,yScale),startX,startY);
    }

    private static Sprite setSpriteScale(Sprite sprite,float xScale, float yScale){
        sprite.setScale(xScale,yScale);
        return sprite;
    }

    protected Body defineBody(World world){
        // First we create a body definition
        BodyDef bodyDef = new BodyDef();
        // We set our body to dynamic, for something like ground which doesn't move we would set it to StaticBody
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.fixedRotation = true;
        // Set our body's starting position in the world
        bodyDef.position.set(getX(), getY());

        // Create our body in the world using our body definition
        Body body = world.createBody(bodyDef);

        PolygonShape polyShape = new PolygonShape();
        //System.out.println("Width: "+getWidth()+", Height: "+getHeight());
        polyShape.setAsBox(getWidth()/2,getHeight()/2);

        // Create a fixture definition to apply our shape to
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = polyShape;
        fixtureDef.density = 0.001f;
        fixtureDef.friction = 0.8f;
        fixtureDef.restitution = 0f; // Make it bounce a little bit

        // Create our fixture and attach it to the body
        body.createFixture(fixtureDef);
        //System.out.println("Player mass: "+body.getMass());

        // Remember to dispose of any shapes after you're done with them!
        // BodyDef and FixtureDef don't need disposing, but shapes do.
        polyShape.dispose();
        return body;
    }

    @Override
    public void draw(Batch batch, float parentAlpha){
        //batch.draw(sprite,sprite.getX(),sprite.getY(),getWidth(),getHeight());
        sprite.draw(batch);
    }
}
