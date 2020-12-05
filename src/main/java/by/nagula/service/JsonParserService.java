package by.nagula.service;

import by.nagula.entity.Temperature;
import by.nagula.entity.Wind;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.Charset;

@Service
public class JsonParserService {

    private String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public JSONObject getJson(InputStream is){
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            return new JSONObject(jsonText);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Temperature getTemp(JSONObject jsonObj){
        JSONObject jsonObject = jsonObj.getJSONObject("main");
        Temperature temperature = new Temperature();
        temperature.setTemp((Double) jsonObject.get("temp") - 273.15);
        temperature.setTemp_min((Double) jsonObject.get("temp_min") - 273.15);
        temperature.setTemp_max((Double) jsonObject.get("temp_max") - 273.15);
        temperature.setFeels_like((Double) jsonObject.get("feels_like") - 273.15);
        temperature.setPressure((Integer) jsonObject.get("pressure"));
        temperature.setHumidity((Integer) jsonObject.get("humidity"));
        return temperature;
    }

    public Wind getWind(JSONObject jsonObj){
        JSONObject jsonObject = jsonObj.getJSONObject("wind");
        Wind wind = new Wind();
        wind.setWind((Integer) jsonObject.get("speed"));
        wind.setVisibility((Integer) jsonObj.get("visibility"));
        return wind;
    }

}
