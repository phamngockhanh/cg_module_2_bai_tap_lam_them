package entity;

public class Vehicle {
    private String registerNumber;
    private String brandName;
    private String year;
    private String distributePerson;

    public Vehicle(String registerNumber, String brandName, String year, String distributePerson) {
        this.registerNumber = registerNumber;
        this.brandName = brandName;
        this.year = year;
        this.distributePerson = distributePerson;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDistributePerson() {
        return distributePerson;
    }

    public void setDistributePerson(String distributePerson) {
        this.distributePerson = distributePerson;
    }

    @Override
    public String toString() {
        return
                "registerNumber='" + registerNumber + '\'' +
                        ", brandName='" + brandName + '\'' +
                        ", year=" + year +
                        ", distributePerson='" + distributePerson + '\'';
    }

    public String getInfo() {
        return this.registerNumber + "," + this.brandName + "," + this.year + "," + this.distributePerson;
    }
}
