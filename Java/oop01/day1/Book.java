package Java.oop01.day1;

/**
 * 책 정보를 표현하는 클래스
 */
public class Book {

    // 필드  : 클래스 내에 선언된 변수
    // 멤버변수 : 클래스에 속한 변수 필드랑 같은의미
    // 프로퍼티 : 객체의 속성을 나타냄
    //  title, author, publisher, price, discountRate, stock, soldOut은 모두 필드이며, 동시에 멤버 변수
    // 각각의 필드는 Book 객체의 프로퍼티

    String title;  // 제목
    String author;  // 저자
    String publisher;  // 출판사
    int price; // 가격
    double discountRate;  // 할인율
    int stock; // 재고갯수
    boolean soldOut;   // 품절 유무
}
