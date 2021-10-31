package com.example.kitchenkompanion;

public class Recipes {

    String name;
    String ingredients;
    String title;
    String recipe;
    int thumbnail;

    public Recipes(String name, String ingredients, String title, String recipe, int thumbnail) {
        this.name = name;
        this.ingredients = ingredients;
        this.title = title;
        this.recipe = recipe;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
