package com.rampatra.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author rampatra
 * @version 17/02/2017
 */
public class FlatMapInStreams {

    public static long countTotalIngredientsInAllDishes(List<Dish> dishes) {
        return dishes.stream()
                .map(Dish::getIngredients)
                .flatMap(List::stream)
                .count();
    }

    public static void main(String[] args) {
        List<String> ingredients = new ArrayList<>();
        ingredients.add("rice");
        ingredients.add("chicken");
        ingredients.add("haldi");
        List<Dish> dishes = Arrays.asList(
                new Dish("biriyani", 600, ingredients),
                new Dish("pulao", 600, new ArrayList<>()));
        // to show whether empty List is counted in flatMap
        System.out.println(countTotalIngredientsInAllDishes(dishes));
    }
}

class Dish {
    private String name;
    private int calories;
    private List<String> ingredients;

    public Dish(String name, int calories, List<String> ingredients) {
        this.name = name;
        this.calories = calories;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }
}
