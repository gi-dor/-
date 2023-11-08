package Java.oop01.static1;

/**
 * 원의 반지름과 원주율을 멤버변수로 가지는 Circle 클래스 정의하기
 */
public class Circle {
    double r;	// 반지름
    double pi;

    Circle(double pi , double r){
        this.r = r;
        this.pi = pi;
    }

    /**
     * 원의 둘레 길이를 반환
     * @return 원의 둘레길이
     */
    public double round() {
        return 2 * pi * r;
    }

    public double area() {
        return pi * r * r;
    }
}
