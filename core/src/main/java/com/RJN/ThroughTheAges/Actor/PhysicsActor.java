package com.RJN.ThroughTheAges.Actor;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Affine2;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class PhysicsActor extends Actor {
    protected World world;
    protected Sprite sprite;
    protected Body body;

    protected PhysicsActor(World world, Sprite sprite, int startX, int startY){
        this.world = world;
        this.sprite = sprite;
        sprite.setX(startX);
        sprite.setY(startY);
        setBounds(startX,startY,sprite.getWidth(),sprite.getHeight());
        this.body = defineBody(world);
    }

    protected Body defineBody(World world){
        // First we create a body definition
        BodyDef bodyDef = new BodyDef();
        // We set our body to dynamic, for something like ground which doesn't move we would set it to StaticBody
        bodyDef.type = BodyDef.BodyType.DynamicBody;
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
    public void act(float delta){
        Vector2 position = body.getPosition();
        float hw = sprite.getWidth() / 2.0f;
        float hh = sprite.getHeight() / 2.0f;
        float a = body.getAngle() * MathUtils.radiansToDegrees;
        float x = position.x - hw;
        float y = position.y - hh;
        sprite.setPosition(x, y);
        sprite.setRotation(a);
        setX(x);
        setY(y);
        setRotation(a);
    }

    public void draw(Batch batch, float parentAlpha){
        batch.draw(sprite,getX(),getY());
    }
}
