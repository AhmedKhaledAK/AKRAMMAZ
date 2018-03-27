package sample.peoples;

import sample.Interfaces.ITrip;
import sample.Main;
import sample.files.FileClass;
import sample.trips.Trip;
import sample.vehicles.Bus;
import sample.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.Arrays;

public class Manager extends People implements ITrip {
    @Override
    public int createTrip(int number, ArrayList<String> trips, Trip trip) {
        int n = search(number, trips);
        if (n != -1) {
            System.out.println("Another trip was found with the same number.");
            return 0;
        }
        trips.add(trip.toString());
        return 1;
    }

    public void updateTrip(int s, int s1){
        FileClass fc;
        for(int i = 0; i < Main.list.size(); i++){
            String [] strings = Main.list.get(i).split(",");
            System.out.println(s + " " + strings[13]);
            System.out.println(Arrays.toString(strings));
            System.out.println(Main.driverList.get(s).getID());
            if(strings[13].trim().equals(Main.driverList.get(s).getID().trim())){
                System.out.println("IN IFFFFFFFFF");
                strings[13]=Main.driverList.get(s1).getID();
                System.out.println(strings[13]);
                Main.list.remove(i);
                Main.list.add(Arrays.toString(strings));
                System.out.println(Arrays.toString(strings));
            }
        }
        fc = new FileClass("C:/Users/User/trips.txt");
        fc.writeToFile(Main.list);
    }

    @Override
    public int deleteTrip(int number, ArrayList<String> trips) {
        int n = search(number, trips);
        if (n != -1) {
            String[] strings = Main.list.get(n).split(",");
            updateVehicle(n,Integer.parseInt(strings[12].trim()));
            int in = searchDriver(strings[13].trim(), Main.driverList);
            updateDriver(in, true);
            trips.remove(n);
            return Integer.parseInt(strings[12].trim());
        }
        return -1;
    }

    private void updateVehicle(int n, int num) {
        String [] strings = Main.list.get(n).split(",");
        FileClass fc = null;
        if(strings[14].trim().equals("bus")){
            fc=new FileClass("C:/Users/User/bus.txt");
        }else if(strings[14].trim().equals("minibus")){
            fc=new FileClass("C:/Users/User/minibus.txt");
        }else if(strings[14].trim().equals("minibus")){
            fc=new FileClass("C:/Users/User/limo.txt");
        }
        int in = searchBus(num,Main.busList);
        if(in !=-1){
            Main.busList.get(in).setAvailable(true);
            fc.writeToFile(Main.busList,0);
        }
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

    public int deleteDriver(String id, ArrayList<Driver> drivers){
        int s = searchDriver(id, drivers);
        if(s==-1) return -1;
        if(drivers.get(s).isAvaialble()){
            drivers.remove(s);
            return '\0';
        }
        else if(!drivers.get(s).isAvaialble()){
            int s1 = searchAvail(drivers);
            if(s1 != -1){
                updateTrip(s,s1);
                updateDriver(s1,false);
                drivers.remove(s);
                System.out.println(s1);
                return s1;
            }else {
                return -1;
            }
        }
        return -99999;
    }
    public void updateDriver(int s1, boolean avail){
        Main.driverList.get(s1).setAvaialble(avail);
        FileClass fc = new FileClass("C:/Users/User/driver.txt");
        fc.writeDrivers(Main.driverList,0,0);
    }
    public int searchAvail(ArrayList<Driver> drivers){
        for(int i =0; i < drivers.size(); i++){
            if(drivers.get(i).isAvaialble()){
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
