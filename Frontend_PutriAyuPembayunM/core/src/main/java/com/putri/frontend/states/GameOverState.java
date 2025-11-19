package com.putri.frontend.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameOverState implements GameState{
    private final GameStateManager gsm;
    private final BitmapFont font;

    public GameOverState(GameStateManager gsm){
        this.gsm = gsm;
        this.font = new BitmapFont();
    }

    public void update(float delta){
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            gsm.set(new PlayingState(gsm));
        }
    }


    public void render(SpriteBatch batch){
        batch.begin();

        String textGameOver = "GAME OVER";
        String textRestart = "Press SPACE to restart";

        GlyphLayout layout = new GlyphLayout(font, textGameOver);
        float x = (Gdx.graphics.getWidth() - layout.width) / 2;
        float y = (Gdx.graphics.getHeight() / 2f) + 50;
        font.draw(batch, textGameOver, x, y);

        layout.setText(font, textRestart);
        x = (Gdx.graphics.getWidth() - layout.width) / 2;
        y = (Gdx.graphics.getHeight() / 2f) - 10;
        font.draw(batch, textRestart, x, y);

        batch.end();
    }

    @Override
    public void dispose() {
        font.dispose();
    }
}
