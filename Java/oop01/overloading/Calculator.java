package Java.oop01.overloading;

public class Calculator {

    /**
     * 정수 2개를 전달 받아 덧셈을 수행하고 그 결과를 반환한다
     * @param x
     * @param y
     * @return
     */
    int sum (int x, int y){
        System.out.println("(정수 + 정수)의 덧셈을 실행 한다");
        int result = x + y;
        return  result;
    }


    /**
     * 정수 2개가 아닌 정수 3개를 전달받는다 메서드의 중복정의
     * @param x
     * @param y
     * @param z
     * @return
     */
    // 정수 2개가 아닌 이번엔 3개
    int sum ( int x, int y , int z){
        System.out.println("정수 + 정수 + 정수 의 덧셈을 실행 한다");
        int result = x + y + z ;
        return result;
    }

    double sum (double x , double y) {
        System.out.println("(실수 + 실수)의 덧셈을 실행한다 ");
        double result = x + y;

        return result;
    }

    double sum( double x , int y) {
        System.out.println("(실수 + 정수)의 덧셈을 실행한다");
        double result = x + y;

        return result;
    }


    double sum(int x , double y) {
        System.out.println("(정수 + 실수)의 덧셈을 실행한다");
        double result = x + y;

        return result;
    }


    // 안되는 경우
    // 매개변수의 이름이 서로 다른 것은 메소드 중복정의의 요건이 될수 없다.,
    //	double sum (int a , double z) {
    //		System.out.println("매개변수의 이름만 다르기에 안된다");
    //		double result = a + z;
    //
    //		return result;
    //	}

    /*
     * 메서드 중복정의 (Method overloading)
     * - 하나의 클래스 안에 이름이 동일한 메서드를 여러 개 정의하는 것
     * - 목적
     *       + 유사한 기능은 동일한 이름으로 일관되게 정의하자
     *       + 객체의 기능에 대한 사용성이 높아진다
     * - 방법
     *       + 매개변수의 갯수 / 타입을 다른 메서드(이름이 같은)와 서로 다르게 정의 해야한다
     */



}
