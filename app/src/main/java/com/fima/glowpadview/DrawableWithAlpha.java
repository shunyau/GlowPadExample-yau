package com.fima.glowpadview;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

class DrawableWithAlpha extends Drawable {
    private float mAlpha = 1.0f;
    private Drawable mRealDrawable;

    public DrawableWithAlpha(Drawable realDrawable) {
        mRealDrawable = realDrawable;
    }

    public void setAlpha(float alpha) {
        mAlpha = alpha;
    }

    public float getAlpha() {
        return mAlpha;
    }

    public void draw(Canvas canvas) {
        mRealDrawable.setAlpha((int) Math.round(mAlpha * 255f));
        mRealDrawable.draw(canvas);
    }

    @Override
    public void setAlpha(int alpha) {
        mRealDrawable.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter cf) {
        mRealDrawable.setColorFilter(cf);
    }

    @Override
    public int getOpacity() {
        return mRealDrawable.getOpacity();
    }
}
