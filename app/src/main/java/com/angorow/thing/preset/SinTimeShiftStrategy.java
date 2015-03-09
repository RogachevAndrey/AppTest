package com.angorow.thing.preset;

import com.angorow.thing.strategy.TimeShiftStrategy;

/**
 * Created by Andrey Rogachev on 08.03.2015.
 */
public class SinTimeShiftStrategy extends TimeShiftStrategy {
    private final Double _step;
    private int multiplier;
    ///////////////////////////////////////////////////////////////////////////
    private Double _period;

    ///////////////////////////////////////////////////////////////////////////
    ///0.00 => period <= 6.28
    ///////////////////////////////////////////////////////////////////////////
    public SinTimeShiftStrategy(Double period, Double step, int multiplier) {

        this._period = period;
        this._step = step;
        this.multiplier = multiplier;
    }

    ///////////////////////////////////////////////////////////////////////////
    ///Default
    ///////////////////////////////////////////////////////////////////////////
    public static SinTimeShiftStrategy Create() {
        return new SinTimeShiftStrategy(0.0, 0.1, 10);
    }

    @Override
    protected Double get_nextDelay() {
        double sin = Math.sin(_period);

        if (_period >= 6.28) _period = 0.0;
        else
            _period = +_step;

        return sin * multiplier;
    }
}
