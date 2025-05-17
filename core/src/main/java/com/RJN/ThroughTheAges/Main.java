package com.RJN.ThroughTheAges;

import com.RJN.ThroughTheAges.Actor.Player;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter{
    private Stage stage;
    private Skin skin;
    //private Player player;
    private World world;
    private float accumulator = 0;
    private final static float physicsStep = 0.1f;
    private static final int physicVelocityIterations = 600;
    private static final int physicsPositionIterations = 600;
    private PolygonSpriteBatch batch;
    private Box2DDebugRenderer debugRenderer;
    private Stage[] stages;
    private int stageNumber;


    @Override
    public void create() {
        world = new World(new Vector2(0, -9.8f), true);
        //stage = new GameStage(new FitViewport(160, 90), world);
        stage = new Stage();
        stages = new Stage[2];
        stages[0] = stage;
        stages[1] = new TestStage(world);
        stageNumber = 0;
        skin = new Skin(Gdx.files.internal("ui/uiskin.json"));
        //player = new Player(world);
        batch = new PolygonSpriteBatch();
        debugRenderer = new Box2DDebugRenderer();
        // We round the window position to avoid awkward half-pixel artifacts.
        // Casting using (int) would also work.
        stage.addActor(new MainMenu(skin,stage,this));
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render() {
        batch.begin();
        ScreenUtils.clear(0f, 0f, 0f, 1f);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
        BitmapFont font = new BitmapFont();
        font.draw(batch,"FPS: "+Gdx.graphics.getFramesPerSecond(),20,20);
        if(stage instanceof GameStage) {
            ((GameStage)(stage)).processInputs();
        }
        batch.end();
        debugRenderer.render(world,stage.getCamera().combined);
        updatePhysics(Gdx.graphics.getDeltaTime());
    }

    public void updatePhysics(float deltaTime){
        // fixed time step
        // max frame time to avoid spiral of death (on slow devices)
        float frameTime = Math.min(deltaTime, 0.25f);
        accumulator += frameTime;
        while (accumulator >= physicsStep) {
            world.step(physicsStep, physicVelocityIterations, physicsPositionIterations);
            accumulator -= physicsStep;
        }
    }



    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height);
    }

    @Override
    public void dispose() {
        stage.dispose();
        skin.dispose();
    }

    public void advanceStage(){
        stageNumber++;
        stage = stages[stageNumber];
        Gdx.input.setInputProcessor(stage);
    }
}
