package ru.mirea.java2020.pr3;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;

public class Main {
    private static final Semaphore semaphore = new Semaphore(3);
    private static ConcurrentHashMap<Integer, String> hashMap = new ConcurrentHashMap<>();

    static void go(int i) {
        try{
                semaphore.acquire();
                System.out.println(hashMap.get(i));
                semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) throws InterruptedException {
        hashMap.put(0,"One");
        hashMap.put(1,"Two");
        hashMap.put(2,"Three");
        hashMap.put(3,"Four");
        hashMap.put(4,"Five");
        Thread one = new Thread(() -> {
            for (int i=0;i<5;i++) go(i);
        });
        Thread two = new Thread(() -> {
            for (int i=0;i<5;i++) go(i);
        });

        one.start();
        two.start();
        Thread.sleep(5000);
    }
}
