package com.putri.frontend;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Main extends ApplicationAdapter {
    private ShapeRenderer shape;
    private float x, y;
    private float size = 100;
    private Color[] colors = {Color.RED, Color.YELLOW, Color.BLUE};
    private int colorIndex = 0;

    @Override
    public void create() {
        shape = new ShapeRenderer();
        x = Gdx.graphics.getWidth() / 2f - size / 2;
        y = Gdx.graphics.getHeight() / 2f - size / 2;
    }

    @Override
    public void render() {
        // Background hitam
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        handleInput();

        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.setColor(colors[colorIndex]);
        shape.rect(x, y, size, size);
        shape.end();

        if (Gdx.input.justTouched()) {
            colorIndex = (colorIndex + 1) % colors.length;
            System.out.println(getColorName(colors[colorIndex]));
        }
    }

    private void handleInput() {
        float speed = 200 * Gdx.graphics.getDeltaTime();

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A)) x -= speed;
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D)) x += speed;
        if (Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(Input.Keys.W)) y += speed;
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN) || Gdx.input.isKeyPressed(Input.Keys.S)) y -= speed;

        if (x < 0) x = 0;
        if (y < 0) y = 0;
        if (x + size > Gdx.graphics.getWidth()) x = Gdx.graphics.getWidth() - size;
        if (y + size > Gdx.graphics.getHeight()) y = Gdx.graphics.getHeight() - size;
    }

    private String getColorName(Color color) {
        if (color.equals(Color.RED)) return "Merah";
        if (color.equals(Color.YELLOW)) return "Kuning";
        if (color.equals(Color.BLUE)) return "Biru";
        return "Tidak diketahui";
    }

    @Override
    public void dispose() {
        shape.dispose();
    }
}
