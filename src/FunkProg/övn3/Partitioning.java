package FunkProg.övn3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.partitioningBy;


public class Partitioning {

    public static Map<Boolean, List<Person>> partitionAdults(List<Person> people) {

        return people.stream().collect(partitioningBy(p -> p.getAge() >= 18));

//        throw new UnsupportedOperationException("Not supported yet.");
    }
    public static Map<Boolean, List<Person>> partitionByNationality(List<Person> people, String input) {

        return people.stream().collect(partitioningBy(p -> p.getNationality().equalsIgnoreCase(input)));

//        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();
        people.add(new Person("k",25,"sw"));
        people.add(new Person("l",75,"dk"));
        people.add(new Person("a",35,"uk"));
        people.add(new Person("s",24,"us"));
        people.add(new Person("s",23,"uk"));
        people.add(new Person("i",6,"dk"));
        people.add(new Person("s",50,"sw"));
        people.add(new Person("k",12,"nw"));
        people.add(new Person("t",21,"sw"));

        Map<Boolean, List<Person>> result =
                Partitioning.partitionByNationality(people,"sw");

    }
}
