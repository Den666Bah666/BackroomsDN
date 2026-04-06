package com.github.den666bah666.drawables;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.BaseDrawable;

public class MinecraftButtonDrawable extends BaseDrawable {
    private final TextureRegion l, tl, t, tr, r, br, b, bl, c;
    private TextureRegion pre;

    public MinecraftButtonDrawable(NinePatch patch, TextureRegion region) {
        tl = new TextureRegion(region, 0, 0, (int) patch.getLeftWidth(), (int) patch.getTopHeight());

        tr = new TextureRegion(region, (int) (patch.getLeftWidth() + patch.getMiddleWidth()), 0,
            (int) patch.getRightWidth(), (int) patch.getTopHeight());

        bl = new TextureRegion(region, 0, (int) (patch.getTopHeight() + patch.getMiddleHeight()),
            (int) patch.getLeftWidth(), (int) patch.getBottomHeight());

        br = new TextureRegion(region, (int) (patch.getLeftWidth() + patch.getMiddleWidth()),
            (int) (patch.getTopHeight() + patch.getMiddleHeight()), (int) patch.getRightWidth(),
            (int) patch.getBottomHeight());

        b = new TextureRegion(region, (int) patch.getLeftWidth(),
            (int) (patch.getTopHeight() + patch.getMiddleHeight()), (int) patch.getMiddleWidth(),
            (int) patch.getBottomHeight());

        l = new TextureRegion(region, 0, (int) patch.getTopHeight(), (int) patch.getLeftWidth(), (int) patch.getMiddleHeight());

        t = new TextureRegion(region, (int) patch.getLeftWidth(), 0, (int) patch.getMiddleWidth(),
            (int) patch.getTopHeight());

        r = new TextureRegion(region, (int) (patch.getLeftWidth() + patch.getMiddleWidth()),
            (int) patch.getTopHeight(), (int) patch.getRightWidth(), (int) patch.getMiddleHeight());

        c = new TextureRegion(region, (int) patch.getLeftWidth(), (int) patch.getTopHeight(),
            (int) patch.getMiddleWidth(), (int) patch.getMiddleHeight());

        pre = new TextureRegion();
    }

    @Override
    public void draw(Batch batch, float x, float y, float width, float height) {
        int iW, iH;
        int fW, fH;

        // Corners
        batch.draw(bl, x, y);
        batch.draw(tl, x, y + height - t.getRegionHeight());
        batch.draw(br, x + width - l.getRegionWidth(), y);
        batch.draw(tr, x + width - r.getRegionWidth(), y + height - t.getRegionHeight());

        // Top + Bottom
        iW = (int) (width - l.getRegionWidth() - r.getRegionWidth()) / c.getRegionWidth();
        fW = (int) (width - l.getRegionWidth() - r.getRegionWidth()) % c.getRegionWidth();
        for (int x_ = 0; x_ < iW; x_++) {
            batch.draw(t, x + l.getRegionWidth() + c.getRegionWidth() * x_,
                y + height - t.getRegionHeight());
            batch.draw(b, x + l.getRegionWidth() + c.getRegionWidth() * x_, y);
        }
        if (fW > 0) {
            pre.setRegion(t, 0, 0, fW, t.getRegionHeight());
            batch.draw(pre, x + l.getRegionWidth() + c.getRegionWidth() * iW,
                y + height - t.getRegionHeight());
            pre.setRegion(b, 0, 0, fW, b.getRegionHeight());
            batch.draw(pre, x + l.getRegionWidth() + c.getRegionWidth() * iW, y);
        }

        // Left + Right
        iH = (int) (height - t.getRegionHeight() - b.getRegionHeight()) / c.getRegionHeight();
        fH = (int) (height - t.getRegionHeight() - b.getRegionHeight()) % c.getRegionHeight();
        for (int y_ = 0; y_ < iH; y_++) {
            batch.draw(l, x, y + b.getRegionHeight() + c.getRegionHeight() * y_);
            batch.draw(r, x + width - r.getRegionWidth(), y + b.getRegionHeight() + c.getRegionHeight() * y_);
        }
        if (fH > 0) {
            pre.setRegion(l, 0, l.getRegionHeight() - fH, l.getRegionWidth(), fH);
            batch.draw(pre, x, y + b.getRegionHeight() + c.getRegionHeight() * iH);
            pre.setRegion(r, 0, r.getRegionHeight() - fH, r.getRegionWidth(), fH);
            batch.draw(pre, x + width - r.getRegionWidth(), y + b.getRegionHeight() + c.getRegionHeight() * iH);
        }

        for (int x_ = 0; x_ < iW; x_++) {
            for (int y_ = 0; y_ < iH; y_++) {
                batch.draw(c, x + l.getRegionWidth() + c.getRegionWidth() * x_,
                    y + b.getRegionHeight() + c.getRegionHeight() * y_);
            }
            if (fH > 0) {
                pre.setRegion(c, 0, c.getRegionHeight() - fH, c.getRegionWidth(), fH);
                batch.draw(pre, x + l.getRegionWidth() + c.getRegionWidth() * x_,
                    y + b.getRegionHeight() + c.getRegionHeight() * iH);
            }
        }
        if (fW > 0) {
            for (int y_ = 0; y_ < iH; y_++) {
                pre.setRegion(c, 0, 0, fW, c.getRegionHeight());
                batch.draw(pre, x + l.getRegionWidth() + c.getRegionWidth() * iW,
                    y + b.getRegionHeight() + c.getRegionHeight() * y_);
            }
            if (fH > 0) {
                pre.setRegion(c, 0, c.getRegionHeight() - fH, fW, fH);
                batch.draw(pre, x + l.getRegionWidth() + c.getRegionWidth() * iW,
                    y + b.getRegionHeight() + c.getRegionHeight() * iH);
            }
        }
    }


