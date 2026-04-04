package com.github.den666bah666.screens;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.github.den666bah666.Assets;
import com.github.den666bah666.Settings;
import com.github.den666bah666.drawables.MinecraftButtonDrawable;
import com.github.den666bah666.drawables.TiledNinePatchDrawable;

public class MenuScreen implements Screen {
    private SpriteBatch batch;
    private Stage stage = new Stage(new FillViewport(
        (float) (Gdx.graphics.getWidth() / Settings.GUI_SCALE),
        (float) (Gdx.graphics.getHeight() / Settings.GUI_SCALE))
    );

    public MenuScreen(SpriteBatch batch) {
        this.batch = batch;

        TextureAtlas atlas = Assets.getAtlas(Assets.UI_ATLAS);

        InputMultiplexer multiplexer = new InputMultiplexer(stage);
        multiplexer.addProcessor(new InputAdapter() {
            @Override
            public boolean keyDown(int keycode) {
                if (keycode == Input.Keys.F11) {
                    if (Gdx.graphics.isFullscreen()) {
                        Gdx.graphics.setWindowedMode(1280, 720);
                    } else {
                        Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
                    }
                    return true;
                }
                return false;
            }
        });
        Gdx.input.setInputProcessor(multiplexer);

        BitmapFont font = new BitmapFont(Gdx.files.internal("fonts/minecraft.fnt"));
        font.setColor(Color.WHITE);
        font.getData().setScale(1f);

        // Generic style
        TextButton.TextButtonStyle genericStyle = new TextButton.TextButtonStyle();
        genericStyle.fontColor = Color.WHITE;
        genericStyle.up = new TiledNinePatchDrawable(atlas.createPatch("button"), atlas.findRegion("button"));
        genericStyle.up = new MinecraftButtonDrawable(atlas.createPatch("button"), atlas.findRegion("button"));
        genericStyle.over = new TiledNinePatchDrawable(
            atlas.createPatch("button_highlighted"), atlas.findRegion("button_highlighted"));
        genericStyle.font = font;

        Table table = new Table();
        table.setFillParent(true);
        table.padTop(192f / Settings.GUI_SCALE).top();

        // Menu button
        TextButton menuButton = new TextButton("Play", genericStyle);
        table.add(menuButton).width(61).height(20).align(Align.center)
             .padTop(8f / Settings.GUI_SCALE).row();
        table.pack();

        // Settings button
        TextButton settingsButton = new TextButton("Settings", genericStyle);
        table.add(settingsButton).width(200).height(20).align(Align.center)
             .padTop(8f / Settings.GUI_SCALE).row();
        table.pack();

        stage.addActor(table);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.RED);
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
