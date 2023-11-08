package Java.oop01.inheritance;

public class PhoneApp2 {

    public static void main(String[] args) {

        // Iphone 객체는 Iphone 타입이다
        Iphone p1 = new Iphone();
        p1.applemusic(); 		// Iphone 객체
        p1.appleplay();			// Iphone 객체
        p1.internet();			// SmartPhone 객체
        p1.game();				// SmartPhone 객체
        p1.ip = "192.168.10.1";	// SmartPhone 객체
        p1.call(); 				// Phone 객체
        p1.receive();			// Phone 객체

        // Iphone 객체는 SmartPhone 타입이다
        SmartPhone p2 = new Iphone();
//		p2.applemusic(); 		// Iphone 객체
//		p2.appleplay();			// Iphone 객체
        p2.internet();			// SmartPhone 객체
        p2.game();				// SmartPhone 객체
        p2.ip = "192.168.10.1"; // SmartPhone 객체
        p2.call(); 				// Phone 객체
        p2.receive();			// Phone 객체


        // Iphone 객체는 Phone 타입이다
        Phone p3 = new Iphone();
//		p3.applemusic(); 		// Iphone 객체
//		p3.appleplay();			// Iphone 객체
//		p3.internet();			// SmartPhone 객체
//		p3.game();				// SmartPhone 객체
//		p3.ip = "192.168.10.1"; // SmartPhone 객체
        p3.call(); 				// Phone 객체
        p3.receive();			// Phone 객체
    }
}
