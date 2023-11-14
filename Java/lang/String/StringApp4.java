package Java.lang.String;

public class StringApp4 {

    public static void main(String[] args) {
        /*
         * String substring(int beginIndex)
         * 	` 지정된 시작위치 ~ 문자열의 끝 범위에 해당하는 문자열로 구성된 새 문자열을 반환
         *	` 문자열의 인덱스는 0 부터 시작
         *	` beginIndex는 포함
         *
         * String substring(int beginIndex , int endIndex)
         * 	` 지정된 시작위치 ~ 끝위치 범위에 해당하는 문자열로 구성된 새 문자열을 반환
         * 	` beginIndex는 포함 , endIndex는 포함되지 않는다
         */

        String str1 = "ERP 코퍼레이션";

        String str2 = str1.substring(2);
        String str3 = str1.substring(2, 6);

        System.out.println(str2);
        System.out.println(str3);

        String str4 = "000305 - 3333852";

        String str5 = str4.substring(0, 2);
        System.out.println("태어난해 : " + str5 + " 년생");

        String str6 = str4.substring(2, 6);
        System.out.println("생일 : " + str6);


    }
}
