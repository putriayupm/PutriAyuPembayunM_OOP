package com.putri.frontend.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.putri.frontend.GameManager;

public class MenuState implements GameState {

    private GameStateManager gsm;
    private Stage stage;
    private Skin skin;

    private TextField nameField;
    private TextButton startButton;

    public MenuState(GameStateManager gsm) {
        this.gsm = gsm;

        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        createBasicSkin();
        buildUI();
    }

    private void createBasicSkin() {
        skin = new Skin();

        BitmapFont font = new BitmapFont();
        skin.add("default", font);

        Pixmap white = new Pixmap(1, 1, Pixmap.Format.RGB888);
        white.setColor(Color.WHITE);
        white.fill();
        skin.add("white", new Texture(white));
        white.dispose();

        Pixmap gray = new Pixmap(1, 1, Pixmap.Format.RGB888);
        gray.setColor(Color.GRAY);
        gray.fill();
        skin.add("gray", new Texture(gray));
        gray.dispose();

        Pixmap darkGray = new Pixmap(1, 1, Pixmap.Format.RGB888);
        darkGray.setColor(Color.DARK_GRAY);
        darkGray.fill();
        skin.add("dark_gray", new Texture(darkGray));
        darkGray.dispose();

        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = font;
        labelStyle.fontColor = Color.WHITE;
        skin.add("default", labelStyle);

        TextField.TextFieldStyle textFieldStyle = new TextField.TextFieldStyle();
        textFieldStyle.font = font;
        textFieldStyle.fontColor = Color.WHITE;
        textFieldStyle.background = skin.getDrawable("dark_gray");
        textFieldStyle.cursor = skin.getDrawable("white");
        textFieldStyle.selection = skin.getDrawable("gray");
        skin.add("default", textFieldStyle);

        TextButton.TextButtonStyle buttonStyle = new TextButton.TextButtonStyle();
        buttonStyle.font = font;
        buttonStyle.up = skin.getDrawable("gray");
        buttonStyle.down = skin.getDrawable("white");
        buttonStyle.over = skin.getDrawable("dark_gray");

        skin.add("default", buttonStyle);
    }

    private void buildUI() {

        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);


        Label title = new Label("NETLAB JOYRIDE", skin);
        title.setFontScale(2f);

        Label prompt = new Label("Enter Your Name:", skin);

        nameField = new TextField("", skin);
        nameField.setMessageText("Username...");
        nameField.setAlignment(Align.center);

        startButton = new TextButton("START GAME", skin);

        startButton.addListener(new ClickListener() {
            @Override
            public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {

                String inputName = nameField.getText();
                if (inputName.trim().isEmpty()) inputName = "Guest";

                GameManager.getInstance().registerPlayer(inputName);

                gsm.set(new PlayingState(gsm));
            }
        });

        table.add(title).padBottom(40).row();
        table.add(prompt).padBottom(10).row();
        table.add(nameField).width(300).height(50).padBottom(20).row();
        table.add(startButton).width(200).height(60).row();
    }

    @Override
    public void update(float delta) {
        stage.act(delta);
    }

    @Override
    public void render(SpriteBatch batch) {
        ScreenUtils.clear(0,0,0,1);
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
        skin.dispose();
    }
}
