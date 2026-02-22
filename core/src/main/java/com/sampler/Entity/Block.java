package com.sampler.Entity;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Block {

    public int x;
    public int y;
    public int width;
    public int height;
    Color color;
    public Block(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }



    public void draw(ShapeRenderer shape){
        shape.setColor(color);
        shape.rect(x, y, width, height);

    }
}
