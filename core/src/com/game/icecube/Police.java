package com.game.icecube;
/** This is the class for the policecar which is an obstacle 
 that you must jump over, it is an early major obstacle
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
import com.badlogic.gdx.math.Rectangle;

public class Police implements Serializable{

    private static long serialVersionUID = 1L;
    Vector2 position;
    Texture texture;
    String textureLoc;
    InputProcessor input;
    Rectangle bounds;
    SpriteBatch batch;
    Texture police;
    /** initializing the position of the car, drawing the image based on relative positioning
     **/
    public Police(Vector2 position, String textureLoc){
        this.position = position;
        this.texture = new Texture(Gdx.files.internal(textureLoc));
        bounds = new Rectangle(position.x, position.y, Gdx.graphics.getWidth()/6, Gdx.graphics.getHeight()/6);
        police = new Texture(Gdx.files.internal("policecar.png"));
    }
    public void update (){
        bounds.set(position.x, position.y, Gdx.graphics.getWidth()/6, Gdx.graphics.getHeight()/6);

/** Below is code to run functions/classes that are associated with this class and that are used in this
 along with the code to remove image once it is not required to free up memory space
 **/ 
    }
    public void dispose(){
        police.dispose();
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public Texture getPolice() {
        return police;
    }

    public void setPolice(Texture police) {
        this.police = police;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    public void setBatch(SpriteBatch batch) {
        this.batch = batch;
    }

    public void draw(SpriteBatch batch){
        batch.draw(police, position.x, position.y, Gdx.graphics.getWidth()/6, Gdx.graphics.getHeight()/6);
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
