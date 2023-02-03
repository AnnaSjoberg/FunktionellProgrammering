import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<String, List<String>> phoneNumbers = new HashMap<>();
        List<String> sigrunsNumbers = List.of("123435","6546464","5647657");
        List<String> skravlansNumbers = List.of("787878","11111","222454");
        List<String> matsNumbers = List.of("1","2","3");

        phoneNumbers.put("sigrun",sigrunsNumbers);
        phoneNumbers.put("mats",List.of("545485","33335","98765432"));
        phoneNumbers.put("skravlan", skravlansNumbers);


      //  phoneNumbers.put("sigrun",sigrunsNumbers.add("1234"));
        //phoneNumbers.forEach((k,v)-> System.out.println(k+" "+v));

        Map<String, Integer> numbers = new HashMap<>();
        numbers.put("1an", 0);
        numbers.put("2an", 0);
        numbers.put("3an", 0);

        numbers.forEach((k,v)-> System.out.println(k+" "+v));
        numbers.put("1an", (numbers.get("1an")+2));
        numbers.forEach((k,v)-> System.out.println(k+" "+v));

        matsNumbers.stream().forEach(mn->numbers.put("2an",(numbers.get("2an")+Integer.parseInt(mn))));
        System.out.println(numbers.get("2an"));

    }
}
/*
var counter = new AtomicInteger(1);

        var orderedMap = new LinkedHashMap<Integer,String>();

        var demoList = List.of("a","b","c","d","e","f","g");

        demoList.stream()
                .forEachOrdered(string -> orderedMap.put(counter.getAndIncrement(),string));

        orderedMap.forEach((number, string) -> System.out.println(number + " " + string));

 */