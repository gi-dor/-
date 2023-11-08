package Java.oop01.method;


public class ParamReturn {

    /**
     *
     * @param x 매개변수 x
     * @param y 매개변수 y
     */
    void add(int x, int y){
        int z = x + y;
        System.out.println("int z " + z);
    }

    /**
     *
     * @param x 매개변수 실수 x
     * @param y 매개변수 실수 y
     */
    void add2(double x, double y){
        double z = x + y;
        System.out.println("double z = " + z);
    }

    /**
     *
     * @return return 값으로 "return getName"
     */
    String getName(){
        return "return getName!";
    }

    int getAge(){
        return 30;
    }
}
