//인터페이스를 구현한 클래스 작성하기
public class ProductRowMapper implements RowMapper<product> {

    // 전달받은 ResultSet 객체에서 현재 커서가 위치한 행의 데이터를 가져와서
    // Product 객체를 생성해서 담고 반환한다.
    
    public Product mapRow(ResultSet rs) {
        int no = rs.getInt("prod_no");
        String name = rs.getString("prod_name");
        String maker = rs.getString("prod_maker");
        .....



        Product product = new Product();
        product.setNo(no);
        product.setName(name);
        product.setMaker(maker);
        ....


             return product;
        }
    }

// 인터페이스를 구현한 구현 클래스를 작성하지않고 익명 객체

        RowMapper<product> rwNapper = new RowMapper<Product>() {
                public Product mapRow(ResultSet rs) {
                product product = new Product();
                Product.setNo(rs.getInt("prod_no"));
                Product.setName(rs.getString("prod_no"));
                Product.setMaker(rs.getInt("prod_no"));
                
                }
        };

// 인터페이스를 구현한 클래스를 구현하지않고 , 람다식으로 익명객체 생성

        RowMapper<Product> rowMApper = x -> {
        Product product = new Ppoduct();
        product.setNo(x.getInt("Prod_no"));
        product.setName(x.getString("prod_name");
        ...
        return Product;
        };

        public List<Product> getAllProducts() {
            String sql =="""
                select prod_no ,prod_name,
                prod_maker, prod_price....
                from sample_products
                order by prod_no desc
                """;
    }

    }

