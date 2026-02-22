package com.sampler;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.sampler.screens.MenuScreen;

public class BreakoutGame extends Game {
    public SpriteBatch batch;
    public ShapeRenderer shape;
    @Override
    public void create() {
        batch = new SpriteBatch();
        shape = new ShapeRenderer();
        this.setScreen(new MenuScreen(this));
    }
    @Override
    public void dispose() {
        batch.dispose();
        shape.dispose();
    }
}

