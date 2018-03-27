package sample.vehicles;

import java.util.Arrays;

public class Limo extends Vehicle {

    private String type;
    private String color;

    @Override
    public void setCapacity() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        return number + "," + available + "," + Arrays.toString(passengers.toArray()) + "-" + type + "-" + color;
    }
}
