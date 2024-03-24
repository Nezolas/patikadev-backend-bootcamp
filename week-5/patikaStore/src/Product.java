public class Product {
    private static int idCounter = 1;
    private int id;
    private double unitPrice;
    private double discountRatio;
    private int stockAmount;
    private String name;
    private Brand brand;
    private int storage;
    private double screenSize;
    private int camera;
    private double battery;
    private int ram;
    private String color;

    public Product(double unitPrice, int stockAmount, String name, Brand brand, int storage, double screenSize, int camera, double battery) {
        this.id = idCounter++;
        this.unitPrice = unitPrice;
        this.stockAmount = stockAmount;
        this.name = name;
        this.brand = brand;
        this.storage = storage;
        this.screenSize = screenSize;
        this.camera = camera;
        this.battery = battery;

    }

    public Product(double unitPrice, int stockAmount, String name, Brand brand, int storage, double screenSize, int ram) {
        this.id = idCounter++;
        this.unitPrice = unitPrice;
        this.stockAmount = stockAmount;
        this.name = name;
        this.brand = brand;
        this.storage = storage;
        this.screenSize = screenSize;
        this.ram = ram;
    }

    public Product(double unitPrice, double discountRatio, int stockAmount, String name, Brand brand, int storage, double screenSize, int camera, double battery, int ram, String color) {
        this.id = idCounter++;
        this.unitPrice = unitPrice;
        this.discountRatio = discountRatio;
        this.stockAmount = stockAmount;
        this.name = name;
        this.brand = brand;
        this.storage = storage;
        this.screenSize = screenSize;
        this.camera = camera;
        this.battery = battery;
        this.ram = ram;
        this.color = color;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public int getId() {
        return id;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public double getDiscountRatio() {
        return discountRatio;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public String getName() {
        return name;
    }

    public Brand getBrand() {
        return brand;
    }

    public int getStorage() {
        return storage;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public int getCamera() {
        return camera;
    }

    public double getBattery() {
        return battery;
    }

    public int getRam() {
        return ram;
    }

    public String getColor() {
        return color;
    }
}
