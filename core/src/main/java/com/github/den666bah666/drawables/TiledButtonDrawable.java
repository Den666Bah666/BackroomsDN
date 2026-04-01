package com.github.den666bah666.drawables;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.BaseDrawable;

public class TiledButtonDrawable extends BaseDrawable {
    private TextureRegion bgRegion;

    public TiledButtonDrawable(TextureRegion bgRegion) {
        this.bgRegion = bgRegion;
    }

    @Override
    public void draw(Batch batch, float x, float y, float width, float height) {
        int tileW = bgRegion.getRegionWidth();
        int tileH = bgRegion.getRegionHeight();

        for (float y_ = y; y_ < y + height; y_ += tileH) {
            for (float x_ = x; x_ < x + width; x_ += tileW) {
                batch.draw(bgRegion, x_, y_,
                    Math.min(tileW, x + width - x_), Math.min(tileH, y + height - y_));
            }
        }
    }
}
