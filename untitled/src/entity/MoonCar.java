package entity;

public class MoonCar extends Vehicle {
    private String defensive;

    public MoonCar(String registerNumber, String brandName, String year, String distributePerson, String defensive) {
        super(registerNumber, brandName, year, distributePerson);
        this.defensive = defensive;
    }

    public String getDefensive() {
        return defensive;
    }

    public void setDefensive(String defensive) {
        this.defensive = defensive;
    }

    @Override
    public String toString() {
        return "MoonCar{" + super.toString()+
                "defensive='" + defensive + '\'' +
                '}';
    }

    public String getInfo(){
        return super.getInfo()+","+this.getDefensive();
    }
}
