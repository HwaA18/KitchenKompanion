package com.example.kitchenkompanion;

public class Item {
    String name, exp;
    int quantity;
    double price;
    boolean inFridge;

    public Item (String name, double price, int quantity, boolean inFridge, String exp) {
        this.name = name;
        //this.img = img;
        this.price = price;
        this.quantity = quantity;
        this.inFridge = inFridge;
        this.exp = exp;
    }
    public Item (String name, double price, int quantity, String exp) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.inFridge = false;
        this.exp = exp;
    }

    public Item() {

    }

    public String getName() {return this.name;}
    public String getExp() {return this.exp;}
    public double getPrice() {return this.price;}
    public int getQuantity() {return this.quantity;}
    public boolean isInFridge() {return inFridge; }
}
