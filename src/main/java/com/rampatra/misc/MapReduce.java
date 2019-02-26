package com.rampatra.misc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * A rudimentary example explaining the concept of Map/Reduce paradigm. The question is, provided a list of Person
 * objects from various countries, compute the total population in each country.
 *
 * @author rampatra
 * @since 2019-02-26
 */
public class MapReduce {

    private static class Person {
        String name;
        int age;
        String country;

        Person(String country) {
            this.country = country;
        }
    }

    /**
     * The mapper function will take all the data and output only the information which we need, and in this
     * case, it is just the country name to which a person belongs.
     *
     * @param personList a list of all persons
     * @return a list of country names
     */
    private static List<String> mapper(List<Person> personList) {
        return personList.stream().map(person -> person.country).collect(Collectors.toList());
    }

    /**
     * The reducer function will take all the useful information from the mapper function and then compute the result
     * we need. In this case, it is to count the number of persons in each country.
     *
     * @param countryNamesOfAllPersons a list of country names taken out of all {@code Person} objects
     * @return a map containing country names as the keys and their resp. population as values
     */
    private static Map<String, Integer> reducer(List<String> countryNamesOfAllPersons) {
        Map<String, Integer> countryToPopulationMap = new HashMap<>();

        countryNamesOfAllPersons.forEach(countryName -> {
            countryToPopulationMap.computeIfPresent(countryName, (country, population) -> population + 1);
            countryToPopulationMap.computeIfAbsent(countryName, country -> countryToPopulationMap.put(country, 1));
        });

        return countryToPopulationMap;
    }

    /**
     * Just to print the output.
     *
     * @param countryToPopulationMap a map containing country names as the keys and their resp. population as values
     */
    private static void printPopulation(Map<String, Integer> countryToPopulationMap) {
        countryToPopulationMap.forEach((k, v) -> System.out.println(k + ": " + v));
    }

    public static void main(String[] args) {

        Person[] persons = new Person[]{new Person("India"), new Person("Ireland"),
                new Person("Sweden"), new Person("United States"), new Person("India"),
                new Person("Ireland"), new Person("India")};

        printPopulation(reducer(mapper(Arrays.asList(persons))));
    }
}