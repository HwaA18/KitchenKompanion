package com.example.kitchenkompanion;

public class Item {
    String name;
    String img;
    int quantity;
    boolean inFridge;

    public Item (String name, String img, int quantity, boolean inFridge) {
        this.name = name;
        this.img = img;
        this.quantity = quantity;
        this.inFridge = inFridge;
    }

    public String getName() {return this.name;}
    public String getImg() {return this.img;}
    public int getQuantity() {return this.quantity;}
    public boolean isInFridge() {return inFridge; }
}
