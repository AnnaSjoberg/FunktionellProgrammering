package FunkProg.övn2b;

public class MathOperationMain {

    private static int operate(int a, int b, MathOperation mathOperation) {

        return mathOperation.operation(a, b);
    }

    public static void main(String args[]) {
        final int i = 10;
        final int j = 5;
        MathOperation addition = (a, b) -> a + b;
        MathOperation subtraction = (a, b) -> a - b;
        MathOperation multiplication = (a, b) -> a * b;
        MathOperation division = (a, b) -> a / b;

        System.out.println("10 + 5 = " + operate(10, 5, addition));
        System.out.println("10 - 5 = " + operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + operate(10, 5, division));
        System.out.println();
        System.out.println(subtraction.multiply(addition).operation(1,2));
        System.out.println(operate(i,j,addition.multiply(subtraction)));
        System.out.println(multiplication.squareIt(addition).operation(i,j));

    }
}
