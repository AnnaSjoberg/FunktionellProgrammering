package FunkProg.övn3;

import java.util.List;

public class FlattenCollection {
    public static List<String> transform(List<List<String>> l){

        return l.stream().flatMap(s->s.stream()).toList();
//        throw new UnsupportedOperationException("Not supported yet.");
    }

    //valfri att implementera
    static List<String> goingDeeper(List<List<List<String>>> collection) {

        return collection.stream().flatMap(c1->c1.stream().flatMap(c2->c2.stream())).toList();

        //throw new UnsupportedOperationException("Not supported yet.");
    }
}
