package repository;

import common.ReadAndWriteFileCSV;
import entity.Drone;

import java.util.ArrayList;
import java.util.List;

public class DroneRepo implements IDroneRepo {

    private String FILE_PATH = "D:\\Codegym\\module2_bai_tap_lam_them\\untitled\\src\\data\\drone.csv";

    @Override
    public List<Drone> findAll() {
        List<String> stringList = ReadAndWriteFileCSV.readFileCSV(FILE_PATH);
        List<Drone> droneList = new ArrayList<>();
        for (String line : stringList) {
            String[] arr = line.split(",");
            droneList.add(new Drone(arr[0], arr[1], arr[2], arr[3], Double.parseDouble(arr[4])));
        }
        return droneList;
    }

    @Override
    public void add(Drone drone) {
        List<String> stringList = new ArrayList<>();
        stringList.add(drone.getInfo());
        ReadAndWriteFileCSV.writeFileCSV(FILE_PATH, stringList, true);
    }

    @Override
    public List<Drone> search(String idOrName) {
        List<Drone> droneList2 = new ArrayList<>();
        List<Drone> droneList = findAll();
        for (Drone drone : droneList) {
            if ((drone.getRegisterNumber().toLowerCase()).contains(idOrName.toLowerCase()) || (drone.getDistributePerson().toLowerCase()).contains(idOrName.toLowerCase())) {
                droneList2.add(drone);
            }
        }
        if (!droneList2.isEmpty()) {
            return droneList2;
        }
        return null;
    }

    @Override
    public boolean delete(String registerNumber) {
        boolean found = false;
        List<Drone> droneList = findAll();
        for (int i = 0; i < droneList.size(); i++) {
            if (droneList.get(i).getRegisterNumber().equals(registerNumber)) {
                droneList.remove(droneList.get(i));
                found = true;
            }
        }
        List<String> listString = new ArrayList<>();
        if (found) {
            for (Drone drone : droneList) {
                listString.add(drone.getInfo());
            }
        }
        ReadAndWriteFileCSV.writeFileCSV(FILE_PATH,listString,false);
        return found;
    }

    @Override
    public boolean findId(String registerNumber) {
        List<Drone> droneList = findAll();
        for(Drone drone : droneList){
            if(drone.getRegisterNumber().equals(registerNumber)){
                return true;
            }
        }
        return false;
    }
}
