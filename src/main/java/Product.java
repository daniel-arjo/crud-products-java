public class Product {
    private Integer id;
    private String name;
    private double price;
    private String description;
    private int stockQuantity;
    public Product(String name, double price, String description, int StockQuantity){
        this.name = name;
        this.price = price;
        this.description = description;
        this.stockQuantity = StockQuantity;
    }
    public Product(Integer id, String name, double price, String description, int StockQuantity){
        this(name, price, description, StockQuantity);
        this.id = id;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", stockQuantity=" + stockQuantity +
                '}' + '\n';
    }

    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public String getDescription() {
        return description;
    }
    public int getStockQuantity() {
        return stockQuantity;
    }
}

