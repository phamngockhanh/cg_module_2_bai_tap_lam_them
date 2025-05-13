package view;

import common.RegularExpression;
import entity.Brand;
import entity.MoonCar;

import java.util.List;
import java.util.Scanner;

public class MoonCarView {
    private static Scanner sc = new Scanner(System.in);

    public static void display(List<MoonCar> moonCarList) {
        for (MoonCar moonCar : moonCarList) {
            System.out.println(moonCar);
        }
    }

    public static MoonCar add(List<Brand> brandList) {
        String registerId = RegularExpression.checkId(sc, "Nhập số hiệu: ", "MoonCar");
        for (int i = 0; i < brandList.size(); i++) {
            System.out.println(i + 1 + " : " + brandList.get(i).getBrandName());
        }
        int choice;
        do {
            System.out.println("Chọn hãng sản xuất:");
            choice = Integer.parseInt(sc.nextLine());
            if (choice < 0 || choice > brandList.size()) {
                System.out.printf("Chọn từ 1 đến %d", brandList.size());
                System.out.println();
            }
        } while (choice < 0 || choice > brandList.size());
        String brandName = "";
        for (int i = 0; i < brandList.size(); i++) {
            if (choice == (i + 1)) {
                brandName = brandList.get(i).getBrandName();
            }
        }
        String year = RegularExpression.checkDate(sc, "Nhập năm sản xuất: ");
        String distributePerson = RegularExpression.checkName(sc, "Nhập tên người điều phối");
        int level= RegularExpression.validateDefensive(sc,"Nhập khả năng chống phóng xạ: ");
        String defensive = "Cấp " + level;
        return new MoonCar(registerId, brandName, year, distributePerson, defensive);
    }
}
