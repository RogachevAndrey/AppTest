package com.angorow.thing;

/**
 * Created by Andrey Rogachev on 28.02.2015.
 * Abstraction for all world objects
 */

import android.graphics.Path;

import java.util.Observable;

public abstract class Thing extends Observable {

    private Path _bounds;
    private String _name;

    protected Thing(Path bounds, String name) {

        if (bounds == null) throw new NullPointerException("");
        if (name == null) throw new NullPointerException("");

        _name = name;
        _bounds = bounds;
    }

    public Path get_bounds() {
        return _bounds;
    }

    public void set_bounds(Path _bounds) {

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
