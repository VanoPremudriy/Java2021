package ru.mirea.java2020.pr1;


import java.util.ArrayList;

import java.util.function.Predicate;


public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("One",1));
        students.add(new Student("Two",10));
        students.add(new Student("Three",500));
        students.add(new Student("Four",50));

        Predicate<ArrayList<Student>> isMax = (_students) -> {
            for (Student st : _students){
                if (st.getScores()==100) return true;
            }
            return false;
        };

        System.out.println(isMax.test(students));

    }
    
}
