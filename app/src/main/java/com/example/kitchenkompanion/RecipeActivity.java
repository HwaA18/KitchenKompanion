package com.example.kitchenkompanion;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.FileObserver;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecipeActivity extends AppCompatActivity {
    private TextView mRecipeName;
    private TextView mRecipeIngredients;
    private TextView mRecipeMethodTitle;
    private TextView mRecipe;
    public static ArrayList<Item> it = FridgeActivity.items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
        for(Item i : it) {
            Log.d("HWAIJDOIASJDOAISJDOAIWJDOAIWJDOASJDOAS",i.getName());
        }
    }

    public void loadInventory(View view) {
        Toast.makeText(getApplicationContext(), "Go to the Inventory first!",
                Toast.LENGTH_LONG).show();
    }
}