package com.example.kitchenkompanion;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class RecipeMainActivity extends AppCompatActivity {

    RecyclerView myrecyclerView;
    RecyclerViewAdapter myAdapter;

    List<Recipes> recipes1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_main_page);

        recipes1 = new ArrayList<>();

        String[] steakIng = {"potatoes", "cheese", "salt", "olive oil", "black pepper", "beef"};
        recipes1.add(new Recipes("3 Ingredient Steak with Potatoes", "\n" +
                "2 pounds small new potatoes\n" +
                "Salt\n" +
                "1/2 cup olive oil, divided\n" +
                "3/4 cup grated Parmesan\n" +
                "1 (1 1/2-pound) hanger steak\n" +
                "Freshly ground black pepper", "Instructions", "Step 1\n" +
                "Place potatoes in a medium pot; add cold water to cover by 1\". Season with salt, bring to a boil, and cook until potatoes are fork-tender, 12–15 minutes. Transfer to a rimmed baking sheet; let cool slightly, then lightly crush with your palm.\n" +
                "\n" +
                "Step 2\n" +
                "Heat 3 Tbsp. oil in a large heavy skillet over medium-high. Reduce heat to medium-low and add half of the potatoes; season with 3/4 tsp. salt. Cook, turning once, until golden brown, 15–20 minutes. Transfer potatoes to a plate. Add 3 Tbsp. oil, 3/4 tsp. salt, and remaining potatoes to pan; cook, turning once, until golden brown, 15–20 minutes. Return all potatoes to pan, sprinkle with cheese, and cook, tossing to coat, until cheese begins to crisp, 1–2 more minutes.\n" +
                "\n" +
                "Step 3\n" +
                "Meanwhile, heat remaining 2 Tbsp. oil in a large skillet over medium-high. Season steak with salt and pepper and cook, turning occasionally, until deep brown and an instant-read thermometer registers 125°F for medium-rare, about 3 minutes per side.\n" +
                "\n" +
                "Step 4\n" +
                "Transfer steak to a cutting board. Thinly slice steak against the grain and serve with potatoes alongside.", R.drawable.steakpotatoes, "meat"));


        String[] macIng = {"pasta", "cheese", "milk"};
        recipes1.add(new Recipes("3 ingredient Mac & Cheese", "5 cups milk\n" +
                "1 lb elbow macaroni, dry\n" +
                "2 cups shredded cheddar cheese", "Steps", "1. In a large pot, bring the milk to a boil.\n" +
                "2. Add the pasta and stir constantly until the pasta is cooked, about 10 minutes.\n" +
                "3. Turn off the heat, then add the cheddar. Stir until the cheese is melted and the pasta is evenly coated.\n" +
                "4. Enjoy!\n", R.drawable.macandcheese, "vegetarian"));

        String[]  chiliIng = {"beans", "salsa", "vegan crumbles"};
        recipes1.add(new Recipes("3 Ingredient Chili", "15.5 ounce can pinto beans\n" +
                "2 cups spicy salsa or your favorite salsa\n" +
                "1 ½ cups vegan crumbles - i.e. Beyond Meat Beefy Crumbles", "Steps", "Bring pinto beans, salsa, vegan crumbles, and water to a boil. Simmer for 8 minutes. If mixture becomes too think, add more water.", R.drawable.chili, "vegan"));

        recipes1.add(new Recipes("Chicken Roll", "200 gm chopped into cubes chicken" +
                "1 medium chopped tomato" +
                "1/2 pinch red chilli powder" +
                "2 tablespoon vegetable oil" +
                "1/2 cut into strips cucumber" +
                "1/2 tablespoon chopped coriander leaves" +
                "1 large thinly sliced onion" +
                "2 medium chopped green chilli" +
                "2 pinches garam masala powder" +
                "1 lemon wedges" +
                "1 teaspoon tomato ketchup" +
                "1 tablespoon green chilli sauce", "Method",
                "Chicken Roll is a delectable North Indian recipe made using all purpose flour, stir-fried chicken, yoghurt and a variety of vegetables rolled into paranthas. On days you do not want to prepare an elaborate meal, this delectable dish can be a saviour. Rolls are quite popular across India and they are often a favourite evening snack. Egg Roll, Kathi Kebab Roll, Mutton Roll, Paneer Roll, Potato Roll and even Fish Roll are among its many variations. This easy roll recipe is made using chicken and has the unforgettable aroma of Indian spices. You can also utilize your leftover parathas and chapatis in making this recipe. If you do not like to use all-purpose flour or maida, you can make it with whole wheat flour too. In fact, it can be made even with leftover chicken. All you have to ensure is that you use the right amount of spices so that the flavour is not lost. Easy to pack and carry, you can also take it to office or prepare it for picnics and day trips. A must try roll recipe for all chicken lovers!\n", R.drawable.chicken_roll, "meat"));

        recipes1.add(new Recipes("Donut", "1 c. whole milk" +
                "1/4 c. plus 1 tsp. granulated sugar, divided" +
                "1 packet (or 2 1/4 tsp.) active dry yeast " +
                "4 c. all-purpose flour, plus more if needed" +
                "1/2 tsp. kosher salt" +
                "6 tbsp. melted butter" +
                "2 large eggs" +
                "1/2 tsp. pure vanilla extract" +
                "Canola or vegetable oil, for frying", "Method", "\n" +
                "Grease a large bowl with cooking spray and set aside. In a small, microwave-safe bowl or glass measuring cup, add milk. Microwave until lukewarm, 40 seconds. Add a teaspoon of sugar and stir to dissolve, then sprinkle over yeast and let sit until frothy, about 8 minutes.\n" +
                "Make glaze: In a large bowl, whisk together milk, powdered sugar, and vanilla until smooth. Set aside.\n" +
                "Line a large baking sheet with paper towels. In a large dutch oven over medium heat, heat 2'' oil to 350°. Cook doughnuts, in batches, until deeply golden on both sides, about 1 minute per side. Holes will cook even faster!\n" +
                "Transfer doughnuts to paper towel-lined baking sheet to drain and cool slightly. Dip into glaze, then place onto a cooling rack (or eat immediately!)", R.drawable.donut1, "vegetarian"));


        recipes1.add(new Recipes("Pancake", "1 1/4 cups milk" +
                "1 egg" +
                "3 tablespoons butter melted" +
                "1 1/2 cups all-purpose flour" +
                "3 1/2 teaspoons baking powder" +
                "1 teaspoon salt" +
                "1 tablespoon white sugar", "Method",
                "In a large bowl, sift together the flour, baking powder, salt and sugar. Make a well in the center and pour in the milk, egg and melted butter; mix until smooth." +
                        "Heat a lightly oiled griddle or frying pan over medium high heat. Pour or scoop the batter onto the griddle, using approximately 1/4 cup for each pancake. Brown on both sides and serve hot.", R.drawable.pancakes, "vegetarian"));

        recipes1.add(new Recipes("Pasta", "1 tsp oil" +
                "1 tsp butter" +
                "2 clove garlic, finely chopped" +
                "1 inch ginger, finely chopped" +
                "½ onion, finely chopped" +
                "1 cup tomato pulp" +
                "¼ tsp turmeric / haldi" +
                "½ tsp kashmiri red chilli powder" +
                "2 tbsp tomato sauce" +
                "½ tsp garam masala", "Method",
                "firstly, saute 1 inch ginger and 2 clove garlic in 1 tsp oil and 1 tsp butter." +
                        "further saute ½ onion till they turn soft." +
                        "additionally add 1 cup tomato pulp and saute well." +
                        "keep stirring till the tomato pulp thickens." +
                        "now add ¼ tsp turmeric, ½ tsp chilli powder, ½ tsp garam masala and ½ tsp salt." +
                        "saute till the spices gets cooked completely." +
                        "now add 2 tbsp corn, ¼ capsicum, ¼ carrot, 2 tbsp peas and 7 florets broccoli. saute for a minute." +
                        "add in 3 tbsp water and mix well." +
                        "cover and simmer for 5 minutes." +
                        "now add in 2 tbsp tomato sauce and ½ tsp mixed herbs. mix well." +
                        "add in cooked pasta and mix gently till the sauce gets coated well." +
                        "finally, serve masala pasta indian style hot topped with cheese if required.", R.drawable.pasta1, "vegetarian"));

        myrecyclerView = (RecyclerView) findViewById(R.id.recyclerView_id);

        myAdapter = new RecyclerViewAdapter(this, recipes1);

        myrecyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        myrecyclerView.setAdapter(myAdapter);

    }

    public void filterItems(String status) {

        ArrayList<Recipes> filtered = new ArrayList<Recipes>();

        for(Recipes r : recipes1) {

            if(r.getCategory().toLowerCase().contains(status)) {
                filtered.add(r);
            }

        }

        myrecyclerView = (RecyclerView) findViewById(R.id.recyclerView_id);

        myAdapter = new RecyclerViewAdapter(this, filtered);

        myrecyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        myrecyclerView.setAdapter(myAdapter);

    }

    public void filterAll(View view) {

        myrecyclerView = (RecyclerView) findViewById(R.id.recyclerView_id);

        myAdapter = new RecyclerViewAdapter(this, recipes1);

        myrecyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        myrecyclerView.setAdapter(myAdapter);

    }

    public void filterVegan(View view) {
        filterItems("vegan");
    }

    public void filterMeat(View view) {
        filterItems("meat");
    }

    public void filterAllergyFree(View view) {
        filterItems("allergy free");
    }

    public void filterVegetarian(View view) {
        filterItems("vegetarian");
    }
}
