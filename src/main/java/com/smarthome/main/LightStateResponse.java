package com.smarthome.main;

/**
 * Created by Olga on 23.03.2017.
 */
public class LightStateResponse {

    private String content;

    public LightStateResponse() {
    }

    public LightStateResponse(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

}