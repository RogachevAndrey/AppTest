package com.angorow.thing.core;

/**
 * Created by Andrey Rogachev on 01.03.2015.
 */
public abstract class ExecStrategy {

    protected ExecStrategy() {
    }

    public abstract Boolean get_canExec();
}
