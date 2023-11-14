package Java.lang;

public class ContactApp2 {

    public static void main(String[] args) {

        Contact c1 = new Contact();
        Contact c2 = new Contact();


        c1.name = "테스트 네임";
        c1.phone = "010 - 9090 - 8080";
        c1.email = "Test1Name@gmail.com";
        c1.companyString = "와부덕소로";

        c2.name = "테스트 네임";
        c2.phone = "010 - 9090 - 8080";
        c2.email = "Test2Name@gmail.com";
        c2.companyString = "와부덕소로";

        System.out.println(c1);
        System.out.println(c2);

        /*
         * Object의 equals(Object other)
         * 동일한 객체인지 비교하는 메서드
         * 두 객체의 주소값을 비교한다
         *
         * 두객체가 같은 값을 가지고 있으면 같은 객체로 판단하게 하기
         * - equals(Object other)를 재 정의한다
         */

        boolean result1 = c1.equals(c2);
        boolean result2 = c1 == c2;
        // == 연산자는 int float double같은 값을 비교
        // c1= 5 , c2 = 5
        // c1 == c2 // true

        // equals 객체의 메모리 주소가 아닌 문자열 내용을 비교

        // String a = new String("test");
        //String b = new String("test");
        //a == b;        // false, 두 객체의 메모리 주소가 다름


        System.out.println(result1);	// false
        System.out.println(result2);	// false
    }
}
