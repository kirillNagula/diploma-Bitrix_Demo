package by.nagula.controller;

import by.nagula.service.JsonParserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

@Controller
@RequestMapping(path = "/home")
public class WeatherController {
    private static final String URLs = "http://api.openweathermap.org/data/2.5/weather?q=Minsk&appid=d4ff6f3eae5a8a2a0919410237405626";
    private final JsonParserService parserService;

    public WeatherController(JsonParserService parserService) {
        this.parserService = parserService;
    }

    @GetMapping(path = "/weather")
    public ModelAndView  getPage(ModelAndView modelAndView) {
        InputStream is = null;
        try {
            is = new URL(URLs).openStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject json = parserService.getJson(is);
        modelAndView.addObject("weather", parserService.getTemp(json));
        modelAndView.addObject("wind", parserService.getWind(json));
        modelAndView.setViewName("weather");
        return modelAndView;
    }
}
