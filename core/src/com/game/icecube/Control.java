package com.game.icecube;
 /** 
 This class if for the controls of the game
 **/
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


public class Control implements Serializable{

    private static long serialVersionUID = 1L;
    Vector2 position;
    Texture texture;
    String textureLoc;
    InputProcessor input;
    Texture left;
    Texture up;


    public Control(Vector2 position, String textureLoc){
        this.position = position;
        this.texture = new Texture(Gdx.files.internal(textureLoc));
        left = new Texture(Gdx.files.internal("Buttons.png"));
        up = new Texture(Gdx.files.internal("A&B.png"));


    }
    public void update (){



    }
    public void draw(SpriteBatch batch){
        batch.draw(up , 0, 0, Gdx.graphics.getWidth()/5, Gdx.graphics.getHeight()/7);
        batch.draw(left , (Gdx.graphics.getWidth()*8)/10, 0, Gdx.graphics.getWidth()/5, Gdx.graphics.getHeight()/7);


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
