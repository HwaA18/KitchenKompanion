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

        recipes1.add(new Recipes("Spiced Chicken", "\n" +
                "    8 boneless skinless chicken thighs\n" +
                "    2 teaspoons chili powder\n" +
                "    2 teaspoons smoked paprika\n" +
                "    2 teaspoons garlic powder\n" +
                "    1 teaspoon cumin\n" +
                "    1 teaspoon kosher salt\n" +
                "    1 teaspoon fresh cracked pepper\n" +
                "    1 teaspoon red pepper flakes\n" +
                "    1/2 teaspoon dried oregano\n" +
                "    1/2 cup honey\n" +
                "    2 tablespoons apple cider vinegar\n", "Instructions", "    Un-tuck chicken thighs so they are flat.\n" +
                "    In a small bowl mix together chili powder, smoked paprika, garlic powder, cumin, kosher salt, black pepper, red pepper flakes, and dried oregano.\n" +
                "    Cover both sides in seasoning, set flat onto a sheet pan.\n" +
                "    On your oven, set your broiler to low heat and move the rack near the top of the oven.\n" +
                "    Add the chicken to the oven and cook for 5-7 minutes and flip the chicken.\n" +
                "    Cook for 5-7 minutes on the other side.\n" +
                "    Remove chicken from the oven, flip, and baste the chicken in honey apple cider vinegar mixture.\n" +
                "    Add chicken back to the oven and let it cook under the broiler for a few minutes until the honey starts to thicken up and glaze. It may smoke a little but this is completely normal.\n" +
                "    Take chicken out of the oven and let rest for a few minutes before serving.\n" +
                "    * If you have a gas oven and your broiler is at the bottom you can bake the chicken at 400 degrees for about 15 - 20 mins.", R.drawable.spiced_chicken, "meat"));

        recipes1.add(new Recipes("Carrot Soup", "    1 tbsp vegetable oil\n" +
                "    1 onion, chopped\n" +
                "    1 tsp ground coriander\n" +
                "    1 potato, chopped\n" +
                "    450g carrots, peeled and chopped\n" +
                "    handful coriander (about ½ a supermarket packet)", "Instructions", "    STEP 1\n" +
                "\n" +
                "    Heat 1 tbsp vegetable oil in a large pan, add 1 chopped onion, then fry for 5 mins until softened.\n" +
                "    STEP 2\n" +
                "\n" +
                "    Stir in 1 tsp ground coriander and 1 chopped potato, then cook for 1 min.\n" +
                "    STEP 3\n" +
                "\n" +
                "    Add the 450g peeled and chopped carrots and 1.2l vegetable or chicken stock, bring to the boil, then reduce the heat.\n" +
                "    STEP 4\n" +
                "\n" +
                "    Cover and cook for 20 mins until the carrots are tender.\n" +
                "    STEP 5\n" +
                "\n" +
                "    Tip into a food processor with a handful of coriander then blitz until smooth (you may need to do this in two batches). Return to pan, taste, add salt if necessary, then reheat to serve.", R.drawable.soup, "vegan"));
        recipes1.add(new Recipes("Onion Stuffing Balls", "    2 tablespoons olive or rapeseed oil plus extra for greasing\n" +
                "    1 red onion\n" +
                "    3 teaspoons dried sage\n" +
                "    2 teaspoons dried mixed herbs\n" +
                "    500 g plain pork sausage meat ensure gluten, egg, nut and dairy free, as necessary", "Instructions","    Preheat your oven to 220C / 200C / gas mark 7 / 425F and grease an oven tray enough to hold all the stuffing balls.\n" +
                "    Drizzle about 2 tablespoons of olive oil into a saucepan. Add the diced onion and put the lid on. Cook over a low heat for about 5 minutes, stirring occasionally, until the onion is soft but not brown.\n" +
                "    When the onions are ready, tip into a bowl and add the sausage meat, herbs, salt and pepper and stir thoroughly.\n" +
                "    Divide the mixture into 12 and shape into balls. Place in your greased tin(s) and cook for 20-25 minutes or until they are golden brown and cooked through.", R.drawable.balls, "allergy free" ));
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
