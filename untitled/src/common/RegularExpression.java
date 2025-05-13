package common;

import java.time.Year;
import java.util.Scanner;

public class RegularExpression {
    public static int readInt(Scanner sc, String message) {
        int number = 0;
        boolean isValid = false;

        while (!isValid) {
            System.out.println(message);
            try {
                number = sc.nextInt();
                isValid = true;
                sc.nextLine();
            } catch (Exception ex) {
                System.out.println("Nhập một số nguyên dương!!!");
                sc.nextLine();
            }
        }
        return number;
    }

    public static String checkId(Scanner sc, String message, String type) {
        boolean check;
        String regexId;
        String id;
        do {
            System.out.println(message);
            id = sc.nextLine();
            if (type.equals("Drone")) {
                regexId = "^D+R+N+-+\\d{3}$";
            } else {
                regexId = "^X+T+T+-+\\d{3}$";
            }
            check = id.matches(regexId);
        } while (!check);
        return id;
    }

    public static String checkName(Scanner sc, String message) {
        boolean check;
        String name;
        do {
            System.out.println(message);
            name = sc.nextLine();
            String regexName = "^([A-Z][a-z]*)(\\s[A-Z][a-z]*)?(\\s[A-Z][a-z]*)+$";
            check = name.matches(regexName);
        } while (!check);
        return name;
    }

    public static String checkDate(Scanner sc, String message) {
        boolean isGreater;
        String year;
        do {
            System.out.println(message);
            year = sc.nextLine();
            isGreater = isGreater(year);
            if(!isGreater){
                System.out.printf("Năm phải bé hơn năm %s",Year.now());
            }
        } while (!isGreater);
        return year;
    }

    public static boolean isGreater(String dateStr) {
        Year year = Year.now();
        Year year2 = Year.parse(dateStr);
        return year.isAfter(year2);
    }

    public static double validateDistance(Scanner sc, String message) {
        double distance = 0;
        do {
            try {
                System.out.println(message);
                distance = Double.parseDouble(sc.nextLine());
                if (distance <= 0) {
                    System.out.println("Nhập 1 số dương");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Nhập sai! Vui lòng nhập một số!");
            }

        } while (distance <= 0);
        return distance;
    }

    public static int validateDefensive(Scanner sc, String message) {
        int defensive = 0;
        do {
            try {
                System.out.println(message);
                defensive = Integer.parseInt(sc.nextLine());
                if (defensive <= 0 || defensive >= 11) {
                    System.out.println("Nhập một số từ 1 đến 10");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Nhập sai! Vui lòng nhập một số!");
            }
        } while (defensive <= 0 || defensive >= 11);
        return defensive;
    }
}
