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

public class Main {

    public static void main(String[] args) {

        IPizzaCreator pizzaCreator = new StdinPizzaCreator();
        String pizzaDescription = pizzaCreator.Create();
        System.out.println(pizzaDescription);
    }
}