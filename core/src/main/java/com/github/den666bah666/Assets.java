package com.github.den666bah666;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Assets {
    public static final AssetManager manager = new AssetManager();

    public static final String UI_ATLAS = "ui.atlas";
    public static final String PLAYER_TEXTURE = "player.png";

    public static void loadAll() {
        manager.load(PLAYER_TEXTURE, Texture.class);
        manager.load(UI_ATLAS, TextureAtlas.class);

        manager.finishLoading();
    }

    public static Texture getTexture(String name) {
        return manager.get(name, Texture.class);
    }

    public static TextureAtlas getAtlas(String name) {
        return manager.get(name, TextureAtlas.class);
    }

    public static boolean isLoaded() {
        return manager.update();
    }

    public static float getProgress() {
        return manager.getProgress();
    }

    public static void dispose() {
        manager.dispose();
    }
}
