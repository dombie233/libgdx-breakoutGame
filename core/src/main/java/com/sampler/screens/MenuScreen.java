package com.sampler.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.sampler.BreakoutGame;

public class MenuScreen implements Screen {
    BreakoutGame game;
    Texture playButtonActive;
    Texture playButtonInactive;
    Texture exitButtonActive;
    Texture exitButtonInactive;
    public MenuScreen (BreakoutGame game) {
        this.game = game;
        playButtonActive = new Texture("play_button_active.png");

        exitButtonActive = new Texture("exit_button_active.png");


    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    game.batch.begin();
        float playX = 400, playY = 450, btnW = 200, btnH = 200;
        float exitX = 400, exitY = 200;
        game.batch.draw(playButtonActive, playX, playY, btnW, btnH);
        game.batch.draw(exitButtonActive, exitX, exitY, btnW, btnH);
    game.batch.end();

    if (Gdx.input.isTouched()) {
        float mouseX = Gdx.input.getX();
        float mouseY = Gdx.graphics.getHeight() - Gdx.input.getY();
        if (mouseX >= playX && mouseX <= playX + btnW && mouseY >= playY && mouseY <= playY + btnH) {
            game.setScreen(new BreakoutLevelOneScreen(game));

        }
        if (mouseX >= exitX && mouseX <= exitX + btnW && mouseY >= exitY && mouseY <= exitY + btnH) {
            Gdx.app.exit();
        }

    }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        playButtonActive.dispose();
    }
}
