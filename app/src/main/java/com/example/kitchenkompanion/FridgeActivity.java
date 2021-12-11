package com.example.kitchenkompanion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Scanner;

public class FridgeActivity extends AppCompatActivity {

    static ListView inventoryView;
    static ArrayList<Item> items = new ArrayList<Item>();
    static InventoryAdapter itemsAdapter;
    ArrayAdapter<Item> adapter;

    static Context c;
    
    boolean displayFridge = true;

    EditText input;
    EditText quant;
    Button button;
    Button load;

    Button fridgeButton;
    Button all;
    Button cabinetButton;

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
        setContentView(R.layout.activity_fridge);

        getSupportActionBar().setTitle("Inventory");

        LinearLayout rl = (LinearLayout) findViewById(R.id.buttons);
        rl.bringToFront();

        inventoryView = findViewById(R.id.listview);

        input = findViewById(R.id.editTextTextPersonName);
        button = findViewById(R.id.button2);
        quant = findViewById(R.id.quant);
        load = findViewById(R.id.load);

        fridgeButton = findViewById(R.id.fridge);
        cabinetButton = findViewById(R.id.cabinet);
        all = findViewById(R.id.all);

        c = getApplicationContext();

        items = new ArrayList<Item>();

        Item milk = new Item("Milk", 3.69, 1, true, "11/15/2021");
        Item orange = new Item("Orange", 3, 6, false, "12/01/2021");
        Item notOrange = new Item("Apples", 3, 6, false, "12/01/2021");


        itemsAdapter = new InventoryAdapter(this, items);
        items.add(new Item());

        inventoryView.setAdapter(itemsAdapter);

        items.remove(0);

        itemsAdapter.addItem(orange);
        itemsAdapter.addItem(milk);

        /*for(int i = 0; i < 15; i++)
            itemsAdapter.addItem(notOrange); */

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String text = input.getText().toString();
                int quantity = 0;

                try {
                    quantity = Integer.parseInt(quant.getText().toString());
                } catch(NumberFormatException e) {

                    Toast.makeText(getApplicationContext(), "Enter a valid number",
                            Toast.LENGTH_LONG).show();

                    return;
                }

                if(text == null || text.length() == 0) {
                    return;
                } else {
                    addFood(text, quantity, getApplicationContext());
                    input.setText("");
                    quant.setText("");
                }
            }
        });

        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFromCart();
            }
        });
    }

    public static void addFood(String text, int quantity, Context c) {

        int daysToExpire = -1;
        boolean inFridge = false;

        if(lookup.get(text.toLowerCase()) != null) {
            daysToExpire = Integer.parseInt(lookup.get(text.toLowerCase()).getExp().split("\\s+")[0]);
            inFridge = lookup.get(text.toLowerCase()).isInFridge();
        }

        LocalDate date = LocalDate.now();
        date = date.plusDays(daysToExpire);

        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String expDate = date.format(format);

        if(daysToExpire == -1) {
            Toast.makeText(c, "We do not have expiration and fridge data on the given food item, so it is placed in the cabinet", Toast.LENGTH_LONG).show();
            expDate = "N/A";
        }

        itemsAdapter.addItem(new Item(text, 1, quantity, inFridge, expDate));
        inventoryView.setAdapter(itemsAdapter);

    }

    public static void removeFood(int toRemove) {
        itemsAdapter.removeItem(toRemove);
        inventoryView.setAdapter(itemsAdapter);
    }

    private static void loadFromCart() {

        try {
            File file = new File(c.getFilesDir(), "inventory.txt");
            //Load content of file into the items' array
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] split = data.split("\\s+");// \\s+
                Item temp;

                try {
                    temp = new Item(split[0],
                            Integer.parseInt(split[1]));//, split[2]);
                }catch (Exception e)
                {
                    temp = new Item(split[0],
                            1, " ");
                }
                addFood(temp.getName(), temp.getQuantity(), inventoryView.getContext());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void onAddItem(View view) {

    }

    public void filterItems(boolean fridge) {

        ArrayList<Item> filtered = new ArrayList<Item>();

        for(Item item : items) {

            if(item.isInFridge() == fridge) {
                filtered.add(item);
            }

        }

        InventoryAdapter filteredAdapter = new InventoryAdapter(this, filtered);
        inventoryView.setAdapter(filteredAdapter);

    }

    public void filterAll(View view) {

        cabinetButton.setBackgroundColor(0x003300);
        fridgeButton.setBackgroundColor(0x003300);
        all.setBackgroundColor(0x33622F);

        InventoryAdapter adapter = new InventoryAdapter(this, items);
        inventoryView.setAdapter(adapter);

    }

    public void filterFridge(View view) {

        cabinetButton.setBackgroundColor(0x003300);
        fridgeButton.setBackgroundColor(0x33622F);
        all.setBackgroundColor(0x003300);
        filterItems(true);

    }

    public void filterCabinet(View view) {
        cabinetButton.setBackgroundColor(0x33622F);
        fridgeButton.setBackgroundColor(0x003300);
        all.setBackgroundColor(0x003300);

        filterItems(false);
    }

    public void writeToFile(View view) {
        try{
            File filesDir = new File(FridgeActivity.this.getFilesDir(), "current_inventory.txt");
            FileOutputStream fileOut = new FileOutputStream(filesDir,true);
            PrintWriter writer = new PrintWriter(fileOut);
            for(Item i : items) {
                writer.println(i.toString());
            }
            writer.close();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}