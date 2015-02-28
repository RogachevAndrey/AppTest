package com.angorow.thing;

/**
 * Created by Alyaska on 28.02.2015.
 */

import android.graphics.Rect;

public abstract class Thing {

    private Rect _bounds;

    protected Thing(Rect bounds) throws Exception {

        if (bounds == null) throw new Exception();

        _bounds = bounds;
    }

    public Rect get_bounds() {
        return _bounds;
    }

    public void set_bounds(Rect _bounds) {
        this._bounds = _bounds;
    }

}
