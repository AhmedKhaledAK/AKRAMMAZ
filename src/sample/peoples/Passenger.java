package sample.peoples;

import sample.Control;
import sample.Interfaces.ITrip;
import sample.Main;
import sample.files.FileClass;
import sample.trips.Trip;
import sample.vehicles.Limo;
import sample.vehicles.Vehicle;

import java.io.File;
import java.util.ArrayList;

public class Passenger extends People  implements ITrip{
    private int numberOfTrips;

    public int getNumberOfTrips() {
        return numberOfTrips;
    }

    public void setNumberOfTrips(int numberOfTrips) {
        this.numberOfTrips = numberOfTrips;
    }

    @Override
    public String toString() {
        return getID() + "," + getNumberOfTrips();
    }

    public void createTrip(Trip trip){
        for (int i = 0; i < Main.limoList.size(); i++){
            Vehicle v;
            if (Main.limoList.get(i).isAvailable()) {
                Main.limoList.get(i).setAvailable(false);
                createTrip(Main.limoList.get(i).getNumber(), Main.limoTrips, trip);
                v=Main.limoList.get(i);
                Main.limoList.remove(i);
                Main.limoList.add(v);
                FileClass fileClass = new FileClass("C:/Users/User/limo.txt");
                fileClass.writeToFile(Main.limoList,0);
                return;
            }
        }
    }

    @Override
    public int createTrip(int number, ArrayList<String> trips, Trip trip) {
        trip.setTripNumber(number);
        trips.add(trip.getTripNumber() + ", " + trip.getPickUp() + ", " + trip.getDestination() + ", "
        + trip.getTripDate());
        Main.limoTrips=trips;
        FileClass fileClass = new FileClass("C:/Users/User/limotrips.txt");
        fileClass.writeToFile(trips);
        return -1;
    }

    public void deleteTrip(String id, Passenger p, int num){
        Control.searchPassenger(id, "cancel", p, Main.passengerList);
        deleteTrip(num, Main.limoTrips);
    }

    @Override
    public int deleteTrip(int number, ArrayList<String> trips) {
        for(int i = 0; i < trips.size(); i++){
            String [] strings = trips.get(i).split(",");
            if(Integer.parseInt(strings[0].trim()) == number){
                updateLimo(Integer.parseInt(strings[0].trim()));
                trips.remove(i);
                Main.limoTrips = trips;
                FileClass fileClass = new FileClass("C:/Users/User/limotrips.txt");
                fileClass.writeToFile(trips);
                break;
            }
        }
        return 0;
    }

    private void updateLimo(int n) {
        for(int i = 0; i < Main.limoList.size(); i++){
            Vehicle v;
            if(Main.limoList.get(i).getNumber() == n){
                Main.limoList.get(i).setAvailable(true);
                v=Main.limoList.get(i);
                Main.limoList.remove(i);
                Main.limoList.add(v);
                FileClass fileClass = new FileClass("C:/Users/User/limo.txt");
                fileClass.writeToFile(Main.limoList,0);
                break;
            }
        }
    }
}
