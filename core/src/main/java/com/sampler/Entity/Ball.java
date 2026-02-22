package com.sampler.Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball {
    float x, y, xSpeed, ySpeed;
    int size;
    Color color = Color.GREEN;

    public Ball(int x, int y, int size, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public void update() {
        x += xSpeed;
        y += ySpeed;

        if (x - size < 0 || x + size > Gdx.graphics.getWidth()) {
            xSpeed = -xSpeed;
        }

        if (y - size < 0 || y + size > Gdx.graphics.getHeight()) {
            ySpeed = -ySpeed;
        }
    }

    public void draw(ShapeRenderer shape) {
        shape.setColor(color);
        shape.circle(x, y, size);
    }


    public boolean checkCollision(float rectX, float rectY, float rectW, float rectH) {
        float closestX = Math.max(rectX, Math.min(x, rectX + rectW));
        float closestY = Math.max(rectY, Math.min(y, rectY + rectH));

        float dx = x - closestX;
        float dy = y - closestY;

        boolean hit = (dx * dx + dy * dy) <= (size * size);

        if (hit) {

            if (Math.abs(dx) > Math.abs(dy)) {
                xSpeed = -xSpeed;
            } else {
                ySpeed = -ySpeed;
            }
            y += ySpeed;
        }
        return hit;
    }
}
