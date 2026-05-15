package carts.pojo;

import carts.pojo.enums.ProductType;

public class Product {

    private String productID;
    private String name;
    private ProductType productType;
    private int cost;

    public Product(String productID, String name, ProductType productType, int cost) {
        this.productID = productID;
        this.name = name;
        this.productType = productType;
        this.cost = cost;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
