package com.rampatra.java8;

import java.util.function.Consumer;

/**
 * @author rampatra
 * @version 21/02/2017
 */
public class Lambdas {

    private int a = 1;

    public void testScopeOfLambda(Consumer<String> consumer) {
        consumer.accept("Lambda");
    }

    public static void main(String[] args) {
        Lambdas l = new Lambdas();
        l.testScopeOfLambda(x -> System.out.println(x));
        l.testScopeOfLambda(x -> System.out.println(x + l.a));
        l.a = 2;
        l.testScopeOfLambda(x -> System.out.println(x + l.a));
        /*for (int i = 0; i < 10; i++) {
            l.testScopeOfLambda(x -> System.out.println(x + i));
        }*/
        /*l.testScopeOfLambda(x -> {
            int a = 2;
            System.out.println(x + l.a);
        });*/
        l.testScopeOfLambda(new Consumer<String>() {
            int a = 2;

            @Override
            public void accept(String s) {

            }
        });
    }
}
