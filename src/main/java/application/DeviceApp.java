package application;

import entities.Device;
import dao.*;

public class DeviceApp {

    public static void main(String[] args) {
    	
    	Dao dao = new Dao();
    	
        Device l1 = new Device("Dell Latitude 7490");
        dao.saveDevice(l1);
        System.out.println("Device saved.");
        System.out.println(l1.getDeviceId());

        Device l2 = dao.getDevice(1);
        System.out.println("Device retrieved.");
        System.out.println(l2);

        Device l3 = new Device("Device with a auto-generated ID.");
        dao.saveDevice(l3);
        System.out.println("Device saved.");
        System.out.println(l3.getDeviceId());

        dao.updateDeviceDescription(1, "Dell Latitude 7490 - updated");

        dao.removeDevice(2);

    }
}

