package dao;

import com.ibatis.sqlmap.client.SqlMapClient;
import ibatis.IbatisUtil;
import java.sql.SQLException;
import java.util.List;
import vo.Company;
import vo.Event;
import vo.Product;
import vo.ProductCategory;
import vo.ProductEvent;
import vo.ProductStatus;

public class ProductDao {


    private SqlMapClient ibatis = IbatisUtil.getSqlMapClient();

    public List<ProductCategory> getAllProductCategories() throws SQLException {
        return (List<ProductCategory>) ibatis.queryForList("products.getAllProductCategories");
    }

    public List<Company> getAllCompanies() throws SQLException {
        return (List<Company>) ibatis.queryForList("products.getAllCompanies");
    }

    public List<ProductStatus> getAllProductStatus() throws SQLException {
        return (List<ProductStatus>) ibatis.queryForList("products.getAllProductStatus");
    }


    public List<Event> getAllEvents() throws SQLException {
        return (List<Event>) ibatis.queryForList("products.getAllEvents");
    }

    /**
     * 새상품의 상품번호로 사용할 시퀀스 번호를 조회해서 반환
     *
     * @return 새상품 번호
     * @throws SQLException
     */
    public int getProductNo() throws SQLException {
        return (Integer) ibatis.queryForObject("products.getProductNo");
    }


    /**
     * 새상품 정보를 전달받아 데이터 베이스에 저장
     *
     * @param product 새상품정보(본허 , 이름 , 카테고리 , 제조사 , 상태 , 가격 , 할인가격 , 설명)
     * @throws SQLException
     */
    public void insertProduct(Product product) throws SQLException {
        ibatis.insert("products.insertProduct", product);
    }

    /**
     * 새상품과 관련된 이벤트 정보를 전달받아 데이터베이스에 저장
     *
     * @param event 새상품 이벤트 정보 (상품번호 , 이벤트 번호)
     * @throws SQLException
     */
    public void insertProductEvent(ProductEvent event) throws SQLException {
        ibatis.insert("products.insertProductEvent", event);
    }

    public List<Product> getAllProducts() throws SQLException {
        return (List<Product>) ibatis.queryForList("products.getAllProducts");
    }


    /**
     * 지정된 상품번호의 상세 정보를 조회해서 반환
     *
     * @param no 조회할 상품 번호
     * @return 상품정보
     * @throws SQLException
     */
    public Product getProductByNo(int no) throws SQLException {
        return (Product) ibatis.queryForObject("products.getProductByNo", no);
    }


    /**
     * 지정된 상품번호의 상품과 관련된 모든 이벤트를 조회해서 반환
     *
     * @param ProductNo 상품번호
     * @return 해당상품과 관련된 이벤트 목록
     * @throws SQLException
     */
    public List<Event> getEventByProductNo(int productNo) throws SQLException {
        return (List<Event>) ibatis.queryForList("products.getEventByProductNo", productNo);
    }


    /**
     * 수정된 상품정보가 포함된 정보를 전달받아서 반영시킨다
     *
     * @param product 수정된 상품정보가 포함된 Product 객체
     * @throws SQLException
     */
    public void updateProduct(Product product) throws SQLException {
        ibatis.update("products.updateProduct", product);
    }

    /**
     * 지정된 상품번호로 등록된 모든 이벤트를 삭제한다
     *
     * @param productNo 이벤트를 삭제할 상품번호ㅇ
     * @throws SQLException
     */
    public void deleteProductEventsByProductNo(int productNo) throws SQLException {
        ibatis.delete("products.deleteProductEventsByProductNo", productNo);
    }
}
