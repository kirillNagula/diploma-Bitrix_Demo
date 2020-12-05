package by.nagula.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/home")
public class WeatherController {
    private static final String URL = "http://api.openweathermap.org/data/2.5/weather?q=Minsk&appid=d4ff6f3eae5a8a2a0919410237405626";

    @GetMapping(path = "/weather")
    public ModelAndView  getPage(ModelAndView modelAndView) {

        return modelAndView;
    }

}
