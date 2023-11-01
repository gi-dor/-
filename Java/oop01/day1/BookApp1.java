package Java.oop01.day1;



public class BookApp1 {
    public static void main(String[] args) {

    /*
     * 객체 생성
     * new 클래스이름();
     *
     * 클래스 이름에 해당하는 객체를 생성하고
     * 생성된 객체의 주소값을 반환한다
     * 반환되는 주소 값은 생성된 객체를 이용하기 위해서 사용된다
     */

    /*
     * 참조변수를 생성하고 객체의 주소값을 저장하기
     *
     * 클래스명 참조변수 이름 = new 클래스명();
     *
     * 참조변수의 타입은 생성한 객체의 클래스명이다;
     * 클래스 명은 참조변수의 타입이다.
     * 클래스는 사용자 정의 데이터 타입 (자료형)이다.
     */
    BookApp1 bk1 = new BookApp1();
    BookApp1 bk2 = new BookApp1();
    BookApp1 bk3 = new BookApp1();

        System.out.println(bk1);
        System.out.println(bk2);
        System.out.println(bk3);
        /*
            Java.oop01.day1.BookApp1@4eec7777
            Java.oop01.day1.BookApp1@3b07d329
            Java.oop01.day1.BookApp1@41629346
         */

    }

}
