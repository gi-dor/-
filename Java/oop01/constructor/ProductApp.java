package Java.oop01.constructor;

public class ProductApp {
    public static void main(String[] args) {
        // 객체 생성하기
        // 	클래스이름 참조변수 = new 생성자메서드();

        // 생성자 메서드
        // 	- 객체 생성 직후에 실행되는 메서드
        // 	- 객체 생성 직후에 수행할 작업을 정의하는 메서드
        //	- 클래스의 이름과 동일한 이름을 가지기 때문에
        //	- new 연산자는 생성자 메서드 이름으로 설계도(클래스)이름을 알 수 있다.
        //  - new 연산자는 설계도 이름에 해당하는 클래스를 메모리에 로딩하고 , 그 설계도로 객체를 생성한다
        //  - new 연산자는 객체 생성이 완료되면 생성자 메서드를 실행해서 객체에 대한 초기화 작업을 수행한다


        // Product의 기본 생성자 메서드 - default Constructor method
        Product p1 = new Product();
        p1.no = 100;
        p1.name = "아이폰15";
        p1.maker = "애플";
        p1.price = 1_500_000;
        p1.stock = 10;
        p1.soldOut = false;


        Product p2 = new Product();
        p2.no = 101;
        p2.name = "아이폰 15 Pro";
        p2.maker = "애플";
        p2.price = 1_700_000;
        p2.stock = 10;
        p2.soldOut = false;

        // Product의 매개변수 있는 생성자 메서드 사용
        Product p3 = new Product(103 , "갤럭시 S23" ,"삼성" ,  1_500_000 , 5 );
        Product p4 = new Product(104 , "갤럭시 폴더" ,"삼성" ,  1_900_000 , 10 );

    }
}
