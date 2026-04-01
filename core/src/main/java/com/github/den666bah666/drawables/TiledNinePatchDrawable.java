package com.github.den666bah666.drawables;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;

public class TiledNinePatchDrawable extends TiledButtonDrawable {
    private NinePatchDrawable patchDrawable;

    public TiledNinePatchDrawable(NinePatch patch, TextureRegion bgRegion) {
        super(bgRegion);
        patchDrawable = new NinePatchDrawable(patch);

        patchDrawable.getPatch().getTexture().setFilter(
            com.badlogic.gdx.graphics.Texture.TextureFilter.Nearest,
            com.badlogic.gdx.graphics.Texture.TextureFilter.Nearest
        );
    }

    @Override
    public void draw(Batch batch, float x, float y, float width, float height) {
        super.draw(batch, x, y, width, height);
        patchDrawable.draw(batch, x, y, width, height);
    }
}
