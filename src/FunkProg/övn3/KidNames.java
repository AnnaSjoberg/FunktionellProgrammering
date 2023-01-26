package FunkProg.övn3;

import java.util.List;

public class KidNames {

    public static List<String> getKidNames(List<Person> ppl) {

        return ppl.stream().filter(p -> p.getAge() < 18).map(Person::getName).toList();

        //throw new UnsupportedOperationException("Not supported yet.");
    }
}
