package Java.lang.wrapper;

public class IntegerApp1 {

    public static void main(String[] args) {

        /*
        Integer
            - int의 wrapper 클래스

            - 상수
                MAX_VALUE
                    int 기본 자료형의 최대값
                MIN_VALUE
                    int 기본 자료형의 최소값
            -  메서드
                클래스 메서드
                    int Integer.parseInt(String str)
                    전달받은 문자열(숫자로 구성된 문자열)

                    int Integer.parseInt(String str , int radix)
                    문자열과 진법을 전달받아서 정수로 변환해서 반환


                    -- 잘안쓰임 --
                    String toBinaryString(int i)
                    전달받은 정수를 2진수로 구성된 문자열로 반환
                    String toOctalString(int i)
                    전달받은 정수를 8진수로 구성된 문자열로 반환
                    String toHexString(int i)
                    전달받은 정수를 16진수로 구성된 문자열로 반환

                    static int min(int x, int y)
                    작은수 반환
                    static int max(int x , int y)
                    큰수 반환
                    static int sum (int x, int y)
                    합계 반환

                    static Integer valueOf(int i)
                    전달받은 정수를 포함하는 Integer 객체의 주소값을 반환

                    static Integer valueOf(String str)
                    정수(전달받은 문자열이 표현하는)를 포함한 Integer객체의 주소값을 반환

                    static Integer valueOf(String str, int radix)
                    정수(전달받은 문자열이 표현하는)를 포함하는 Integer 객체의 주소값을 반환

                멤버 메서드
                    int intValue()
                       Integer 객체가 가지고있는 정수값을 반환한다
                       오토 언박싱이 지원되면서 사용할 일이 거의 없음.

         */

        System.out.println("Integer.MAX_VALUE : " + Integer.MAX_VALUE);
        System.out.println("Integer.MIN_VALUE : " + Integer.MIN_VALUE);
        System.out.println();

        // 문자열을 정수로 변환하기
        int a = Integer.parseInt("100");
        int b = Integer.parseInt("34");
        int c = Integer.parseInt("100", 16);
        int d = Integer.parseInt("100", 10);
        int e = Integer.parseInt("100", 8);
        int f = Integer.parseInt("100", 2);

        System.out.println("parseInt()");
        System.out.println("a : " + a); // 100 대입
        System.out.println("b : " + b); // "34" 아닌 34가 대입된다
        System.out.println("16진수 100 : " + c);
        System.out.println("10진수 100 : " + d);
        System.out.println("8진수 100 : " + e);
        System.out.println("2진수 100 : " + f);

        // 각각 정수 123을 2진수 8진수 16진수 문자열로 변환
        String str1 = Integer.toBinaryString(123);
        String str2 = Integer.toOctalString(123);
        String str3 = Integer.toHexString(123);

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);

        // Integer 객체 생성하기
        Integer i1 = 100;
        Integer i2 = Integer.valueOf(100);
        Integer i3 = Integer.valueOf("100");
        Integer i4 = Integer.valueOf("100", 16);

        System.out.println(i1);
        System.out.println(i2);


    }
}
