package com.example.kitchenkompanion;

public class Recipe {
    String name;
    int calories;
    String[] ingredients;
    int[] quantities;
    String directions;

    public Recipe(String name, int calories, String[] ingredients, int[] quantities, String directions) {
        this.name = name;
        this.calories = calories;
        this.ingredients = ingredients;
        this.quantities = quantities;
        this.directions = directions;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    public int[] getQuantities() {
        return quantities;
    }

    public void setQuantities(int[] quantities) {
        this.quantities = quantities;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }
}
