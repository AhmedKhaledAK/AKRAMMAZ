package sample.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.Control;
import sample.Main;
import sample.Scenes;
import sample.dates.Date;
import sample.lang.Error;
import sample.peoples.Passenger;
import sample.trips.Trip;

public class BookLimoPage {

    Trip trip;
    @FXML
    TextField txtFrom;
    @FXML
    TextField txtTo;
    @FXML
    DatePicker datePickerStart;
    @FXML
    DatePicker datePickerEnd;
    @FXML
    TextField txtID;
    @FXML
    RadioButton rdioBtnExternal;
    @FXML
    RadioButton rdioBtnInternal;
    @FXML
    RadioButton rdioBtnOneWay;
    @FXML
    RadioButton rdioBtnRoundWay;
    @FXML
    RadioButton rdioBtnOneStop;
    @FXML
    RadioButton rdioBtnNonStop;
    @FXML
    RadioButton rdioButtonManyStops;
    @FXML
    RadioButton rdioButtonLimo;
    @FXML
    TextField txtPromoCode;

    private Scenes scenes = new Scenes();

    private ToggleGroup toggleGroup = new ToggleGroup();
    private  ToggleGroup toggleGroup1 = new ToggleGroup();
    private  ToggleGroup toggleGroup2 = new ToggleGroup();
    private  ToggleGroup toggleGroup3 = new ToggleGroup();
    @FXML
    public void initialize(){
        rdioButtonLimo.setToggleGroup(toggleGroup);
        rdioBtnExternal.setToggleGroup(toggleGroup1);
        rdioBtnInternal.setToggleGroup(toggleGroup1);
        rdioBtnOneStop.setToggleGroup(toggleGroup2);
        rdioBtnNonStop.setToggleGroup(toggleGroup2);
        rdioButtonManyStops.setToggleGroup(toggleGroup2);
        rdioBtnRoundWay.setToggleGroup(toggleGroup3);
        rdioBtnOneWay.setToggleGroup(toggleGroup3);
    }

    public void btnCreateTrip(ActionEvent actionEvent) {
        trip = new Trip();
        trip.setTripNumber(0);
        Date date = new Date();
        date.setStartDate(datePickerStart.getValue().toString());
        date.setEndDate(datePickerEnd.getValue().toString());
        trip.setTripDate(date);
        trip.setPickUp(txtFrom.getText());
        trip.setDestination(txtTo.getText());
        trip.setCost();
        if (rdioBtnExternal.isSelected()) {
            trip.setExternal();
        }
        if (rdioBtnInternal.isSelected()) {
            trip.setInternal();
        }
        if (rdioBtnOneWay.isSelected()) {
            trip.setOneWay();
        }
        if (rdioBtnRoundWay.isSelected()) {
            trip.setRoundWay();
        }
        if (rdioBtnOneStop.isSelected()) {
            trip.setOneStop();
        }
        if (rdioButtonManyStops.isSelected()) {
            trip.setManyStops();
        }
        if (rdioBtnNonStop.isSelected()) {
            trip.setNonStops();
        }
        Passenger passenger = new Passenger();
        boolean val = Control.isValidID(txtID.getText().trim());
        if(!val){
            Error.error(Alert.AlertType.ERROR,"Error", "Wrong ID", "Please enter a valid ID");
            return;
        }
        passenger.setID(txtID.getText().trim());
        passenger.createTrip(trip);
        Control.searchPassenger(txtID.getText().trim(),"book",passenger, Main.passengerList);
        int c = Control.searchPromoCodes(txtPromoCode.getText().trim(), Main.promocodes);
    }

    public void btnBack(ActionEvent actionEvent) throws Exception {
        scenes.btnAll(actionEvent, "PassengerPage.fxml", "sample.gui.BookLimoPage");
    }
}
