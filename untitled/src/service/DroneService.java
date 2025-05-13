package service;

import entity.Drone;
import repository.DroneRepo;
import repository.IDroneRepo;

import java.util.List;

public class DroneService implements IDroneSerivce {

    private static final IDroneRepo iDroneRepo = new DroneRepo();
    @Override
    public List<Drone> findAll() {
        return iDroneRepo.findAll();
    }

    @Override
    public void add(Drone drone) {
        iDroneRepo.add(drone);
    }

    @Override
    public List<Drone> search(String idOrName) {
        return iDroneRepo.search(idOrName);
    }

    @Override
    public boolean delete(String registerNumber) {
       return iDroneRepo.delete(registerNumber);
    }

    @Override
    public boolean findId(String registerNumber) {
        return iDroneRepo.findId(registerNumber);
    }
}
