package FunkProg.övn3;

import java.util.List;
import java.util.stream.Collectors;

public class LessThanFour {
//plocka fram de ord som är kortare än 4 tecken
    public static List<String> transform(List<String> l){

        return l.stream().filter(e -> e.length() < 4).toList();
        //return l.stream().filter(e -> e.length() < 4).collect(Collectors.toList());

        //throw new UnsupportedOperationException("Not supported yet.");
    }

}
