package ubersuccess;

import java.util.Date;
public class Car {
    public boolean isAvailable=true;
    // A/N
    public String make;
    public int manYear;
    public int numSeats;
    public String serialNumber;
    public String modelNumber;
    public static String modifiedDt=new Date().toString();
    public String city;
    public boolean mainCertExpired=false;
    public Car()
    {
        //mainCertExpired=false;
        this.modifiedDt=new Date().toString();
    }
    public Car(    
        String make,
        int manYear,
        int numSeats,
        String serialNumber,
        String modelNumber,
        String city,
        boolean isMainCertExpired,
        boolean isAvailable
    )
    {
        this.make=make;
        this.manYear=manYear;
        this.numSeats=numSeats;
        this.serialNumber=serialNumber;
        this.modelNumber=modelNumber;
        this.modifiedDt=new Date().toString();
        this.city=city;
        this.mainCertExpired=isMainCertExpired;
        this.isAvailable=isAvailable;
    }
    public void modifyCar(    
        boolean isAvailable,
        String make,
        int manYear,
        int numSeats,
        String modelNumber,
        String serial,
        String city,
        boolean mainCertExpired
    )
    {
        this.make=make;
        this.manYear=manYear;
        this.numSeats=numSeats;
        this.modelNumber=modelNumber;
        this.modifiedDt=new Date().toString();
        this.city=city;
        this.mainCertExpired=mainCertExpired;
    }
    public Object[]getArray()
    {
        return new Object[]{
            make, manYear, numSeats,
            serialNumber, modelNumber, city, 
            modifiedDt, mainCertExpired,isAvailable};
    }
}
