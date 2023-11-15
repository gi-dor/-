package Java.lang.wrapper;

public class WrapperApp2 {

    public static void main(String[] args) {

        Integer a = 10; // Integer a = new Integer(10) 이게 기본모습인데
        Integer b = 20;
        Double d = 3.14;


        /*
        오토 언박싱
        - Wrapper 클래스 타입의 객체를 참조하는 참조변수를
            기본자료형 타입의 변수에 대입을 하면 ,
            참조변수의 주소값이 변수에 대입되는게 아니라
            기본자료형 값을 변수에 대입한다.

        - 정수 , 실수 값을 포함하는 Wrapper 클래스타입의 객체에 대해서
         사칙연산 , 비교연산 등을 실행하면 자동으로 오토 언박싱이 실행되어서
         Wrapper 객체에 저장된 기본자료형 값이 연산에 활용된다
         */

        int x = a;  // a라는 객체 주소가 아닌 int x = a.intValue();
        int y = b;  // b라는 객체 주소 가 아닌 int y = b.intValue();
        double z = d; // double z = d.doubleValue();

        int result = a + b; // int result = a.intValue() + b.intValue();

    }
}
