package Java.oop01.abstraction.interface_Phone;

public class Iphone implements Phone,SmartPhone {

    // 인터페이스 Phone 구현
    @Override
    public void call(String numbers){
        System.out.println("아이폰으로 전화번호 ["+numbers+"]에 전화 합니다");
    }

    @Override
    public void sms(String to,String message){
        System.out.println("문자를 보냅니다");
        System.out.println("아이폰으로 ["+to+"] 가 ["+message+"] 를 보냅니다");
    }

    @Override
    public void receive(){}

    // 인터페이스 SmartPhone 구현하기
    @Override
    public void internet(){
        System.out.println("Iphone으로 인터넷이나 하자!");
    }

    @Override
    public void game(){
        System.out.println("Iphone으로 albion 모바일 게임이나 하자!");
    }

}
