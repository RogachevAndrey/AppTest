package com.angorow.thing;

/**
 * Created by Alyaska on 28.02.2015.
 */

import android.graphics.Region;

import java.util.Observable;

public abstract class Thing extends Observable {

    private Region _bounds;
    private String _name;

    protected Thing(Region bounds, String name) {

        if (bounds == null) throw new NullPointerException("");
        if (name == null) throw new NullPointerException("");

        _name = name;
        _bounds = bounds;
    }

    public Region get_bounds() {
        return _bounds;
    }

    public void set_bounds(Region _bounds) {

        this._bounds = _bounds;
        Notify();
    }

    public String get_name() {
        return _name;
    }

    private void Notify() {
        this.notifyObservers(this);
    }
}
