package controller;

import common.NotFoundVehicleException;
import common.RegularExpression;
import entity.Brand;
import entity.Drone;
import entity.MoonCar;
import service.BrandService;
import service.DroneService;
import service.MoonCarService;
import view.DroneView;
import view.MoonCarView;

import java.util.List;
import java.util.Scanner;

public class VehicleController {

    private static Scanner sc = new Scanner(System.in);

    public static void displayMainMenu() {
        DroneService droneService = new DroneService();
        MoonCarService moonCarService = new MoonCarService();
        boolean flag = true;
        do {
            System.out.println("======================================================");
            System.out.println("=       CHƯƠNG TRÌNH QUẢN LÝ PHƯƠNG TIỆN THÁM HIỂM   =");
            System.out.println("= 1. Thêm mới phương tiện                            =");
            System.out.println("= 2. Hiển thị danh sách phương tiện                  =");
            System.out.println("= 3. Tìm kiếm phương tiện                            =");
            System.out.println("= 4. Xóa phương tiện                                 =");
            System.out.println("= 5. Thoát                                           =");
            System.out.println("======================================================");
            int choice = RegularExpression.readInt(sc, "Chọn chức năng: ");
            switch (choice) {
                case 1:
                    addMenu();
                    break;
                case 2:
                    displayVehicle();
                    break;
                case 3:
                    String nameOrId = DroneView.search();
                    List<Drone> droneList = droneService.search(nameOrId);
                    List<MoonCar> moonCarList = moonCarService.search(nameOrId);
                    if (droneList != null || moonCarList != null) {
                        if (droneList != null) {
                            DroneView.display(droneList);
                        }
                        if (moonCarList != null) {
                            MoonCarView.display(moonCarList);
                        }
                    } else {
                        System.out.println("Không tìm thấy phương tiện phù hợp");
                    }
                    break;
                case 4:
                    boolean isDeleteDrone;
                    boolean isDeleteMoonCar;
                    String id = DroneView.delete();
                    boolean findIdDrone = droneService.findId(id);
                    boolean findIdMoonCar = moonCarService.findId(id);
                    if (findIdDrone || findIdMoonCar) {
                        boolean confirm = DroneView.confirm();

                        if (confirm) {
                            isDeleteDrone = droneService.delete(id);
                            isDeleteMoonCar = moonCarService.delete(id);
                            if (isDeleteDrone || isDeleteMoonCar) {
                                if (isDeleteDrone) {
                                    System.out.println("Xóa drone thành công");
                                } else {
                                    System.out.println("Xóa xe tuần tra mặt trăng thành công");
                                }
                            } else {
                                System.out.println("Không tìm thấy");
                            }
                            break;

                        } else {
                            System.out.println("Thoát chức năng xóa");
                        }
                    }else{
                        throw new NotFoundVehicleException("Số hiệu phương tiện không tồn tại.");
                    }
                    break;
                case 5:
                    flag = false;
                    break;
                default:
                    System.out.println("Hãy chọn số từ 1 tới 5!!");
            }
        } while (flag);
    }

    public static void addMenu() {
        DroneService droneService = new DroneService();
        MoonCarService moonCarService = new MoonCarService();
        BrandService brandService = new BrandService();
        List<Brand> brandList = brandService.findAll();
        boolean flag = true;
        do {
            System.out.println("======================================================");
            System.out.println("=       THÊM MỚI PHƯƠNG TIỆN                         =");
            System.out.println("= 1. Thêm Drone bay                                  =");
            System.out.println("= 2. Thêm Xe tuần tra mặt trăng                      =");
            System.out.println("= 3. Thoát                                           =");
            System.out.println("======================================================");
            int choice = RegularExpression.readInt(sc, "Chọn chức năng: ");
            switch (choice) {
                case 1:
                    Drone drone = DroneView.add(brandList);
                    droneService.add(drone);
                    break;
                case 2:
                    MoonCar moonCar = MoonCarView.add(brandList);
                    moonCarService.add(moonCar);
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    System.out.println("Hãy chọn số từ 1 tới 3!!");
            }
        } while (flag);
    }


    public static void displayVehicle() {
        boolean flag = true;
        DroneService droneService = new DroneService();
        MoonCarService moonCarService = new MoonCarService();
        do {
            System.out.println("======================================================");
            System.out.println("=       THÊM MỚI PHƯƠNG TIỆN                         =");
            System.out.println("= 1. Hiển thị Drone bay                              =");
            System.out.println("= 2. Hiển thị Xe tuần tra mặt trăng                  =");
            System.out.println("= 3. Thoát                                           =");
            System.out.println("======================================================");
            int choice = RegularExpression.readInt(sc, "Chọn chức năng: ");
            switch (choice) {
                case 1:
                    List<Drone> droneList = droneService.findAll();
                    DroneView.display(droneList);
                    break;
                case 2:
                    List<MoonCar> moonCar = moonCarService.findAll();
                    MoonCarView.display(moonCar);
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    System.out.println("Hãy chọn số từ 1 tới 3!!");
            }
        } while (flag);
    }

}
