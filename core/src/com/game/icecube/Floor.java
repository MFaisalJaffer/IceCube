package com.game.icecube;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.Gdx;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Floor implements Serializable{

    private static long serialVersionUID = 1L;
    Vector2 position;
    String textureLoc;
    InputProcessor input;
    Texture spritesheet;
    String image;
    private Texture         texture;            // #1
    private Texture         texture1;            // #1
    private Texture         texture2;            // #1

    private Texture         texture3;            // #1

    private SpriteBatch         batch;
    private TextureRegion[]     regions = new TextureRegion[4];
    TextureRegion [][] frames;
    float sizex;
    float sizey;

    public Floor(Vector2 position, String textureLoc){
        this.position = position;
        this.texture = new Texture(Gdx.files.internal(textureLoc));
        texture = new Texture(Gdx.files.internal("Ground.png"));
        texture1 = new Texture(Gdx.files.internal("Zainground.png"));
        texture2 = new Texture(Gdx.files.internal("Dimitar Level.png"));


        batch = new SpriteBatch();

    }
    public void update (){

    }
    public void draw (SpriteBatch batch){


        if (PlayScreen.level==1) {
            sizex=Gdx.graphics.getWidth();
            sizey=75;

            batch.draw(texture, 0, 0, sizex, sizey);
        }
        if (PlayScreen.level==2) {
            sizex=Gdx.graphics.getWidth();
            sizey=Gdx.graphics.getHeight()/2;
            batch.draw(texture1, 0, 0, sizex, sizey);
        }
        if (PlayScreen.level==3) {
            sizex=Gdx.graphics.getWidth();
            sizey=Gdx.graphics.getHeight();
            batch.draw(texture2, 0, 0, sizex, sizey);
        }

    }
    public void dispose(){


    }

    @SuppressWarnings("unused")
    private static byte[] serialize(Object obj) throws IOException{
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        ObjectOutputStream o = new ObjectOutputStream(b);
        o.writeObject(obj);
        return b.toByteArray();
    }

    public static Object deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream b = new ByteArrayInputStream(bytes);
        ObjectInputStream o = new ObjectInputStream(b);
        return o.readObject();
    }
    public Vector2 getPosition(){
        return position;
    }
    public void setPosition(Vector2 position){
        this.position = position;
    }
    public Texture getTexture(){
        return texture;
    }
    public void setTexture(Texture texture){
        this.texture = texture;
    }
}
