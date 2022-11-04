package com;

/*
 Ваша задача написать программу для пиццерии.
 Пиццерия  выпекает всяческие виды пиццы с различными ингредиентами.
 Исходя из различных параметров (открытая, закрытая пицца), ингредиенты, острая или нет, использования различных
  ингредиентов, получить для заказа соответствующий тип продукта.
 Выходной тип продукта будет определяться выбором ингредиентов.
 Шаблоны метода по умолчанию будет делать например пиццу Маргариту.
 Типы ингредиентов и способы приготовления будет определяться выбранной реализацией продукта,
  для этого следует использовать хуки.
*/

import java.util.List;

// Класс генерирует текстовые описания пицц.
public abstract class IPizzaCreator
{
    // Является ли пицца открытой.
    protected abstract boolean GetIsPizzaOpened();
    // Является ли пицца острой.
    protected abstract boolean GetPizzaIsSpicy();
    // Получить ингредиенты.
    protected abstract List<Ingredient> GetIngredients();

    // Получить название пиццы (хук).
    protected String GetPizzaName()
    {
        return "Margarita";
    }

    protected enum CookingMethod
    {
        Oven, // в духовке
        Pan, // на сковороде
        Steam, // на пару
        Raw, // сырая
    }

    protected CookingMethod GetCookingMethod()
    {
        return CookingMethod.Oven;
    }


    // Создать пиццу (шаблонный метод).
    public String Create()
    {
        boolean isPizzaOpened = GetIsPizzaOpened();
        boolean isPizzaSpicy = GetPizzaIsSpicy();
        List<Ingredient> ingredientsList = GetIngredients();
        CookingMethod cookingMethod = GetCookingMethod();
        CollectingIngredientVisitor visitor = new CollectingIngredientVisitor();
        for (Ingredient ingredient : ingredientsList)
        {
            ingredient.Accept(visitor);
        }

        String ingredients = visitor.GetIngredients();

        String result = "";
        result += "Pizza: " + GetPizzaName() + "\n";
        result += (isPizzaOpened ? "opened" : "closed") + " ";
        result += (isPizzaSpicy ? "spicy" : "not spicy") + "\n";
        result += "Cooking method: ";
        switch (cookingMethod)
        {
            case Oven -> {
                result += "Oven";
            }
            case Pan -> {
                result += "Pan";
            }
            case Steam -> {
                result += "Steam";
            }
            case Raw -> {
                result += "Raw";
            }
        }
        result += "\n";
        result += "Ingredients:\n" + ingredients;

        return result;
    }
}