    public void draw_old(Batch batch, float x, float y, float width, float height) {
        batch.draw(tl, x, y + height - tl.getRegionHeight(), tl.getRegionWidth(), tl.getRegionHeight());
        batch.draw(tr, x + width - tr.getRegionWidth(), y + height - tr.getRegionHeight(),  tr.getRegionWidth(), tr.getRegionHeight());
        batch.draw(bl, x, y, bl.getRegionWidth(), bl.getRegionHeight());
        batch.draw(br, x + width - br.getRegionWidth(), y, br.getRegionWidth(), br.getRegionHeight());

        // Bottom
        int ints = (int) (width - bl.getRegionWidth() - br.getRegionWidth()) / b.getRegionWidth();
        int floats = (int) (width - bl.getRegionWidth() - br.getRegionWidth()) % b.getRegionWidth();
        for (int x_ = 0; x_ < ints; x_++) {
            batch.draw(b, x + bl.getRegionWidth() + b.getRegionWidth() * x_, y, b.getRegionWidth(), b.getRegionHeight());
        }
        if (floats > 0) {
            pre.setRegion(b, 0, 0, floats, b.getRegionHeight());
            batch.draw(pre, x + bl.getRegionWidth() + b.getRegionWidth() * ints, y);
        }

        // Left
        ints = (int) (height - bl.getRegionHeight() - tl.getRegionHeight()) / l.getRegionHeight();
        floats = (int) (height - bl.getRegionHeight() - tl.getRegionHeight()) % l.getRegionHeight();
        for (int y_ = 0; y_ < ints; y_++) {
            batch.draw(l, x, y + bl.getRegionHeight() + l.getRegionHeight() * y_, l.getRegionWidth(), l.getRegionHeight());
        }
        if (floats > 0) {
            pre.setRegion(l, 0, 0, l.getRegionWidth(), floats);
            batch.draw(pre, x, y + bl.getRegionHeight() + l.getRegionHeight() * ints);
        }

        // Top
        ints = (int) (width - tl.getRegionWidth() - tr.getRegionWidth()) / t.getRegionWidth();
        floats = (int) (width - tl.getRegionWidth() - tr.getRegionWidth()) % t.getRegionWidth();
        for (int x_ = 0; x_ < ints; x_++) {
            batch.draw(t, x + tl.getRegionWidth() + t.getRegionWidth() * x_,
                y + bl.getRegionHeight() + c.getRegionHeight());
        }
        if (floats > 0) {
            pre.setRegion(t, 0, 0, floats, t.getRegionHeight());
            batch.draw(pre, x + tl.getRegionWidth() + t.getRegionWidth() * ints,
                y + bl.getRegionHeight() + l.getRegionHeight());
        }

        // Right
        ints = (int) (height - tr.getRegionHeight() - br.getRegionHeight()) / r.getRegionHeight();
        floats = (int) (width - tr.getRegionWidth() - br.getRegionWidth()) % r.getRegionWidth();
        for (int y_ = 0; y_ < ints; y_++) {
            batch.draw(r, x + width - tr.getRegionWidth(), y + br.getRegionHeight() + r.getRegionHeight() * y_);
        }
        if (floats > 0) {
            pre.setRegion(r, 0, r.getRegionHeight() - floats, r.getRegionWidth(), floats);
            batch.draw(pre, x + width - tr.getRegionWidth(), y + bl.getRegionHeight() + r.getRegionHeight() * ints);
        }

        // Center
        int intsH = (int) (height - b.getRegionHeight() - t.getRegionHeight()) / c.getRegionHeight();
        float floatsH = (int) (height - b.getRegionHeight() - t.getRegionHeight()) % c.getRegionHeight();
        int intsW = (int) (width - l.getRegionWidth() - r.getRegionWidth()) / c.getRegionWidth();
        float floatsW = (int) (width - l.getRegionWidth() - r.getRegionWidth()) % c.getRegionWidth();
        for (int y_ = 0; y_ < intsH; y_++) {
            for (int x_ = 0; x_ < intsW; x_++) {
                batch.draw(c, x + tl.getRegionWidth() + c.getRegionWidth() * x_,
                    y + b.getRegionHeight() + c.getRegionHeight() * y_);
            }
        }
    }
}
