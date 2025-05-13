package entity;

public class Drone extends Vehicle {
    private double distance;

    public Drone(String registerNumber, String brandName, String year, String distributePerson, double distance) {
        super(registerNumber, brandName, year, distributePerson);
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Drone{" + super.toString() +
                "distance=" + distance +
                '}';
    }

    public String getInfo(){
        return super.getInfo()+","+this.getDistance();
    }
}
