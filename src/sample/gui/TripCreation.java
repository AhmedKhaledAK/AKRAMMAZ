package sample.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import sample.lang.Error;
import sample.Main;
import sample.dates.Date;
import sample.files.FileClass;
import sample.peoples.Manager;
import sample.trips.Trip;
import sample.vehicles.Bus;

public class TripCreation {

    Trip trip;
    @FXML
    TextField txtTripNumber;
    @FXML
    TextField txtFrom;
    @FXML
    TextField txtTo;
    @FXML
    TextField txtOn;
    @FXML
    TextField txtToDate;
    @FXML
    CheckBox chkBxExternal;
    @FXML
    CheckBox chkBxInternal;
    @FXML
    CheckBox chkBxOneWay;
    @FXML
    CheckBox chkBxRoundWay;
    @FXML
    CheckBox chkBxOneStop;
    @FXML
    CheckBox chkBxNonStop;
    @FXML
    CheckBox chkBxManyStops;
    @FXML
    TextField txtBusNumber;


    public void btnCreateTrip(ActionEvent actionEvent) {
        trip = new Trip();
        trip.setTripNumber(Integer.parseInt(txtTripNumber.getText()));
        Date date = new Date();
        date.setStartDate(txtOn.getText());
        date.setEndDate(txtToDate.getText());
        trip.setTripDate(date);
        trip.setPickUp(txtFrom.getText());
        trip.setDestination(txtTo.getText());
        trip.setCost();
        if (chkBxExternal.isSelected()) {
            trip.setExternal();
        }
        if (chkBxInternal.isSelected()) {
            trip.setInternal();
        }
        if (chkBxOneWay.isSelected()) {
            trip.setOneWay();
        }
        if (chkBxRoundWay.isSelected()) {
            trip.setRoundWay();
        }
        if (chkBxOneStop.isSelected()) {
            trip.setOneStop();
        }
        if (chkBxManyStops.isSelected()) {
            trip.setManyStops();
        }
        if (chkBxNonStop.isSelected()) {
            trip.setNonStops();
        }
        System.out.println(txtBusNumber.getText());
        Manager manager = new Manager();
        Bus bus = new Bus();
        int in = bus.search(Integer.parseInt(txtBusNumber.getText()), Main.busList);
        if(in!=-1){
            if(manager.search(trip.getTripNumber(), Main.list)==-1) {
                if (Main.busList.get(in).isAvailable()) {
                    bus.setNumber(Integer.parseInt(txtBusNumber.getText()));
                    bus.setAvailable(false);
                    Main.busList.remove(in);
                    Main.busList.add(bus);
                    FileClass fc = new FileClass("C:/Users/User/bus.txt");
                    fc.writeToFile(Main.busList, 0);
                } else Error.error("Error", "Bus Not Added",
                        "It looks like the bus is found but not available at the time.");
            }
        }else{
            Error.error("Error", "Bus Not Added",
                    "It looks like there is another bus with the same number");
        }
        trip.setBus(bus);
        if(trip.getTripNumber()!=0 && trip.getBus().getNumber()!=0) {
            int t = manager.createTrip(Integer.parseInt(txtTripNumber.getText()), Main.list, trip);
            if (t == 0) {
                Error.error("Error", "Trip Not Added",
                        "It looks like there is another trip with the same number");
            }
            FileClass fc1 = new FileClass("C:/Users/User/trips.txt");
            fc1.writeToFile(Main.list);
        }
    }
}
