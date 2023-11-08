package Java.oop01.static1;

public class Circle2 {
    // 멤버변수
    // 원의 반지름은 Circle객체마다 서로 다른 값을 가지기 때문에 멤버변수로 정의한다.
    double r;


    // 정적변수 - 클래스 변수  cv
    // 원주율은 Cicle 의 종류에 상관없이 항상 3.14  (상수 값)
    static final double PI = 3.14;
    // 변하지 않는 값 static으로 정의


    public Circle2(double r) {
        this.r = r;
        // PI는 이미 고정된 값이니깐
        // 객체에 없고 클래스에 속해있음.
    }


    public double around() {
        return 2 * PI * r;
    }

    public double area() {
        return PI * r * r;
    }
}
