package sample.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import sample.Controller;
import sample.Interfaces.ITrip;
import sample.lang.Error;
import sample.Main;
import sample.dates.Date;
import sample.files.FileClass;
import sample.peoples.Driver;
import sample.peoples.Manager;
import sample.trips.Trip;
import sample.vehicles.Bus;
import sample.vehicles.Vehicle;

import java.util.ArrayList;

public class TripCreation {

    Trip trip;
    @FXML
    TextField txtTripNumber;
    @FXML
    TextField txtFrom;
    @FXML
    TextField txtTo;
    @FXML
    DatePicker datePickerStart;
    @FXML
    DatePicker datePickerEnd;
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
    TextField txtBusNumber;
    @FXML
    TextField txtDriverNumber;
    @FXML
    RadioButton rdioBtnBus;
    @FXML
    RadioButton rdioBtnMini;
    @FXML
    RadioButton rdioButtonLimo;

    private ToggleGroup toggleGroup = new ToggleGroup();
    private  ToggleGroup toggleGroup1 = new ToggleGroup();
    private  ToggleGroup toggleGroup2 = new ToggleGroup();
    private  ToggleGroup toggleGroup3 = new ToggleGroup();
    @FXML
    public void initialize(){
        rdioBtnBus.setToggleGroup(toggleGroup);
        rdioBtnMini.setToggleGroup(toggleGroup);
        rdioButtonLimo.setToggleGroup(toggleGroup);

        rdioBtnExternal.setToggleGroup(toggleGroup1);
        rdioBtnInternal.setToggleGroup(toggleGroup1);
        rdioBtnOneStop.setToggleGroup(toggleGroup2);
        rdioBtnNonStop.setToggleGroup(toggleGroup2);
        rdioButtonManyStops.setToggleGroup(toggleGroup2);
        rdioBtnRoundWay.setToggleGroup(toggleGroup3);
        rdioBtnOneWay.setToggleGroup(toggleGroup3);

        if(Controller.pageType){
            txtDriverNumber.setVisible(false);
            txtBusNumber.setVisible(false);
            txtTripNumber.setVisible(false);
            rdioBtnBus.setVisible(false);
            rdioBtnMini.setVisible(false);
        }
    }

    public void btnCreateTrip(ActionEvent actionEvent) {
        trip = new Trip();
        trip.setTripNumber(Integer.parseInt(txtTripNumber.getText()));
        
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
        System.out.println(txtBusNumber.getText());
        Manager manager = new Manager();
        Driver driver = new Driver();
        driver.setID(txtDriverNumber.getText());
        trip.setDriver(driver);
        if(rdioBtnMini.isSelected()){
            trip.setVehicle("bus");
        }else if(rdioBtnBus.isSelected()){
            trip.setVehicle("minibus");
        }
        Vehicle vehicle = trip.getVehicle();
        trip.setTripType();
        ArrayList<Vehicle> vehicles=null;
        int f=0;
        if(trip.getTripType().equals("bus")){
            vehicles = Main.busList;
            f=1;
        }else if(trip.getTripType().equals("minibus")){
            vehicles = Main.miniList;
            f=2;
        }else if(trip.getTripType().equals("limo")){
            vehicles = Main.limoList;
            f=3;
        }
        int in = manager.searchBus(Integer.parseInt(txtBusNumber.getText()), vehicles);
        int din = manager.searchDriver(driver.getID(), Main.driverList);
        if(in!=-1){
            if(din!=-1) {
                if (manager.search(trip.getTripNumber(), Main.list) == -1) {
                    if (vehicles.get(in).isAvailable()) {
                        if (Main.driverList.get(din).isAvaialble()) {
                            vehicle.setNumber(Integer.parseInt(txtBusNumber.getText()));
                            vehicle.setAvailable(false);
                            vehicles.remove(in);
                            vehicles.add(vehicle);
                            FileClass fc = new FileClass("C:/Users/User/"+trip.getTripType()+".txt");
                            fc.writeToFile(vehicles, 0);
                            driver.setAvaialble(false);
                            Main.driverList.remove(din);
                            Main.driverList.add(driver);
                            FileClass fileClass = new FileClass("C:/Users/User/driver.txt");
                            fileClass.writeDrivers(Main.driverList,0,0);
                            if(f==1) Main.busList=vehicles;
                            else if(f==2) Main.miniList=vehicles;
                            else if(f==3) Main.limoList=vehicles;
                        } else Error.error("Error", "Bus Not Added",
                                "It looks like the bus is found but not available at the time.");
                    }
                }
            }
        }else{
            Error.error("Error", "Bus Not Added",
                    "It looks like there is another bus with the same number");
        }
        if(trip.getTripNumber()!=0 && trip.getVehicle().getNumber()!=0) {
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
