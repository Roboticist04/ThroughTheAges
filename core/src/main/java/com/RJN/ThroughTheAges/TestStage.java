package com.RJN.ThroughTheAges;

import com.RJN.ThroughTheAges.Actor.Player;
import com.RJN.ThroughTheAges.Actor.PushBox;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.utils.viewport.FitViewport;
import space.earlygrey.shapedrawer.ShapeDrawer;

import static com.badlogic.gdx.Gdx.graphics;

public class TestStage extends Stage {
    private static final Texture whiteTexture = new Texture(Gdx.files.internal("textures/1WhitePixel.png"));
    private Player player;
    private Body groundBody;
    private PushBox Box;

    public TestStage(Player player, World world){
        super(new FitViewport(1920,1080));
        //addActor(new Player());
        createGroundBody(world);
        this.player = player;
        addActor(player);

    }

    public void createGroundBody(World world){
        // Create our body definition
        BodyDef groundBodyDef = new BodyDef();
// Set its world position
        groundBodyDef.position.set(new Vector2(0, 0));

// Create a body from the definition and add it to the world
        groundBody = world.createBody(groundBodyDef);

// Create a polygon shape
        PolygonShape groundBox = new PolygonShape();
// Set the polygon shape as a box which is twice the size of our view port and 20 high
// (setAsBox takes half-width and half-height as arguments)
        groundBox.setAsBox(getCamera().viewportWidth, 20.0f);
// Create a fixture from our polygon shape and add it to our ground body
        groundBody.createFixture(groundBox, 0.0f);
// Clean up after ourselves
        groundBox.dispose();
    }

    public void act(){

    }

    public void draw(){
        getBatch().begin();
        ShapeDrawer shapeDrawer = new ShapeDrawer(getBatch(), new TextureRegion(whiteTexture));
        shapeDrawer.setColor(new Color(0,0,1,1));
        shapeDrawer.filledRectangle(0,0,graphics.getWidth(),graphics.getHeight());
        shapeDrawer.setColor(new Color(0,1,0,1));
        shapeDrawer.filledRectangle(0,0,getCamera().viewportWidth, 40.0f);
        getBatch().end();
        super.draw();
    }


}
