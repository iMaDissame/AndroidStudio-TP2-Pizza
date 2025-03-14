package com.example.tp2list;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tp2list.adapter.PizzaAdapter;
import com.example.tp2list.entities.Pizza;
import com.example.tp2list.service.ProduitService;

import java.util.List;

public class ListPizzaActivity extends AppCompatActivity {

    private ListView listView;
    private ProduitService pizzaService;
    private List<Pizza> pizzas;
    private ImageView shareButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pizza);

        listView = findViewById(R.id.liste);
        shareButton = findViewById(R.id.shareButton);

        pizzaService = ProduitService.getInstance();

        if (pizzaService.findAll().isEmpty()) {
            loadPizzaData();
        }

        pizzas = pizzaService.findAll();

        PizzaAdapter adapter = new PizzaAdapter(this, pizzas);
        listView.setAdapter(adapter);

        shareButton.setOnClickListener(v -> {
        });
    }

    // Additional pizzas to load into the database
    private void loadPizzaData() {
        // Existing pizza entries are kept as is
        pizzaService.create(new Pizza("BARBECUED CHICKEN PIZZA", 3, R.mipmap.pizza1, "35 min",
                "- 2 boneless skinless chicken breast halves (6 ounces each)\n- 1/4 teaspoon pepper\n- 1 cup barbecue sauce, divided\n- 1 tube (13.8 ounces) refrigerated pizza crust\n- 2 teaspoons olive oil\n-2 cups shredded Gouda cheese\n-1 small red onion, halved and thinly sliced\n-1/4 cup minced fresh cilantro",
                "So fast and so easy with refrigerated pizza crust, these saucy, smoky pizzas make quick fans with their hot-off-the-grill, rustic flavor. They're perfect for spur-of-the-moment cookouts and summer dinners on the patio. —Alicia Trevithick, Temecula, California",
                "STEP 1:\n\n Sprinkle chicken with pepper; place on an oiled grill rack over medium heat. Grill, covered, until a thermometer reads 165°, 5-7 minutes per side, basting frequently with 1/2 cup barbecue sauce during the last 4 minutes. Cool slightly. Cut into cubes.\n\nSTEP 2:\n\n Divide dough in half. On a well-greased large sheet of heavy-duty foil, press each portion of dough into a 10x8-in. rectangle; brush lightly with oil. Invert dough onto grill rack; peel off foil. Grill, covered, over medium heat until bottom is lightly browned, 1-2 minutes.\n\nSTEP 3:\n\n Remove from grill. Spread grilled sides with remaining barbecue sauce. Top with cheese, chicken and onion. Grill, covered, until bottom is lightly browned and cheese is melted, 2-3 minutes. Sprinkle with cilantro. Yield: 2 pizzas (4 pieces each).",
                4));

        pizzaService.create(new Pizza("BRUSCHETTA PIZZA", 5, R.mipmap.pizza2, "35 min",
                "-1/2 pound reduced-fat bulk pork sausage\n- 1 prebaked 12-inch pizza crust\n- 1 package (6 ounces) sliced turkey pepperoni\n- 2 cups shredded part-skim mozzarella cheese\n- 1-1/2 cups chopped plum tomatoes\n- 1/2 cup fresh basil leaves, thinly sliced\n- 1 tablespoon olive oil\n- 2 garlic cloves, minced\n- 1/2 teaspoon minced fresh thyme or 1/8 teaspoon dried thyme\n- 1/2 teaspoon balsamic vinegar\n- 1/4 teaspoon salt\n- 1/8 teaspoon pepper\n- Additional fresh basil leaves, optional",
                "You might need a knife and fork for this hearty pizza! Loaded with Italian flavor and plenty of fresh tomatoes, it's bound to become a family favorite. It's even better with a homemade, whole wheat crust! —Debra Kell, Owasso, Oklahoma",
                "STEP 1:\n\n In a small skillet, cook sausage over medium heat until no longer pink; drain. Place crust on an ungreased baking sheet. Top with pepperoni, sausage and cheese. Bake at 450° for 10-12 minutes or until cheese is melted.\n\nSTEP 2:\n\n In a small bowl, combine the tomatoes, sliced basil, oil, garlic, thyme, vinegar, salt and pepper. Spoon over pizza. Garnish with additional basil if desired. Yield: 8 slices.",
                8));

        // New pizza entries
        pizzaService.create(new Pizza("MARGHERITA PIZZA", 2, R.mipmap.pizza3, "25 min",
                "- 4 large tomatoes, sliced\n- 1 pound fresh mozzarella, sliced\n- 1/2 cup fresh basil leaves\n- Drizzle of olive oil\n- Salt and pepper to taste\n- Pizza dough",
                "This classic pizza is all about simplicity and fresh ingredients. A drizzle of olive oil and a sprinkle of fresh basil complete this popular choice.",
                "STEP 1: Prepare the pizza dough and spread it onto a pizza stone or baking sheet. \nSTEP 2: Arrange slices of mozzarella and tomatoes over the dough. Season with salt and pepper. \nSTEP 3: Bake in a preheated oven at 475°F for about 10-12 minutes or until the crust is golden and cheese is bubbly. \nSTEP 4: Once out of the oven, add fresh basil leaves and a drizzle of olive oil before serving.",
                4));

        pizzaService.create(new Pizza("PEPPERONI PIZZA", 4, R.mipmap.pizza4, "30 min",
                "- 1/2 pound pepperoni slices\n- 2 cups shredded mozzarella cheese\n- 1 cup pizza sauce\n- Pizza dough",
                "A favorite among many, this pizza is layered with spicy pepperoni and lots of mozzarella cheese on a classic red sauce base.",
                "STEP 1: Roll out your pizza dough on a flat surface. \nSTEP 2: Spread pizza sauce evenly over the dough. \nSTEP 3: Sprinkle shredded mozzarella cheese and then layer pepperoni slices on top. \nSTEP 4: Bake at 475°F for about 12-15 minutes or until the edges are crispy and cheese is melted and slightly browned.",
                6));
        pizzaService.create(new Pizza("HAWAIIAN PIZZA", 3, R.mipmap.pizza5, "30 min",
                "- 1 cup pineapple chunks\n- 1/2 pound ham, sliced\n- 2 cups shredded mozzarella cheese\n- 1 cup pizza sauce\n- Pizza dough",
                "The controversial yet popular pizza with a tropical twist features sweet pineapple paired with ham on a classic cheese and tomato base.",
                "STEP 1: Roll out the pizza dough and apply a thin layer of pizza sauce. \nSTEP 2: Sprinkle with mozzarella cheese. \nSTEP 3: Evenly distribute ham slices and pineapple chunks over the top. \nSTEP 4: Bake at 475°F for 12-15 minutes until the crust is golden and cheese is bubbly.",
                5));

        pizzaService.create(new Pizza("VEGAN PIZZA", 4, R.mipmap.pizza6, "40 min",
                "- 2 cups vegan cheese (shredded)\n- 1 cup tomato sauce\n- 1/2 cup sliced bell peppers\n- 1/2 cup sliced mushrooms\n- 1/4 cup red onions\n- 1/4 cup black olives\n- Pizza dough",
                "A delightful treat for vegans, loaded with colorful vegetables and topped with a delicious dairy-free cheese.",
                "STEP 1: Prepare the pizza dough and preheat the oven to 475°F. \nSTEP 2: Spread tomato sauce over the dough. \nSTEP 3: Add vegan cheese and arrange all the vegetables on top. \nSTEP 4: Bake for 15-20 minutes or until the edges are crispy and toppings are cooked.",
                6));

        pizzaService.create(new Pizza("SEAFOOD PIZZA", 2, R.mipmap.pizza7, "45 min",
                "- 1/2 cup tomato sauce\n- 1 cup mozzarella cheese\n- 1/2 cup cooked shrimp\n- 1/2 cup crabmeat\n- 1/4 cup sliced red onions\n- 2 tablespoons capers\n- Pizza dough",
                "This pizza offers a luxurious taste of the sea with shrimp and crabmeat, complemented by the tanginess of capers.",
                "STEP 1: Spread tomato sauce on prepared dough. \nSTEP 2: Add a layer of mozzarella cheese. \nSTEP 3: Top with seafood and onions. \nSTEP 4: Sprinkle capers over everything. \nSTEP 5: Bake at 475°F for about 15 minutes.",
                4));

        pizzaService.create(new Pizza("BUFFALO CHICKEN PIZZA", 4, R.mipmap.pizza8, "30 min",
                "- 1/2 pound cooked chicken breast, shredded\n- 1/4 cup buffalo sauce\n- 1 cup mozzarella cheese\n- 1/2 cup blue cheese crumbles\n- 1/4 cup chopped celery\n- 1/4 cup ranch dressing\n- Pizza dough",
                "Spicy and tangy, this pizza is topped with buffalo chicken and a blend of mozzarella and blue cheese, perfect for those who enjoy a little heat.",
                "STEP 1: Combine shredded chicken with buffalo sauce. \nSTEP 2: Spread ranch dressing as the base on the dough. \nSTEP 3: Top with mozzarella, buffalo chicken, and blue cheese. \nSTEP 4: Bake at 475°F for 12-15 minutes. \nSTEP 5: Garnish with chopped celery before serving.",
                5));

        pizzaService.create(new Pizza("GLUTEN-FREE MUSHROOM PIZZA", 4, R.mipmap.pizza9, "35 min",
                "- 1 gluten-free pizza base\n- 1 cup cremini mushrooms, sliced\n- 1 cup mozzarella cheese\n- 2 cloves garlic, minced\n- 1/2 cup ricotta cheese\n- Fresh thyme leaves\n- Olive oil",
                "Ideal for those avoiding gluten, this pizza doesn't compromise on taste with its rich toppings of mushrooms, garlic, and thyme.",
                "STEP 1: Brush the gluten-free base with olive oil and sprinkle minced garlic over it. \nSTEP 2: Add a layer of mozzarella and dot with ricotta cheese. \nSTEP 3: Arrange mushroom slices and sprinkle thyme leaves. \nSTEP 4: Bake at 450°F for 15-18 minutes.",
                3));

        pizzaService.create(new Pizza("SPINACH AND ARTICHOKE PIZZA", 3, R.mipmap.pizza10, "30 min",
                "- 1/2 cup cream cheese, softened\n- 1/4 cup mayonnaise\n- 1/4 cup grated Parmesan cheese\n- 1/2 cup cooked spinach, squeezed dry\n- 1/2 cup artichoke hearts, chopped\n- 1 cup mozzarella cheese\n- Pizza dough",
                "A creamy and delicious spin on the classic dip, this pizza is a perfect blend of spinach, artichoke, and cheeses.",
                "STEP 1: Mix cream cheese, mayonnaise, and Parmesan as the base spread. \nSTEP 2: Spread it evenly over the pizza dough. \nSTEP 3: Top with mozzarella, spinach, and artichokes. \nSTEP 4: Bake at 475°F for 12-15 minutes until golden and bubbly.",
                5));

    }

}