package com.angorow.apptest;

import com.angorow.thing.core.ExecStrategy;
import com.angorow.thing.core.Function;
import com.angorow.thing.core.Thing;

/**
 * Created by Andrey Rogachev on 01.03.2015.
 */
public class CircleMove extends Function {

    private final int _radius;
    private Double _period;
    private int _x;
    private int _y;

    protected CircleMove(Thing thing, ExecStrategy execStrategy, int radius) {
        super(thing, execStrategy);

        this._radius = radius;
        _x = (int) (Math.sin(_period) * _radius);
        _y = (int) (Math.cos(_period) * _radius);

        _period = 0.0;
    }

    @Override
    protected void OnExec(Thing thing) {

        if (_period > 6.27) _period = 0.0;
        else
            _period = +0.01;

        int x_Offset = _x - (int) (Math.sin(_period) * _radius);
        int y_Offset = _y - (int) (Math.cos(_period) * _radius);

        _x = (int) (Math.sin(_period) * _radius);
        _y = (int) (Math.cos(_period) * _radius);

        thing.set_Location( x_Offset, y_Offset);
    }
}
