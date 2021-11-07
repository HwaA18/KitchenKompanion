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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;


public class ChartActivity extends Activity {

    Hashtable<String, Item> lookup = new Hashtable<>();



    ListView liv;
    Button btn ;
    Button end ;
    TextView name;
    TextView price;
    TextView expDate;
    TextView qty;
    ArrayList<Item> items;
    ArrayAdapter<Item> adp ;
    ItemAdapter itemAdp;
    String nameStr, expStr;
    String info = "";
    int qtySTr;
    double priceStr;
    File filesDir, updated;
    FileOutputStream fileOut, fileOutUp;
    PrintWriter writer, writerUp;




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
        lookup.put("honey", new Item("Honey", 9.10,1, false, "None"));
        lookup.put("olive oil", new Item("Olive oil", 7.12,1, false, "600 days"));
        lookup.put("pasta", new Item("Pasta", 1.31,1, false, "365 days"));
        lookup.put("rice", new Item("Rice", 12.32,1, false, "1200 days"));
        lookup.put("vinegar", new Item("Vinegar", 2.86,1, false, "None"));
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
        lookup.put("salt", new Item("Salt", 1.08, 1, false, "None"));
        lookup.put("vanilla extract", new Item("Vanilla extract", 20,1, false, "1800 days"));
        lookup.put("butter", new Item("Butter", 2.18, 1, true, "14 days"));
        lookup.put("yogurt", new Item("Yogurt", 2.33,1, true, "7 days"));
        lookup.put("cheese", new Item("Cheese", 1.77, 1, true, "30 days"));
        lookup.put("bacon", new Item("Bacon", 5.76, 1, true, "7 days"));
        lookup.put("beef", new Item("Beef", 5.67,1, true, "3 days"));
        lookup.put("turkey", new Item("Turkey", 1.39, 1, true, ""));
        lookup.put("chicken", new Item("Chicken", 1.65,1, true, "2 days"));
        lookup.put("ham", new Item("Ham", 3.50, 1, true, "7 days"));
        lookup.put("fish", new Item("Fish", 9.99,1, true, "2 days"));
        lookup.put("crab", new Item("Crab", 19.99,1, true, "2 days"));
        lookup.put("lobster", new Item("Lobster", 5.99,1, true, "2 months"));
        lookup.put("shrimp", new Item("Shrimp", 15.99,1, true, "2 days"));
        lookup.put("sugar", new Item("Sugar", 2.59, 1, false, "720 days"));
        lookup.put("flour", new Item("Flour", 2.50,1, false, "120 days"));
        lookup.put("yeast", new Item("Yeast", 1.25,1, false, "60 days"));
        lookup.put("bread", new Item("Bread", 2.50,1, false, "6 days"));





        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);



        liv =  findViewById(R.id.lv);
        btn = (Button) findViewById(R.id.button);
        name = (TextView) findViewById(R.id.editTextTextPersonName3);
        price = (TextView) findViewById(R.id.editTextTextPersonName);
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


        try {
            //File myObj = new File("inventory.txt");
            Scanner myReader = new Scanner(filesDir);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] split = data.split("\\s+");

                Item dummy = new Item(split[0],Double.parseDouble(split[1]),
                        Integer.parseInt(split[2]), split[3]);
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

       Item r = new Item("jello", 30, 2, "02/22");
       items.add(r);

        /*for(int i = 0; i< 5; i++)
        {
            items.add(r);
            itemAdp.addItem(r);
        }*/



        setupListViewListener();


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
                    nameStr = name.getText().toString().toLowerCase();
                    expStr = expDate.getText().toString();
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

                    Item item = new Item(nameStr, priceStr, qtySTr, expStr);
                    String p, q, ex;
                    nameStr = leftpad(nameStr, 15);
                    p = ""+priceStr;
                    p = leftpad(p, 15);
                    q = ""+qtySTr;
                    q = leftpad(q, 15);

                    ex = ""+expStr;
                    ex = leftpad(ex, 15);


                    info = nameStr+p+q+ex;
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
                    price.setText("");
                    expDate.setText("");


                }

            }
        });

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
                        priceUp = leftpad(""+items.get(i).getPrice(), 15);
                        qtyUp = leftpad(""+items.get(i).getQuantity(), 15);
                        expUp = leftpad(items.get(i).getExp(), 15);
                        writerUp.println(nameUp+priceUp+qtyUp+expUp);
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
    public void add(Item ne) {

        itemAdp.addItem(ne);
        liv.setAdapter(itemAdp);
        adp.notifyDataSetChanged();

    }

    private String leftpad(String text, int length) {
        return String.format("%-" + length + "." + length + "s", text);
    }
    private void writeItems() {


    }



}