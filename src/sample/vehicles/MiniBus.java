package sample.vehicles;

public class MiniBus extends Vehicle {
    public MiniBus(){
        this.capacity=16;
    }
    @Override
    public void setCapacity() {
        this.capacity=10;
    }

}
