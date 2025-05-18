package com.RJN.ThroughTheAges;

import com.RJN.ThroughTheAges.Stages.GameStage;
import com.RJN.ThroughTheAges.Stages.Stage2;
import com.RJN.ThroughTheAges.Stages.Stage1;
import com.RJN.ThroughTheAges.Stages.Stage3;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.ScreenUtils;

import java.lang.reflect.Constructor;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter{
    private Stage stage;
    private Skin skin;
    private PolygonSpriteBatch batch;
    private Class[] stages;
    private int stageNumber;

    @Override
    public void create() {
        stage = new Stage();
        stages = new Class[4];
        stages[0] = null;
        stages[1] = Stage1.class;
        stages[2] = Stage2.class;
        stages[3] = Stage3.class;
        stageNumber = 0;
        skin = new Skin(Gdx.files.internal("ui/uiskin.json"));
        batch = new PolygonSpriteBatch();
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
    }


    @Override
    public void resize(int width, int height) {
        //stage.getViewport().update(width, height);
        stage.getViewport().update(width, height);
    }

    @Override
    public void dispose() {
        //stage.dispose();
        stage.dispose();
        skin.dispose();
    }

    public void advanceStage(){
        stageNumber++;
        stage.dispose();
        try {
            Constructor<Stage> c =stages[stageNumber].getConstructor(this.getClass());
            stage = c.newInstance(this);
        }
        catch (Exception e){
            throw new IllegalStateException("Failed to construct next stage!");
        }
        Gdx.input.setInputProcessor(stage);
    }
}
