package FunkProg.övn3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

class KidNamesTest {


    @Test
    public void getKidNameShouldReturnNamesOfAllKids() {

        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        Person anna = new Person("Anna", 5);
        List<Person> collection = asList(sara, eva, viktor, anna);

        List<String> result = KidNames.getKidNames(collection);

        assertEquals(result.size(), 2);
        assertTrue(result.contains("Sara"));
        assertTrue(result.contains("Anna"));
        assertFalse(result.contains("Viktor"));
        assertFalse(result.contains("Eva"));

    }

}