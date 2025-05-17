package com.RJN.ThroughTheAges;

import com.RJN.ThroughTheAges.Actor.Player;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private Stage stage;
    private Skin skin;
    private Player player;
    private World world;
    private float accumulator = 0;
    private final float physicsStep = 0.1f;
    private final int physicVelocityIterations = 3;
    private final int physicsPositionIterations = 3;


    @Override
    public void create() {
        stage = new Stage(new FitViewport(160, 90));
        skin = new Skin(Gdx.files.internal("ui/uiskin.json"));
        world = new World(new Vector2(0, -1), true);
        player = new Player(world);
        // We round the window position to avoid awkward half-pixel artifacts.
        // Casting using (int) would also work.

        stage.addActor(new MainMenu(skin,stage,this));

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render() {
        ScreenUtils.clear(0f, 0f, 0f, 1f);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
        processInputs();
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

    public void processInputs(){
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            player.moveUp();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            player.moveDown();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            player.moveRight();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            player.moveLeft();
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
        stage = new TestStage(player, world);
    }
}
