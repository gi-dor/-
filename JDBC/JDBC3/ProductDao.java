package JDBC.JDBC3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductDao {

    // 모든 상품 정보를 반환

    /**
     * 반환타입 : List<Product> 메서드명 : getAllProduct 매개변수 X
     */
    public List<Product> getAllProduct() throws SQLException {
        String sql = """
                select 
                    prod_no , prod_name , prod_maker ,
                    prod_price, prod_discount_price , prod_stock,
                    prod_sold_out , prod_created_date , prod_update_date
                from 
                    sample_products
                order by
                    prod_no
                    
                """;
        List<Product> productList = new ArrayList<Product>();

        // Java랑 oracle 연결
        Connection con = getConnection();

        // sql 실핼 쿼리
        PreparedStatement pstmt = con.prepareStatement(sql);

        // 쿼리 결과물 담기
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            int no = rs.getInt("prod_no");
            String name = rs.getString("prod_name");
            String maker = rs.getString("prod_maker");
            int price = rs.getInt("prod_price");
            int discountPrice = rs.getInt("prod_discount_price");
            int stock = rs.getInt("prod_stock");
            String soldOut = rs.getString("prod_sold_out");
            Date createdDate = rs.getDate("prod_created_date");
            Date updateDate = rs.getDate("prod_update_date");

            Product product = new Product();
            product.setNo(no);
            product.setName(name);
            product.setMaker(maker);
            product.setPrice(price);
            product.setDiscountPrice(discountPrice);
            product.setStock(stock);
            product.setSoldOut(soldOut);
            product.setCreatedDate(createdDate);
            product.setUpdateDate(updateDate);

            // ArrayList에 담음
            productList.add(product);
        }
        rs.close();
        pstmt.close();
        con.close();

        return productList;
    }

    // 상품 번호에 해당하는 상품정보를 반환

    /**
     * 반환타입 : Product 메서드명 : getProductByNo 매개변수 : int prodNo
     */

    public Product getProductByNo(int prodNo) throws SQLException {
        String sql = """
                select  
                    prod_no , prod_name , prod_maker ,
                    prod_price, prod_discount_price , prod_stock,
                    prod_sold_out , prod_created_date , prod_update_date
                from 
                    sample_products
                where 
                    prod_no = ?    
                order by
                    prod_no                            
                """;

        // Java랑 oracle 연결
        Connection con = getConnection();

        // sql 실핼 쿼리
        PreparedStatement pstmt = con.prepareStatement(sql);

        pstmt.setInt(1, prodNo);

        // 쿼리 결과물 담기
        ResultSet rs = pstmt.executeQuery();

        Product product = null;

        // if(rs.next()) 는 데이터베이스로부터 쿼리의 결과를 가져올 때 사용하는 메서드
        if (rs.next()) {
            int no = rs.getInt("prod_no");
            String name = rs.getString("prod_name");
            String maker = rs.getString("prod_maker");
            int price = rs.getInt("prod_price");
            int discountPrice = rs.getInt("prod_discount_price");
            int stock = rs.getInt("prod_stock");
            String soldOut = rs.getString("prod_sold_out");
            Date createdDate = rs.getDate("prod_created_date");
            Date updateDate = rs.getDate("prod_update_date");

            product = new Product();

            product.setNo(no);
            product.setName(name);
            product.setMaker(maker);
            product.setPrice(price);
            product.setDiscountPrice(discountPrice);
            product.setStock(stock);
            product.setSoldOut(soldOut);
            product.setCreatedDate(createdDate);
            product.setUpdateDate(updateDate);

        }
        rs.close();
        pstmt.close();
        con.close();

        return product;

    }

    // 최저가격 , 최고가격을 전달받아 해당 가격범위에 속하는 상품정보 반환

    public List<Product> getProductByPrice(int minPrice, int maxPrice) throws SQLException {
        String sql = """
                     select  
                    prod_no , prod_name , prod_maker ,
                    prod_price, prod_discount_price , prod_stock,
                    prod_sold_out , prod_created_date , prod_update_date
                from 
                    sample_products
                where 
                    PROD_PRICE BETWEEN ? AND ?
                order by
                    prod_no    
                """;

        List<Product> productList = new ArrayList<Product>();

        Connection con = getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);

        pstmt.setInt(1, minPrice);
        pstmt.setInt(2, maxPrice);

        // 쿼리 결과물 담기
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            int no = rs.getInt("prod_no");
            String name = rs.getString("prod_name");
            String maker = rs.getString("prod_maker");
            int price = rs.getInt("prod_price");
            int discountPrice = rs.getInt("prod_discount_price");
            int stock = rs.getInt("prod_stock");
            String soldOut = rs.getString("prod_sold_out");
            Date createdDate = rs.getDate("prod_created_date");
            Date updateDate = rs.getDate("prod_update_date");

            Product product = new Product();
            product.setNo(no);
            product.setName(name);
            product.setMaker(maker);
            product.setPrice(price);
            product.setDiscountPrice(discountPrice);
            product.setStock(stock);
            product.setSoldOut(soldOut);
            product.setCreatedDate(createdDate);
            product.setUpdateDate(updateDate);

            // ArrayList에 담음
            productList.add(product);
        }
        rs.close();
        pstmt.close();
        con.close();

        return productList;
    }

    // 신규 상품정보 저장

    /**
     * 반환타입 : void 메서드 이름 : insertProduct 매개변수 :  Product product
     */

    public void insertProduct(Product product) throws SQLException {
        String sql = """
                INSERT INTO sample_products
                        ( prod_no , prod_name , prod_maker ,
                        prod_price, prod_discount_price , prod_stock)
                VALUES
                        (?,?,?,?,?,?)
                """;

        Connection con = getConnection();

        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, product.getNo());
        pstmt.setString(2, product.getName());
        pstmt.setString(3, product.getMaker());
        pstmt.setInt(4, product.getPrice());
        pstmt.setInt(5, product.getDiscountPrice());
        pstmt.setInt(6, product.getStock());

        // 변경된거 적용
        pstmt.executeUpdate();

        pstmt.close();
        con.close();
    }

    // 상품번호를 전달받아 해당 상품정보 삭제

    /**
     * 메서드 이름 : deleteByNo 반환 타입 : void
     *
     * @param prodNo
     */
    public void deleteByNo(int prodNo) throws SQLException {

        String sql = """
                delete from sample_products
                where
                    PROD_NO = ?
                """;

        Connection con = getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);

        pstmt.setInt(1, prodNo);
        pstmt.executeUpdate();

        pstmt.close();
        con.close();


    }

    // 상품번호  전달받아 상품의 가격 , 할인가격수정 기능

    /**
     * 반환타입 void 메서드명 setUpdateFromNotoprice 매개변수 int prodNo ,int prodPrice , int prodDiscountPrice
     */

    public void setUpdateFromNotoPrice(int prodNo, int prodPrice, int prodDiscountPrice) throws SQLException {

        String sql = """
                update sample_products
                set
                    PROD_PRICE = ? ,
                    PROD_DISCOUNT_PRICE = ?
                where 
                    PROD_NO = ?    
                """;

        Connection con = getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);

        pstmt.setInt(1, prodPrice);
        pstmt.setInt(2, prodDiscountPrice);
        pstmt.setInt(3, prodNo);

        pstmt.executeUpdate();

        pstmt.close();
        con.close();


    }

    // 상품번호 ,수량을 전달받아 해당상품의 수량을 변경하는 기능


    /**
     * 반환타입 void 메서드명 setUpdateByNo 매개변수 int prodNo , int prodStock
     *
     * @return
     */


    public void setUpdateByNo(int prodNo, int prodStock) throws SQLException {

        // 사용할 SQL 쿼리문
        String sql = """
                update SAMPLE_PRODUCTS
                set     
                    prod_stock = ?
                where 
                    prod_no = ?
                        """;

        /**
         * Java Database Connectivity
         * JDBC - 자바 프로그램에서 데이터베이스에 접속하고 상호작용 하기위한 API
         */

        // getConnection() 으로 Java 응용프로그램과 JDBC를 통해 DB연결
        // 이 연결을 con 에 할당함 이제 JDBC를 통해 데이터를 읽거나 사용할수 있다
        Connection con = getConnection();

        // 쿼리문을 (sql)를 PrepareStatement에 담음
        PreparedStatement pstmt = con.prepareStatement(sql);

        pstmt.setInt(1, prodStock);
        pstmt.setInt(2, prodNo);

        // 변경사항이 있다면 적용하기위해 executeUpdate() 메서드를 사용
        pstmt.executeUpdate();

        pstmt.close();
        con.close();

    }


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
