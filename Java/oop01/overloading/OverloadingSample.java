package Java.oop01.overloading;

public class OverloadingSample {

    public static void main(String[] args) {

        // Operator 객체 생성
        Operator o = new Operator();

        o.add(5,3);
        o.add(5,0.9);
        o.add(5.2,12);
        o.add(3.14 , 6.30);
        System.out.println();

        int x = o.add(5,3);
        double y = o.add(5,0.9);
        double z = o.add(5.2,12);
        double c = o.add(3.14 , 6.30);

        System.out.println("x의 값 " +x);
        System.out.println("y의 값 " +y);
        System.out.println("z의 값 " +z);
        System.out.println("c의 값 " +c);

    }
}
