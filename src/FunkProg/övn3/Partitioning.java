package FunkProg.övn3;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.partitioningBy;


public class Partitioning {

    public static Map<Boolean, List<Person>> partitionAdults(List<Person> people) {

        return people.stream().collect(partitioningBy(p -> p.getAge() >= 18));

//        throw new UnsupportedOperationException("Not supported yet.");
    }
}
