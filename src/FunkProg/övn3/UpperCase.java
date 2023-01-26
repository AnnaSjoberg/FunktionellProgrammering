package FunkProg.övn3;

import java.util.List;

public class UpperCase {

    public static List<String> transform(List<String> l){

        return l.stream().map(s->s.toUpperCase()).toList();


//        throw new UnsupportedOperationException("Not supported yet.");
    }

}
