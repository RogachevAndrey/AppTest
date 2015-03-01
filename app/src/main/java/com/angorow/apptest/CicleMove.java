package com.angorow.apptest;

import com.angorow.thing.core.ExecStrategy;
import com.angorow.thing.core.Function;
import com.angorow.thing.core.Thing;

/**
 * Created by Andrey Rogachev on 01.03.2015.
 */
public class CicleMove extends Function {

    protected CicleMove(Thing thing, ExecStrategy execStrategy) {
        super(thing, execStrategy);
    }

    @Override
    protected void OnExec(Thing thing) {
    }

    public CicleMove Create(Thing thing) {
        return new CicleMove(thing, new CicleStrategy());
    }
}
