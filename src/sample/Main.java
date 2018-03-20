package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.files.FileClass;
import sample.gui.BookTripPage;
import sample.peoples.Driver;
import sample.trips.Trip;
import sample.vehicles.Bus;
import sample.vehicles.Vehicle;

import java.io.File;
import java.util.ArrayList;

public class Main extends Application {

    public static ArrayList<String> list;
    public static ArrayList<Vehicle> busList;
    public static ArrayList<Vehicle> miniList;
    public static ArrayList<Vehicle> limoList;
    public static ArrayList<Driver> driverList;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Bus Station");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        FileClass fileClass = new FileClass("C:/Users/User/trips.txt");
        list = fileClass.readFromFile();
        FileClass fileClass1 = new FileClass("C:/Users/User/bus.txt");
        busList = fileClass1.readFromFile("bus");
        FileClass fc = new FileClass("C:/Users/User/minibus.txt");
        miniList = fc.readFromFile("minibus");
        FileClass fileClass3 = new FileClass("C:/Users/User/minibus.txt");
        limoList = fileClass3.readFromFile("minibus");
        FileClass fileClass2 = new FileClass("C:/Users/User/driver.txt");
        driverList = fileClass2.readDrivers();
        launch(args);
    }
}
