package com.sampler.Entity;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
public class Platform {
    public int x;
    public int y;
    public int sizeX;
    public int sizeY;
    int speed;

    public Platform(int x, int y, int sizeX, int sizeY, int speed)
    {
        this.x = x;
        this.y = y;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.speed = speed;
    }
    public void draw(ShapeRenderer shape) {
        shape.setColor(Color.WHITE);
        shape.rect(x,y,sizeX, sizeY);

    }

}
