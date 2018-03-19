package sample.trips;


import sample.dates.Date;
import sample.vehicles.Bus;

public class Trip {
    private int tripNumber;
    private Date tripDate;
    private String pickUp;
    private String destination;
    private float cost;
    Bus bus;
    boolean external, internal, oneWay, roundWay, oneStop, manyStops, nonStops;


    public Trip(){
        this.external=false;
        this.internal=false;
        this.oneWay=false;
        this.roundWay=false;
        this.oneStop=false;
        this.manyStops=false;
        this.nonStops=false;
    }



    public boolean isExternal() {
        return external;
    }

    public void setExternal() {
        this.external = true;
    }

    public boolean isInternal() {
        return internal;
    }

    public void setInternal() {
        this.internal = true;
    }

    public boolean isOneWay() {
        return oneWay;
    }

    public void setOneWay() {
        this.oneWay = true;
    }

    public boolean isRoundWay() {
        return roundWay;
    }

    public void setRoundWay() {
        this.roundWay = true;
    }

    public boolean isOneStop() {
        return oneStop;
    }

    public void setOneStop() {
        this.oneStop = true;
    }

    public boolean isManyStops() {
        return manyStops;
    }

    public void setManyStops() {
        this.manyStops = true;
    }

    public boolean isNonStops() {
        return nonStops;
    }

    public void setNonStops() {
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

    public float getCost() {
        return cost;
    }

    public void setCost() {
        this.cost = 15;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
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
                ", " + bus.getNumber() +
                ", " + cost;
    }
}
