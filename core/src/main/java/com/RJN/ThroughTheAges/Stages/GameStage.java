package com.RJN.ThroughTheAges.Stages;

import com.RJN.ThroughTheAges.Actor.GameActor;
import com.RJN.ThroughTheAges.Actor.Player;
import com.RJN.ThroughTheAges.Props.Platform;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.Viewport;
import space.earlygrey.shapedrawer.ShapeDrawer;

import java.util.ArrayList;

import static com.badlogic.gdx.Gdx.graphics;

public class GameStage extends Stage{
    protected Player player;
    public static final Texture whiteTexture = new Texture(Gdx.files.internal("textures/1WhitePixel.png"));
    private Platform ground;

    public GameStage(Viewport viewport, World world) {
        super(viewport);
        player = new Player();
        addListener(new inListener());
        //createGroundBody(world);
        //ground = new Platform(world, 0, 0,new Texture(Gdx.files.internal("textures/ground.png")), getWidth()*2, 20f);
        ground = new Platform(new Texture(Gdx.files.internal("textures/ground.png")), 0, 0, graphics.getWidth(), 20);
        addActor(ground);
        addActor(player);
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

    public void act(float delta){
        //super.act();
        //If actor are moving ticking twice, try removing this loop
        for(Actor a : getActors()){
            a.act(delta);
        }
        callHit();
    }

    private void callHit(){
        ArrayList<GameActor> actors = new ArrayList<>();
        for(Actor a : getActors()){
            if(a instanceof GameActor){
                actors.add((GameActor) a);
            }
        }
        for(GameActor a : actors){
            a.clearTouchingState();
            for(GameActor b : actors){
                if(a.collidesWith(b) && a!=b){
                    a.hit(b);
                }
            }
        }
    }
}
