package Java.oop01.overriding;

public class ColorPrinter extends Printer {

    // 조상클래스인 Printer 에서
    // 상속받은 print() 메서드를 지 입맛대로 바꿈
    // 그대로 사용해도되지만 자신에 맞게 변경해서 쓰기때문

    @Override
    void print(){
        System.out.println("컬러 프린트 합니다");
    }
}
