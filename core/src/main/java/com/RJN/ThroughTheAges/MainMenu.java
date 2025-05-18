package com.RJN.ThroughTheAges;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

//import static java.awt.SystemColor.window;

public class MainMenu extends Window{
    //private Window window;
    private Main main;

    public MainMenu(Skin skin, Stage stage, Main main){
        super("Main Menu", skin, "border");
        setWidth(stage.getWidth());
        setHeight(stage.getHeight());
        this.main = main;
        defaults().pad(4f);
        add("ThroughTheAges").row();
        final TextButton button = new TextButton("Play", skin);
        button.pad(8f);
        button.addListener(new ChangeListener() {
            @Override
            public void changed(final ChangeEvent event, final Actor actor) {
                button.setText("Clicked.");
                main.advanceStage();
            }
        });
        add(button);
        pack();
        setPosition(MathUtils.roundPositive(stage.getWidth() / 2f - getWidth() / 2f),
            MathUtils.roundPositive(stage.getHeight() / 2f - getHeight() / 2f));
        addAction(Actions.sequence(Actions.alpha(0f), Actions.fadeIn(1f)));
    }
}
