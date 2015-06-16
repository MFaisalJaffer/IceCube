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
 * Name: Faisal, Ryan, Dimitar and Zain
 * Description: The main game code, implements the other classes
 * 
 * 
 **/
public class IceCubeGame extends Game {
    Game game;
	@Override
	public void create () {
        game=this;
        setScreen(new MainMenu(game)); /** sends user to Main Menu**/

	}

	@Override
	public void render () {
    super.render(); /** renders the mainmenu **/
	}
}
