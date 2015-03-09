package com.angorow.thing.strategy;

/**
 * Created by Andrey Rogachev on 08.03.2015.
 */
public class FilmFpsStrategy extends TimeShiftStrategy {
    ///////////////////////////////////////////////////////////////////////////
    public static Double FILM_FPS = 1.0;//41.6;

    ///////////////////////////////////////////////////////////////////////////
    @Override
    protected Double get_nextDelay() {
        return FILM_FPS;
    }
}
