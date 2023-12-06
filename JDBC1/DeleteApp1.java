package JDBC1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteApp1 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String sql = """
                delete from sample_books
                where book_no = ?
                """;

        // jdbc driver를 메모리에 로딩한다
        Class.forName("oracle.jdbc.driver.OracleDriver");

        // 데이터 베이스와 연결을 담당하는 Connection객체 획득
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "zxcv1234");

        // SQL 전송을 담당하는 PreparedStatement 객체를 획득한다
        PreparedStatement pstmt = con.prepareStatement(sql);

        // SQL의 ? 에 바인딩할 값을 순서대로 설정한다
        pstmt.setInt(1, 16);

        int rowCount = pstmt.executeUpdate();
        System.out.println(rowCount + "개의 행이 삭제 되었습니다");

        pstmt.close();
        con.close();

    }
}
