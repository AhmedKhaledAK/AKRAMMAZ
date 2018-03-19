package sample.vehicles;

import sample.dates.Date;

public abstract class Vehicle {

    short capacity;
    int number;
    boolean available;

    public abstract void setCapacity();

    public void setNumber(int number) {
        this.number = number;
    }

    public short getCapacity() {
        return capacity;
    }

    public int getNumber() {
        return number;
    }

    public void setCapacity(short capacity) {
        this.capacity = capacity;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
