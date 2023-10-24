package Java.Variable;

public class Sample08 {
    public static void main(String[] args) {
        /*
         * 정수타입과 문자타입간의 형변환
         *
         * char c1 = 65;	// 유니코드 65번에 해당하는 문자값이 대입이 된다.
         * int number1 = 'A';
         *
         */

        char c1 = 65;
        System.out.println("c1 : "+c1);

        int number1 = 'A';
        System.out.println("number : "+number1);

        byte x = 10;
        int y = x;
        System.out.println(y);

        double d1 = 3.14;
        float fy = (float)d1;
        System.out.println("fy :"+fy);

        double dx = 10;
        int ix = (int)3.14;

        System.out.println("dx : "+dx);
        System.out.println("ix : "+ix);
    }
}
