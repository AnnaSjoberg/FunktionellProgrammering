package FunkProg.övn3;
import java.util.List;
import java.util.stream.IntStream;


public class SumElements {

    public static int calculate(List<Integer> numbers) {

        return numbers.stream().mapToInt(n->n).sum();
//        throw new UnsupportedOperationException("Not supported yet.");
    }
}