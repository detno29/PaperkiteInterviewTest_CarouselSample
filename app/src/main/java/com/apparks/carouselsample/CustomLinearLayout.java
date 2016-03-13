package com.apparks.carouselsample;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by longdao on 12/03/16.
 */
public class CustomLinearLayout extends LinearLayout {
    private float scale = MainActivity.BIG_SCALE;
    private float opacity = MainActivity.ALMOST_HALF_OPACITY;

    public CustomLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomLinearLayout(Context context) {
        super(context);
    }

    public void setScaleBoth(float scale) {
        this.scale = scale;
        this.invalidate();

    }

    /*
    @Override
    public void setAlpha(float alpha) {
        this.opacity = alpha;
        this.invalidate();
    }
    */

    @Override
    protected void onDraw(Canvas canvas) {
        // The main mechanism to display scale animation, you can customize it as your needs
        int w = this.getWidth();
        int h = this.getHeight();
        canvas.scale(scale, scale, w/2, h/2);

        super.onDraw(canvas);
    }
}
