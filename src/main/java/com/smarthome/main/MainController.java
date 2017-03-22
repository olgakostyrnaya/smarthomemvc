package com.smarthome.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;


@Controller

public class MainController  {
    @RequestMapping(value = "/home.html", method = RequestMethod.GET)
    public ModelAndView home(@RequestParam(value = "light",required = false) String lightState,
                             @RequestParam(value = "errorMessage",required = false) String msg) throws IOException {

        ModelAndView mv = new ModelAndView();

        if (readFromFile().equals(lightState)){
            return mv.addObject("lightState", lightState);
        }
        else if (lightState != null){
            saveToFile(lightState);
            return mv.addObject("lightState",lightState);
        }

        mv.addObject("lightState",readFromFile());
        return mv;
    }

    private void saveToFile(String state){
        File file = new File("C:\\Users\\Olga\\IdeaProjects\\smarthomemvc\\src\\main\\webapp\\docs\\states.txt");

        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {

            if (!file.exists()) {
                file.createNewFile();
            }

            byte[] stateBytes =state.getBytes();

            fileOutputStream.write(stateBytes);
            fileOutputStream.flush();
            fileOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readFromFile() throws IOException {

        File file = new File("C:\\Users\\Olga\\IdeaProjects\\smarthomemvc\\src\\main\\webapp\\docs\\states.txt");

        FileInputStream fileInputStream = new FileInputStream(file);

        try(ByteArrayOutputStream result = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fileInputStream.read(buffer)) != -1) {
                result.write(buffer, 0, length);
            }
            return result.toString("UTF-8");
        }
    }
}
