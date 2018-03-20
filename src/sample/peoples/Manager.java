package sample.peoples;

import sample.Main;
import sample.trips.Trip;
import sample.vehicles.Bus;
import sample.vehicles.Vehicle;

import java.util.ArrayList;

public class Manager extends People {
    public int createTrip(int number, ArrayList<String> trips, Trip trip) {
        int n = search(number, trips);
        if (n != -1) {
            System.out.println("Another trip was found with the same number.");
            return 0;
        }
        trips.add(trip.toString());
        return 1;
    }

    public int deleteTrip(int number, ArrayList<String> trips) {
        int n = search(number, trips);
        if (n != -1) {
            String[] strings = Main.list.get(n).split(",");
            trips.remove(n);
            return Integer.parseInt(strings[12].trim());
        }
        return -1;
    }

    public int searchBus(int number, ArrayList<Vehicle> buses) {
        for (int i = 0; i < buses.size(); i++) {
            if (Integer.parseInt(buses.get(i).getNumber() + "") == number) {
                return i;
            }
        }
        return -1;
    }

    public int searchDriver(String id, ArrayList<Driver> drivers) {
        for (int i = 0; i < drivers.size(); i++) {
            if (drivers.get(i).getID().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public int search(int number, ArrayList<String> trips) {
        System.out.println(number);
        for (int i = 0; i < trips.size(); i++) {
            if (Integer.parseInt(trips.get(i).charAt(0) + "") == number) {
                return i;
            }
        }
        return -1;
    }
}
