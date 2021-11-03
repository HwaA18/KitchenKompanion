package com.example.kitchenkompanion;



import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;


public class ChartActivity extends Activity {

    ListView liv;
    Button btn ;
    TextView name;
    TextView price;
    TextView qty;
    ArrayList<Item> items;
    ArrayAdapter<Item> adp ;
    ItemAdapter itemAdp;
    String nameStr;
    String info = "";
    int qtySTr;
    double priceStr;
    File filesDir;
    File todoFile;



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
                android.R.layout.simple_spinner_dropdown_item, items);
        filesDir = new File(getApplicationContext().getFilesDir(), "content.txt");


        try {

            FileUtils.writeStringToFile(filesDir, "Item Name\t" +
                    "Price\t\tQuantity");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Item t = new Item("bate", 50, 3);

        itemAdp.addItem(t);
        setupListViewListener();


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
                    info = ""+ nameStr+"\t"+priceStr+"\t\t"+qtySTr+"\n";

                    add(item);
                    name.setText("");
                    qty.setText("");
                    price.setText("");
                    try {

                        FileUtils.writeStringToFile(filesDir, info);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }

            }
        });
    }



    public void setupListViewListener()
    {
        liv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {



                new AlertDialog.Builder(ChartActivity.this)
                        .setIcon(android.R.drawable.ic_dialog_info)
                        .setTitle("Inventory modification")
                        .setMessage("Do you want to edit this item?")
                        .setPositiveButton("Remove", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                items.remove(position);

                                // Refresh the adapter
                                itemAdp.notifyDataSetChanged();
                                adp.notifyDataSetChanged();
                                // Return true consumes the long click event (marks it handled)

                            }
                        })
                        .setNegativeButton("Cancel",null)
                        .show();

                return true;

            }
        });
    }
    public void AddingItem(View view) {


    }
    public void add(Item ne) {

        itemAdp.addItem(ne);

        liv.setAdapter(itemAdp);
        adp.notifyDataSetChanged();

    }


    private void writeItems() {


    }




}