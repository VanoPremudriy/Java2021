package ru.mirea.java2020.pr3;

public class Main3 {
    static volatile int buf;
    synchronized static void increment() {
        buf++;
    }
    public static void main(String[] args) throws Exception {
        buf = 0;
        Thread one = new Thread(()->{
            for (int i = 0; i < 5000; i++) {
                increment();
            }
        });
        Thread two = new Thread(()->{
            for (int i = 0; i < 5000; i++) {
                increment();
            }
        });
        one.start();
        two.start();
        Thread.sleep(3000);
        System.out.println(buf);
    }
}
