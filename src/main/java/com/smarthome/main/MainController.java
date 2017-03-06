package com.smarthome.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Olga on 06.03.2017.
 */

@Controller
public class MainController {
    @RequestMapping(value = "/")
    public String home(){
        return "test";
    }
}