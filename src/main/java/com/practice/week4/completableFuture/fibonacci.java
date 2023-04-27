package com.practice.week4.completableFuture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.function.Supplier;

public class fibonacci {
    public static void main(String[] args) {

        List<Integer> sizes = Arrays.asList(10,20,30);

        Function<Integer, List<Integer>> fibonacciSeries = length -> {
            int num1 = 0, num2 = 1;
            List<Integer> series = new ArrayList<>();
            int counter = 0;

            while (counter < length)
            {
                series.add(num1);

                int num3 = num2 + num1;
                num1 = num2;
                num2 = num3;
                counter = counter + 1;
            }
            return series;
        };


        for (int size : sizes) {
            CompletableFuture.supplyAsync(()->size).thenApplyAsync(fibonacciSeries).thenAcceptAsync(System.out::println);
        }

    }

}
