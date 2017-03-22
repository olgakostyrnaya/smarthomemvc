package com.smarthome.main;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
/**
 * Created by Olga on 23.03.2017.
 */
@Controller
public class LightStateController {

        @MessageMapping("/checkLight")
        @SendTo("/topic/light")
        public LightStateResponse lightStateResponse(Light light) throws Exception {
            return new LightStateResponse("light" + light.getState());
        }

    }
