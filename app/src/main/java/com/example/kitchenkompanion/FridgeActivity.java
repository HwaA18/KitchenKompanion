package com.example.kitchenkompanion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class FridgeActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> items;
    ArrayAdapter<String> adapter;

    EditText input;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fridge);

        getSupportActionBar().setTitle("here we are");

        listView = findViewById(R.id.listview);
        input = findViewById(R.id.editTextTextPersonName);
        button = findViewById(R.id.button2);

        items = new ArrayList<String>();
        items.add("Apple");
        items.add("Banana");
        items.add("Mangoes");

        adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String text = input.getText().toString();
                if(text == null || text.length() == 0) {
                    return;
                } else {
                    addFood(text);
                    input.setText("");
                }
            }
        });
    }

    public void addFood(String text) {
        items.add(text);
        listView.setAdapter(adapter);
    }

    public void onAddItem(View view) {

    }
}