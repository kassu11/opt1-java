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
        Car car2 = new Car("Lamborghini", driver);

        driverDAO.saveDriver(driver);
        carDAO.saveCar(car);
        carDAO.saveCar(car2);

        driver.getCars().add(car);
        driver.getCars().add(car2);
        driverDAO.updateDriver(driver);

        System.out.println("Car 1 driver: " + car.getDriver());
        System.out.println("Car 2 driver: " + car2.getDriver());
        System.out.println("Driver cars: " + driver.getCars());
    }
}

