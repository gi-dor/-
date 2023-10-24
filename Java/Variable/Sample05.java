package Java.Variable;

public class Sample05 {
    public static void main(String[] args) {

        		/*
		 * 문자열은 1글자 이상의 문자를 표현하는 자료형이다.
			문자열은 " " 사이에 표시한다.
			문자열은 1글자 이상으표현 되기 때문에 문자열을 대상으로 다양한 작업을 수행할 필요가 있다.

			(길이 조회하기 , 특정 문자열이 포함되어 있는지 , 조회하기 , 특정위치 파악 문자 알아내기
			특정 문자열로 시작하거나 끝나는지 알아내기 , 대 / 소문자로 변환하기
			특정 시간 위치부터 지정된 위cl까지 잘라 내기
			특정 문자열을 다른 문자열로 변경하기...)
		 *
		 *
		 * Java는 문자열을 표현하고 문자열을 조작하는 다양한 기능을 포함하고 있는 String 클래스 (설계도)를 제공한다.
		 */

        /*
         *  String s1 = "홍길동";
         *  String s2 = "서울특별시 종로구 ";
         *  String s3 = "홍길동 , 김유신 , 김시민 , 곽재우";
         *  String s4 = "010-1234-9876";
         *	String s5 = "A";
         * 	String s6 = 'A'; // 오류 , 문자 타입의 값은 String 변수에 담을수 없다
         *
         * char c1 ='A';
         * char c2 = "A"; // 오류 , 문자열 타입의 값은 char에 담을수 없다
         *
         */

        String s1 = "홍길동";
        String s2 = "서울 특별시 종로구";
        String s3 = "홍길동 , 김유신 , 김시민 , 곽재우";
        String s4 = "010 - 123 - 6294";
        String s5 = "A";
//		String s6 = 'A';  //  Error : Type mismatch: cannot convert from char to String

        // 각각의 변수에 저장된 문자열 출력
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);

        // 각각의 변수에 저장된 문자열의  길이를 출력한다
        System.out.println(s1.length());
        System.out.println(s2.length());
        System.out.println(s3.length());



    }
}
