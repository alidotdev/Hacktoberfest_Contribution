/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication;

/**
 *
 * @author Hp
 */
public class Car {

    private String model;
    private int make;
    private String carNumber;
    private int engineCapacity;
    private int seatCapacity;
    private String driverName;
    private boolean isGovtVehicle;
    
    
    Car(){
        //Default Constructor
        model = "";
        make = 0;
        carNumber = "";
        engineCapacity = 0;
        seatCapacity = 0;
        driverName = "";
        isGovtVehicle = false;
    }
    
    Car(String model, int year, int eng, int seats){
        //Parametrized Constructor
        this.model = model;
        this.make = year;
        engineCapacity = eng;
        seatCapacity = seats;
    }
    
    public String getmodel() {

        return model;
    }

    public int getmake() {
        return make;

    }

    public String getCarNo() {

        return carNumber;

    }

    public int getEngineCap() {
        return engineCapacity;

    }

    public int getSeatCap() {

        return seatCapacity;

    }

    public String getDriverName() {

        return driverName;
    }

    public boolean isGovtVehicle() {

        return isGovtVehicle;
    }

    boolean validateModel(String model) {
        boolean flag = true;

        for (int i = 0; i < model.length(); i++) {
            if (!(model.charAt(i) >= 'a' && model.charAt(i) <= 'z') || (model.charAt(i) >= 'A' && model.charAt(i) <= 'Z') || (model.charAt(i) == ' ')) {
            } else {
                flag = false;
            }

        }

        return flag;
    }

    boolean validateMake(int make) {
        boolean flag = true;
        for (int i = 0; i < 4; i++) {
            if (make >= 1893 && make <= 2021)
            {
                 flag = true;
            }
            else {
                 flag = false;
             
        }
        }
         return flag;
    }

    boolean validatecarNumber(String carNumber) // LEK-14-1324
    {

        int x = carNumber.length();
        boolean flag = false;
        if (x == 11) {
            if (carNumber.charAt(0) >= 'A' && carNumber.charAt(0) <= 'Z' && carNumber.charAt(3) == '-' && carNumber.charAt(6) == '-') {
                flag = true;

                for (int n = 1; n < 3; n++) {
                    if (carNumber.charAt(n) >= 'A' && carNumber.charAt(n) <= 'Z') {
                        flag = true;
                    } else {
                        flag = false;
                        break;
                    }
                }
                if (flag == true) {
                    for (int n = 4; n < 6; n++) {
                        if (carNumber.charAt(n) >= 'A' && carNumber.charAt(n) <= 'Z') {
                            flag = true;
                        } else {
                            flag = false;
                            break;
                        }

                    }
                    if (flag == true) {

                        for (int j = 7; j < 11; j++) {
                            if (carNumber.charAt(j) >= '0' && carNumber.charAt(j) <= '9') {
                                flag = true;
                            } else {
                                flag = false;
                                break;
                            }
                        }
                    }

                }

            } else {
                flag = false;
            }
        }

        return flag;
    }

    boolean validateengineCapacity(int engineCapacity) {
        boolean flag = true;
        if (engineCapacity == 1000 || engineCapacity == 1300 || engineCapacity == 1800) {
        } else {

            flag = false;
        }
        return flag;
    }

    boolean validateseatCapacity(int seatCapacity) {
        boolean flag = true;
//        for (seatCapacity=0; seatCapacity<8; seatCapacity++)
        if (seatCapacity < 8) {

            flag = true;
        } else {
            flag = false;

        }
        return flag;

    }

    boolean validatedriverName() {
        boolean flag = true;
        for (int i = 0; i < driverName.length(); i++) {
            if (!(driverName.charAt(i) >= 'a' && driverName.charAt(i) <= 'z') || (driverName.charAt(i) >= 'A' && driverName.charAt(i) <= 'Z') || (driverName.charAt(i) == ' ')) {
            } else {
                flag = false;
            }

        }

        return flag;
    }

    public int calculateToll(){
        if(!isGovtVehicle)
        {
            int toll = 10;

            //add toll upon engine capacity
            if(engineCapacity>1000 & engineCapacity<=1300)
                toll = toll + (engineCapacity/100);
            else if(engineCapacity>1300 & engineCapacity<=1800)
                toll = toll + (engineCapacity/65);
            else if(engineCapacity>1800)
                toll = toll + (engineCapacity/50);

            //add toll if more than 4 seats
            if(seatCapacity>4)
            {
                toll = toll + ((seatCapacity - 4) * 5);
            }

            //add toll upon make year
            if(make<2018)
            {
                toll = toll + ((2018 - make)* 2);
            }

            return toll;
        }
        else
            return 0;
    }
    
    public void setDriver(String name)
    {
        driverName = name;
    }
    
    public void setLicensenumber(String plate)
    {
        carNumber = plate;
    }
}
    

//public static void main(String[] args)
//{
//
//
//System.out.print("Hello Peeepss");
//}
//
//
//}

