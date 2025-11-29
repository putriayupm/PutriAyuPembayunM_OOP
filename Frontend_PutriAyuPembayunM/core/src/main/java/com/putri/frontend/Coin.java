package com.putri.frontend;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Pool;

public class Coin implements Pool.Poolable {
    private Vector2 position;
    private Rectangle collider;
    private boolean active;
    private float radius = 15f;
    private float bobOffset;
    private float bobSpeed = 10f;

    public Coin() {
        position = new Vector2();
        collider = new Rectangle(0, 0, 30, 30);
        active = false;
    }

    public void init(float x, float y) {
        position.set(x, y);
        collider.setPosition(x, y);
        active = true;
        bobOffset = 0f;
    }

    @Override
    public void reset() {
        position.set(0, 0);
        active = false;
        bobOffset = 0f;
    }

    public void update(float delta) {
        if (!active) return;

        bobOffset += bobSpeed * delta;
        float drawY = position.y + (float) (Math.sin(bobOffset) * 5f);
        collider.setPosition(position.x, drawY);
    }

    public void renderShape(ShapeRenderer shapeRenderer) {
        if (!active) return;

        float drawY = position.y + (float) (Math.sin(bobOffset) * 5f);

        shapeRenderer.setColor(1f, 1f, 0f, 1f);
        shapeRenderer.circle(position.x + radius, drawY + radius, radius);
    }

    public boolean isColliding(Rectangle playerCollider) {
        return active && collider.overlaps(playerCollider);
    }

    public boolean isOffScreenCamera(float cameraLeftX) {
        return position.x + (radius * 2) < cameraLeftX;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }
}
