package sample.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import sample.Control;
import sample.Main;
import sample.Scenes;
import sample.files.FileClass;
import sample.lang.Error;
import sample.peoples.Passenger;
import sample.vehicles.Vehicle;
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
    TextField txtPromoCode;
    @FXML
    ListView<String> listViewTrips;

    private String [] arrSplit;
    private ObservableList<String> ol = FXCollections.observableArrayList(Main.list);
    private Scenes scenes = new Scenes();
    @FXML
    public void initialize(){
        listViewTrips.setItems(ol);
    }

    public void btnListClick(MouseEvent mouseEvent) {
        String selectedItem = listViewTrips.getSelectionModel().getSelectedItem();
        arrSplit = selectedItem.split(",");
        lblSelectedTrip.setText(selectedItem);
        lblPrice.setText(arrSplit[15]);
        lblFrom.setText(arrSplit[1]);
        lblTo.setText(arrSplit[2]);
        lblStartDate.setText(arrSplit[3]);
        lblEndDate.setText(arrSplit[4]);
        lblBusNumber.setText(arrSplit[12]);
    }

    boolean c;

    public void btnBookTrip(ActionEvent actionEvent) {
        Passenger passenger = new Passenger();
        boolean val = Control.isValidID(txtID.getText().trim());
        if(!val){
            Error.error(Alert.AlertType.ERROR,"Error", "Wrong ID", "Please enter a valid ID");
            return;
        }
        passenger.setID(txtID.getText());
        boolean b = Control.searchPassenger(txtID.getText().trim(), "book", passenger, Main.passengerList);
        c = Control.searchPromoCodes(txtPromoCode.getText().trim(), Main.promocodes);

        FileClass fc=null;
        ArrayList<Vehicle> vehicles=null;
        int f1=0;
        if(arrSplit[14].trim().equals("bus")){
            fc=new FileClass("C:/Users/User/bus.txt");
            vehicles = Main.busList;
            f1=1;
        }
        else if(arrSplit[14].trim().equals("minibus")) {
            fc = new FileClass("C:/Users/User/minibus.txt");
            vehicles = Main.miniList;
            f1 = 2;
        }
        assert vehicles != null;
        for (int i = 0; i < vehicles.size(); i++){
            int busNum = vehicles.get(i).getNumber();
            /*for(int j =0; j < vehicles.get(i).passengers.size(); j++){
                System.out.println(vehicles.get(i).passengers.get(j));
            }*/
            if(busNum== Integer.parseInt(arrSplit[12].trim())){
                int s = vehicles.get(i).passengers.size();
                vehicles.get(i).setCounter(s);
                //System.out.println("~!!!!!!!!!!!!!!!!!!!!!!"+vehicles.get(i).getCounter());
                vehicles.get(i).setPassengers(passenger);
                fc.writeToFile(vehicles,0);
            }
        }
        if(f1==1) Main.busList=vehicles;
        else Main.miniList=vehicles;
        if(b){
            lblPrice.setText(Double.parseDouble(lblPrice.getText())/ 10 + "");
            Error.error(Alert.AlertType.INFORMATION, "Information", "Discount", "You have got a " +
                    "discount! The trip cost is: " + lblPrice.getText());
        }
    }

    public void btnBack(ActionEvent actionEvent) throws Exception {
        scenes.btnAll(actionEvent, "PassengerPage.fxml", "sample.gui.BookTripPage");
    }

    public void btnCheck(ActionEvent actionEvent) {
        if(c){
            lblPrice.setText(Double.parseDouble(lblPrice.getText())/ 5 + "");
            Error.error(Alert.AlertType.INFORMATION, "Information", "Discount", "You have got a " +
                    "discount! The trip cost is: " + lblPrice.getText());
        }
    }
}
