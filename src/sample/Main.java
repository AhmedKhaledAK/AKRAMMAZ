package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import sample.files.FileClass;
import sample.peoples.Driver;
import sample.peoples.Passenger;
import sample.vehicles.Vehicle;
import java.util.ArrayList;

public class Main extends Application {

    public static ArrayList<String> list;
    public static ArrayList<String> limoTrips;
    public static ArrayList<String> promocodes;
    public static ArrayList<Vehicle> busList;
    public static ArrayList<Vehicle> miniList;
    public static ArrayList<Vehicle> limoList;
    public static ArrayList<Driver> driverList;
    public static  ArrayList<Passenger> passengerList;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Bus Station");
        //primaryStage.getIcons().add(new Image("https://en.wikipedia.org/wiki/File:Bath_Bus_Station.jpg"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        FileClass fileClass = new FileClass("C:/Users/User/trips.txt");
        list = fileClass.readFromFile();
        FileClass ltfc = new FileClass("C:/Users/User/limotrips.txt");
        limoTrips = ltfc.readFromFile();
        FileClass fileClass1 = new FileClass("C:/Users/User/bus.txt");
        busList = fileClass1.readFromFile("bus");
        FileClass fc = new FileClass("C:/Users/User/minibus.txt");
        miniList = fc.readFromFile("minibus");
        /*for (int i = 0; i < miniList.size(); i++) {
            int busNum = miniList.get(i).getNumber();
            for (int j = 0; j < miniList.get(i).passengers.size(); j++) {
                System.out.println(miniList.get(i).passengers.get(j));
            }
        }*/
        FileClass fileClass3 = new FileClass("C:/Users/User/limo.txt");
        limoList = fileClass3.readFromFile("limo");
        FileClass fileClass2 = new FileClass("C:/Users/User/driver.txt");
        driverList = fileClass2.readDrivers();
        FileClass pfc = new FileClass("C:/Users/User/passengers.txt");
        passengerList = pfc.readPassenger();
        /*for (Passenger aPassengerList : passengerList) {
            System.out.println(aPassengerList);
        }*/

        FileClass pcfc = new FileClass("C:/Users/User/promocodes.txt");
        promocodes = pcfc.readFromFile();
        launch(args);
    }
}
