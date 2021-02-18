package ru.mirea.java2020.pr2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        int ages  =1;
        List<Human> humans = new ArrayList<>();
        humans.add(new Human(10,"Ann","Whiteblued", LocalDate.of(2010,5,3),40));
        humans.add(new Human(18,"John","Ghosta", LocalDate.of(2002,7,5),10));
        humans.add(new Human(20,"Garry","Showmanc", LocalDate.of(2000,6,10),70));
        humans.add(new Human(50,"Noel","Gridmanb", LocalDate.of(1970,8,21),40));

        Comparator<Human> nameComparator = new Comparator<Human>(){
            @Override
            public int compare(Human o1, Human o2) {
                char first = o1.getLastName().charAt(o1.getLastName().length()-1);
                char second = o2.getLastName().charAt(o2.getLastName().length()-1);
                return Character.compare(first, second);
            }
        };

        Comparator<Human> dateComparator = new Comparator<Human>() {
            @Override
            public int compare(Human o1, Human o2) {
                LocalDate first = o1.getBirthDate();
                LocalDate second = o2.getBirthDate();
                return first.compareTo(second);
            }
        };

        List<Human> list =  humans.stream().sorted(nameComparator).collect(Collectors.toList());
        list.forEach(e-> System.out.println(e.getAge() + " " + e.getFirstName() + " " + e.getLastName() + " " + e.getWeight()));
        System.out.println();

        list = humans.stream().filter(human -> human.getAge()>human.getWeight()).collect(Collectors.toList());
        list.forEach(e-> System.out.println(e.getAge() + " " + e.getFirstName() + " " + e.getLastName() + " " + e.getWeight()));
        System.out.println();

        list = humans.stream().sorted(dateComparator).collect(Collectors.toList());
        list.forEach(e-> System.out.println(e.getAge() + " " + e.getFirstName() + " " + e.getLastName() + " " + e.getWeight()));
        System.out.println();

        Stream<Human> stream = humans.stream();
        ages *= stream.mapToInt(Human::getAge).reduce(1, (a, b) -> a * b);
        System.out.println(ages);
    }
}
