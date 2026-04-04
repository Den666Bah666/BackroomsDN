package com.github.den666bah666;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;

public class ShadowLabel extends Label {
    public ShadowLabel(String text, LabelStyle style) {
        super(text, style);
        setAlignment(Align.center);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {

    }
}
