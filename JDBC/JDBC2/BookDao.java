package JDBC.JDBC2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookDao {

    // 책 정보를 저장 하는 기능 insert

    /**
     * 반환 타입 : void 메서드 이름 : insertBook 매개변수 : Book book
     */
    public void insertBook(Book book) throws SQLException {
        String sql = """
                insert into sample_books
                (book_no , book_title , book_writer , book_price , book_stock)
                values
                (?,?,?,?,?)
                """;
        // Java와 오라클을 연결한다
        Connection con = getConnection();
        // 위에 String sql 쿼리문을
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, book.getNo());
        pstmt.setString(2, book.getTitle());
        pstmt.setString(3, book.getWriter());
        pstmt.setInt(4, book.getPrice());
        pstmt.setInt(5, book.getStock());

        pstmt.executeUpdate();

        pstmt.close();
        con.close();

    }

    // 책 정보를 변경 하는 기능 update

    /**
     * 반환타입 : void 메서드 이 름: UpdateBook 매개변수 : Book book
     */
    public void UpdateBook(Book book) throws SQLException {
        String sql = """
                update sample_books
                set
                    book_title = ?,
                    book_writer = ?,
                    book_price = ? ,
                    book_stock = ?
                 where 
                    book_no = ?
                """;

        // dbc driver를 메모리에 로딩한다
        //데이터 베이스와 연결을 담당하는 Connection객체 획득

        // -----------------------Java와 Oracle을 연결함 ---------------------------
        Connection con = getConnection();

        // SQL 전송을 담당하는 PreparedStatement 객체를 획득한다
        // PreparedStatement  를 사용해서 실제 쿼리를 실행하고 결과를 받아옴
        PreparedStatement pstmt = con.prepareStatement(sql);

        // String sql의 ? 에 해당하는 값을 순서대로 설정
        pstmt.setString(1, book.getTitle());
        pstmt.setString(2, book.getWriter());
        pstmt.setInt(3, book.getPrice());
        pstmt.setInt(4, book.getStock());
        pstmt.setInt(5, book.getNo());

        //  PreparedStatement객체 사용해서 변경사항을 적용함
        pstmt.executeUpdate();

        pstmt.close();
        con.close();


    }

    // 책 정보를 삭제 하는 기능 delete

    /**
     * 반환타입 : void 메서드명 : deleteBookByNo 매개변수 : int bookNo
     */

    public void deleteBookByNo(int bookNo) throws SQLException {
        String sql = """
                delete from sample_books
                where
                    book_no = ?
                """;

        // dbc driver를 메모리에 로딩한다
        //데이터 베이스와 연결을 담당하는 Connection객체 획득
        Connection con = getConnection();

        // SQL 전송을 담당하는 PreparedStatement 객체를 획득한다
        PreparedStatement pstmt = con.prepareStatement(sql);

        pstmt.setInt(1, bookNo);

        pstmt.executeUpdate();

        pstmt.close();
        con.close();

    }

    // 책 정보 한권 조회 하는 기능 select

    /**
     * 반환타입 : Book 메서드명 : getBookByNo 매개변수 : int bookNo
     */

    public Book getBookByNo(int bookNo) throws SQLException {

        String sql = """
                select 
                    book_no , book_title , book_writer , book_price , 
                    book_stock , book_reg_date
                from 
                    sample_books
                where 
                    book_no = ?
                """;

        // Java 오라클 연결
        Connection con = getConnection();

        // 위에 String sql 에있는 쿼리를 매개변수, PreparedStatement 객체 생성
        // 실제 쿼리 실행하는거임
        PreparedStatement pstmt = con.prepareStatement(sql);

        // 첫번째 ? 에다가 bookNo를 설정했음
        // where book_no = ? 이부분
        pstmt.setInt(1, bookNo);

        // pstmt.executeUpdate(); executeUpdate() 는 변경사항을 적용하는거임
        // 예를 들면 update , delete , insert 같은 테이블에 결과물에 변동이있으니 적용하려고

        // executeQuery() 메서드를 호출하여 쿼리를 실행
        // ResultSet 은 쿼리 실행 결과를 객체에 담아야한다
        ResultSet rs = pstmt.executeQuery();

        Book book = null;

        // if(rs.next()) 는 데이터베이스로부터 쿼리의 결과를 가져올 때 사용하는 메서드다
        // 위에 보면 ResultSet rs 에 쿼리의 실행 결과를 담고 있다

        // if(rs.next())가 true 일시 아래 if문이 작동한다
        if (rs.next()) {
            int no = rs.getInt("book_no");
            String title = rs.getString("book_title");
            String writer = rs.getString("book_writer");
            int price = rs.getInt("book_price");
            int stock = rs.getInt("book_stock");
            Date regDate = rs.getDate("book_reg_date");

            // Book에 담음
            book = new Book();
            book.setNo(no);
            book.setTitle(title);
            book.setWriter(writer);
            book.setPrice(price);
            book.setStock(stock);
            book.setRegDate(regDate);
        }

        rs.close();
        pstmt.close();
        con.close();

        return book;

    }

    // 모든 책 정보를 조회 하는 기능 selectALl

    /**
     * 반환타입 : List<Book> 메서드명 : getAllBooks 매개변수 : X
     */

    public List<Book> getAllBooks() throws SQLException {
        String sql = """
                select 
                    book_no , book_title , book_writer , book_price , 
                    book_stock , book_reg_date
                from
                    sample_books
                order by 
                    book_no desc
                    
                """;

        List<Book> bookList = new ArrayList<Book>();

        Connection con = getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);

        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            // 꺼냄
            int no = rs.getInt("book_no");
            String title = rs.getString("book_title");
            String writer = rs.getString("book_writer");
            int price = rs.getInt("book_price");
            int stock = rs.getInt("book_stock");
            Date regDate = rs.getDate("book_reg_date");

            // Book에 담음
            Book book = new Book();
            book.setNo(no);
            book.setTitle(title);
            book.setWriter(writer);
            book.setPrice(price);
            book.setStock(stock);
            book.setRegDate(regDate);

            // ArrayList에 담음
            bookList.add(book);
        }

        rs.close();
        pstmt.close();
        con.close();

        return bookList;
    }

    // dbc driver를 메모리에 로딩한다
    //데이터 베이스와 연결을 담당하는 Connection객체 획득

    private Connection getConnection() throws SQLException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException ex) {
            throw new SQLException(ex.getMessage(), ex);
        }

        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "hr";
        String password = "zxcv1234";

        return DriverManager.getConnection(url, user, password);
    }


}
