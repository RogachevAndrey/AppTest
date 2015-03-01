package com.angorow.apptest;

import android.graphics.Path;

import com.angorow.thing.Thing;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Andrey Rogachev on 01.03.2015.
 */
public class TestThing extends Thing {

    private Timer timer;

    protected TestThing(Path bounds, String name) {
        super(bounds, name);

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                _Move();
            }
        }, 0, 1);
    }

    public static TestThing CreateTrianglePrimitive() {

        Path path = new Path();

        int x, y;

        int a = 0;
        path.moveTo((int) (Math.random() * Math.random() * 100), (int) (Math.random() * Math.random() * 100));
        while (a < 10) {

            path.lineTo((int) (Math.random() * Math.random() * 100), (int) (Math.random() * Math.random() * 100));
            a++;
        }
        path.close();

        x = (int) (Math.random() * 100);
        y = (int) (Math.random() * 100);

        //path.addRect(x, y, 100 + x, 100 + y, Path.Direction.CW);

        return new TestThing(path, "test");
    }

    private void _Move() {
        Path bounds = this.get_bounds();

        bounds.offset((int) ((Math.random() - .5) * 10), (int) ((Math.random() - .5) * 10));

        set_bounds(bounds);
    }
}
