package com.putri.frontend;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class Ground {

    public static final float GROUND_HEIGHT = 50f;

    private Rectangle collider;

    public Ground() {
        collider = new Rectangle(0, 0, Gdx.graphics.getWidth() * 2f, GROUND_HEIGHT);
    }

    public void update(float cameraX) {
        collider.setPosition(cameraX - Gdx.graphics.getWidth() / 2f - 500, 0);
        collider.width = Gdx.graphics.getWidth() * 2f;
    }

    public boolean isColliding(Rectangle playerCollider){
        if(collider.overlaps(playerCollider)){
            return true;
        } else {
            return false;
        }
    }

    public float getTopY() {
        return GROUND_HEIGHT;
    }

    public void renderShape(ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(0.5f, 0.5f, 0.5f, 1f);
        shapeRenderer.rect(collider.x, collider.y, collider.width, collider.height);
    }
}
