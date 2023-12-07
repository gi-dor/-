package JDBC.JDBC2;

import JDBC.JDBC3.Scanner;
import java.sql.SQLException;
import java.util.List;

public class BookUI {

    private BookDao bookDao = new BookDao();
    private Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        System.out.println("=======================================================");
        System.out.println("1. 전체 조회  2. 상세조회  3. 등록 4. 수정  5. 삭제 0. 종료");
        System.out.println("=======================================================");

        System.out.print("### 메뉴 선택");
        int menuNo = scanner.nextInt();

        try {
            switch (menuNo) {
                case 1:
                    전체조회();
                    break;
                case 2:
                    상세조회();
                    break;
                case 3:
                    등록();
                    break;
                case 4:
                    수정();
                    break;
                case 5:
                    삭제();
                    break;
                case 0:
                    종료();
                    break;
            }

        } catch (SQLException ex) {
            System.out.println("### 데이터베이스 작업중 오류 발생 신속히 처리하겠습니다");
        }
        System.out.println();
        System.out.println();
        System.out.println();

        showMenu();

    }

    private void 전체조회() throws SQLException {
        System.out.println("<< 전체 도서 조회 >>");

        List<Book> books = bookDao.getAllBooks();

        if (books.isEmpty()) {
            System.out.println("### 도서 정보가 존재하지 않습니다.");
            return; // 없는 경우 종료하기 위해 return 사용
        }

        System.out.println("========================================================");
        System.out.println("번호\t\t가격\t\t저자\t\t제목");
        System.out.println("========================================================");

        for (Book book : books) {
            System.out.print(book.getNo() + "\t");
            System.out.print(+book.getPrice() + "\t");
            System.out.print(book.getWriter() + "\t");
            System.out.println(book.getTitle() + "\t");
        }
    }

    private void 상세조회() throws SQLException {
        System.out.println("<< 도서 정보 상세 조회 >>");
        System.out.println("### 책의 번호를 입력해 상세정보를 확인하세요");
        System.out.println("### 책번호 : ");

        int bookNo = scanner.nextInt();
        Book book = bookDao.getBookByNo(bookNo);
        if (book == null) {
            System.out.println("### 책번호 [  " + bookNo + " ] 책 정보가 존재하지 않습니다 ");
            return;
        }
        System.out.println("### 도서 상세 정보 조회");
        System.out.println("======================================================");
        System.out.println("번호 : " + bookNo);
        System.out.println("제목 :" + book.getTitle());
        System.out.println("저자 : " + book.getWriter());
        System.out.println("가격 : " + book.getPrice());
        System.out.println("수량 : " + book.getStock());
        System.out.println("등록일 : " + book.getRegDate());
        System.out.println("======================================================");

    }

    private void 등록() throws SQLException {
        System.out.println("<<신규 도서 등록>>");
        System.out.println("### 신규 도서 정보를 입력하세요");

        System.out.print("### 번호 :");
        int no = scanner.nextInt();

        System.out.print("### 제목 :");
        String title = scanner.nextString();

        System.out.print("### 저자  :");
        String writer = scanner.nextString();

        System.out.print("### 가격 :");
        int price = scanner.nextInt();

        System.out.print("### 재고  ");
        int stock = scanner.nextInt();

        Book book = new Book();
        book.setNo(no);
        book.setTitle(title);
        book.setPrice(price);
        book.setWriter(writer);
        book.setStock(stock);

        bookDao.insertBook(book);
        System.out.println("### 신규 도서 등록 하였습니다");
    }

    private void 수정() throws SQLException {

    }


    private void 삭제() throws SQLException {
        System.out.println("<< 도서 정보 삭제 >>");
        System.out.println("### 책 번호를 입력받아 책 정보를 삭제 합니다");

        System.out.print("### 책 번호 입력 : ");
        int bookNo = scanner.nextInt();

        bookDao.deleteBookByNo(bookNo);
        System.out.println("### 책번호 [ " + bookNo + "]");
        System.out.println("### 삭제가 완료 되었습니다.");
    }

    private void 종료() {
        System.out.println("### 프로그램 종료 하겠습니다");
        System.exit(0);

    }


    public static void main(String[] args) throws Exception {

        new BookUI().showMenu();
    }
}
