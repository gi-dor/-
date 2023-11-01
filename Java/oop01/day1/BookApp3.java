package Java.oop01.day1;

public class BookApp3 {
    public static void main(String[] args) {

        // Book 객체를 생성해서 책정보를 저장하기

        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();


        book1.title = "이것이 자바다";
        book1.author = "신용권";
        book1.publisher = "한빛 미디어";
        book1.discountRate = 0.15;
        book1.price = 36000;
        book1.stock = 100;
        book1.soldOut = false;

        book2.title = "자바의 정석";
        book2.author = "남궁성";
        book2.publisher = "도우 출판사";
        book2.discountRate = 0.15;
        book2.price = 32000;
        book2.stock = 50;
        book2.soldOut = false;


        book3.title = "헤더 퍼스트 자바";
        book3.author = "케이시 시에라";
        book3.publisher = "한빛 미디어";
        book3.discountRate = 0.15;
        book3.price = 28000;
        book3.stock = 100;
        book3.soldOut = true;


        // Book 객체를 여러 개 저장하는 배열을 생성하고 , 그 배열에 Book 객체 담기
        Book [] books = new Book[3];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;


        // 배열에 저장된 책 정보를 출력하기
        for(Book b : books) {
            System.out.println("제목 : "+b.title);
            System.out.println("작성자 : "+b.author);
            System.out.println("공급자 : "+b.publisher);
            System.out.println("할인율 : "+b.discountRate);
            System.out.println("가격 : "+b.price);
            System.out.println("재고 : "+b.stock);
            System.out.println("품절현황 : "+b.soldOut);
            System.out.println();
        }


    }
}
