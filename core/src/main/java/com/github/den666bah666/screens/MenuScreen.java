package com.github.den666bah666.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.github.den666bah666.Assets;
import com.github.den666bah666.drawables.TiledNinePatchDrawable;

public class MenuScreen implements Screen {
    private SpriteBatch batch;
    private Stage stage;

    public MenuScreen(SpriteBatch batch) {
        this.batch = batch;
        stage = new Stage(new ScreenViewport());
        stage.getViewport().setWorldSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        TextureAtlas atlas = Assets.getAtlas(Assets.UI_ATLAS);

        Gdx.input.setInputProcessor(stage);

        BitmapFont font = new BitmapFont(Gdx.files.internal("fonts/minecraft.fnt"));
        font.setColor(Color.WHITE);
        font.getData().setScale(1f);

        TiledNinePatchDrawable tiledNinePatchDrawable = new TiledNinePatchDrawable(
            atlas.createPatch("button_frame"), atlas.findRegion("button_bg")
        );

        // Generic style
        TextButton.TextButtonStyle genericStyle = new TextButton.TextButtonStyle();
        genericStyle.fontColor = Color.WHITE;
        genericStyle.up = tiledNinePatchDrawable;
        genericStyle.font = font;

        // Menu button
        TextButton menuButton = new TextButton("Play", genericStyle);
        menuButton.setSize(200, 20);
        stage.addActor(menuButton);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height);
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
        stage.dispose();
    }
}
