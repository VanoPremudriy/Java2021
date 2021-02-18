package ru.mirea.java2020.pr3;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Stream;

public class Main2 {
    static HashSet<Integer> hs = new HashSet<>();
    static Iterator iterator = hs.iterator();
     static void go(int i){
         hs.add(i);
    }
    public static void main(String[] args) throws InterruptedException {
        hs.add(1);
        hs.add(2);
        hs.add(3);
        hs.add(4);

        Thread one = new Thread(() -> {
            for (int i=5;i<=8;i++) go(i);
        });
        Thread two = new Thread(() -> {
            for (int i=9;i<=10;i++) go(i);
        });

        one.start();
        two.start();

        Stream stream = hs.stream();
        stream.forEach(System.out::println);

    }
}
