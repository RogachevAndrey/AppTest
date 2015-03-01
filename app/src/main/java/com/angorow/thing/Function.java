package com.angorow.thing;

/**
 * Created by Alyaska on 01.03.2015.
 */
public abstract class Function {

    protected Function() {
    }

    public void Exec() {
        OnExec();
    }

    protected abstract void OnExec();
}
