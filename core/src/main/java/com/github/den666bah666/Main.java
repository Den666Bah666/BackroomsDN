package com.github.den666bah666;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.github.den666bah666.screens.GameScreen;

public class Main extends Game {
    public static final int MENU_STATE = 0;
    public static final int GAME_STATE = 1;
    public SpriteBatch batch;

    @Override
    public void create() {
        AssetManager.load("player.png", "player", Texture.class);

        batch = new SpriteBatch();
        switchState(GAME_STATE);
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0, 1);
        screen.render(Gdx.graphics.getDeltaTime());
    }

    @Override
    public void dispose() {
        batch.dispose();
        AssetManager.dispose();
    }

    private void switchState(int state) {
        switch (state) {
            case MENU_STATE -> IO.println("Пошёл нахуй");
            case GAME_STATE -> setScreen(new GameScreen(batch));
        }
    }
}
