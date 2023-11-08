package Java.oop01.static1;

public class CircleApp2 {
    public static void main(String[] args) {


        // 반지름만 전해주고 있음.
        Circle2 c1 = new Circle2(2);
        Circle2 c2 = new Circle2(3);
        Circle2 c3 = new Circle2(5);
        Circle2 c4 = new Circle2(6);
        Circle2 c5 = new Circle2(8);

        //
        System.out.println("원의 둘레 : "+ c1.around());
        System.out.println("원의 둘레 : "+ c2.around());
        System.out.println("원의 둘레 : "+ c3.around());
        System.out.println("원의 둘레 : "+ c4.around());
        System.out.println("원의 둘레 : "+ c5.around());
    }
}
