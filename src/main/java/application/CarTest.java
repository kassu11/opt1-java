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
        Driver driver2 = new Driver("Mike", 5);
        Car car = new Car("Ferrari");
        Car car2 = new Car("Lamborghini");
        Car car3 = new Car("Porsche");

        driverDAO.saveDriver(driver);
        driverDAO.saveDriver(driver2);
        carDAO.saveCar(car);
        carDAO.saveCar(car2);
        carDAO.saveCar(car3);

        driver.getCars().add(car);
        driver.getCars().add(car2);
        driver2.getCars().add(car3);
        driverDAO.updateDriver(driver);

        car.getDrivers().add(driver);
        car2.getDrivers().add(driver);
        car3.getDrivers().add(driver2);
        carDAO.updateCar(car);
        carDAO.updateCar(car2);
        carDAO.updateCar(car3);

        System.out.println("Car 1 driver: " + car.getDrivers());
        System.out.println("Car 2 driver: " + car2.getDrivers());
        System.out.println("Car 3 driver: " + car2.getDrivers());
        System.out.println("Driver 1 cars: " + driver.getCars());
        System.out.println("Driver 2 cars: " + driver2.getCars());
    }
}

