package Java.oop01.overriding;

public class Printer {

    String black;

    void print(){
        System.out.println("흑백만 인쇄 합니다");
    }
}

class ColorPrinter2 extends Printer{
    void print(){
        System.out.println("폴더내의 접근제어자 default 해서 만든 ColorPrinter2 클래스");
    }
}
