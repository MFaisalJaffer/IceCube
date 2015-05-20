package com.game.icecube;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class IceCubeGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture h;
    Cube cube;
    Floor floor;
    Cloud cloud;
    PalmTree tree;
    Sun sun;
    Vector2 position;

	@Override
	public void create () {
        sun = new Sun(new Vector2(Gdx.graphics.getWidth()-204, Gdx.graphics.getHeight()-131), "Sun.png");
		batch = new SpriteBatch();
        tree = new PalmTree(new Vector2 (Gdx.graphics.getWidth()/2, 99), "Palm Tree.png");
        cube = new Cube(new Vector2(Gdx.graphics.getWidth()/20, 75), "Sprite-2.png");
        floor = new Floor(new Vector2(0, 0), "Ground.png");
        cloud = new Cloud (new Vector2(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()-100), "Cloud.png");
        position = new Vector2(Gdx.graphics.getWidth(), 10);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        cube.update();
        tree.update();
        cloud.update();
        sun.update();
		batch.begin();
        batch.draw(sun.getTexture(), sun.getPosition().x, sun.getPosition().y);
        batch.draw(tree.getTexture(), tree.getPosition().x, tree.getPosition().y);

        batch.draw(cloud.getTexture(), cloud.getPosition().x, cloud.getPosition().y);
        batch.draw(floor.getTexture(), floor.getPosition().x, floor.getPosition().y);
        batch.draw(floor.getTexture(), 1127, floor.getPosition().y);
        batch.draw(cube.getCurrentframe(), cube.getPosition().x, cube.getPosition().y);
		batch.end();
	}
}
