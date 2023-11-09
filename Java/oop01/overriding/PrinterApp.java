package Java.oop01.overriding;

public class PrinterApp {
    public static void main(String[] args) {

        Printer p = new Printer();
        p.print();
        // Printer 클래스에 존재하는 print()메서드 호출
        System.out.println();

        ColorPrinter cp = new ColorPrinter();
        cp.print();
        // ColorPrinter 클래스에 존재하는 print() 메서드 호출
        // Printer 클래스를 상속받아 그중에 print() 메서드를 오버라이딩해서 자신에 맞게 변경했다

        // 제약 조건으로 접근제어자는 조상보다 좁은 범위로 변경할수 없다
        // 선언부가 조상클래스의 메서드와 일치해야한다
        // 예외는 조상클래스의 메서드보다 많이 선언 할수 없다 - 객체지향 이후에 배운다
        System.out.println("-------------------------------테스트-----------------------------");
        ColorPrinter2 cp2 = new ColorPrinter2();
        cp2.print();

        System.out.println();
        PhotoPrinter ph = new PhotoPrinter();
        ph.print();

    }
}
