package com.smarthome.main;

/**
 * Created by Olga on 23.03.2017.
 */
public class Light {

    private String state;

    public Light() {
    }

    public Light(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
