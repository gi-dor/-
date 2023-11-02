package Java.oop01.constructor.practice;

public class ProductEx {

    // 제품 클래스

    // 멤버변수
    int no;			// 제품번호
    String name;	// 제품이름
    String maker;	// 제조사
    int price;		// 제품 가격
    int stock;		// 재고
    boolean soldOut;// 품절 유무

    ProductEx(){}	// 기본생성자

    // 생성자
    // Source - Generate Constructor
    // 매개변수로 번호 , 이름 , 제조사 , 가격 , 수량 받아서 만드려고
    public ProductEx(int no, String name, String maker, int price, int stock) {
        super();
        this.no = no;
        this.name = name;
        this.maker = maker;
        this.price = price;
        this.stock = stock;
        this.soldOut = false;
    }

    public ProductEx(int no , String name , String maker , int price ) {
        // no , name , maker , price로 만 객체 생성
        // stock , soldOut은 기본값을 줬음
        // 객체 생성시
        // ProductEx pex = new ProductEx(17 , "모니터" , "삼성" , 10);
        this.no = no;
        this.name = name;
        this.maker = maker;
        this.price = price;
        this.stock = 10;
        this.soldOut = false;
    }

    // 마찬가지로 제품의 번호 , 이름 , 가격 만 주고
    // 기본 값으로 제조사와 재고수량 품절유무를 직접 주고있다
    public ProductEx (int no , String name  ,int price) {
        this.no = no;
        this.name =  name;
        this.price =  price;
        this.maker = "삼성";
        this.stock = 10;
        this.soldOut = false;
    }


    // 출력메서드
    void printProductEx() {
        System.out.println();
        System.out.println("상품 번호 : "+ no);
        System.out.println("상품 이름 : "+ name);
        System.out.println("제조사 : "+ maker);
        System.out.println("가격 : "+ price);
        System.out.println("재고 수량 : "+ stock);
        System.out.println("재고 여부 : "+ soldOut);
        System.out.println();
    }
}
