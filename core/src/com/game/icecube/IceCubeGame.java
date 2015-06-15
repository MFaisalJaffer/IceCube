package com.game.icecube;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;

import sun.applet.Main;

/**
 * Main Ice Cube class which creates and renders the game
 * starting from the main menu
 **/

public class IceCubeGame extends Game {
    Game game;
	@Override
	public void create () {
        game=this;
        setScreen(new MainMenu(game));

	}

	@Override
	public void render () {
    super.render();
	}
}
