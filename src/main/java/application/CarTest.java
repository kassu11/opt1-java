package application;

import dao.CarDAO;
import dao.DriverDAO;
import entities.Car;
import entities.Driver;

public class CarTest {

    public static void main(String[] args) {
    	CarDAO carDAO = new CarDAO();
        DriverDAO driverDAO = new DriverDAO();

        Driver driver = new Driver("John", 10);
        Car car = new Car("Ferrari", driver);

        driverDAO.saveDriver(driver);
        carDAO.saveCar(car);

        driver.setCar(car);
        driverDAO.updateDriver(driver);

        System.out.println("Car driver " + car.getDriver());
        System.out.println("Driver car " + driver.getCar());
    }
}

