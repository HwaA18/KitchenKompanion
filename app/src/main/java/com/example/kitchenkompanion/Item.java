package com.example.kitchenkompanion;

public class Item {
    String name;
    int quantity;
    double price;
    boolean inFridge;

    public Item (String name, double price, int quantity, boolean inFridge) {
        this.name = name;
        //this.img = img;
        this.price = price;
        this.quantity = quantity;
        this.inFridge = inFridge;
    }
    public Item (String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.inFridge = false;
    }

    public String getName() {return this.name;}
    public double getPrice() {return this.price;}
    public int getQuantity() {return this.quantity;}
    public boolean isInFridge() {return inFridge; }
}
