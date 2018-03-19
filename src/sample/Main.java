package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.files.FileClass;
import sample.gui.BookTripPage;
import sample.trips.Trip;
import sample.vehicles.Bus;

import java.util.ArrayList;

public class Main extends Application {

    public static ArrayList<String> list;
    public static ArrayList<Bus> busList;

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
        busList = fileClass1.readFromFile(0);
        for(int i = 0; i < busList.size(); i++){
            System.out.println(busList.get(i));
        }
        launch(args);
    }
}
