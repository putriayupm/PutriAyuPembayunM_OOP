package com.putri.frontend;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player {
    private Vector2 position;
    private Vector2 velocity;
    private float gravity = 2000f;
    private float force = 4500f;
    private float maxVerticalSpeed = 700f;
    private Rectangle collider;
    private float width = 64f;
    private float height = 64f;

    private float baseSpeed = 300f;
    private float distanceTraveled = 0f;

    public Player(Vector2 startPosition) {
        this.position = new Vector2(startPosition);
        this.velocity = new Vector2(baseSpeed, 0);
        this.collider = new Rectangle(position.x, position.y, width, height);
    }

    public void  update(float delta, boolean isFlying){
        updateDistanceAndSpeed(float delta);
        updatePosition(float delta);
        applyGravity(float delta);

        if (isFlying) {
            fly(delta);
        }
    }

    private void updateDistanceAndSpeed(float delta) {
        distanceTraveled += velocity.x * delta;
    }

    private void updatePosition(float delta){
        position.x += velocity.x * delta;
        position.y += velocity.y * delta;

        collider.setPosition(position.x, position.y);
    }

    private void applyGravity(float delta){

    }

    private void fly (float delta){
        velocity.y += force * delta;
    }

}
