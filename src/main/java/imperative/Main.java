package imperative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static imperative.Main.Gender.*;

public class Main {

    public static void main(String[] args) {

        List<Person> people = Arrays.asList(
                new Person("Adrian", MALE),
                new Person("Justyna", FEMALE),
                new Person("Eliza", FEMALE),
                new Person("Norbert", MALE),
                new Person("Aldona", FEMALE)
        );

        System.out.println("Imperative approach");
        //Imperative approach
        List<Person> females = new ArrayList<>();
        for (Person person : people) {
            if (person.gender.equals(FEMALE))
                females.add(person);
        }

        for (Person female : females)
            System.out.println(female);

        System.out.println("Declarative approach");
        //Declarative approach
        Predicate<Person> predicate = person -> person.gender.equals(FEMALE);
        people.stream()
                .filter(predicate)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    static class Person {

        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE
    }
}
