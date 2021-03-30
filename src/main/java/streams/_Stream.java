package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static streams._Stream.Gender.*;

public class _Stream {

    public static void main(String[] args) {

        List<Person> people = Arrays.asList(
                new Person("Adrian", MALE),
                new Person("Justyna", FEMALE),
                new Person("Eliza", FEMALE),
                new Person("Norbert", MALE),
                new Person("Aldona", FEMALE)
        );

        people.stream()
                .map(person -> person.name)
                .mapToInt(String::length)
                .forEach(System.out::println);

        // czy wszystkie elementy spełniają warunek
        System.out.println(
                people.stream().allMatch(person -> person.name.equals("Adrian"))
        );

        // czy jakikolwiek element spełnia warunek
        System.out.println(
                people.stream().anyMatch(person -> person.name.equals("Adrian"))
        );

        // zwraca liczbę elementów w strumieniu
        System.out.println(
                people.stream().count()
        );

        // zwraca tylko unikatowe elementy
        System.out.println(
                people.stream().map(person -> person.gender).distinct().collect(Collectors.toList())
        );


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
