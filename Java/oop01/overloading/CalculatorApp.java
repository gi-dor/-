package Java.oop01.overloading;

public class CalculatorApp {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        int result1 = calculator.sum(10,20,30);
        int result2 = calculator.sum(40,50);
        double result3 = calculator.sum(3.14, 2.2);

        System.out.println("1번 실행 : "+ result1);
        System.out.println("2번 실행 : "+ result2);
        System.out.println("3번 실행 : "+ result3);
    }
}
