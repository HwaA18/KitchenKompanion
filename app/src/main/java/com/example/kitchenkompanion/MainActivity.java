package com.example.kitchenkompanion;
/*Description: Main page of the app which contains 4 icons that
 * when clicked take the user to a different activity
 * Author: Oscar Akakpo Ayewanou, Austin Hwa, Kevin Tat
 * Date: 10/21/21
 * */
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Kitchen Kompanion");
    }


    public void Shopping(View view) {
        startActivity(new Intent(this, ChartActivity.class));
    }

    public void Fridge(View view) {
        startActivity(new Intent(this, FridgeActivity.class));
    }

    public void Recipe(View view) {
        startActivity(new Intent(this, RecipeMainActivity.class));
    }

    public void Cabinet(View view) {
        startActivity(new Intent(this, CabActivity.class));
    }
}