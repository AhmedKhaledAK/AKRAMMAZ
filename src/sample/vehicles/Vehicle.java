package sample.vehicles;

import sample.peoples.Passenger;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class Vehicle {

    short capacity;
    int number;
    boolean available;
    public ArrayList<Passenger> passengers;
    int counter;

    public Vehicle(){
        passengers = new ArrayList<>();
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

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

    public void addPassengers(ArrayList<Passenger> passengers){
        this.passengers.addAll(passengers);
    }

    public String toString() {
        return number + "," + available + "," + Arrays.toString(passengers.toArray());
    }
}
