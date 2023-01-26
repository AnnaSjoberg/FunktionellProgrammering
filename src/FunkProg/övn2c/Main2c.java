package FunkProg.övn2c;

public class Main2c {

    public Main2c(){


        SingleDigitOperation square = a -> a*a;
        SingleDigitOperation isPos = a ->{
            if (a<0){
                return 0;
            }
            return 1;
        };
        System.out.println(isPos.Operate(5));
        System.out.println(isPos.Operate(-5));
        System.out.println(square.Operate(5));
    }


    public static void main(String[] args) {
        Main2c c = new Main2c();
    }
}
