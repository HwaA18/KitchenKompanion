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
        getSupportActionBar().setTitle("ShoppingList activity");
    }

    public void openmain2(View view) {
        startActivity(new Intent(this, MainActivity2.class));
    }

    public void openmain3 (View view) {
        startActivity(new Intent(this, MainActivity3.class));
    }
}