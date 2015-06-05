package com.game.icecube;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Dimitar on 01/06/2015.
 */
public class Money{
    public Vector2 getSize() {
        return size;
    }

    public Vector2 getPosition() {
        return position;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    Vector2 position, size;
    Texture money;
    Rectangle bounds;

    public Money(Vector2 position, Vector2 size){
        this.position = position;
        this.size = size;
        bounds = new Rectangle(position.x, position.y, size.x, size.y);
        money = new Texture(Gdx.files.internal("money.png"));
    }

    public void update(){
        bounds.set(position.x, position.y, size.x, size.y);
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    public void draw(SpriteBatch batch){
        batch.draw(money, position.x, position.y, size.x, size.y);
    }
}
