package com.angorow.thing.strategy;

import junit.framework.Assert;

/**
 * Created by Andrey Rogachev on 01.03.2015.
 */
public abstract class TimePointsStrategy extends TimeShiftStrategy {
    ///////////////////////////////////////////////////////////////////////////
    private Double[] _delays;
    private int _delayIndex;

    ///////////////////////////////////////////////////////////////////////////
    protected TimePointsStrategy(Double[] delays) {

        Assert.assertNotNull(delays);

        _delays = delays;
        _delayIndex = 0;
    }

    @Override
    protected Double get_nextDelay() {

        Double delay = _delays[_delayIndex];

        if (_delayIndex >= _delays.length) _delayIndex = 0;
        else
            _delayIndex++;

        return delay;
    }
}
