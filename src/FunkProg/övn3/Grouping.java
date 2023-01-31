package FunkProg.övn3;
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
}
