package Java.oop01.inheritance;

/**
 * 전화기를 표현하는 클래스
 * 속성 : 전화번호
 * 기능 :  전화걸기 , 전화받기
 *
 */
public class Phone {
    String number;

    public void call() {
        System.out.println("전화 걸기");
    }

    public void receive() {
        System.out.println("전화 받기");
    }
}
