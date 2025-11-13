package com.putri.frontend;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Background {

    private Texture backgroundTexture;
    private TextureRegion backgroundRegion;
    private float width;
    private float height;
    private float currentCameraX = 0f;

    public Background() {
        backgroundTexture = new Texture(Gdx.files.internal("background.png"));
        backgroundRegion = new TextureRegion(backgroundTexture);
        width = 2688f;
        height = 1536f;
    }

    public void update(float cameraX) {
        this.currentCameraX = cameraX;
    }

    public void render(SpriteBatch batch) {
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();

        float scale = screenHeight / height;
        float scaledWidth = width * scale;
        float scaledHeight = height * scale;

        float startX = currentCameraX - screenWidth / 2f;

        float firstTileX = (float) (Math.floor(startX / scaledWidth) * scaledWidth);

        int numTiles = (int) Math.ceil(screenWidth / scaledWidth) + 2;

        for (int i = 0; i < numTiles; i++) {
            float tileX = firstTileX + (i * scaledWidth);
            batch.draw(backgroundRegion, tileX, 0, scaledWidth, scaledHeight);
        }
    }


    public void dispose() {
        if (backgroundTexture != null) {
            backgroundTexture.dispose();
        }
    }
}
