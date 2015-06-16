package com.game.icecube;

/**
 * Name: Faisal, Ryan, Dimitar and Zain
 * Description: The game over class is used to show a prompt whenever the main character dies or loses
 * all of his lives. The player can then choose to start a new game.
 * 
 **/

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class GameOver implements Screen {
    SpriteBatch batch;

    Stage stage;
    Label label;
    Sprite sprite;
    Label.LabelStyle style;
    TextureAtlas buttonatlas;
    TextButton.TextButtonStyle buttonstyle;
    TextButton button;
    Texture logo;
    Skin skin;
    Game game;
    BitmapFont font;

    public GameOver(Game game){
        this.game = game;
    }
    @Override
    public void show() {

        BitmapFont font;
        batch = new SpriteBatch();
        stage = new Stage();
        font = new BitmapFont (Gdx.files.internal("font.fnt"), false);



        skin = new Skin();
        buttonatlas = new TextureAtlas("button2.pack");
        skin.addRegions(buttonatlas);
        logo = new Texture(Gdx.files.internal("logo.png"));

        buttonstyle = new TextButton.TextButtonStyle();
        buttonstyle.up= skin.getDrawable("button2");
        buttonstyle.over = skin.getDrawable("button2pressed");
        buttonstyle.down = skin.getDrawable("button2pressed");
        buttonstyle.font = font;
        button=new TextButton("", buttonstyle);
        button.setWidth(button.getWidth());
        button.setHeight(button.getHeight());
        button.setPosition(Gdx.graphics.getWidth() / 2 - (Gdx.graphics.getWidth() * 9 / 10) / 2, Gdx.graphics.getHeight() / 2 - (button.getHeight()/2));
        stage.addActor(button);

        Gdx.input.setInputProcessor(stage);

        button.addListener(new InputListener(){
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
                game.setScreen(new PlayScreen(game));
                return true;
            }


        });
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.draw();
        batch.begin();
        batch.draw(logo, Gdx.graphics.getWidth() / 2 - (Gdx.graphics.getWidth() * 3 / 8) / 2, 0, Gdx.graphics.getWidth() * 3 / 8, Gdx.graphics.getHeight() );




        batch.end();
        stage.act();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
        skin.dispose();
        stage.dispose();
    }
}
