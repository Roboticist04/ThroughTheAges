package com.RJN.ThroughTheAges.Props;

import com.RJN.ThroughTheAges.Actor.Player;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class KillingPlatform extends Platform {
    public KillingPlatform(Texture texture, float x, float y, float width, float height) {
        super(texture, x, y, width, height);
    }

    public KillingPlatform(Texture tex, float x, float y) {
        super(tex, x, y);
    }

    public void onCollide(Actor a){
        if(a instanceof Player){
            ((Player)(a)).die();
        }
    }
}
