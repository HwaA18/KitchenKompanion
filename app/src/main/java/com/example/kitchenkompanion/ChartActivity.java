package com.example.kitchenkompanion;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ChartActivity extends AppCompatActivity  {

    ListView liv;
    Button btn ;
    TextView name;
    TextView price;
    TextView qty;
    ArrayList<Item> items;
    ArrayAdapter<Item> adp ;
    ItemAdapter itemAdp;
    String nameStr;
    int qtySTr;
    double priceStr;
    //int cnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        liv =  findViewById(R.id.lv);
        btn = (Button) findViewById(R.id.button);
        name = (TextView) findViewById(R.id.editTextTextPersonName3);
        price = (TextView) findViewById(R.id.editTextTextPersonName);
        qty = (TextView) findViewById(R.id.editTextTextPersonName2);
        items = new ArrayList<>();
        itemAdp = new ItemAdapter(this,items);
        adp = new ArrayAdapter<Item>(this,
                android.R.layout.simple_list_item_1, items);
        //cnt = 0;
        Item i = new Item("Beef", 4.0, 4);
        Item t = new Item("bate", 50, 3);
        //itemAdp.addItem(i);
        //itemAdp.addItem(t);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                if(!name.getText().toString().isEmpty() && !price.getText().toString().isEmpty()
                        && !qty.getText().toString().isEmpty())
                {
                    nameStr = name.getText().toString();
                    try
                    {
                        qtySTr = Integer.parseInt(qty.getText().toString());
                    }
                    catch (Exception e)
                    {
                        qtySTr = 0;
                    }

                    try
                    {
                        priceStr = Double.parseDouble(price.getText().toString());
                    }
                    catch (Exception e)
                    {
                        priceStr = 0;
                    }

                    Item item = new Item(nameStr, priceStr, qtySTr);

                    add(item);
                    name.setText("");
                    qty.setText("");
                    price.setText("");

                }

            }
        });
    }


    public void AddingItem(View view) {


    }
    public void add(Item ne) {
        //items.add(ne);
        itemAdp.addItem(ne);
        liv.setAdapter(itemAdp);
        adp.notifyDataSetChanged();

    }
}