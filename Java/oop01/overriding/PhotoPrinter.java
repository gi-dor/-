package Java.oop01.overriding;

public class PhotoPrinter extends Printer {
    // Printer 클래스를 상속받은 PhotoPrinter 클래스


    @Override
    void print() {
        System.out.println("조상인 Printer에서 상속받은 print()메서드를 내용 변경해서 사용 하겠다 ");
        System.out.println(" 이것을 오버 라이딩 이라고 한다");
        System.out.println("포토 프린트를 실행");
    }
}
