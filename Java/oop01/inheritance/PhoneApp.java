package Java.oop01.inheritance;

public class PhoneApp {
    public static void main(String[] args) {

        // Phone 객체 생성
        Phone p1 = new Phone();
        p1.number = "010 - 1234 -4568";
        p1.call();
        p1.receive();

        // SmartPhone 객체 생성
        SmartPhone p2 = new SmartPhone();
        p2.number = "010 - 9874 - 6532";
        p2.call();
        p2.receive();
        p2.ip = "192.168.10.111";
        p2.game();
        p2.internet();
    }
}
