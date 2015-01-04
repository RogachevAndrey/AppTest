package com.angorow.apptest;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Alyaska on 02.01.2015.
 */
public class TestDrawableView extends SurfaceView implements SurfaceHolder.Callback {

    public TestDrawableView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);



        canvas.drawColor(165);
        canvas.clipRect(0, 0, 400, 400);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
