package com.angorow.apptest;

import com.angorow.thing.ExecStrategy;
import com.angorow.thing.Function;
import com.angorow.thing.Thing;

/**
 * Created by Alyaska on 01.03.2015.
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
