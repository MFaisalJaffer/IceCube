package com.game.icecube;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics.*;

import java.awt.Rectangle;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import javafx.animation.*;
import javafx.animation.AnimationTimer;


/**
 * Created by faisaljaffer on 15-04-16.
 */
public class Cube implements Serializable{

    private static long serialVersionUID = 1L;
    Vector2 position;
    Texture texture;
    String textureLoc;
    InputProcessor input;
    boolean touch;


    private static final int col =4;
    private static final int row = 4;
    private  float gravity = 1;
    public float vel_x = 0;
    public float vel_y = 0;
    public boolean Left = false;
    public boolean Right = false;
    public boolean Up = false;
    public boolean UL = false;
    public boolean UR = false;
    public boolean Down = false;
    SpriteBatch batch;
    Animation animation;
    Texture spritesheet;
    TextureRegion currentframe;
    TextureRegion [][] frames;


    float frameTime;
    public Cube(Vector2 position, String textureLoc){
        this.position = position;
        this.texture = new Texture(Gdx.files.internal(textureLoc));
        spritesheet = new Texture(Gdx.files.internal("Sprite-2.png"));
        frames = TextureRegion.split(spritesheet, spritesheet.getWidth()/3, spritesheet.getHeight());
        animation=new Animation(0.055f, frames[0]);
        touch = false;




    }



    public void update (){
        float delta = Gdx.graphics.getDeltaTime();
        float posy = 0;
        frameTime += delta;

        currentframe = animation.getKeyFrame(frameTime, touch);
        if (Gdx.input.isTouched()){
            if (Gdx.input.getX() < 1000) {
                Up=true;
            }
            else{
                Up = false;
            }
            if (Gdx.input.getX() < 1000 && Gdx.input.getX()>1000 && Gdx.input.getX()<1500) {
                UL=true;

            }
            else{
                UL = false;
            }
            if (Gdx.input.getX() < 1000 && Gdx.input.getX()>1500 ) {
                UR=true;

            }
            else{
                UR = false;
            }
            if (Gdx.input.getX()>1000 && Gdx.input.getX()<1500) {
                Left=true;
            }
            else{
                Left = false;
            }
            if (Gdx.input.getX()>1500 ){
                Right=true;
            }
            else{
                Right = false;
            }
            if (Up) {
                jump();
            }
            if (Gdx.input.getX() < 1000 && Gdx.input.getX()>1500){
                ur();
            }
            if (Gdx.input.getX() < 1000 && Gdx.input.getX()>1000 && Gdx.input.getX()<1500){
                ul();
            }
            if (Left){
                touch=true;
                left();
            }
            if (Right){
                touch=true;
                right();
            }
            if (UR){
                jump();
                right();
            }
            if (UL){
                jump();
                left();
            }
        }
        else {
            stop();
        }

       vel_y-=70*delta;
       position.y+=vel_y;
       position.x+=vel_x;
        if (position.y<75){
            position.y=75;
        }






    }

    public void action(int type){

    }

    public void jump(){
        vel_y= 20;
    }
    public void left(){
        vel_x= -8;
    }
    public void ul (){
        vel_x= -8;
        vel_y= 20;
    }
    public void ur(){
        vel_x= 8;
        vel_y= 20;
    }
    public void right(){
        vel_x= 8;
    }
    public void stop(){
        vel_x=0;
    }

    public void draw (){


    }


    public TextureRegion getCurrentframe() {
        return currentframe;
    }

    public void setCurrentframe(TextureRegion currentframe) {
        this.currentframe = currentframe;
    }

    public Animation getAnimation() {
        return animation;
    }

    public TextureRegion[][] getFrames() {
        return frames;
    }



    public void setFrames(TextureRegion[][] frames) {
        this.frames = frames;
    }

    public void setAnimation(Animation animation) {
        this.animation = animation;
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
