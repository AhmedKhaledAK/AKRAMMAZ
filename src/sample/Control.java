package sample;

import sample.Main;
import sample.files.FileClass;
import sample.peoples.Passenger;

import java.util.ArrayList;

public class Control {

    public static void searchPassenger(String id, String type, Passenger passenger, ArrayList<Passenger> passengers){
        int x = -1;
        for(int i = 0; i < passengers.size(); i++){
            if(passengers.get(i).getID().trim().equals(id.trim())){
                int var = passengers.get(i).getNumberOfTrips();
                if(type.equalsIgnoreCase("book")) passengers.get(i).setNumberOfTrips(++var);
                else passengers.get(i).setNumberOfTrips(--var);
                System.out.println(passengers.get(i).getNumberOfTrips());
                if(passengers.get(i).getNumberOfTrips() >= 5){
                    System.out.println("You have got a discount!");
                    passengers.get(i).setNumberOfTrips(0);
                }
                x=i;
                passenger.setNumberOfTrips(passengers.get(i).getNumberOfTrips());
            }
        }
        updatePassengers(x,passenger, passengers);
    }

    private static void updatePassengers(int i, Passenger passenger, ArrayList<Passenger> passengers) {
        FileClass pfc = new FileClass("C:/Users/User/passengers.txt");
        if(i!=-1) passengers.remove(i);
        passengers.add(passenger);
        Main.passengerList=passengers;
        pfc.writePassengers(passengers);
    }

    public static int searchPromoCodes(String promocode, ArrayList<String> promocodes){
        for(int i = 0; i < promocodes.size(); i++){
            if(promocodes.get(i).trim().equalsIgnoreCase(promocode)){
                System.out.println("You have got a discount!");
                return 1;
            }
        }
        return 0;
    }

    public static boolean isValidID(String id){
        return (id.length() == 14) && id.matches("[0-9]+");
    }
}
