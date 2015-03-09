package com.angorow.thing.strategy;

import com.angorow.thing.core.ExecStrategy;

/**
 * Created by Andrey Rogachev on 01.03.2015.
 */
public abstract class TimeShiftStrategy extends ExecStrategy {
    ///////////////////////////////////////////////////////////////////////////
    private Double _tickCounter;

    ///////////////////////////////////////////////////////////////////////////
    protected TimeShiftStrategy() {
        _tickCounter = 0.0;
    }

    ///////////////////////////////////////////////////////////////////////////
    protected abstract Double get_nextDelay();

    @Override
    public final Boolean get_canExec() {

        Boolean _flag = _tickCounter <= 0;

        if (_flag) _tickCounter = get_nextDelay();

        _tickCounter--;

        return _flag;
    }
}
