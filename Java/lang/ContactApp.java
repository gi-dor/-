package Java.lang;

public class ContactApp {
    public static void main(String[] args) {

        Contact c1 = new Contact();
        Contact c2 = new Contact();

        c1.name = "테스팅";
        c1.phone = "010 - 4567 - 9635";

        c2.name = "테스팅2";
        c2.phone = "010 - 1234 - 5069";

        /*
         * String toString()
         * 	- Object의 메서드
         * 	- 객체의 "클래스명@해시코드값" 을 '문자열'로 반환한다
         */
        // 패키지.클래스이름@해시코드 값을 반환
        System.out.println(c1.toString());
        System.out.println(c2.toString());
//		lang.Contact@6f2b958e
//		lang.Contact@5e91993f

        // 참조변수 값 출력 , 참조변수 값 대신 참조변수가 참조하는
        // 객체의 toString() 메서드가 반환하는 값이 출력된다.
        System.out.println(c1);
        System.out.println(c2);



        String str1 = new String("안녕 , 반가워");
        String str2 = "반갑다";

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str1.toString());
        System.out.println(str2.toString());
    }
}
