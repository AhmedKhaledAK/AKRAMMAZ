package sample.files;

import sample.peoples.Driver;
import sample.peoples.Passenger;
import sample.peoples.People;
import sample.vehicles.Bus;
import sample.vehicles.Vehicle;
import sample.vehicles.VehicleFactory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileClass {

    File file;
    private final String filepath, charset;
    private final boolean append, autoFlush;
    private int numberOfLines = 0;

    public FileClass(String path) {
        this.filepath = path;
        this.charset = "UTF-8";
        this.append = false;
        this.autoFlush = true;
        file = new File(this.filepath);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public void writeToFile(ArrayList<String> list) {
        try {
            FileOutputStream fos = new FileOutputStream(file, append);
            OutputStreamWriter osw = new OutputStreamWriter(fos, charset);
            BufferedWriter bw = new BufferedWriter(osw);
            PrintWriter pw = new PrintWriter(bw, autoFlush);
            list.forEach((s) -> pw.println(s));
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(FileClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void writeToFile(ArrayList<Vehicle> buses, int x){
        try {
            FileOutputStream fos = new FileOutputStream(file,append);
            OutputStreamWriter osw = new OutputStreamWriter(fos, charset);
            BufferedWriter bw = new BufferedWriter(osw);
            PrintWriter pw = new PrintWriter(bw, autoFlush);
            for(int i = 0; i < buses.size(); i++){
                pw.println(buses.get(i).toString());
            }

        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(FileClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void writeDrivers(ArrayList<Driver> drivers, int x, int y){
        try {
            FileOutputStream fos = new FileOutputStream(file,append);
            OutputStreamWriter osw = new OutputStreamWriter(fos, charset);
            BufferedWriter bw = new BufferedWriter(osw);
            PrintWriter pw = new PrintWriter(bw, autoFlush);
            for(int i = 0; i < drivers.size(); i++){
                pw.println(drivers.get(i).toString());
            }
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(FileClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<String> readFromFile() {
        ArrayList<String> list = new ArrayList<>();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bf.readLine()) != null) {
                list.add(line);
                numberOfLines++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList<Vehicle> readFromFile(String type){
        VehicleFactory vehicleFactory = new VehicleFactory();
        ArrayList<Vehicle> list = new ArrayList<>();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bf.readLine()) != null) {
                String [] arr = line.split(",");
                Vehicle vehicle = vehicleFactory.createVehicle(type);
                vehicle.setNumber(Integer.parseInt(arr[0]));
                vehicle.setAvailable(Boolean.parseBoolean(arr[1]));
                list.add(vehicle);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList<Driver> readDrivers(){
        ArrayList<Driver> drivers = new ArrayList<>();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bf.readLine()) != null) {
                String [] split = line.split(",");
                Driver driver = new Driver();
                driver.setID(split[0]);
                driver.setAvaialble(Boolean.parseBoolean(split[1]));
                drivers.add(driver);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return drivers;
    }

    public void delFileContent() throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(file)) {
            writer.print("");
        }
    }

    int getNumberOfLines() {
        return numberOfLines;
    }
}
