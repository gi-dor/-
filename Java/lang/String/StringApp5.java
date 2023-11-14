package Java.lang.String;

public class StringApp5 {
    public static void main(String[] args) {

        /*
         * String toUpperCase()
         * 	` 문자열의 내용을 참조해서 대문자로만 구성된 새 문자열객체를 반환
         *
         *
         *
         *
         * String toLowerCase()
         * 	` 문자열의 내용을 참조해서 소문자로만 구성된 새 문자열 객체를 반환
         *
         */

        String str1 = "Hello Eclipse";
        String str2 = str1.toUpperCase();
        String str3 = str1.toLowerCase();

        System.out.println("원본 문자열 : " + str1);
        System.out.println("새로운 문자열 : " + str2);
        System.out.println("새로운 문자열 : " + str3);
        System.out.println();

        /*
         * String replace(String searchStr,String replaceStr)
         *
         *	` searchStr에 해당하는 문자열이 replaceStr로 대체된 새문자열을 반환한다
         *
         * */

        String str4 = "The red House's color is red";
        String str5 = str4.replace("red", "Gray");
        System.out.println("원본 문자열 : " + str4);
        System.out.println("새로운 문자열 : " + str5);
        System.out.println("===============================================");


        /*
         * String replaceAll(String regex , String replacement)
         * 	` 문자열에서 지정된 정규표현식 패턴에 해당하는 부분을 replacement에서
         * 	` 지정한 문자열을 대체한 새 문자열을 반환 한다
         */

        String str6 = "Red house's color is red";
        String str7 = str6.replace("red", "green");
        String str8 = str6.replaceAll("/red/i", "green");
        System.out.println("새로운 문자열 : " + str7);
        System.out.println("새로운 문자열 : " + str8);

        /*
         * String trim()
         * 	` 문자열에서 불필요한 좌우 공백이 제거된 문자열을 반환
         *
         * String strip()
         * 	` 문자열에서 불필요한 좌우 공백이 제거된 새문자열을 반환
         *
         * String stripLeading()
         * 	` 문자열에서 왼쪽 공백이 제거된 새 문자열 반환
         *
         * String stripTrailing()
         * 	` 문자열에서 오른쪽 공백이 제거된 새 문자열 반환
         */

        String str9 = "    반갑 습니다      입니다      ";
        String str10 = str9.trim();
        String str11 = str9.strip();
        String str12 = str9.stripLeading();
        String str13 = str9.stripTrailing();

        System.out.println("원본 문자열 : [" + str9 + "]");
        System.out.println("새로운 문자열1 : [" + str10 + "]");
        System.out.println("새로운 문자열2 : [" + str11 + "]");
        System.out.println("새로운 문자열3 왼쪽 공백제거: [" + str12 + "]");
        System.out.println("새로운 문자열4 오른쪽 공백제거: [" + str13 + "]");
    }
}
