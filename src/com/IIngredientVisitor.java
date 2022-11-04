package com;

public interface IIngredientVisitor {
    public abstract void Visit(Cheese cheese);

    public abstract void Visit(Chicken chicken);
}
