package sample.vehicles;

public class VehicleFactory {

    Vehicle vehicle;

    public Vehicle createVehicle(String type){
        if(type.equalsIgnoreCase("Bus")){
            vehicle=new Bus();
        }else if (type.equalsIgnoreCase("Minibus")){
            vehicle=new MiniBus();
        }else if(type.equalsIgnoreCase("limo")){
            vehicle=new Limo();
        }
        return vehicle;
    }
}
