package sample.peoples;

import sample.trips.Trip;
import java.util.ArrayList;

public class Manager extends People {
    public int createTrip(int number, ArrayList<String> trips, Trip trip){
        int n = search(number, trips);
        if(n!=-1) {
            System.out.println("Another trip was found with the same number.");
            return 0;
        }
        trips.add(trip.toString());
        return 1;
    }

    public int deleteTrip(int number, ArrayList<String> trips){
        int n = search(number,trips);
        if(n!=-1){
            trips.remove(n);
            return 1;
        }
        return 0;
    }

    public int search(int number, ArrayList<String> trips) {
        System.out.println(number);
        for (int i = 0; i < trips.size(); i++) {
            if (Integer.parseInt(trips.get(i).charAt(0)+"")== number) {
                return i;
            }
        }
        return -1;
    }
}
