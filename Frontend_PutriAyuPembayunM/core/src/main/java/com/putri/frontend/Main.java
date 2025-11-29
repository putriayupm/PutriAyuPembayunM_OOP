package com.putri.frontend;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.putri.frontend.states.GameStateManager;
import com.putri.frontend.states.MenuState;

public class Main extends ApplicationAdapter {
    private GameStateManager gsm;
    private SpriteBatch spriteBatch;


    @Override
    public void create() {
        spriteBatch = new SpriteBatch();
        gsm = new GameStateManager();
        gsm.push(new MenuState(gsm));
        Gdx.gl.glClearColor(1, 0, 0, 1);
    }


    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        gsm.update(Gdx.graphics.getDeltaTime());
        gsm.render(spriteBatch);
    }


    @Override
    public void dispose() {
        super.dispose();
        if (spriteBatch != null) spriteBatch.dispose();
    }
}

