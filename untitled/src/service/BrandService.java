package service;

import entity.Brand;
import repository.BrandRepo;
import repository.IBrandRepo;

import java.util.List;

public class BrandService implements IBrandService {
    private static final IBrandRepo iBrandrepo = new BrandRepo();

    @Override
    public List<Brand> findAll() {
        return iBrandrepo.findAll();
    }

    @Override
    public void add(Brand brand) {

    }

    @Override
    public List<Brand> search(String idOrName) {
        return List.of();
    }

    @Override
    public boolean delete(String registerNumber) {
        return false;
    }

    @Override
    public boolean findId(String registerNumber) {
        return false;
    }
}
