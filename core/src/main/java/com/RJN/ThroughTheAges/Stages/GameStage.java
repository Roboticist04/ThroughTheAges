package com.RJN.ThroughTheAges.Stages;

import com.RJN.ThroughTheAges.Actor.Player;
import com.RJN.ThroughTheAges.Props.Platform;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;
import space.earlygrey.shapedrawer.ShapeDrawer;

import static com.badlogic.gdx.Gdx.graphics;

public class GameStage extends Stage{
    protected Player player;
    private static final Texture whiteTexture = new Texture(Gdx.files.internal("textures/1WhitePixel.png"));
    private Platform ground;

    public GameStage(Viewport viewport, World world) {
        super(viewport);
        player = new Player(world);
        addListener(new inListener());
        //createGroundBody(world);
        ground = new Platform(world, 0, 0,new Texture(Gdx.files.internal("textures/ground.png")), getWidth()*2, 20f);
        addActor(ground);
        setupEdgeCollision(world);
    }

    private void setupEdgeCollision(World world){
        //Left
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.fixedRotation = true;
        bodyDef.position.set(-10, 0);
        Body body = world.createBody(bodyDef);
        PolygonShape polyShape = new PolygonShape();
        polyShape.setAsBox(5, graphics.getHeight()/2f);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = polyShape;
        fixtureDef.density = 0.001f;
        fixtureDef.friction = 0.8f;
        fixtureDef.restitution = 0f;
        body.createFixture(fixtureDef);
        polyShape.dispose();

        //Right
        BodyDef bodyDef2 = new BodyDef();
        bodyDef2.type = BodyDef.BodyType.StaticBody;
        bodyDef2.fixedRotation = true;
        bodyDef2.position.set(-10, 0);
        Body body2 = world.createBody(bodyDef2);
        PolygonShape polyShape2 = new PolygonShape();
        polyShape.setAsBox(5, graphics.getHeight()/2f);
        FixtureDef fixtureDef2 = new FixtureDef();
        fixtureDef2.shape = polyShape2;
        fixtureDef2.density = 0.001f;
        fixtureDef2.friction = 0.8f;
        fixtureDef2.restitution = 0f;
        body.createFixture(fixtureDef2);
        polyShape2.dispose();
    }

    @Override
    public void draw(){
        getBatch().begin();
        ShapeDrawer shapeDrawer = new ShapeDrawer(getBatch(), new TextureRegion(whiteTexture));
        shapeDrawer.setColor(new Color(0,0,1,1));
        shapeDrawer.filledRectangle(0,0,graphics.getWidth(),graphics.getHeight());
        getBatch().end();
        super.draw();
    }

    private class inListener extends InputListener{
        public boolean keyUp (InputEvent event, int keycode) {
            if(keycode == Input.Keys.UP){
                player.moveUp();
                return true;
            }
            return false;
        }
    }

    public void processInputs(){
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            player.moveRight();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            player.moveLeft();
        }
    }
}
