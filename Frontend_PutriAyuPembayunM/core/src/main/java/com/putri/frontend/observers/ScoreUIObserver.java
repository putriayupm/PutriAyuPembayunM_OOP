package com.putri.frontend.observers;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ScoreUIObserver implements Observer{
    private BitmapFont font;
    private SpriteBatch batch;

    public ScoreUIObserver (BitmapFont font, SpriteBatch batch){
        this.font = new BitmapFont();
        this.batch = new SpriteBatch();
    }

    @Override
    public void update(int score) {
        System.out.println("Skor terbaru: ");
    }

    public void render(int score){

    }

    public void dispose(){

    }
}
