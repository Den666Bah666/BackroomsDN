package com.github.den666bah666.views;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.github.den666bah666.models.Player;

public class PlayerView {
    private Texture texture;

    public PlayerView(Texture texture) {
        this.texture = texture;
    }

    public void render(SpriteBatch batch, Player model) {
        batch.draw(texture, model.getPosition().x, model.getPosition().y);
    }
}
