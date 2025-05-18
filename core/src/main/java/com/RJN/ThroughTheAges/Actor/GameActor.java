package com.RJN.ThroughTheAges.Actor;

import com.RJN.ThroughTheAges.Stages.GameStage;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import space.earlygrey.shapedrawer.ShapeDrawer;

public class GameActor extends Actor {
    //private Sprite sprite;
    private TextureRegion texture;
    protected boolean touchingSurface;
    protected boolean mayMoveDown;
    protected boolean mayMoveUp;
    protected boolean mayMoveRight;
    protected boolean mayMoveLeft;
    private static final float collisionFudge = 10f;
    protected static final boolean drawDebug = true;

    protected GameActor(TextureRegion region, float x, float y, float width, float height){
        //setX(x);
        //setY(y);
        setBounds(x,y,width,height);
        this.texture = region;
    }

    protected GameActor(TextureRegion region, float x, float y){
        this(region,x,y,region.getRegionWidth(),region.getRegionHeight());
    }

    public void draw(Batch batch, float parentAlpha){
        if (texture != null) {
            batch.draw(texture,getX(),getY(),getWidth(),getHeight());
        }
        if(drawDebug){
            ShapeDrawer shape = new ShapeDrawer(batch, new TextureRegion(GameStage.whiteTexture));
            shape.rectangle(getX(),getY(),getWidth(),getHeight());
        }
    }

    public boolean collidesWith(Actor actor){
        Rectangle rect1 = new Rectangle(getX(),getY(),getWidth(),getHeight());
        Rectangle rect2 = new Rectangle(actor.getX(),actor.getY(),actor.getWidth(),actor.getHeight());
        return rect1.overlaps(rect2);
    }

    public void onCollide(Actor a){}

    public void updateAllowedMoves(Actor a){
        Rectangle otherActorRect = new Rectangle(a.getX(),a.getY(),a.getWidth(),a.getHeight());
        Rectangle thisActorRect = new Rectangle(getX(),getY(),getWidth(),getHeight());
        boolean objectsTouching = thisActorRect.overlaps(otherActorRect);

        mayMoveLeft = mayMoveLeft && !((getX() - collisionFudge <= a.getX() + a.getWidth() && getX() + collisionFudge >= a.getX() + a.getWidth()) && objectsTouching);
        mayMoveRight = mayMoveRight && !(((getX()+getWidth())-collisionFudge<=a.getX()&&(getX()+getWidth())+collisionFudge>=a.getX())&&objectsTouching);
        mayMoveDown = mayMoveDown && !(getY() - collisionFudge <= a.getY() + a.getHeight() && getY() + collisionFudge >= a.getY() + a.getHeight() && objectsTouching);
        mayMoveUp = mayMoveUp && !(((getY()+getHeight())-collisionFudge<=a.getY()&&(getY()+getHeight())+collisionFudge>=a.getY())&&objectsTouching);
    }

    public void resetAllowedMoves(){
        //touchingSurface = false;
        //mayMoveDown = false;
        mayMoveLeft = true;
        mayMoveRight = true;
        mayMoveUp = true;
        mayMoveDown = true;
    }

    public static class movingPlat {
        private Sprite sprite;
        private Vector2 position;
        private Vector2 velocity;
        private Vector2 pointA, pointB;
        private boolean movingToB;

        public movingPlat(Vector2 pointA, Vector2 pointB, float speed) {
            this.sprite = new Sprite(new Texture("Textures/Platform.png"));
            this.position = new Vector2(pointA);
            this.velocity = new Vector2(speed, 0);
            this.pointA = pointA;
            this.pointB = pointB;
            this.movingToB = true;
            this.sprite.setSize(60, 10); // Adjust size as needed
        }

        public void update(float deltaTime) {
            position.add(velocity.x * deltaTime, velocity.y * deltaTime);

            if (position.epsilonEquals(pointB, 1f)) {
                movingToB = false;
                velocity.scl(-1); // Reverse direction
            } else if (position.epsilonEquals(pointA, 1f)) {
                movingToB = true;
                velocity.scl(-1); // Reverse direction
            }

            sprite.setPosition(position.x - sprite.getWidth() / 2, position.y - sprite.getHeight() / 2);
        }

        public void render(SpriteBatch batch) {
            sprite.draw(batch);
        }

        public void handlePlayerCollision(Player player) {
            Rectangle platformBounds = new Rectangle(position.x - sprite.getWidth() / 2, position.y - sprite.getHeight() / 2, sprite.getWidth(), sprite.getHeight());
            Rectangle playerBounds = new Rectangle(player.getX(), player.getY(), player.getWidth(), player.getHeight());

            if (platformBounds.overlaps(playerBounds)) {
                // Determine the direction of collision and adjust player's position accordingly
                if (playerBounds.y + playerBounds.height <= platformBounds.y + platformBounds.height) {
                    // Player is above the platform
                    player.setPosition(platformBounds.x - playerBounds.width / 2, platformBounds.y + platformBounds.height);
                }
            }
        }
    }
}
