package com.game.icecube;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;



public class PlayScreen implements Screen {
    SpriteBatch batch;
    Texture h;
    Cube cube;
    Floor floor;
    Cloud cloud;
    PalmTree tree;
    Control control;
    Police police;
    Sun sun;
    Vector2 position;
    private Viewport viewport;
    private Camera camera;
    Game game;
    Coin coin;
    public static int level=3;

    public PlayScreen(Game game){
        this.game =game;
    }
    @Override
    public void show() {
        level=1;
        police = new Police (new Vector2(((Gdx.graphics.getWidth()*6)/10), 80), "policecar.png");
        camera = new PerspectiveCamera();
        viewport = new FitViewport(200, 280, camera);
        sun = new Sun(new Vector2(Gdx.graphics.getWidth()-204, Gdx.graphics.getHeight()-131), "Sun.png");
        batch = new SpriteBatch();
        tree = new PalmTree(new Vector2 (Gdx.graphics.getWidth()/2, 99), "Palm Tree.png");
        cube = new Cube(new Vector2(Gdx.graphics.getWidth()/20, 500), "Sprite-2.png");
        floor = new Floor(new Vector2(0, 0), "Ground.png");
        cloud = new Cloud (new Vector2(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()-100), "Cloud.png");
        position = new Vector2(Gdx.graphics.getWidth(), 10);
        control = new Control(new Vector2(0,0), "A&B.png");
        coin = new Coin(new Vector2((Gdx.graphics.getWidth()*9)/10, 200), "money.png");
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        cube.update();
        tree.update();
        cloud.update();
        control.update();
        floor.update();
        sun.update();
        coin.update();

        if (level==1){
            batch.begin();
            batch.draw(sun.getTexture(), sun.getPosition().x, sun.getPosition().y);
            batch.draw(tree.getTexture(), tree.getPosition().x, tree.getPosition().y, Gdx.graphics.getWidth()/12, Gdx.graphics.getHeight()/4);
            batch.draw(coin.getTexture(), coin.getPosition().x, coin.getPosition().y);
            batch.draw(cloud.getTexture(), cloud.getPosition().x, cloud.getPosition().y);

            floor.draw(batch);
            if (cube.getBounds().overlaps(coin.getBounds())){

                cube.getPosition().x=Gdx.graphics.getWidth()/20;
                cube.getPosition().y=500;
                if (cube.getPosition().x==Gdx.graphics.getWidth()/20) {
                    level = 2;
                }
            }
            police.draw(batch);
            cube.draw(batch);
            control.draw(batch);
            batch.end();
        }
        if (level==2){
            batch.begin();
            floor.draw(batch);
            batch.draw(tree.getTexture(), tree.getPosition().x, tree.getPosition().y, Gdx.graphics.getWidth() / 12, Gdx.graphics.getHeight() / 4);
            batch.draw(coin.getTexture(), coin.getPosition().x, coin.getPosition().y);
            batch.draw(cloud.getTexture(), cloud.getPosition().x, cloud.getPosition().y);
            cube.draw(batch);
            control.draw(batch);
            if (cube.getPosition().x>2200 && level==2){

                cube.getPosition().x=Gdx.graphics.getWidth()/23;
                cube.getPosition().y=900;
                level=3;

            }
            batch.end();
        }
        if (level==3){
            batch.begin();
            floor.draw(batch);
            batch.draw(coin.getTexture(), coin.getPosition().x, coin.getPosition().y);
            batch.draw(cloud.getTexture(), cloud.getPosition().x, cloud.getPosition().y);
            cube.draw(batch);
            control.draw(batch);
            if (cube.getBounds().overlaps(coin.getBounds())){
                level=3;
                cube.getPosition().x=Gdx.graphics.getWidth()/20;
                cube.getPosition().y=500;

            }
            batch.end();

        }
        System.out.println(level);

        if (cloud.getPosition().x==cube.getPosition().x){

        }

        if (cube.getBounds().overlaps(police.getBounds())){

        }
        if (level==2 && cube.getPosition().x>police.getPosition().x && cube.getPosition().x<(police.getPosition().x+Gdx.graphics.getWidth()/6) && cube.getPosition().y>((Gdx.graphics.getHeight()/6)+100)){
            cube.getPosition().y=Gdx.graphics.getHeight()/6+100;
        }


    }

    @Override
    public void resize(int width, int height) {

    }

    public static int getLevel() {
        return level;
    }

    public static void setLevel(int level) {
        PlayScreen.level = level;
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
    public int getlevel(){
        return level;
    }

    @Override
    public void dispose() {

        police.batch.dispose();
        sun.dispose();
        batch.dispose();
        floor.dispose();

    }
}
