package com.angorow.thing.core;

import junit.framework.Assert;

import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Andrey Rogachev on 28.02.2015.
 */
public abstract class World {

    private Timer _timer;
    private Set<Thing> _thingSet;
    private Set<Function> _functionSet;

    protected World() {
        _thingSet = new HashSet<Thing>();
        _functionSet = new HashSet<Function>();
        _timer = new Timer();
        _timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                OnTick();
            }
        }, 0, 100);
    }

    protected void OnTick() {
        for (Function func : _functionSet) {
            func.Exec();
        }
    }

    public void RegisterFunction(Function function) {

        Assert.assertNotNull(function);

        _functionSet.add(function);
    }

    public void AddThing(Thing thing) {

        Assert.assertNotNull(thing);

        _thingSet.add(thing);
    }

    public Set<Thing> get_thingSet() {
        return _thingSet;
    }
}
