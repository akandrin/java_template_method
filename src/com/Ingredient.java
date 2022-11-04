package com;

public abstract class Ingredient {
    private final float weight; // масса ингредингта

    // Конструктор
    public Ingredient(float weight)
    {
        this.weight = weight;
    }

    public float GetWeight()
    {
        return weight;
    }

    public abstract void Accept(IIngredientVisitor visitor);
}
