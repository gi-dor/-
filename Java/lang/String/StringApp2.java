package Java.lang.String;

public class StringApp2 {
    public static void main(String[] args) {

        // String클래스의 주요 메서드

        /*
         * int length()
         * - 문자열의 길이를 반환'
         *
         *
         */
        String s3 = "안녕하세요";
        String s4 = "";
        String s5 = "    ";
        System.out.println("길이1 : " + s3.length());
        System.out.println("길이1 : " + s4.length());
        System.out.println();

        /*
         * booleanb isEmpty()
         * 빈문자열 일 경우 true반환
         * 빈문자열 => ""
         * 빈문자열은 길이가 0 인 문자열
         */
        System.out.println("빈 문자열인가 ?" + s3.isEmpty());
        System.out.println("빈 문자열인가 ?" + s4.isEmpty());
        System.out.println("빈 문자열인가 ?" + s5.isEmpty());
        System.out.println();


        /*
         * boolean isBlank()
         * 빈문자열이거나 white space로만 구성된 문자열인 경우 true반환
         */
        System.out.println("빈 문자열인가 ?" + s3.isBlank());
        System.out.println("빈 문자열인가 ?" + s4.isBlank());
        System.out.println("빈 문자열인가 ?" + s5.isBlank());
        System.out.println();

        /*
         * boolean contains(CharSequence s)
         * 문자열이 지정된 문자열을 포함하고 있으면 true 를 반환한다
         */

        String str6 = "ERP 코퍼레이션";
        System.out.println("문자열을 포함하는가 : " + str6.contains("코퍼"));

        /*
         * boolean startsWith(String prefix)
         * 문자열이 지정된 prefix를 포함하고 있으면 true반환
         *
         */
        String str7 = "http://projectSyuSyu/syusyu/notice";
        String str8 = "https://localhost/8080/intdex.html";
        String str9 = "https://kmooc.udemy.com/organization/home/";

        System.out.println("문자열이 https 시작 하는가 :" + str7.startsWith("https"));
        System.out.println("문자열이 https 시작 하는가 :" + str8.startsWith("https"));
        System.out.println("문자열이 http 시작 하는가 :" + str9.startsWith("http"));
        System.out.println();


        /*
         * boolean endWith(String suffix)
         * 문자 열이 지정된 suffix로 끝나면 truf로 반환
         */
        String str10 = "sample.hwp";
        String str11 = "sample2.xlsx";
        String str12 = "sample.xml";

        System.out.println("엑셀 파일인가 ? : " + str10.endsWith("xlsx"));
        System.out.println("엑셀 파일인가 ? : " + str11.endsWith("xlsx"));
        System.out.println("엑셀 파일인가 ? : " + str12.endsWith("xlsx"));
        System.out.println();


    }
}
