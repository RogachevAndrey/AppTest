package com.angorow.thing.core;

/**
 * Created by Andrey Rogachev on 28.02.2015.
 * Abstraction for all world objects
 */

import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;

import java.util.Observable;

public abstract class Thing extends Observable {
    ///////////////////////////////////////////////////////////////////////////
    private Path _bounds;
    private String _name;

    ///////////////////////////////////////////////////////////////////////////
    protected Thing(Path bounds, String name) {

        if (bounds == null) throw new NullPointerException("");
        if (name == null) throw new NullPointerException("");

        _name = name;
        _bounds = bounds;
    }

    public Path get_bounds() {
        return _bounds;
    }

    private void set_bounds(Path _bounds) {

        this._bounds = _bounds;

        Notify();
    }

    public Point get_Location() {
        RectF bounds = new RectF();
        _bounds.computeBounds(bounds, false);

        return new Point((int) bounds.left, (int) bounds.right);
    }

    public String get_name() {
        return _name;
    }

    private void Notify() {
        if (this.countObservers() > 0)
            this.notifyObservers(this);
    }

    /**
     * Returns an integer hash code for this object. By contract, any two
     * objects for which {@link #equals} returns {@code true} must return
     * the same hash code value. This means that subclasses of {@code Object}
     * usually override both methods or neither method.
     * <p/>
     * <p>Note that hash values must not change over time unless information used in equals
     * comparisons also changes.
     * <p/>
     * <p>See <a href="{@docRoot}reference/java/lang/Object.html#writing_hashCode">Writing a correct
     * {@code hashCode} method</a>
     * if you intend implementing your own {@code hashCode} method.
     *
     * @return this object's hash code.
     * @see #equals
     */
    @Override
    public int hashCode() {
        return super.hashCode() ^ _name.hashCode();
    }

    public void set_Location(int x, int y) {
        _bounds.offset(x, y);
    }
}
