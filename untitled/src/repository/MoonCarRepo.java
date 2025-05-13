package repository;

import common.ReadAndWriteFileCSV;
import entity.Drone;
import entity.MoonCar;

import java.util.ArrayList;
import java.util.List;

public class MoonCarRepo implements IMoonCarRepo{

    private static String FILE_PATH = "D:\\Codegym\\module2_bai_tap_lam_them\\untitled\\src\\data\\xeTuanTra.csv";
    @Override
    public List<MoonCar> findAll() {
        List<String> stringList = ReadAndWriteFileCSV.readFileCSV(FILE_PATH);
        List<MoonCar> moonCarList = new ArrayList<>();
        for(String line : stringList){
            String[] arr = line.split(",");
            moonCarList.add(new MoonCar(arr[0],arr[1],arr[2],arr[3],arr[4]));
        }
        return moonCarList;
    }

    @Override
    public void add(MoonCar moonCar) {
        List<String> stringList = new ArrayList<>();
        stringList.add(moonCar.getInfo());
        ReadAndWriteFileCSV.writeFileCSV(FILE_PATH,stringList,true);
    }

    @Override
    public List<MoonCar> search(String idOrName) {
        List<MoonCar> moonCarList2 = new ArrayList<>();
        List<MoonCar> moonCarList = findAll();
        for (MoonCar moonCar : moonCarList) {
            if ((moonCar.getRegisterNumber().toLowerCase()).contains(idOrName.toLowerCase()) || (moonCar.getDistributePerson().toLowerCase()).contains(idOrName.toLowerCase())) {
                moonCarList2.add(moonCar);
            }
        }
        if(!moonCarList2.isEmpty()){
            return moonCarList2;
        }
        return null;
    }

    @Override
    public boolean delete(String registerNumber) {
        boolean found = false;
        List<MoonCar> moonCarList = findAll();
        for (int i = 0; i < moonCarList.size(); i++) {
            if (moonCarList.get(i).getRegisterNumber().equals(registerNumber)) {
                moonCarList.remove(moonCarList.get(i));
                found = true;
            }
        }
        List<String> listString = new ArrayList<>();
        if (found) {
            for (MoonCar moonCar : moonCarList) {
                listString.add(moonCar.getInfo());
            }
        }
        ReadAndWriteFileCSV.writeFileCSV(FILE_PATH,listString,false);
        return found;
    }

    @Override
    public boolean findId(String registerNumber) {
        List<MoonCar> moonCarList = findAll();
        for(MoonCar moonCar : moonCarList){
            if(moonCar.getRegisterNumber().equals(registerNumber)){
                return true;
            }
        }
        return false;
    }
}
