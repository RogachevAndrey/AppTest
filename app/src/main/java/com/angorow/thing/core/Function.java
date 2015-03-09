package com.angorow.thing.core;

import junit.framework.Assert;

/**
 * Created by Andrey Rogachev on 01.03.2015.
 */
public abstract class Function {

    private static int _keyGen = 0;
    private final int _key;
    private Thing _thing;
    private ExecStrategy _execStrategy;

    protected Function(Thing thing, ExecStrategy execStrategy) {

        Assert.assertNotNull(thing);
        Assert.assertNotNull(execStrategy);

        _keyGen++;
        _key = _keyGen;
        _thing = thing;
        _execStrategy = execStrategy;
    }

    void Exec() {
        if (_execStrategy.get_canExec())
            OnExec(_thing);
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
        return super.hashCode() ^ _key;
    }

    protected abstract void OnExec(Thing thing);
}

