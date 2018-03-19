package sample.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import sample.Main;
import sample.files.FileClass;
import sample.peoples.Passenger;
import sample.vehicles.Bus;

import javax.swing.*;
import java.util.ArrayList;

public class BookTripPage {

    @FXML
    Label lblSelectedTrip;
    @FXML
    Label lblPrice;
    @FXML
    Label lblFrom;
    @FXML
    Label lblTo;
    @FXML
    Label lblStartDate;
    @FXML
    Label lblEndDate;
    @FXML
    Label lblBusNumber;
    @FXML
    TextField txtID;
    @FXML
    ListView<String> listViewTrips;

    String selectedItem;

    String [] arrSplit;
    ObservableList<String> ol = FXCollections.observableArrayList(Main.list);

    public void btnLoadTrips(ActionEvent actionEvent) {
        listViewTrips.setItems(ol);
    }

    public void btnListClick(MouseEvent mouseEvent) {
        selectedItem = listViewTrips.getSelectionModel().getSelectedItem();
        arrSplit = selectedItem.split(",");
        lblSelectedTrip.setText(selectedItem);
        lblPrice.setText(arrSplit[13]);
        lblFrom.setText(arrSplit[1]);
        lblTo.setText(arrSplit[2]);
        lblStartDate.setText(arrSplit[3]);
        lblEndDate.setText(arrSplit[4]);
        lblBusNumber.setText(arrSplit[12]);
    }

    public void btnBookTrip(ActionEvent actionEvent) {
        Passenger passenger = new Passenger();
        passenger.setID(txtID.getText());
        for (int i = 0; i < Main.busList.size(); i++){
            int busNum = Main.busList.get(i).getNumber();
            if(busNum== Integer.parseInt(arrSplit[12].trim())){
                Main.busList.get(i).setPassengers(passenger);
                FileClass fileClass = new FileClass("C:/Users/User/bus.txt");
                fileClass.writeToFile(Main.busList,0);
            }
        }
    }
}
