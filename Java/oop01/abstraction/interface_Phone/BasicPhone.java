package Java.oop01.abstraction.interface_Phone;

// 주의사항

/**
 * 인터페이스는 알다 싶이 메서드에 public abstract가 생략되어있다
 * 근데 오버라이딩 규칙에 보면 접근제어자가 좁아지면 안되므로
 * 반드시 public 붙여서 구현해주자
 */

public class BasicPhone implements Phone{

    @Override
    public void call(String number){
        System.out.println("[" + number + "]에 전화를 걸겠습니다");
    }

    @Override
    public void receive(){

    }

    @Override
    public void sms(String to , String message){
        System.out.println("문자를 보냅니다");
        System.out.println("아이폰으로 ["+to+"] ["+message+"] 를 보냅니다");
    }

}
