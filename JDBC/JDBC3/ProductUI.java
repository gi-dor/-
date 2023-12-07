package JDBC.JDBC3;

import java.sql.SQLException;
import java.util.List;

public class ProductUI {
    private ProductDao productDao = new ProductDao();
    private Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("1.전체조회 2.상세조회 3.검색(가격) 4.신규등록 5.삭제 6.가격수정 7.재고수정 0.종료");
        System.out.println("----------------------------------------------------------------------------------");

        System.out.print("### 메뉴번호: ");
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
                    검색();
                    break;
                case 4:
                    신규등록();
                    break;
                case 5:
                    삭제();
                    break;
                case 6:
                    가격수정();
                    break;
                case 7:
                    재고수정();
                    break;
                case 0:
                    종료();
                    break;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("### 데이터베이스 작업중 오류 발생 신속히 처리하겠습니다");
        }
        System.out.println();
        System.out.println();
        System.out.println();

        showMenu();
    }

    private void 전체조회() throws SQLException {
        System.out.println("<< 전체 제품 조회 >>");

        List<Product> products = productDao.getAllProduct();

        if (products.isEmpty()) {
            System.out.println("### 제품이 존재 하지 않습니다");
            return;
        }
        System.out.println(
                "============================================================================================");
        System.out.println("번호\t\t제품명\t\t\t제조사\t\t금액\t\t할인금액 \t\t재고 \t 품절유무 \t제조날짜 \t 수정날짜");
        System.out.println(
                "============================================================================================");

        for (Product pr : products) {
            System.out.print(pr.getNo() + "\t\t");
            System.out.print(pr.getName() + "\t\t");
            System.out.print(pr.getMaker() + "\t");
            System.out.print(pr.getPrice() + "\t\t");
            System.out.print(pr.getDiscountPrice() + "\t\t");
            System.out.print(pr.getStock() + "\t");
            System.out.print(pr.getSoldOut() + "\t");
            System.out.print(pr.getCreatedDate() + "\t");
            System.out.println(pr.getUpdateDate() + "\t");
        }
    }

    private void 상세조회() throws SQLException {
        System.out.println("<< 제품 정보 상세 조회>>");
        System.out.println("### 제품의 번호를 입력해 상세정보를 확인");
        System.out.print("### 제품 번호 : ");

        int prodNo = scanner.nextInt();
        Product product = productDao.getProductByNo(prodNo);

        if (product == null) {
            System.out.println("### 제품번호 [ " + prodNo + "]제품 이 존재하지 않습니다,");
            return;
        }

        System.out.println("### 제품 상세조회");
        System.out.println();
        System.out.println("==============================================================");
        System.out.println("번호 : " + prodNo);
        System.out.println("제품명 : " + product.getName());
        System.out.println("제조사 : " + product.getMaker());
        System.out.println("가격 : " + product.getPrice());
        System.out.println("할인가격 : " + product.getDiscountPrice());
        System.out.println("재고갯수 : " + product.getStock());
        System.out.println("재고여부 : " + product.getSoldOut());
        System.out.println("제조일 : " + product.getCreatedDate());
        System.out.println("수정일 : " + product.getUpdateDate());

        System.out.println("==============================================================");
    }

    private void 검색() throws SQLException {
        System.out.println("가격을 입력받아 범위내의 제품 출력");
        System.out.println("### 최소 가격을 입력하세요");
        System.out.print("### A가격 : ");
        int minPrice = scanner.nextInt();

        System.out.println("### 최대 가격을 입력하세요");
        System.out.print("### B 가격 : ");
        int maxPrice = scanner.nextInt();

        List<Product> products = productDao.getProductByPrice(minPrice, maxPrice);
        System.out.println(
                "============================================================================================");
        System.out.println("번호\t\t제품명\t\t제조사\t\t금액\t\t할인금액 \t\t재고 \t 품절유무 \t제조날짜 \t 수정날짜");
        System.out.println(
                "============================================================================================");

        for (Product pr : products) {
            System.out.print(pr.getNo() + "\t\t");
            System.out.print(pr.getName() + "\t");
            System.out.print(pr.getMaker() + "\t");
            System.out.print(pr.getPrice() + "\t\t");
            System.out.print(pr.getDiscountPrice() + "\t\t");
            System.out.print(pr.getStock() + "\t");
            System.out.print(pr.getSoldOut() + "\t");
            System.out.print(pr.getCreatedDate() + "\t");
            System.out.println(pr.getUpdateDate() + "\t");
        }

    }

    private void 신규등록() throws SQLException {
        System.out.println("<<신규 제품 등록>>");
        System.out.println("### 신규 제품 정보를 입력하세요");

        System.out.print("### 번호 : ");
        int no = scanner.nextInt();

        System.out.print("### 제품 이름 : ");
        String name = scanner.nextString();

        System.out.print("### 제조사 : ");
        String maker = scanner.nextString();

        System.out.print("### 가격 : ");
        int price = scanner.nextInt();

        System.out.print("### 할인 가격 : ");
        int discountPrice = scanner.nextInt();

        System.out.print("### 재고 갯수 :");
        int stock = scanner.nextInt();

        Product product = new Product();
        product.setNo(no);
        product.setName(name);
        product.setMaker(maker);
        product.setPrice(price);
        product.setDiscountPrice(discountPrice);
        product.setStock(stock);

        productDao.insertProduct(product);
        System.out.println("### 신규 제품이 등록 되었습니다.");
    }

    private void 삭제() throws SQLException {
        System.out.println("<< 제품 정보 삭제 >>");
        System.out.println("### 제품의 정보를 입력받아 삭제하겠습니다");

        System.out.print("### 제품정보 : ");
        int prodNo = scanner.nextInt();
        productDao.deleteByNo(prodNo);
        System.out.println("### 제품번호 [ " + prodNo + "]");
        System.out.println("### 삭제가 완료 되었습니다");
    }

    private void 가격수정() throws SQLException {
        System.out.println("<< 제품의 가격 수정 >>");
        System.out.println("### 상품번호를 전달받아 해당상품의 가격 과 할인가격을 변경");

        System.out.print("### 상품 번호 : ");
        int prodNo = scanner.nextInt();

        System.out.print("### 변경할 가격 : ");
        int prodPrice = scanner.nextInt();

        System.out.print("### 변경할 할인 가격 : ");
        int prodDiscountPrice = scanner.nextInt();

        productDao.setUpdateFromNotoPrice(prodNo, prodPrice, prodDiscountPrice);
        System.out.println("### 가격 및 할인가 변경 되었습니다");
    }

    private void 재고수정() throws SQLException {
        System.out.println("<< 제품의 재고량 수정 >>");
        System.out.println("### 상품번호 ,수량을 전달받아 해당상품의 수량을 변경");

        System.out.print("### 상품 번호 : ");
        int prodNo = scanner.nextInt();

//        System.out.println("### 기존 재고 수량");
//        int prevProdStock = scanner.nextInt();

        System.out.print("### 변경할 재고 수량 : ");
        int prodStock = scanner.nextInt();

        productDao.setUpdateByNo(prodNo, prodStock);

        System.out.println("### 재고량 수정했습니다");

    }

    private void 종료() {

        System.out.println("### 프로그램 종료 하겠습니다");
        System.exit(0);
    }

    public static void main(String[] args) {
        new ProductUI().showMenu();
    }
}
