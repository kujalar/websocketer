package com.ari.websocketer.greeter;

import javax.inject.Inject;

/**
 * Created by Ari Kujala on 10/4/2017.
 */
public class Greeter {
    private static long counter = 0;
    private long counterNoStatic = 0;

    @Inject
    Counter counterInstance;

    public String sayGreeting(){
        //this is not thread safe, but who cares, just see if it counts up
        counter = counter + 1;
        counterNoStatic++;
        long value = counterInstance.getNextValue();
        return "counterInstance.value="+value+" staticCounter="+counter+" nonStaticCounter="+counterNoStatic+" from a Greeter@"+this.hashCode();
    }
}
