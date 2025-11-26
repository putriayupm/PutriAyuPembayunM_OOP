package com.putri.frontend;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Coin {
    private Vector2 position;
    private Rectangle collider;
    private float radius = 15f;
    private boolean active;

    private float bobOffset;
    private float bobSpeed;

    public Coin (Vector2 startPosition){
        this.position = new Vector2(startPosition);
        this.collider = new Rectangle(position.x - radius,position.y - radius,radius * 2, radius * 2);
        this.active = true;
        this.bobOffset = 0f;
        this.bobSpeed = 3f;
    }


    public void update(float delta){
        bobOffset = bobSpeed * delta;
        collider.setPosition(position.x - radius, position.y - radius + (float)(Math.sin(bobOffset) * 5f));

    }

    public void renderShape(ShapeRenderer shapeRenderer){
        if (!active){
            float drawY = position.y + (float)(Math.sin(bobOffset) * 5f);
            shapeRenderer.circle(position.x, drawY, radius);
            shapeRenderer.setColor(1f, 1f, 0f, 1f);
        }
    }

    public boolean isColliding(Rectangle playerCollider){
        return active && collider.overlaps(playerCollider);
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setPosition(float x, float y) {
        this.position.set(x, y);
        this.collider.setPosition(x - radius, y - radius);
    }

    public Vector2 getPosition() {
        return position;
    }
}
