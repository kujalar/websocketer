package com.ari.websocketer.greeter;

/**
 * Created by Ari Kujala on 10/4/2017.
 */
public class Counter {
    private volatile long value = 0;
    public synchronized long getNextValue(){
        value++;
        return value;
    }
}
