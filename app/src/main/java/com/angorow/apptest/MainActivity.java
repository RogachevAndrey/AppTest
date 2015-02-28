package com.angorow.apptest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;


public class MainActivity extends Activity {

    //private SurfaceHolder holder;
    public static float _x;
    public static float _y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //final SurfaceView view = new SurfaceView(this);
        final TestDrawableView view = new TestDrawableView(this);
        setContentView(view);

        View.OnTouchListener touchListener = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
//
//                if (holder == null)
//                    holder = ((SurfaceView) v).getHolder();
//
//                Canvas canvas1 = holder.lockCanvas();
//
//                Rect r = new Rect(((int) event.getX()), ((int) event.getY()), 0, 0);
//
//                Paint paint = new Paint();
//
//                paint.setColor(150);
//                canvas1.drawColor(150);
//                paint.setStyle(Paint.Style.STROKE);
//                paint.setStrokeWidth(1);
//
//
//
//                if (event.getAction() == MotionEvent.ACTION_DOWN)
//                    paint.setColor(Color.WHITE);
//
//
//                if (event.getAction() == MotionEvent.ACTION_UP)
//                    paint.setColor(Color.BLUE);
//
//                if (event.getAction() == MotionEvent.ACTION_MOVE)
//                    paint.setColor(Color.GREEN);
//
//                canvas1.drawRect(r, paint);
//                canvas1.drawText(canvas1.toString(), r.left, r.top, paint);
//
//                holder.unlockCanvasAndPost(canvas1);
//
                _x = event.getX();
                _y = event.getY();

                view.invalidate();
                return true;
            }
//
        };

        view.setOnTouchListener(touchListener);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar Fwill
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
