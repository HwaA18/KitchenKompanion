package com.example.kitchenkompanion;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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
        startActivity(new Intent(this, RecipeActivity.class));
    }

    public void Cabinet(View view) {
        startActivity(new Intent(this, CabActivity.class));
    }
}