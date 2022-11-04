package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class StdinPizzaCreator extends IPizzaCreator {

    @Override
    protected boolean GetIsPizzaOpened() {
        System.out.println("Is pizza opened? Enter y/n: ");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().toLowerCase();
        return s.charAt(0) == 'y';
    }

    @Override
    protected boolean GetPizzaIsSpicy() {
        System.out.println("Is pizza spicy? Enter y/n: ");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().toLowerCase();
        return s.charAt(0) == 'y';
    }

    @Override
    protected List<Ingredient> GetIngredients() {
        System.out.println("Enter ingredients\n");
        Scanner scanner = new Scanner(System.in);

        IngredientFactory ingredientFactory = new IngredientFactory();
        Ingredient ingredient;
        List<Ingredient> ingredients = new ArrayList<Ingredient>();

        System.out.println("Enter cheese weight (enter 0 if cheese is not required) :");
        ingredient = ingredientFactory.GetIngredient(IngredientFactory.IngredientType.cheese, scanner.nextFloat());
        if (ingredient != null)
        {
            ingredients.add(ingredient);
        }

        System.out.println("Enter chicken weight (enter 0 if chicken is not required) :");
        ingredient = ingredientFactory.GetIngredient(IngredientFactory.IngredientType.chicken, scanner.nextFloat());
        if (ingredient != null)
        {
            ingredients.add(ingredient);
        }

        return ingredients;
    }

    // переопределям один из хуков.
    @Override
    public CookingMethod GetCookingMethod()
    {
        return CookingMethod.Pan;
    }
}
