 package com.abcresttaurant.model;

public class MenuItem {
	
	private int menuItemId;
    private String name;
    private String category;
    private double price;
    private String description;

    public MenuItem(int menuItemId, String name, String category, double price, String description) {
        this.menuItemId = menuItemId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.description = description;
    }

    public MenuItem() {
    }

    public int getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(int menuItemId) {
        this.menuItemId = menuItemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
