package repository;

import common.ReadAndWriteFileCSV;
import entity.Brand;

import java.util.ArrayList;
import java.util.List;

public class BrandRepo implements IBrandRepo{
    private String FILE_PATH = "D:\\Codegym\\module2_bai_tap_lam_them\\untitled\\src\\data\\hangCheTao.csv";


    @Override
    public List<Brand> findAll() {
        List<String> stringList = ReadAndWriteFileCSV.readFileCSV(FILE_PATH);
        List<Brand> brandList = new ArrayList<>();
        for(String line : stringList){
            String[] arr = line.split(",");
            brandList.add(new Brand(arr[0],arr[1],arr[2]));
        }
        return brandList;
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
