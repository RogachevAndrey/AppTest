package com.angorow.thing.core;

/**
 * Created by Andrey Rogachev on 01.03.2015.
 */
public abstract class Function {

    private Thing _thing;
    private ExecStrategy _execStrategy;

    protected Function(Thing thing, ExecStrategy execStrategy) {
        _thing = thing;
        _execStrategy = execStrategy;
    }

    void Exec() {
        if (_execStrategy.get_canExec())
            OnExec(_thing);
    }

    protected abstract void OnExec(Thing thing);
}
