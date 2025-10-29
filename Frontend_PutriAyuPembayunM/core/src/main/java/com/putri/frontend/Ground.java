package com.putri.frontend;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class Ground {
    private static final float GROUND_HEIGHT = 50f;
    private Rectangle collider;

    public void ground (){
        float groundWidth = Gdx.graphics.getWidth() * 2;
        this.collider = new Rectangle(0, 0, groundWidth, GROUND_HEIGHT);

    }

    public void update(float cameraX){
        float groundX = cameraX - Gdx.graphics.getWidth() / 2f - 500;
        float groundY = 0;
        float groundWidth = Gdx.graphics.getWidth() * 2;

        collider.setPosition(groundX, groundY);
        collider.setWidth(groundWidth);
    }

    public boolean isColliding(Rectangle playerCollider){
        return collider.overlaps(playerCollider);
    }

    public float getTopY(){
        return GROUND_HEIGHT;
    }

    public void renderShape(ShapeRenderer shapeRenderer){
        shapeRenderer.setColor(0.5f, 0.5f, 0.5f, 1f);
        shapeRenderer.rect(collider.x, collider.y, collider.width, collider.height);
    }
}
