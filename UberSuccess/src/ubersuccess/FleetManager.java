package ubersuccess;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static ubersuccess.Car.modifiedDt;

public class FleetManager {

    public List<Car> carFleet
            = new ArrayList<Car>();

    public void addCar(Car c) {
        carFleet.add(c);
    }

    public FleetManager() {

    }

    public boolean isExistsSerialNumber(String serial) {
        for (Car c : carFleet) {
            if (c.serialNumber.equals(serial)) {
                return true;
            }
        }
        return false;

    }

    // 1.find first available car

    public List<Car> getFirstAvailableCar1() {
        List<Car> tempFleet = new ArrayList<Car>();
        for (Car c : carFleet) {
            if (c.isAvailable) {
                tempFleet.add(c);
                break;
            }
        }
        return tempFleet;
    }

    // 2. how many cars are currently available

    public int getNumCars2() {
        int count = 0;
        for (Car c : carFleet) {
            if (c.isAvailable) {
                count++;
            }
        }
        return count;
    }

    // 3. list all cars that are made by toyota, gm, etc

    public List<Car> getCarsManBy3(String make) {
        List<Car> tempFleet
                = new ArrayList<Car>();
        for (Car c : carFleet) {
            if (c.make.equals(make)) {
                tempFleet.add(c);
            }
        }
        return tempFleet;
    }

    // 4. list all cars that are manu in year

    public List<Car> getCarsManInYear4(int year) {
        List<Car> tempFleet
                = new ArrayList<Car>();
        for (Car c : carFleet) {
            if (c.manYear == year) {
                tempFleet.add(c);
            }
        }
        return tempFleet;
    }

    // 5. list all cars with min x seats and max y seats 

    public List<Car> getCarsMinMaxSeats5(int min, int max) {
        List<Car> tempFleet
                = new ArrayList<Car>();
        for (Car c : carFleet) {
            if (c.numSeats >= min
                    && c.numSeats <= max) {
                tempFleet.add(c);
            }
        }
        return tempFleet;
    }

    // 6. find the car with the given serial num

    public List<Car> getCarWithSerial6(String serial) {
        List<Car> tempFleet = new ArrayList<Car>();
        for (Car c : carFleet) {
            if (c.serialNumber.equals(serial)) {
                tempFleet.add(c);
            }
        }
        return tempFleet;
    }
    public Car getCarWithSerial(String serial) {
        for (Car c : carFleet) 
            if (c.serialNumber.equals(serial)) 
                return c;
        return null;
    }

    // 7. list all cars given the model num

    public List<Car> getCarsByModel7(String model) {
        List<Car> tempFleet
                = new ArrayList<Car>();
        for (Car c : carFleet) {
            if (c.modelNumber.equals(model)) {
                tempFleet.add(c);
            }
        }
        return tempFleet;
    }

    // 8. list all manufacturers

    public Set<String> getAllManus8() {
        Set<String> manus
                = new HashSet<String>();
        for (Car c : carFleet) {
            manus.add(c.make);
        }
        return manus;
    }

    // 9. when was the last time fleet catalog was updated

    public String getLastModified9() {
        return Car.modifiedDt;
    }

    // 10. list all cars in given city

    public List<Car> getAllCarsInCity10(String city) {
        List<Car> tempFleet
                = new ArrayList<Car>();
        for (Car c : carFleet) {
            if (c.city.equals(city)) {
                tempFleet.add(c);
            }
        }
        return tempFleet;
    }

    // 11. list all cars that expired maintenance certis

    public List<Car> getAllCarsThatExpired11() {
        List<Car> tempFleet
                = new ArrayList<Car>();
        for (Car c : carFleet) {
            if (c.mainCertExpired) {
                tempFleet.add(c);
            }
        }
        return tempFleet;
    }

    public Object[][] getArray() {
        Object[][] data = new Object[carFleet.size()][];
        int i = 0;
        for (Car c : carFleet) {
            data[i] = c.getArray();
            i++;
        }
        return data;
    }

    public Object[][] getArray(List<Car> carFleet) {
        Object[][] data = new Object[carFleet.size()][];
        int i = 0;
        for (Car c : carFleet) {
            data[i] = c.getArray();
            i++;
        }
        return data;
    }

    public String[] getColumns() {
        return new String[]{
            "make", "manYear", "numSeats",
            "serialNumber", "modelNumber", "city", 
            "modifiedDt", "mainCertExpired","isAvailable"};
    }

    public void importDataFromCSV(String path) {
        carFleet.clear();
        // create a reader
        try (BufferedReader br = Files.newBufferedReader(
                Paths.get(path))) {
            // CSV file delimiter
            String DELIMITER = ",";
            // read the file line by line
            String line;
            while ((line = br.readLine()) != null) {
                // convert line into columns
                String[] vals = line.split(DELIMITER);
                // print all columns
                carFleet.add(new Car(
                        vals[0],
                        Integer.parseInt(vals[1]), Integer.parseInt(vals[2]),
                        vals[3], vals[4], vals[5],
                        Boolean.parseBoolean(vals[6]),
                        Boolean.parseBoolean(vals[7])
                ));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
