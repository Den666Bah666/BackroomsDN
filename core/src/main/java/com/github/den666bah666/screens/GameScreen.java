package com.github.den666bah666.screens;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.github.den666bah666.AssetManager;
import com.github.den666bah666.models.Player;
import com.github.den666bah666.views.PlayerView;

public class GameScreen implements Screen {
    private Viewport viewport;
    private Camera camera;
    private SpriteBatch batch;
    private Player player;
    private PlayerView playerView;

    private InputProcessor inputProcessor;

    public GameScreen(SpriteBatch batch) {
        inputProcessor = new InputAdapter() {
            private static final int MASK_LT = 0x8;
            private static final int MASK_BD = 0x4;
            private static final int MASK_FD = 0x2;
            private static final int MASK_RT = 0x1;

            private int mask;

            @Override
            public boolean keyDown(int keycode) {
                if (keycode == Input.Keys.A) {
                    mask |= MASK_LT;
                } else if (keycode == Input.Keys.S) {
                    mask |= MASK_BD;
                } else if (keycode == Input.Keys.W) {
                    mask |= MASK_FD;
                } else if (keycode == Input.Keys.D) {
                    mask |= MASK_RT;
                } else {
                    return false;
                }

                player.getVelocity().set(
                    (mask & 0x1) - (mask >> 3),
                    ((mask >> 1) & 0x1) - ((mask >> 2) & 0x1)
                );

                return true;
            }

            @Override
            public boolean keyUp(int keycode) {
                if (keycode == Input.Keys.A) {
                    mask &= MASK_LT ^ 0xF;
                } else if (keycode == Input.Keys.S) {
                    mask &= MASK_BD ^ 0xF;
                } else if (keycode == Input.Keys.W) {
                    mask &= MASK_FD ^ 0xF;
                } else if (keycode == Input.Keys.D) {
                    mask &= MASK_RT ^ 0xF;
                } else {
                    return false;
                }

                player.getVelocity().set(
                    (mask & 0x1) - (mask >> 3),
                    ((mask >> 1) & 0x1) - ((mask >> 2) & 0x1)
                );

                return true;
            }
        };

        Gdx.input.setInputProcessor(inputProcessor);

        this.batch = batch;
        camera = new OrthographicCamera();
        viewport = new ExtendViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), camera);
        player = new Player(0, 0);
        playerView = new PlayerView(AssetManager.get("player"));
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        player.update();

        viewport.apply();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        playerView.render(batch, player);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {

    }
}
