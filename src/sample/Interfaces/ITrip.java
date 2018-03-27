package sample.Interfaces;

import sample.trips.Trip;

import java.util.ArrayList;

public interface ITrip {
    int createTrip(int number, ArrayList<String> trips, Trip trip);
    int deleteTrip(int number, ArrayList<String> trips);
}
