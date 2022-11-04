package com;

class Cheese extends Ingredient
{
    public Cheese(float weight)
    {
        super(weight);
    }

    @Override
    public void Accept(IIngredientVisitor visitor) {
        visitor.Visit(this);
    }
}

class Chicken extends Ingredient
{
    public Chicken(float weight)
    {
        super(weight);
    }

    @Override
    public void Accept(IIngredientVisitor visitor) {
        visitor.Visit(this);
    }
}

public class IngredientFactory {

    enum IngredientType
    {
        cheese,
        chicken,
    }

    public Ingredient GetIngredient(IngredientType ingredientType, float weight)
    {
        if (weight <= 0)
            return null;
        
        switch (ingredientType) {
            case cheese -> {
                return new Cheese(weight);
            }
            case chicken -> {
                return new Chicken(weight);
            }
        }
        return null;
    }
}
