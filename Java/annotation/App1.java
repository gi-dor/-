package Java.annotation;

public class App1 {

    public static void main(String[] args) {

        Product p1 = new Product(1, "지우개", 1000);
        Product p2 = new Product(2, "샤프", 2000);
        CreatedAtAnnotationProcessor processor = new CreatedAtAnnotationProcessor();
        processor.process(p1);

        System.out.println(1);
        System.out.println(2);
    }
}
