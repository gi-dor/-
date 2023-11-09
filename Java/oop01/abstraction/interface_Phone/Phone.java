package Java.oop01.abstraction.interface_Phone;

/*
인터페이스
일종의 추상 클래스 라고 한다
그러나 추상클래스 처럼 추상메서드를 갖지만 추상화에 정도가 높아
추상메서드와 상수만 멤버로 가질수 있다고한다

다른클래스 작성시 도움을 줄 목적으로 작성 되었다

 */

/*
기본적으로 모든 멤버변수는 public static final 이며 public 생략 가능하다
또한 모든 메서드는 public abstract 이어야 하며 이또한 생략이 가능하다
예를들어 public abstract void call(String number); 라는 미완성 메서드가 있다면
생략하고 void call(String number); 라고 표기해도된다

* 생략된제어자는 컴파일러가 자동으로 추가해준다
 */
public interface Phone {
    // 모든 전화기들이 반드시 가져야 하는 기능

    public abstract void call(String number);
    public abstract  void receive();

    // public , abstract 생략버전
    void sms(String to , String message);

}
