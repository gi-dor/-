package Java.lang.wrapper;

public class WrapperApp3 {

    public static void main(String[] args) {

        /*
        문자열을 숫자(정수, 실수)로 변환하기
            - Wrapper 클래스의 정적 메서드를 활용하면 문자열을 숫자로 변환할 수 있다

            int Integer.parseInt(String str)
            long Long.parseLong(String str)
            double Double.parseDouble(String str)

            Integer Integer.valueOf(String str)
            Long Long.valueOf(String str)
            Double Double.valueOf(String str)

         숫자를 문자열로 변환하기
            - String 클래스 정적메서드를 활용하면 문자열로 변환할 수 있다.
                String String.valueOf(int value)
                String String.valueOf(long value)
                String String.valueOf(double value)
         */

        int a = Integer.parseInt("123");
        System.out.println(a);

        long b = Long.parseLong("10000000");
        System.out.println(b);

        double c = Double.parseDouble("3.141592");

        System.out.println(c);

        Integer d = Integer.parseInt("1000");
        int e = Integer.parseInt("1000");

        System.out.println(d);
        System.out.println(e);

//        오토박싱과 클래스 형변환이 활용되었음
        Object x = 10;
        System.out.println(x); // 10 출력
        /*
        Oject x = 10;

        x가 Ojbject 타입의 참조변수 때문에 Integer 객체가 생성됨 - 오토박싱
                        = new Integer(10);

        x가 Object 타입이기 때문에 Integer 객체의 주소 값이 아니라
                                Integer 객체의 Object 객체주소 값이
                                              x에 대입된다 - 클래스 형변환
        Object x = new Integer(10)

         */

    }
}
