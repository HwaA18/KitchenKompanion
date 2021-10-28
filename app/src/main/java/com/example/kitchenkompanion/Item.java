package com.example.kitchenkompanion;

public class Item {
    String name;
    String img;
    int quantity;

    public Item (String name, String img, int quantity) {
        this.name = name;
        this.img = img;
        this.quantity = quantity;
    }

    public String getName() {return this.name;}
    public String getImg() {return this.img;}
    public int getQuantity() {return this.quantity;}
}
