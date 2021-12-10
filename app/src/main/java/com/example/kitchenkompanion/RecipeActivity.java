package com.example.kitchenkompanion;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.FileObserver;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class RecipeActivity extends AppCompatActivity {
    private TextView mRecipeName;
    private TextView mRecipeIngredients;
    private TextView mRecipeMethodTitle;
    private TextView mRecipe;
    public static ArrayList<Item> it = FridgeActivity.items;

    static Hashtable<String, Item> lookup = new Hashtable<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        lookup.put("milk", new Item("Milk", 3.69, 1, true, "21 days"));
        lookup.put("asparagus", new Item("Asparagus", 2.48, 1, true, "21 days"));
        lookup.put("broccoli", new Item("Broccoli", 2.89, 1, true, "21 days"));
        lookup.put("carrots", new Item("Carrots", 3.89, 1, true, "21 days"));
        lookup.put("cauliflower", new Item("Cauliflower", 1.22, 1, true, "21 days"));
        lookup.put("celery", new Item("Celery", 1.96, 1, true, "21 days"));
        lookup.put("corn", new Item("Corn", 4.69, 1, true, "5 days"));
        lookup.put("cucumbers", new Item("Cucumbers", 1.50, 1, true, "14 days"));
        lookup.put("lettuce", new Item("Lettuce", 1.28, 1, true, "7 days"));
        lookup.put("onions", new Item("Onions", 1.05, 1, true, "60 days"));
        lookup.put("mushrooms", new Item("Mushrooms", 9.99, 1, true, "5 days"));
        lookup.put("peppers", new Item("Peppers", 2.46, 1, false, "3 days"));
        lookup.put("potatoes", new Item("Potatoes", 1.60, 1, false,"28 days"));
        lookup.put("spinach", new Item("Spinach", 6.99, 1, true, "5 days"));
        lookup.put("tomatoes", new Item("Tomatoes", 1.89, 1, false, "6 days"));
        lookup.put("apples", new Item("Apples", 2.99, 1, false, "21 days"));
        lookup.put("avacados", new Item("Avacados",2.10, 1, false, "3 days"));
        lookup.put("bananas", new Item("Bananas", 0.99, 1, false,"3 days" ));
        lookup.put("berries", new Item("Berries", 4.86, 1, true, "6 days"));
        lookup.put("cherries", new Item("Cherries", 8.99, 1, true,"7 days"));
        lookup.put("grapefruit", new Item("Grapefruit", 1.25, 1, false, "17 days"));
        lookup.put("grapes", new Item("Grapes", 2.25, 1, true, "6 days"));
        lookup.put("kiwis", new Item("Kiwis", 0.75, 1, false, "7 days"));
        lookup.put("lemons", new Item("Lemons", 2.60, 1, false, "21 days"));
        lookup.put("lime", new Item("Lime", 1.67,1, false, "21 days"));
        lookup.put("melon", new Item("Melon", 6.99,1, false, "7 days"));
        lookup.put("oranges", new Item("Oranges", 1.33,1, false, "18 days"));
        lookup.put("peaches", new Item("Peaches", 1.68,1, false, "4 days"));
        lookup.put("pears", new Item("Pears",1.52,1, false, "7 days"));
        lookup.put("plums", new Item("Plums",0.77,1, false, "2 days"));
        lookup.put("eggs", new Item("Eggs", 7.69,1, true, "28 days"));
        lookup.put("hummus", new Item("Hummus", 6.10,1, true, "10 days"));
        lookup.put("tofu", new Item("Tofu", 2.59,1, true, "60 days"));
        lookup.put("honey", new Item("Honey", 9.10,1, false, "9999 days"));
        lookup.put("olive oil", new Item("Olive oil", 7.12,1, false, "600 days"));
        lookup.put("pasta", new Item("Pasta", 1.31,1, false, "365 days"));
        lookup.put("rice", new Item("Rice", 12.32,1, false, "1200 days"));
        lookup.put("vinegar", new Item("Vinegar", 2.86,1, false, "9999 days"));
        lookup.put("canola oil", new Item("Canola oil", 2.88,1, false, "720 days"));
        lookup.put("basil", new Item("Basil", 15.21, 1, false, "720 days"));
        lookup.put("black pepper", new Item("Black pepper", 3.87,1, false, "620 days"));
        lookup.put("cilantro", new Item("Cilantro", 1.20,1, true, "5 days"));
        lookup.put("cinnamon", new Item("Cinnamon", 7.99,1, false, "1080 days"));
        lookup.put("oregano", new Item("Oregano", 5.99,1, true, "720 days"));
        lookup.put("ginger", new Item("Ginger", 6.99,1, true, "520 days"));
        lookup.put("garlic", new Item("Garlic", 2.00,1, false, "90 days"));
        lookup.put("paprika", new Item("Paprika", 10.81,1, false, "1080 days"));
        lookup.put("red pepper", new Item("Red pepper", 2.32,1, true, "720 days"));
        lookup.put("salt", new Item("Salt", 1.08, 1, false, "9999 days"));
        lookup.put("vanilla extract", new Item("Vanilla extract", 20,1, false, "1800 days"));
        lookup.put("butter", new Item("Butter", 2.18, 1, true, "14 days"));
        lookup.put("yogurt", new Item("Yogurt", 2.33,1, true, "7 days"));
        lookup.put("cheese", new Item("Cheese", 1.77, 1, true, "30 days"));
        lookup.put("bacon", new Item("Bacon", 5.76, 1, true, "7 days"));
        lookup.put("beef", new Item("Beef", 5.67,1, true, "3 days"));
        lookup.put("turkey", new Item("Turkey", 1.39, 1, true, "2 days"));
        lookup.put("chicken", new Item("Chicken", 1.65,1, true, "2 days"));
        lookup.put("ham", new Item("Ham", 3.50, 1, true, "7 days"));
        lookup.put("fish", new Item("Fish", 9.99,1, true, "2 days"));
        lookup.put("crab", new Item("Crab", 19.99,1, true, "2 days"));
        lookup.put("lobster", new Item("Lobster", 5.99,1, true, "60 days"));
        lookup.put("shrimp", new Item("Shrimp", 15.99,1, true, "2 days"));
        lookup.put("sugar", new Item("Sugar", 2.59, 1, false, "720 days"));
        lookup.put("flour", new Item("Flour", 2.50,1, false, "120 days"));
        lookup.put("yeast", new Item("Yeast", 1.25,1, false, "60 days"));
        lookup.put("bread", new Item("Bread", 2.50,1, false, "6 days"));
        lookup.put("beans", new Item("Beans", 1.75,1, false, "730 days"));
        lookup.put("salsa", new Item("Salsa", 3.38, 1, true, "456 days"));
        lookup.put("vegan crumbles", new Item("Vegan Crumbles", 3.84, 1, true, "365 days"));


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        mRecipeName = (TextView) findViewById(R.id.text_recipe);
        mRecipeIngredients = (TextView) findViewById(R.id.ingredients);
        mRecipeMethodTitle = (TextView) findViewById(R.id.method);
        mRecipe = (TextView) findViewById(R.id.recipe);

        Intent intent = getIntent();
        String Title = intent.getExtras().getString("RecipeName");
        String Ingredients = intent.getExtras().getString("RecipeIngredients");
        String MethodTitle = intent.getExtras().getString("RecipeMethodTitle");
        String Recipe = intent.getExtras().getString("Recipe");

        mRecipeName.setText(Title);
        mRecipeIngredients.setText(Ingredients);
        mRecipeMethodTitle.setText(MethodTitle);
        mRecipe.setText(Recipe);

    }

    public void inventoryCheck(View view) {
        File updated = new File(RecipeActivity.this.getFilesDir(), "uptodate.txt");

        try {
            String  nameUp, qtyUp, expUp;
            FileOutputStream fileOutUp = new FileOutputStream(updated);
            PrintWriter writerUp = new PrintWriter(fileOutUp);


            for(int i = 0; i<5;i++)
            {
                Item randomChar = new ArrayList<>(lookup.values()).get(new Random().nextInt(lookup.size()));
                nameUp = leftpad(randomChar.getName(), 15);
                qtyUp = leftpad(""+new Random().nextInt(3) + 1, 15);
                expUp = leftpad(randomChar.getExp(), 15);
                writerUp.println(nameUp+qtyUp+expUp);
            }
            writerUp.flush();
            writerUp.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        finish();
        int number = new Random().nextInt(4) + 1;
        if(number % 2 == 0) {
            Toast.makeText(getApplicationContext(), "Items added to Shopping List",
                    Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Recipe Made!",
                    Toast.LENGTH_LONG).show();
        }


    }

    private String leftpad(String text, int length) {
        return String.format("%-" + length + "." + length + "s", text);
    }

    public void loadInventory(View view) {
        Toast.makeText(getApplicationContext(), "Go to the Inventory first!",
                Toast.LENGTH_LONG).show();
    }
}