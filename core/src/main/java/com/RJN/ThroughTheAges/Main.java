package com.RJN.ThroughTheAges;

import com.RJN.ThroughTheAges.Stages.*;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.ScreenUtils;

import javax.swing.*;
import java.lang.reflect.Constructor;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter{
    private Stage stage;
    private Skin skin;
    private PolygonSpriteBatch batch;
    private Class[] stages;
    private int stageNumber;
    private static final int startingStage = 0;

    @Override
    public void create() {
        stage = new Stage();
        stages = new Class[5];
        stages[0] = null;
        stages[1] = Stage1.class;
        stages[2] = Stage2.class;
        stages[3] = Stage3.class;
        stages[4] = Stage4.class;
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
        if(stageNumber > stages.length-1){
            JOptionPane.showMessageDialog(null,"You win!");
        }
        else {
            try {
                Constructor<Stage> c = stages[stageNumber].getConstructor(this.getClass());
                stage = c.newInstance(this);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            Gdx.input.setInputProcessor(stage);
            for (int i = stageNumber; i < startingStage; i++) {
                advanceStage();
            }
        }
    }
}
