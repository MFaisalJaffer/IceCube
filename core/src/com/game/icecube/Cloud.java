package com.game.icecube;
/**
 * Name: Faisal, Ryan, Dimitar and Zain
 * Description: The Cloud class is made for use of movement of the cloud which travels from right to left
 **/
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


public class Cloud implements Serializable{

    private static long serialVersionUID = 1L;
    Vector2 position; position; /** gpositon variable **/
    Texture texture;position; /** texture variable **/
    String textureLoc;
    InputProcessor input;



    public Cloud(Vector2 position, String textureLoc){
        this.position = position; /** gets the posisition set previously**/
        this.texture = new Texture(Gdx.files.internal(textureLoc));position; /** gets the texture set previously**/
    }
    public void update (){
    position.x-=1; position; /** moves the cloud by one pixel **/
            if (position.x < -250){
                position.x=Gdx.graphics.getWidth()-50;position; /** if the cloud leaves the screen it redraws it over**/
            }

    }




    public void setInput(InputProcessor input) {
        this.input = input;
    }

    @SuppressWarnings("unused")
    /** places the cloud**/
    private static byte[] serialize(Object obj) throws IOException{
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        ObjectOutputStream o = new ObjectOutputStream(b);
        o.writeObject(obj);
        return b.toByteArray();
    }
    /** places the moving cloud**/
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

