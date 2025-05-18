package com.RJN.ThroughTheAges.Actor;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

    public class MovingPlatform2 extends GameActor {
        //private Sprite sprite;
        //private Vector2 position;
        //private Vector2 velocity;
        //private Vector2 pointA, pointB;
        private boolean movingToB;
        private float speed;
        private float startX;
        private float endX;

        public MovingPlatform2(Texture texture, float startX, float endX, float y, float width, float height, float speed, Player player) {
            super(new TextureRegion(texture),startX,y,width,height, player);
            if(startX > endX){
                float temp = startX;
                startX = endX;
                endX = temp;
            }
            this.speed = speed;
            this.startX = startX;
            this.endX = endX;
            this.movingToB = true;
        }

        public void act(float deltaTime) {
            setX(getX()+(speed*deltaTime));
            if(getX() > endX || getX()<startX){
                speed*=-1;
            }
            if(touchingPlayer){
                player.setX(player.getX()+(speed*deltaTime));
            }
        }

    }
