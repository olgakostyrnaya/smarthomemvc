package com.smarthome.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Olga on 06.03.2017.
 */

@Controller

public class MainController  {
    @RequestMapping(value = "/home.html")
    public ModelAndView home(@RequestParam ("light") String lightState){
        ModelAndView mv = new ModelAndView();
        mv.addObject("lightState",lightState);
        return mv;

    }

}