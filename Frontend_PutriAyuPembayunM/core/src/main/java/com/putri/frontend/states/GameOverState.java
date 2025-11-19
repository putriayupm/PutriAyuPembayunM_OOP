package com.putri.frontend.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
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
        font.draw(batch, "GAME OVER", Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2 + 20);
        font.draw(batch, "Press SPACE to restart", Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2 - 20);
    }

    @Override
    public void dispose() {
        font.dispose();
    }
}
