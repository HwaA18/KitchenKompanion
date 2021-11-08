package com.example.kitchenkompanion;
/*Description: Class created to model item that are bought using
* the app. It consists of the item's name, quantity, price, location
* Author: Kevin Tat, Oscar Akakpo Ayewanou
* Date: 10/21/21
* */
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
    public Item (String name, int quantity, String exp) {
        this.name = name;
        this.price = 0;
        this.quantity = quantity;
        this.inFridge = false;
        this.exp = exp;
    }

    public String getName() {return this.name;}
    public String getExp() {return this.exp;}
    public double getPrice() {return this.price;}
    public int getQuantity() {return this.quantity;}
    public boolean isInFridge() {return inFridge; }
}
