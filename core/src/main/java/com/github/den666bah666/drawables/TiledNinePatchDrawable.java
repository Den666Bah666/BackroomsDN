package com.github.den666bah666.drawables;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TiledDrawable;
import com.github.den666bah666.Settings;

public class TiledNinePatchDrawable extends NinePatchDrawable {
    private final TiledDrawable drawable;
    private final float left, right, top, bottom;

    public TiledNinePatchDrawable(NinePatch patch, TextureRegion textureRegion) {
        super(patch);

        left = getLeftWidth();
        right = getRightWidth();
        top = getTopHeight();
        bottom = getBottomHeight();

        TextureRegion centerRegion = new TextureRegion(
            textureRegion,
            (int) (textureRegion.getRegionX() + left),
            (int) (textureRegion.getRegionY() + bottom),
            (int) (textureRegion.getRegionWidth() - left - right),
            (int) (textureRegion.getRegionHeight() - top - bottom)
        );

        centerRegion.getTexture().setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        drawable = new TiledDrawable(centerRegion);
    }

    @Override
    public void draw(Batch batch, float x, float y, float width, float height) {
        super.draw(batch, x, y, width, height);

        drawable.draw(batch,
            x + left,
            y + bottom,
            width - left - right,
            height - top - bottom
        );
    }
}
