package Java.oop01.day1;

public class CubEx {
    public static void main(String[] args) {

        // 클래스 변수 사용
        System.out.println(HondaCub.company); // 클래스명.변수명

        // 인스턴스 변수 사용 - 반드시 객체를 생성해야 쓸수있음
        HondaCub hc1 = new HondaCub();
        HondaCub hc2 = new HondaCub();
        // h1 , h2 둘다 독릭접이다

        hc1.color = "white";
        hc2.color = "black";

        System.out.println("hc1 색상 : "+ hc1.color);
        System.out.println("hc2 색상 : "+ hc2.color);
        System.out.println();

        // 클래스 변수를 인스턴스 객체로 출력하기
        System.out.println("hc1 제조사 : "+ hc1.company);
        System.out.println("hc2 제조사 : "+ hc2.company);
        System.out.println();
        // 클래스 변수 값변경
        hc1.company = "SuperCub";
        System.out.println("변경 후 hc1 제조사 : "+ hc1.company);
    }
}
