package com.game.icecube;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.math.Rectangle;
public class IceCubeGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture h;
    Cube cube;
    Floor floor;
    Cloud cloud;
    PalmTree tree;
    Control control;
    Money money;
    Sun sun;
    Vector2 position;
    private Viewport viewport;
    private Camera camera;

	@Override
	public void create () {
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
        money = new Money(new Vector2(100,100), new Vector2( 50, 100));

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        cube.update();
        tree.update();
        cloud.update();
        control.update();
        sun.update();
        money.update();



        if (cube.getBounds().overlaps(money.getBounds())){
            System.out.println("Collision");
        }

		batch.begin();
        batch.draw(sun.getTexture(), sun.getPosition().x, sun.getPosition().y);
        batch.draw(tree.getTexture(), tree.getPosition().x, tree.getPosition().y, Gdx.graphics.getWidth()/12, Gdx.graphics.getHeight()/4);

        batch.draw(cloud.getTexture(), cloud.getPosition().x, cloud.getPosition().y);
        batch.draw(floor.getTexture(), floor.getPosition().x, floor.getPosition().y);
        batch.draw(floor.getTexture(), 1127, floor.getPosition().y);
        cube.draw(batch);
		batch.draw(control.getTexture(), control.getPosition().x, control.getPosition().y, Gdx.graphics.getWidth()/5, Gdx.graphics.getHeight()/7);
        money.draw(batch);
        batch.end();
	}
}
