package sample.trips;


import sample.dates.Date;
import sample.peoples.Driver;
import sample.vehicles.Bus;
import sample.vehicles.Limo;
import sample.vehicles.MiniBus;
import sample.vehicles.Vehicle;

public class Trip {
    private int tripNumber;
    private Date tripDate;
    private String pickUp;
    private String destination;
    private double cost;
    private Vehicle vehicle;
    private Driver driver;
    private String tripType;
    private boolean external, internal, oneWay, roundWay, oneStop, manyStops, nonStops;


    public Trip() {
        this.external = false;
        this.internal = false;
        this.oneWay = false;
        this.roundWay = false;
        this.oneStop = false;
        this.manyStops = false;
        this.nonStops = false;
    }

    public boolean isExternal() {
        return external;
    }

    public void setExternal() {
        this.cost += 100;
        this.external = true;
    }

    public boolean isInternal() {
        return internal;
    }

    public void setInternal() {
        this.cost+=30;
        this.internal = true;
    }

    public boolean isOneWay() {
        return oneWay;
    }

    public void setOneWay() {
        this.cost+=20;
        this.oneWay = true;
    }

    public boolean isRoundWay() {
        return roundWay;
    }

    public void setRoundWay() {
        this.cost+=10;
        this.roundWay = true;
    }

    public boolean isOneStop() {
        return oneStop;
    }

    public void setOneStop() {
        this.cost+=20;
        this.oneStop = true;
    }

    public boolean isManyStops() {
        return manyStops;
    }

    public void setManyStops() {
        this.cost+=5;
        this.manyStops = true;
    }

    public boolean isNonStops() {
        return nonStops;
    }

    public void setNonStops() {
        this.cost+=40;
        this.nonStops = true;
    }

    public int getTripNumber() {
        return tripNumber;
    }

    public void setTripNumber(int tripNumber) {
        this.tripNumber = tripNumber;
    }

    public Date getTripDate() {
        return tripDate;
    }

    public void setTripDate(Date tripDate) {
        this.tripDate = tripDate;
    }

    public String getPickUp() {
        return pickUp;
    }

    public void setPickUp(String pickUp) {
        this.pickUp = pickUp;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(String type) {
        if(type.equalsIgnoreCase("Bus")){
            vehicle=new Bus();
        }else if (type.equalsIgnoreCase("Minibus")){
            vehicle=new MiniBus();
        }else {
            vehicle=new Limo();
        }
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void setTripType() {
        if(vehicle instanceof Bus){
            tripType = "bus";
        }else if(vehicle instanceof MiniBus){
            tripType = "minibus";
        }else if(vehicle instanceof  Limo){
            tripType = "limo";
        }
    }

    public String getTripType(){
        return tripType;
    }

    @Override
    public String toString() {
        return tripNumber +
                ", " + pickUp  +
                ", " + destination +
                ", " + tripDate.getStartDate() +
                ", " + tripDate.getEndDate() +
                ", " + external +
                ", " + internal +
                ", " + oneWay +
                ", " + roundWay +
                ", " + oneStop +
                ", " + manyStops +
                ", " + nonStops +
                ", " + vehicle.getNumber() +
                ", " + driver.getID() +
                ", " + tripType +
                 ", " + cost;
    }
}
