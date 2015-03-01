package com.angorow.thing.strategy;

import com.angorow.thing.ExecStrategy;

/**
 * Created by Andrey Rogachev on 01.03.2015.
 */
public abstract class TimeShiftStrategy extends ExecStrategy {

    private Float _multiplier;

    protected TimeShiftStrategy(Float multiplier) {
        _multiplier = multiplier;
    }
}
