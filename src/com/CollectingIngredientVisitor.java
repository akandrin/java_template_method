package com;

public class CollectingIngredientVisitor implements IIngredientVisitor {

    private String ingredients = "";

    private String GetCommonData(Ingredient ingredient)
    {
        return "ingredient: %s; weight = " + ingredient.GetWeight() + "\n";
    }

    @Override
    public void Visit(Cheese cheese)
    {
        ingredients += String.format(GetCommonData(cheese), "cheese");
    }

    @Override
    public void Visit(Chicken chicken)
    {
        ingredients += String.format(GetCommonData(chicken), "chicken");
    }

    public String GetIngredients()
    {
        return ingredients;
    }
}
