package com.example.kitchenkompanion;

/*Description: In this class, a list of items and itemViews are
 * created and manipulated to allow the user to add, remove and view
 * items. As items are inserted or removed, a text file is updated. The file
 * is saved under the context directory under the name "uptodate.txt"
 * Author: Oscar Akakpo Ayewanou
 * Date: 10/21/21
 * */

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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class ChartActivity extends Activity {

    ListView liv;
    Button btn ;
    Button end ;
    TextView name;
    //TextView price;
    TextView expDate;
    TextView qty;
    ArrayList<Item> items;
    ArrayAdapter<Item> adp ;
    ItemAdapter itemAdp;
    String nameStr, expStr;
    String info = "";
    int qtySTr;
    //double priceStr;
    File filesDir, updated;
    FileOutputStream fileOut, fileOutUp;
    PrintWriter writer, writerUp;




    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);


        //Initialization of variables used

        liv =  findViewById(R.id.lv);
        btn = (Button) findViewById(R.id.button);
        name = (TextView) findViewById(R.id.editTextTextPersonName3);
        //price = (TextView) findViewById(R.id.editTextTextPersonName);
        qty = (TextView) findViewById(R.id.editTextTextPersonName2);
        end = (Button) findViewById(R.id.finish);
        expDate = (TextView) findViewById(R.id.exp) ;
        items = new ArrayList<>();
        itemAdp = new ItemAdapter(this,items);

        adp = new ArrayAdapter<Item>(this,
                android.R.layout.simple_spinner_dropdown_item, items);
        filesDir = new File(ChartActivity.this.getFilesDir(), "inventory.txt");
        updated = new File(ChartActivity.this.getFilesDir(), "uptodate.txt");
        try {
            fileOut = new FileOutputStream(filesDir, true);
            writer = new PrintWriter(fileOut);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //The file pointer "filesDir" was used but replaced
        try {
            //File myObj = new File("inventory.txt");
            //Load content of file into the items' array
            Scanner myReader = new Scanner(updated);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] split = data.split("\\s+");

                Item dummy = new Item(split[0],
                        Integer.parseInt(split[1]), split[2]);
                add(dummy);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


       /* try {
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
            String str = formatter.format(date);
            writer.println("Item Name\t" +
                    "Price\tQuantity\tExp.Date\n");
        } catch (Exception e) {
            e.printStackTrace();
        }*/

       //Item r = new Item("Juice", 1, "01/22");
      // items.add(r);

        /*for(int i = 0; i< 5; i++)
        {
            items.add(r);
            itemAdp.addItem(r);
        }*/



        setupListViewListener();

        //"Add item" button listener to insert an item in the list
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString() == null || name.getText().toString().length() == 0)
                    return;

                /*if(!name.getText().toString().isEmpty() && !price.getText().toString().isEmpty()
                        && !qty.getText().toString().isEmpty() && !expDate.getText().toString().isEmpty())
                {

                }*/
                else
                {
                    //The text fields content are grabbed, then later on parsed to their
                    //appropriate type
                    nameStr = name.getText().toString();
                    expStr = expDate.getText().toString();
                    if(expStr == null || expStr.length() == 0)
                        expStr = " ";
                    try
                    {
                        qtySTr = Integer.parseInt(qty.getText().toString());
                    }
                    catch (Exception e)
                    {
                        qtySTr = 0;
                    }

                   /* try
                    {
                        //priceStr = Double.parseDouble(price.getText().toString());
                    }
                    catch (Exception e)
                    {
                        //priceStr = 0;
                    }*/


                    Item item = new Item(nameStr, qtySTr, expStr);
                    String  q, ex;
                    nameStr = leftpad(nameStr, 15);
                    //p = ""+priceStr;
                    //p = leftpad(p, 15);
                    q = ""+qtySTr;
                    q = leftpad(q, 15);

                    ex = ""+expStr;
                    ex = leftpad(ex, 15);


                    info = nameStr+q+ex;
                            //""+ item.getName()+"\t"+item.getPrice()+"\t"+item.getQuantity()
                            //+"\t"+item.getExp();
                    try {
                        writer.println(info);

                        //FileUtils.writeStringToFile(filesDir, info);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    add(item);

                    name.setText("");
                    qty.setText("");
                    //price.setText("");
                    expDate.setText("");




                }

            }
        });

        //"finish shopping" button listener to take the user back to
        //the main page. Save current items in the list to .txt file
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                try{
                    writer.flush();
                    writer.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    String  nameUp, priceUp, qtyUp, expUp;
                    fileOutUp = new FileOutputStream(updated);
                    writerUp = new PrintWriter(fileOutUp);
                    for(int i = 0; i<items.size();i++)
                    {
                        nameUp = leftpad(items.get(i).getName(), 15);
                        //priceUp = leftpad(""+items.get(i).getPrice(), 15);
                        qtyUp = leftpad(""+items.get(i).getQuantity(), 15);
                        expUp = leftpad(items.get(i).getExp(), 15);
                        writerUp.println(nameUp+qtyUp+expUp);
                    }
                    writerUp.flush();
                    writerUp.close();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                finish();
            }
        });
    }


    //Long click listener for items present in the list
    //It allows removing or editing an item. Note the editing
    //functionality is still under construction
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
                        .setNeutralButton("Edit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //Under construction
                            }
                        })
                        .show();

                return true;

            }
        });
    }
    public void AddingItem(View view) {


    }
    //Function to insert an item in the adapter list
    public void add(Item ne) {

        itemAdp.addItem(ne);
        liv.setAdapter(itemAdp);
        adp.notifyDataSetChanged();

    }
    //Function used to format string representation of the items
    //for a good organization when written to file
    private String leftpad(String text, int length) {
        return String.format("%-" + length + "." + length + "s", text);
    }
    private void writeItems() {

    }

}