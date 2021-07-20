package com.android.store;

public class ProductoBean {

    private String productName;
    private int productImage;
    private double productPrice;


    public ProductoBean(String productName, int productImage, double productPrice) {
        this.productName = productName;
        this.productImage = productImage;
        this.productPrice = productPrice;

    }



    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

}
