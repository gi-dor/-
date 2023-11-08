package Java.oop01.overloading;

public class Operator {
    // 오버로딩

    int add (int x, int y) {
        System.out.println("add ( int x , int y )");
        return x + y;
    }

    double add (int x, double y) {
        System.out.println("add (int x, double y)");
        return x + y;
    }

    double add (double x , double y) {
        System.out.println("add( double x , double y )");
        return x + y;
    }

    double add (double x , int y) {
        System.out.println("add (double x , int y )");
        return x + y;
    }
}
