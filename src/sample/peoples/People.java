package sample.peoples;

public abstract class People {
    String name;
    String ID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "People{" +
                "ID='" + ID + '\'' +
                '}';
    }
}
