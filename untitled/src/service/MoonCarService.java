package service;

import entity.MoonCar;
import repository.IMoonCarRepo;
import repository.MoonCarRepo;

import java.util.List;

public class MoonCarService implements IMoonCarService{
    private static final IMoonCarRepo iMoonCarRepo = new MoonCarRepo();
    @Override
    public List<MoonCar> findAll() {
        return iMoonCarRepo.findAll();
    }

    @Override
    public void add(MoonCar moonCar) {
        iMoonCarRepo.add(moonCar);
    }


    @Override
    public List<MoonCar> search(String idOrName) {
        return iMoonCarRepo.search(idOrName);
    }

    @Override
    public boolean delete(String registerNumber) {
       return iMoonCarRepo.delete(registerNumber);
    }

    @Override
    public boolean findId(String registerNumber) {
        return iMoonCarRepo.findId(registerNumber);
    }
}
