package com.sampler.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.sampler.*;
import com.sampler.Entity.Ball;
import com.sampler.Entity.Block;
import com.sampler.Entity.Platform;

import java.util.ArrayList;


public class BreakoutLevelOneScreen implements Screen {


   BreakoutGame game;

    Ball ball;
    Platform platform;
    Sound hitSound;
    ArrayList<Block> blocks = new ArrayList<>();

    public BreakoutLevelOneScreen(BreakoutGame game) {
        this.game = game;

        ball = new Ball(100, 150, 20, 5, 5);
        platform = new Platform(20, 50, 100, 10, 10);
        hitSound = Gdx.audio.newSound(Gdx.files.internal("Random5.wav"));

        int blockWidth = 63;
        int blockHeight = 20;

        for (int y = Gdx.graphics.getHeight() / 2; y < Gdx.graphics.getHeight(); y += blockHeight + 10) {
            Color rowColor = new Color((float) Math.random(), (float) Math.random(), (float) Math.random(), 1);
            for (int x = 0; x < Gdx.graphics.getWidth(); x += blockWidth + 10) {
                blocks.add(new Block(x, y, blockWidth, blockHeight, rowColor));
            }
        }
    }

    @Override
    public void render(float delta) {
        if (Gdx.input.isTouched()) {
            platform.x = Gdx.input.getX() - platform.sizeX / 2;
        }
        ball.update();
        ball.checkCollision(platform.x, platform.y, platform.sizeX, platform.sizeY);

        java.util.Iterator<Block> iter = blocks.iterator();
        while (iter.hasNext()) {
            Block b = iter.next();
            if (ball.checkCollision(b.x, b.y, b.width, b.height)) {
                hitSound.play(1.0f);
                iter.remove();
            }
        }

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.shape.begin(ShapeRenderer.ShapeType.Filled);
        ball.draw(game.shape);
        platform.draw(game.shape);
        for (Block block : blocks) {
            block.draw(game.shape);
        }
        game.shape.end();

        if(blocks.isEmpty()){
            game.setScreen(new MenuScreen(game));
        }
    }

    @Override public void show() {}
    @Override public void resize(int width, int height) {}
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}

    @Override
    public void dispose() {
        hitSound.dispose();
    }
}
