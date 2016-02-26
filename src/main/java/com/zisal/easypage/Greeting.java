package com.zisal.easypage;

import java.io.PrintStream;

/**
 * Created by Ladies Man on 1/13/2016.
 */
public class Greeting {
    public void greet(PrintStream to, String name) {
        to.println(createGreeting(name));
    }

    public String createGreeting(String name) {
        return "Hello, " + name + "!";
    }
}
