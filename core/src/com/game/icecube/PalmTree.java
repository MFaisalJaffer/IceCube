package com.game.icecube;


/**
 * Name: Faisal, Ryan, Dimitar and Zain
 * Description: creates the image of a palmtree
**/

//importing the main LibGDX libraries for graphics and movement
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.Gdx;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// tree is overlapping the cube
public class PalmTree implements Serializable{

    private static long serialVersionUID = 1L;
    Vector2 position;
    Texture texture;
    String textureLoc;
    InputProcessor input;


//palmtree texture and position placement
    public PalmTree(Vector2 position, String textureLoc){
        this.position = position;
        this.texture = new Texture(Gdx.files.internal(textureLoc));
    }
    public void update (){


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
