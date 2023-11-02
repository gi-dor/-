package Java.oop01.constructor;

public class Product {
    // 제품 클래스

    // 멤버변수
    int no;			// 제품번호
    String name;	// 제품이름
    String maker;	// 제조사
    int price;		// 제품 가격
    int stock;		// 재고
    boolean soldOut;// 품절 유무



    // 기본 생성자
    /*
     * 매개변수가 하나도 없는 생성자 메서드
     * 컴파일러가 자동으로 추가한다 , 소스코드로 실행파일을 만들 때 실행 파일에 자동으로 추가한다.
     *   + 클래스에 정의된 생성자 메서드가 '하나도 없는 경우에만'
     * 다른 생성자가 존재한다면 자동으로 추가 해주지 않으니 직접 추가하자 !
     */

    public Product() {
//		System.out.println("Product() 실행됨...");
    }




    // 생성자 메서드 중복정의
    /*
     * 기본생성자 메서드  (매개변수가 하나도 없는 생성자) 말고
     * 매개변수를 가지는 생성자 메서드를 여러개 중복 정의할 수 있다.
     */

    public Product (int no , String name  ,int price) {
        this.no = no;
        this.name =  name;
        this.price =  price;
        this.maker = "삼성";
        this.stock = 10;
        this.soldOut = false;
    }


    public Product(int no , String name , String maker , int price ) {
//		System.out.println("Product(int , String , String , int , int) 실행됨..");
        // no , name , maker , price로 만 객체 생성
        // stock , soldOut은 기본값을 줬음
        this.no = no;
        this.name = name;
        this.maker = maker;
        this.price = price;
        this.stock = 10;
        this.soldOut = false;
    }


    // 객체 생성시 품절 유무빼고
    // 나머지 로 객체생성 하려고 만들었음.
    public Product(int no , String name , String maker , int price , int stock) {
        this.no = no;
        this.name = name;
        this.maker = maker;
        this.price = price;
        this.stock = stock;
        this.soldOut = false;
    }


    // 멤버 메서드 정의하기
    public void printProduct() {
        System.out.println("상품 번호 : "+ no);
        System.out.println("상품 이름 : "+name);
        System.out.println("제조 회사 : "+maker);
        System.out.println("판매 가격: "+price);
        System.out.println("재고 수량 : "+stock);
        System.out.println("재고 여부: "+soldOut);
        System.out.println();
        System.out.println();
    }
}
