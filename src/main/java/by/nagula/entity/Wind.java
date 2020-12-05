package by.nagula.entity;

public class Wind {
    private int wind;
    private int visibility;

    public Wind(int wind, int visibility) {
        this.wind = wind;
        this.visibility = visibility;
    }

    public Wind() {
    }

    public int getWind() {
        return wind;
    }

    public void setWind(int wind) {
        this.wind = wind;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }
}
