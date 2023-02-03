package FunkProg.övn3;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.partitioningBy;


public class Grouping {
    public static Map<String, List<Person>> groupByNationality(List<Person> people) {

     return people.stream().collect(groupingBy(Person::getNationality));

     //   throw new UnsupportedOperationException("Not supported yet.");
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


        Map<String, List<Person>> myMap = groupByNationality(people);

        myMap.forEach((s, people1) -> System.out.println(s +" "+ people1.size()));
    }

}
