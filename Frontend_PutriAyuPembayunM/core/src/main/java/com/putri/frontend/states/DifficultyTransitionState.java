package com.putri.frontend.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.putri.frontend.strategies.DifficultyStrategy;

public class DifficultyTransitionState implements GameState {
    private final GameStateManager gsm;
    private final PlayingState playingState;
    private final DifficultyStrategy newStrategy;

    private final BitmapFont font;
    private float timer = 2.0f;

    public DifficultyTransitionState(GameStateManager gsm, PlayingState playingState, DifficultyStrategy newStrategy) {
        this.gsm = gsm;
        this.playingState = playingState;
        this.newStrategy = newStrategy;
        this.font = new BitmapFont();
    }

    @Override
    public void update(float delta) {
        timer -= delta;

        if (timer <= 0) {
            playingState.setDifficulty(newStrategy);
            gsm.pop();
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        playingState.render(batch);

        batch.begin();

        String text1 = "DIFFICULTY INCREASED!";
        String text2 = newStrategy.getClass().getSimpleName();

        float centerX = Gdx.graphics.getWidth() / 2f;
        float centerY = Gdx.graphics.getHeight() / 2f;

        font.draw(batch, text1, centerX - 100, centerY + 20);
        font.draw(batch, text2,  centerX - 100, centerY - 10);

        batch.end();
    }

    @Override
    public void dispose() {
        font.dispose();
    }
}
