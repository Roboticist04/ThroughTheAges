package com.RJN.ThroughTheAges.Actor;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class MovingPlatform {
    private Sprite sprite;
    private Vector2 position;
    private Vector2 velocity;
    private Vector2 pointA, pointB;
    private boolean movingToB;

    public MovingPlatform(Vector2 pointA, Vector2 pointB, float speed) {
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
