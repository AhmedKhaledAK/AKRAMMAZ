package sample.peoples;

import sample.peoples.People;

public class Driver extends People {

    int salary;
    boolean avaialble;

    public boolean isAvaialble() {
        return avaialble;
    }

    public void setAvaialble(boolean avaialble) {
        this.avaialble = avaialble;
    }

    @Override
    public String toString() {
        return  this.getID() + "," + avaialble;
    }
}
