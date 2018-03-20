package sample.vehicles;

import sample.peoples.Passenger;
import java.util.ArrayList;

public abstract class Vehicle {

    short capacity;
    int number;
    boolean available;
    ArrayList<Passenger> passengers;
    private int counter;

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

    public void setPassengers(Passenger passenger) {
        if(counter == capacity-1) return;
        passengers.add(passenger);
        counter++;
    }
}
