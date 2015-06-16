package com.game.icecube;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics.*;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Rectangle;
import javafx.animation.*;
import javafx.animation.AnimationTimer;


/**
 * Name: Faisal, Ryan, Dimitar and Zain
 * Description: The animation of the main character as well as controlls the animation and character movement
 */
public class Cube implements Serializable{

    private static long serialVersionUID = 1L;
    Vector2 position;
    Texture texture;
    String textureLoc;
    InputProcessor input;
    boolean right;
    boolean left;

    private static final int col =4;
    private static final int row = 4;
    private  float gravity = 1;
    public float vel_x = 0;
    public float vel_y = 0;
    public boolean Left = false;
    public boolean Right = false;
    public static float ground;
    public boolean Up = false;
    public boolean UL = false;
    public boolean UR = false;
    public boolean Down = false;
    SpriteBatch batch;
    Animation animation;
    Animation animation1;
    String direction;
    Texture spritesheet;
    Texture spritesheet1;
    TextureRegion currentframe;
    TextureRegion currentframe1;
    TextureRegion hello;
    TextureRegion [][] frames;
    TextureRegion [][] frames1;
    Texture cubewalking1;
    Texture cubewalking;
    PlayScreen play;
    Rectangle bounds;
    Police police;
    public static int facing= 0;
    float frameTime;
    public Cube(Vector2 position, String textureLoc){
        this.position = position;
        this.texture = new Texture(Gdx.files.internal(textureLoc));
        direction="Swing Sprite(Flip).png";
        spritesheet = new Texture(Gdx.files.internal("Swing Sprite.png"));
        spritesheet1 = new Texture(Gdx.files.internal("Swing Sprite(Flip).png"));
        frames = TextureRegion.split(spritesheet, spritesheet.getWidth()/4, spritesheet.getHeight());/** divides the sprite accordingly**/
        frames1= TextureRegion.split(spritesheet1, spritesheet.getWidth()/4, spritesheet.getHeight());
        animation=new Animation(0.09f, frames[0]);
        animation1=new Animation(0.09f, frames1[0]);
        right = false;
        left=false;
        cubewalking1 = new Texture(Gdx.files.internal("Ice Cube1.png"));/** declares which direction walking**/
        cubewalking = new Texture(Gdx.files.internal("cubewalking.png"));
        bounds = new Rectangle(position.x, position.y, Gdx.graphics.getWidth()/14, Gdx.graphics.getHeight()/6);
        police = new Police (new Vector2(Gdx.graphics.getWidth()-350, 80), "policecar.png");




    }


/**
 * Updates the value which is set for the cubes current frame rate, and 
 * the position of the rectangle around ice cube constantly
 **/
    public void update (){
        bounds.set(position.x, position.y, Gdx.graphics.getWidth()/14, Gdx.graphics.getHeight()/6);
        float delta = Gdx.graphics.getDeltaTime();
        float posy = 0;
        frameTime += delta;
        currentframe1 = animation1.getKeyFrame(frameTime, left); /** animates the sprite**/
        currentframe = animation.getKeyFrame(frameTime, right); /** animates the sprite**/



        if (Gdx.input.isTouched()){
            if (Gdx.input.getX() < Gdx.graphics.getWidth()/10 && position.y < 150) {  /** if user touches**/
                Up=true;  /**jumps**/

            }
            else{
                Up = false;
            }

            if (Gdx.input.getX() > 8*Gdx.graphics.getWidth()/10 && Gdx.input.getX() < 9*Gdx.graphics.getWidth()/10) {  /** if user touches**/
                Left=true;  /** moves left**/
                Right=false;
                left=true;
            }
            else{
                Left = false;

            }
            if (Gdx.input.getX() > 9*Gdx.graphics.getWidth()/10 && Gdx.input.getX() < 10*Gdx.graphics.getWidth()/10) {
                Right=true;  /** moves right**/
                Left=false;
                right=true;
            }
            else{
                Right = false;
            }

            if (Left){

                left();  /** moves left**/
            }
            if (Right){

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
            if (Up){
                jump();
                Up=false;
            }
            if (!Gdx.input.isTouched()){
                right=false;
                left=false;
            }

        }
        else {
            stop();
        }

       vel_y-=70*delta;
       position.y+=vel_y;
       position.x+=vel_x;
        if (position.y<75 && PlayScreen.level!=3){
            position.y = 75;

        }
        if (position.y<105 && PlayScreen.level==3){
            position.y = 125;

        }

        if (PlayScreen.level == 1 &&( position.x+(Gdx.graphics.getWidth()/14))>((Gdx.graphics.getWidth()*6)/10)&& position.x<(((Gdx.graphics.getWidth()*6)/10)+Gdx.graphics.getWidth()/6) && position.y<((Gdx.graphics.getHeight()/6)+100)){  /** if user hits an obstacle**/
            position.y=Gdx.graphics.getHeight()/6+78; /** stands on top of obstacle**/
        }
        if (PlayScreen.level == 3 &&( position.x+(Gdx.graphics.getWidth()/14))>((Gdx.graphics.getWidth()*6)/10)&& position.x<(((Gdx.graphics.getWidth()*6)/10)+Gdx.graphics.getWidth()/3) && position.y>((Gdx.graphics.getHeight()/3)+100)){/** if user hits an obstacle**/
            position.y=Gdx.graphics.getHeight()/3+78;/** stands on top of obstacle**/
            position.y+=70;
        }
        if (PlayScreen.level == 3 &&( position.x+(Gdx.graphics.getWidth()/14))>(240)&& position.x<(450) && position.y<((Gdx.graphics.getHeight()*7)/10)){/** if user hits an obstacle**/
            position.y=(Gdx.graphics.getHeight()*15)/20;
        }
        if (PlayScreen.level == 3 &&( position.x+(Gdx.graphics.getWidth()/14))>(750)&& position.x<(800) && position.y<((Gdx.graphics.getHeight()*7)/10)){/** if user hits an obstacle**/
            position.y=((Gdx.graphics.getHeight()*10)/20)+45;/** stands on top of obstacle**/
        }
    }
    public void draw (SpriteBatch batch){
            if (!Gdx.input.isTouched()){
                right=false;
                left=false;
            }
        if (Right){
            batch.draw(currentframe, position.x, position.y, Gdx.graphics.getWidth()/14, Gdx.graphics.getHeight()/6);
            facing=0;
        }
        else{
            Right=false;
        }

        if (Left){
            batch.draw(currentframe1, position.x, position.y, Gdx.graphics.getWidth()/14, Gdx.graphics.getHeight()/6);
            facing=1;
        }
        else{
            Left=false;
        }
        if (Up){
            batch.draw(cubewalking1, position.x, position.y, Gdx.graphics.getWidth()/14, Gdx.graphics.getHeight()/6); /** drews the Up cube**/

        }
        if (facing==0 && Right==false){
            batch.draw(cubewalking1, position.x, position.y, Gdx.graphics.getWidth()/14, Gdx.graphics.getHeight()/6);/** drews the right cube**/
        }
        if (facing==1 && Left==false ){
            batch.draw(cubewalking, position.x, position.y, Gdx.graphics.getWidth()/14, Gdx.graphics.getHeight()/6);/** drews the left cube**/
        }


    }
    public void action(int type){

    }

    public void jump(){
        vel_y= (Gdx.graphics.getHeight()/30);
    }
    public void left(){
        vel_x= -8; /** moves left **/
    }
    public void ul (){
        vel_x= -8;
        vel_y= 12;
    }
    public void ur(){
        vel_x= 8;
        vel_y= 12;
    }
    public void right(){
        if (PlayScreen.level == 1 && (position.x+Gdx.graphics.getWidth()/14)+15>((Gdx.graphics.getWidth()*6)/10) && Right && position.y<((Gdx.graphics.getHeight()/6)+75) && position.x<(((Gdx.graphics.getWidth()*6)/10)+Gdx.graphics.getWidth()/6)){/**if hits obtacle **/
            vel_x=0;/** doesnt move right **/
        }
        if (PlayScreen.level == 3 && (position.x+Gdx.graphics.getWidth()/14)+15>240 && Right && position.y<((Gdx.graphics.getHeight()*3)/4) && position.x<450){/** hits obstacle **/
            vel_x=0;/** doesnt move right **/
        }
        else {
            vel_x = 8; /**moves right **/
        }
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

    public Rectangle getBounds() {
        return bounds;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
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
