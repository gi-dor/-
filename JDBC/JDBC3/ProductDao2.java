package JDBC.JDBC3;

import JDBC.helper.JdbcTemplate;
import JDBC.helper.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductDao2 {


    public List<Product> getAllProducts() {
        String sql = """
                select *
                from sample_products
                order by prod_no desc
                """;

        return JdbcTemplate.selectList(sql, new RowMapper<Product>() {

            @Override
            public Product mapRow(ResultSet rs) throws SQLException {
                Product product = new Product();
                product.setNo(rs.getInt("prod_no"));
                product.setName(rs.getString("prod_name"));
                product.setMaker(rs.getString("prod_maker"));
                product.setPrice(rs.getInt("prod_price"));
                product.setDiscountPrice(rs.getInt("prod_discount_price"));
                product.setStock(rs.getInt("prod_stock"));
                product.setSoldOut(rs.getString("prod_sold_out"));
                product.setCreatedDate(rs.getDate("prod_created_date"));
                product.setUpdateDate(rs.getDate("prod_updated_date"));

                return product;
            }
        });

    }

    public Product getProductByNo(int no) {

        String sql = """
                select * 
                from sample_products
                where prod_no = ?
                """;
        return JdbcTemplate.selectOne(sql, rs -> {
            Product product = new Product();
            product.setNo(rs.getInt("prod_no"));
            product.setName(rs.getString("prod_name"));
            product.setMaker(rs.getString("prod_maker"));
            product.setPrice(rs.getInt("prod_price"));
            product.setDiscountPrice(rs.getInt("prod_discount_price"));
            product.setStock(rs.getInt("prod_stock"));
            product.setSoldOut(rs.getString("prod_sold_out"));
            product.setCreatedDate(rs.getDate("prod_created_date"));
            product.setUpdateDate(rs.getDate("prod_updated_date"));

            return product;
        }, no);
    }

    public List<Product> getProductsByPrice(int minPrice, int maxPrice) {
        String sql = """
                select * 
                from sample_products
                where prod_price BETWEEN ? and ?
                order by prod_price asc
                """;

        JdbcTemplate.selectList(sql, rs -> {
            Product product = new Product();
            product.setNo(rs.getInt("prod_no"));
            product.setName(rs.getString("prod_name"));
            product.setMaker(rs.getString("prod_maker"));
            product.setPrice(rs.getInt("prod_price"));
            product.setDiscountPrice(rs.getInt("prod_discount_price"));
            product.setStock(rs.getInt("prod_stock"));
            product.setSoldOut(rs.getString("prod_sold_out"));
            product.setCreatedDate(rs.getDate("prod_created_date"));
            product.setUpdateDate(rs.getDate("prod_updated_date"));

            return product;

        }, minPrice, maxPrice);
        return null;
    }

    public void insertProduct(Product product) {
        String sql = """
                insert into
                    sample_products
                (prod_no , prod_name , prod_maker , prod_price,
                prod_discount_price,prod_stock)
                values
                (?,?,?,?,?,?)
                """;

        JdbcTemplate.insert(sql, product.getNo(), product.getName(),
                product.getMaker(), product.getPrice(),
                product.getDiscountPrice(), product.getStock());
    }

    public void updateProductPrice(int no, int price, int discountPrice) {

        String sql = """
                Update sample_products
                set
                    prod_price = ?,
                    prod_discount_price = ?,
                    prod_updated_date = sysate
                where
                    prod_no = ?
                """;
        JdbcTemplate.update(sql, price, discountPrice, no);

    }

    public void updateProductStock(int no, int stock) {

        String sql = """
                Update sample_products
                set
                    prod_stock = ?,
                    prod_updated_date = sysdate
                where 
                    prod_no = ?
                """;
        JdbcTemplate.update(sql, stock, no);
    }

    public void deleteProductByNo(int no) {

        String sql = """
                delete sample_products
                where prod_no = ?
                """;

        JdbcTemplate.delete(sql, no);
    }


}
