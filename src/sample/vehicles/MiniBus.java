package sample.vehicles;

public class MiniBus extends Vehicle {
    @Override
    public void setCapacity() {
        this.capacity=20;
    }

    @Override
    public String toString() {
        return  number + "," +  available;
    }
}
