package com.angorow.thing.strategy;

import com.angorow.thing.core.ExecStrategy;

/**
 * Created by Andrey Rogachev on 01.03.2015.
 */
public abstract class TimePointsStrategy extends ExecStrategy {

    private int[] _delays;

    protected TimePointsStrategy(int[] delays) {
        _delays = delays;
    }

    @Override
    public Boolean get_canExec() {
        return null;
    }
}
