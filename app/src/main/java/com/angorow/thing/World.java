package com.angorow.thing;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Andrey Rogachev on 28.02.2015.
 */
public abstract class World {

    private Set<Thing> _thingSet;

    protected World() {
        _thingSet = new HashSet<Thing>();

    }

    public void AddThing(Thing thing) {
        _thingSet.add(thing);
    }

    public Set<Thing> get_thingSet() {
        return _thingSet;
    }
}
