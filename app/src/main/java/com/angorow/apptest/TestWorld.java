package com.angorow.apptest;

import com.angorow.thing.core.World;

/**
 * Created by Andrey Rogachev on 01.03.2015.
 */
public class TestWorld extends World {

    private static TestWorld _instance;

    private TestWorld() {

    }

    public static TestWorld instance() {
        if (_instance == null) _instance = new TestWorld();

        return _instance;
    }
}
