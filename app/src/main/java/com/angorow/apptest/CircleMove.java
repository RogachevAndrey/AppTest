package com.angorow.apptest;

import com.angorow.thing.core.ExecStrategy;
import com.angorow.thing.core.Function;
import com.angorow.thing.core.Thing;

/**
 * Created by Andrey Rogachev on 01.03.2015.
 */
public class CircleMove extends Function {

    private final int _radius;
    private int _x;
    private int _y;

    protected CircleMove(Thing thing, ExecStrategy execStrategy, int radius) {
        super(thing, execStrategy);

        this._radius = radius;
    }

    @Override
    protected void OnExec(Thing thing) {

        double x_Offset = _x - Math.sin(thing.get_Location().x + 0.01) * _radius;
        double y_Offset = _y - Math.cos(thing.get_Location().y + 0.01) * _radius;

        _x = (int) (Math.sin(thing.get_Location().x + 0.01) * _radius);
        _y = (int) (Math.cos(thing.get_Location().x + 0.01) * _radius);

        thing.set_Location((int) (_y + y_Offset), (int) (_x + x_Offset));
    }
}
