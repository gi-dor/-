package Java.util.math;

public class MathApp {

    public static void main(String[] args) {

        /*
        java.lang.Math 클래스
            - 수학 연산과 관련된 정정메서드를 제공하는 클래스
            - Math 클래스는 상수와 정적 메서드 만으로 구성된 클래스
         */

        // Math 클래스의 상수값
        System.out.println(Math.PI);
        System.out.println(Math.E);

//        int abs(int x) , long abs(long x) , double abs(long x)
//          - 절대값을 반환

        System.out.println("절대 값 : " + Math.abs(10));
        System.out.println("절대 값 : " + Math.abs(-10));

        // int min(int x, int y) , long min(long x , long y) , double min(double x , double y)
        // - 두 수중에서 작은 숫자를 반환한다

        // int max( int x, int y) , long max(long x , long y)
        // - 두 수 중에서 큰 숫자를 반환한다

        System.out.println("작은수 반환 : " + Math.min(100, 50));
        System.out.println("큰 수 반환 : " + Math.max(200, 100));

        // double pow(double a, double b )
        // - a^b값을 반환           ^ 는 제곱을 의미한다  2의 3승 -> 2 * 2 * 2 = 8
        System.out.println(Math.pow(2, 3)); // 8

        // int round(float x) , long round(double x)
        // - 반올림된 값을 반환

        // 소수점 아래 첫째자리에서 반올림되는 것을 확인할수 있으며 정수가 출력
        System.out.println(Math.round(3.14));   // 3
        System.out.println(Math.round(3.45));   // 3
        System.out.println(Math.round(3.56));   // 4

        // 버림 double floor(double x)
        System.out.println("floor 버림 : " + Math.floor(3.45));
        System.out.println("floor 버림 : " + Math.floor(4.89));

        // 올림 double ceil(double x)
        System.out.println("ceil 올림 : " + Math.ceil(4.17));
        System.out.println("ceil 올림 : " + Math.ceil(3.59));
    }
}
