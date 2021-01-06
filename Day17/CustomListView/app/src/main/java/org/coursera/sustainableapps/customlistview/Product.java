package org.coursera.sustainableapps.customlistview;

public class Product {
    private String title, description, type;
    private double price;
    private boolean onSale;

    public Product(String title, String description, String type, double price, boolean onSale) {
        this.title = title;
        this.description = description;
        this.type = type;
        this.price = price;
        this.onSale = onSale;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public boolean isOnSale() {
        return onSale;
    }
}
