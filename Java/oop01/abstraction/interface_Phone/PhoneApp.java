package Java.oop01.abstraction.interface_Phone;

public class PhoneApp {
    public static void main(String[] args) {

        BasicPhone bp = new BasicPhone();
        bp.call("010-1234-9632");
        bp.sms("기선","집가고싶다 다들 집갔네 나만 있네 학원에");

        System.out.println();

        Phone p = new BasicPhone();
        p.call("010-9654-7894");
        p.sms("기선2","집가고싶다 다들 집갔네 나만 있네 학원에");

        System.out.println();
        Iphone ip = new Iphone();
        ip.game();
        ip.internet();

    }
}
