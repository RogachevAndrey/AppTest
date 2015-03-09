package com.angorow.thing.strategy;

import junit.framework.Assert;

/**
 * Created by Andrey Rogachev on 01.03.2015.
 */
public class TimePointsStrategy extends TimeShiftStrategy {
    ///////////////////////////////////////////////////////////////////////////
    private Double[] _delays;
    private int _delayIndex;

    ///////////////////////////////////////////////////////////////////////////
    protected TimePointsStrategy(Double[] delays) {

        Assert.assertNotNull(delays);

        _delays = delays;
        _delayIndex = 0;
    }

    ///////////////////////////////////////////////////////////////////////////
    public static TimePointsStrategy createToSpeedStrategy() {
        Double[] timePoints = new Double[10];

        for (int index = 0; index < 10; index++) {
            int d = index+1;
            d *= 10;
            timePoints[index] = Double.valueOf(d);
        }

        return new TimePointsStrategy(timePoints);
    }

    @Override
    protected Double get_nextDelay() {

        Double delay = _delays[_delayIndex];

        if (_delayIndex >= _delays.length - 3) _delayIndex = 0;
        else
            _delayIndex++;

        return delay;
    }
}
