package Java.lang.String;

public class StringApp6 {
    public static void main(String[] args) {

        /*
         * char indexOf(String str)
         *	` 문자열에서 지정된 문자가 처음으로 등장하는 위치를 반환
         *	` 지정된 문자열을 찾을 수 없으면 -1 반환
         *
         *	int indexOf(String str, int fromIndex)
         *	`formIndex에 지정된 위치부터 문자열을 검색해서 등장위치를 반환한다.
         *
         *	int laseIndexOf(String str)
         *	` 문자열에서 지정된 문자열이 마지막으로 등장하는 위치를 반환한다
         *	` 지정된 문자열을 찾을 수 없으면 -1 을 반환
         *
         *	int laseIndexOf(String str, int fromIndex)
         */

        String str1 = "02)1234-5978";
        String str2 = "031)577-7777";

        // indexOf(")")는 문자열에서 ")"가 등장하는 위치값(index)을 반환한다.
        String strResult1 = str1.substring(0, str1.indexOf(")"));
        String strResult2 = str2.substring(0, str2.indexOf(")"));

        System.out.println("국번 : " + strResult1);
        System.out.println("국번 : " + strResult2);

        /*
         * char charAt(int index)
         * 	` 문자열에서 지정된 위치의 문자 하나를 반환한다
         */

        String str3 = "abcdefghij";
        char strResult3 = str3.charAt(0);
        char strResult4 = str3.charAt(1);
//		char strResult5 = str3.charAt(10);    java.lang.StringIndexOutOfBoundsException

        System.out.println("반환된 문자 : " + strResult3);
        System.out.println("반환된 문자 : " + strResult4);
//		System.out.println("반환된 문자 : "+strResult5);

    }
}
