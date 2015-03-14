package com.angorow.apptest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import com.angorow.thing.preset.SinTimeShiftStrategy;
import com.angorow.thing.strategy.FilmFpsStrategy;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends Activity {

    //private SurfaceHolder holder;
    public static float _x;
    public static float _y;
    private Timer timer;
    private TimerTask task;
    private View.OnTouchListener touchListener;

    private void PrepareWorld() {
        int a;
        for (a = 1; a < 15; a = a + 1)

        {
            TestThing thing = TestThing.CreateTrianglePrimitive();
            TestWorld.instance().AddThing(thing);

            int radius = a * 20;

            CircleMove function = new CircleMove(thing, new FilmFpsStrategy(), radius);
            TestWorld.instance().RegisterFunction(function);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PrepareWorld();
        //final SurfaceView view = new SurfaceView(this);
        //final TestDrawableView view = new TestDrawableView(this);
        //setContentView(view);

        touchListener = new View.OnTouchListener() {
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

                TestThing thing = TestThing.CreateTrianglePrimitive();

                thing.set_Location((int) _x, (int) _y);
                TestWorld.instance().AddThing(thing);
                TestWorld.instance().RegisterFunction(new CircleMove(thing, SinTimeShiftStrategy.Create(), 200));

                //view.invalidate();
                return true;
            }
//
        };

        //view.setOnTouchListener(touchListener);

//        timer = new Timer();
//
//        task = new TimerTask() {
//            @Override
//            public void run() {
//                if (view.isEnabled())
//                    view.invalidate();
//            }
//        };
//        timer.scheduleAtFixedRate(task, 0, 100);
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
