package sample.vehicles;

import sample.peoples.Passenger;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Bus extends Vehicle {

    private int counter;
    ArrayList<Passenger>passengers;

    public Bus() {
        counter = 0;
        passengers = new ArrayList<>();
    }

    @Override
    public void setCapacity() {
        this.capacity = 60;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(Passenger passenger) {
        if(counter == capacity-1) return;
        passengers.add(passenger);
        counter++;
    }

    public int search(int number, ArrayList<Bus> buses) {
        for (int i = 0; i < buses.size(); i++) {
            if (Integer.parseInt(buses.get(i).getNumber()+"") == number) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return number + "," + available + "," + Arrays.toString(passengers.toArray());
    }
}
