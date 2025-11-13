package com.putri.frontend.observers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ScoreUIObserver implements Observer{
    private BitmapFont font;
    private SpriteBatch batch;

    public ScoreUIObserver(){
        font = new BitmapFont();
        font.getData().setScale(1.5f);
        font.setColor(Color.WHITE);
        batch = new SpriteBatch();
    }

    @Override
    public void update(int score) {
        System.out.println("Score diperbarui: " + score);
    }

    public void render(SpriteBatch batch, int score){
        float screenHeight = Gdx.graphics.getHeight();

        float marginX = 30f;
        float marginY = 40f;

        font.draw(batch, "Score: " + score, marginX, screenHeight - marginY);
    }

    public void dispose() {
        font.dispose();
        batch.dispose();
    }
}
