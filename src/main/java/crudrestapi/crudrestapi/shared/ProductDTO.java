package crudrestapi.crudrestapi.shared;

public class ProductDTO {
    private Integer id;
    private String name;
    private String ribbon;
    private String description;
    private Double price;
    private Double salePrice;

    private Integer sku;
    private Integer quantity;
    private String category;
    private Boolean salesCategory;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRibbon() {
        return ribbon;
    }

    public void setRibbon(String ribbon) {
        this.ribbon = ribbon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getSku() {
        return sku;
    }

    public void setSku(Integer sku) {
        this.sku = sku;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean getSalesCategory() {
        return salesCategory;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ribbon='" + ribbon + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", salePrice=" + salePrice +
                ", sku=" + sku +
                ", quantity=" + quantity +
                ", category='" + category + '\'' +
                ", salesCategory=" + salesCategory +
                '}';
    }

    public void setSalesCategory(Boolean salesCategory) {
        this.salesCategory = salesCategory;
    }
}
