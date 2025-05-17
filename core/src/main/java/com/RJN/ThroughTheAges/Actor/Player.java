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
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class Player extends Actor {
    private float speed;
    private Sprite sprite;
    private Body body;

    public Player (World world) {
        createBody(world);
        TextureRegion region = new TextureRegion(new Texture(Gdx.files.internal("textures/redSword.png")));
        setBounds(region.getRegionX(), region.getRegionY(),
            region.getRegionWidth(), region.getRegionHeight());
        speed = 5;
        sprite = new Sprite(region);
    }

    protected void createBody(World world){
        // First we create a body definition
        BodyDef bodyDef = new BodyDef();
    // We set our body to dynamic, for something like ground which doesn't move we would set it to StaticBody
        bodyDef.type = BodyDef.BodyType.DynamicBody;
    // Set our body's starting position in the world
        bodyDef.position.set(30, 60);

    // Create our body in the world using our body definition
        body = world.createBody(bodyDef);

    // Create a circle shape and set its radius to 6
        CircleShape circle = new CircleShape();
        circle.setRadius(6f);

    // Create a fixture definition to apply our shape to
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = circle;
        fixtureDef.density = 0.5f;
        fixtureDef.friction = 0.4f;
        fixtureDef.restitution = 0f; // Make it bounce a little bit

    // Create our fixture and attach it to the body
        Fixture fixture = body.createFixture(fixtureDef);

    // Remember to dispose of any shapes after you're done with them!
    // BodyDef and FixtureDef don't need disposing, but shapes do.
        circle.dispose();
    }

    @Override
    public void draw (Batch batch, float parentAlpha) {
        Color color = getColor();
        batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
        //batch.draw(resgion, getX(), getY(), getOriginX(), getOriginY(),getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
        sprite.draw(batch);
    }

    public void moveUp(){
        //setY(getY()+speed);
        //body.applyLinearImpulse(0f,speed,getX()-(getWidth()/2),getY()-(getHeight()/2),true);
        body.applyForceToCenter(0,500,true);
    }

    public void moveDown(){
        setY(getY()-speed);
    }

    public void moveLeft(){
        setX(getX()-speed);
    }

    public void moveRight(){
        setX(getX()+speed);
    }

    public void act(float delta){
        Vector2 position = body.getPosition();
        // Center body is center sprite here
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
}
