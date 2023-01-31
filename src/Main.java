import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        var counter = new AtomicInteger(1);

        var orderedMap = new LinkedHashMap<Integer,String>();

        var demoList = List.of("a","b","c","d","e","f","g");

        demoList.stream()
                .forEachOrdered(string -> orderedMap.put(counter.getAndIncrement(),string));

        orderedMap.forEach((number, string) -> System.out.println(number + " " + string));

    }
}
