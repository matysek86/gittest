package pl.mpas.advancedprogramming.files;

public class Alcohol {

    private String brand;
    private String type;
    private int voltage;
    private double price;
    private boolean isTeasty;

    public Alcohol(String brand, String type, int voltage, double price, boolean isTeasty) {
        this.brand = brand;
        this.type = type;
        this.voltage = voltage;
        this.price = price;
        this.isTeasty = isTeasty;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public int getVoltage() {
        return voltage;
    }

    public double getPrice() {
        return price;
    }

    public boolean isTeasty() {
        return isTeasty;
    }

    @Override
    public String toString() {
        return "Alcohol{" +
                "brand='" + brand +
                ", type='" + type +
                ", voltage=" + voltage +
                ", price=" + price +
                ", isTeasty=" + isTeasty +
                '}';

    }
}
