package calculator;

public class Calculator {
    private int a;
    private int b;

    public int add(int a, int b){
        return a+b;
    }

    public int subs(int a, int b){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return a-b;
    }

    public int mult(int a, int b){
        return a*b;
    }

    public int div(int a, int b){
        if (b == 0)
            throw new ArithmeticException("Division by zero");
        return a/b;
    }
}




