package view;

import common.RegularExpression;
import entity.Brand;
import entity.Drone;
import java.util.List;
import java.util.Scanner;

public class DroneView {
    private static Scanner sc = new Scanner(System.in);

    public static void display(List<Drone> droneList) {
        for (Drone drone : droneList) {
            System.out.println(drone);
        }
    }

    public static Drone add(List<Brand> brandList) {
        String registerId = RegularExpression.checkId(sc, "Nhập số hiệu: ", "Drone");
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
        String year = RegularExpression.checkDate(sc,"Nhập năm sản xuất");
        String distributePerson = RegularExpression.checkName(sc,"Nhập tên người điều phối: ");
        double distance = RegularExpression.validateDistance(sc,"Nhập tầm bay tối đa");
        return new Drone(registerId, brandName, year, distributePerson, distance);
    }
    public static String search(){
        System.out.println("Nhập tên hoặc số hiệu mà bạn muốn tìm kiếm : ");
        return sc.nextLine();
    }

    public static String delete(){
        System.out.println("Nhập số hiệu mà bạn muốn xóa: ");
        return sc.nextLine();
    }

    public static boolean confirm(){
        System.out.println("Bạn có muốn xóa không?");
        String confirm = sc.nextLine();
        return confirm.equalsIgnoreCase("yes");
    }


}
