package com.angorow.apptest;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.angorow.thing.Thing;

import java.util.Set;

/**
 * Created by Alyaska on 02.01.2015.
 */
public class TestDrawableView extends View {
    Paint paint;
    Drawable drawable;
    Drawable bground;
    Rect r;

    public TestDrawableView(Context context) {
        super(context);

           TestWorld.instance().AddThing(TestThing.CreateTrianglePrimitive());
        TestWorld.instance().AddThing(TestThing.CreateTrianglePrimitive());
        TestWorld.instance().AddThing(TestThing.CreateTrianglePrimitive());
        paint = new Paint();
        Resources resources = getResources();

        drawable = resources.getDrawable(R.drawable.ic_launcher);
        bground = resources.getDrawable(R.drawable.test);

        bground.setBounds(0, 0, 1000, 1000);
        r = new Rect(0, 0, 100, 100);
        drawable.setColorFilter(Color.WHITE, PorterDuff.Mode.MULTIPLY);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Set<Thing> thingSet = TestWorld.instance().get_thingSet();


        r.offsetTo((int) MainActivity._x, (int) MainActivity._y);
        paint.setColor(150);
//                canvas1.drawColor(150);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1);
//
        paint.setColor(Color.GREEN);
//
        for (Thing thing : thingSet) {


            canvas.drawPath(thing.get_bounds(), paint);
        }

//                if (event.getAction() == MotionEvent.ACTION_DOWN)
//                    paint.setColor(Color.WHITE);
//
//
//                if (event.getAction() == MotionEvent.ACTION_UP)
//                    paint.setColor(Color.BLUE);
//
//                if (event.getAction() == MotionEvent.ACTION_MOVE)
//                    paint.setColor(Color.GREEN);

        //drawable.setBounds(r);
        canvas.drawRect(r, paint);


        drawable.draw(canvas);
        //bground.draw(canvas);
    }
}
