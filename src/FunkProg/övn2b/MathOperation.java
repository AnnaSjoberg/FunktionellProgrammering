package FunkProg.övn2b;

public interface MathOperation {
    int operation(int a, int b);

    default MathOperation squareIt(MathOperation mo) {
        return (a, b) -> mo.operation(operation(a, b), operation(a, b));
    }

    default MathOperation multiply(MathOperation mo) {
        return (a, b) -> mo.operation(a, b) * operation(a, b);
    }

}
