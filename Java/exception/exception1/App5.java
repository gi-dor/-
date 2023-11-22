package Java.exception.exception1;

public class App5 {
    public static void main(String[] args) {

        int x = 10;
        int y = 0;
        int f = x / y;
        /* ArithmeticException

         Exception in thread "main" java.lang.ArithmeticException: / by zero
         나눗셈 연산 은 ArithmeticException , 예외 처리 코드를 작성할 필요가 없다.


         어떤숫자를 0 으로 나눌 때 발생한다

         - Unchecked compiler
         */

        System.out.println(f);
    }
}
