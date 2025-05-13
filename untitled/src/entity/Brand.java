package entity;

public class Brand {
    private String brandId;
    private String brandName;
    private String country;

    public Brand(String brandId, String brandName, String country) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.country = country;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "brandId='" + brandId + '\'' +
                ", brandName='" + brandName + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    private String getInfo() {
        return this.getBrandId() + "," + this.getBrandName() + "," + this.getCountry();
    }
}
