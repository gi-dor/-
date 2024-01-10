package dao;

import com.ibatis.sqlmap.client.SqlMapClient;
import dto.Product;
import ibatis.IbatisUtil;
import java.sql.SQLException;
import java.util.List;

public class ProductDAO {

    private SqlMapClient ibatis = IbatisUtil.getSqlMapClient();

    public List<Product> getProducts() throws SQLException {
        return ibatis.queryForList("product.getProducts");
    }

    public void insertProduct(Product product) throws SQLException {
        ibatis.update("product.insertProduct", product);
    }

    public Product getProductByNo(int no) throws SQLException {
        return (Product) ibatis.queryForObject("product.getProductByNo", no);
    }

    public void deleteProductByNo(int no) throws SQLException {
        ibatis.delete("product.deleteProductByNo", no);
    }
}
