package JDBC.JDBC2;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class BookDaoApp2 {

    public static void main(String[] args) throws SQLException {

        BookDao bookDao = new BookDao();

        // 모든 책 정보 조회하기
        List<Book> books = bookDao.getAllBooks();
        for (Book b : books) {
            System.out.println("번호: " + b.getNo() + "  제목 : " + b.getTitle());
        }

        System.out.println("----------------------------------------------------");
        System.out.println("검색으로 책 조회 하기");

        Scanner scanner = new Scanner(System.in);

        System.out.print("검색하고자 하는 책번호를 입력하시오 Ex. 10 12 14 15 101 102 : ");
        int bookNo = scanner.nextInt();
        Book book = bookDao.getBookByNo(bookNo);

//        System.out.println("조회 요청 책의 번호 : " + book.getNo()); NullPoint발생항
        System.out.println("조회 요청 책의 번호 : " + bookNo);
        System.out.println(" << 결과 >>");

        if (book != null) {
            System.out.println("번호 : " + book.getNo() + " 제목 : " + book.getTitle());
        } else {
            System.out.println("조회 요청한 번호에 맞는 책이 없습니다.");
        }

    }
}
