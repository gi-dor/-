package Java.lang.String;

import java.util.Arrays;

public class StringApp7 {
    public static void main(String[] args) {

        /*
         * String[] split(String regax)
         * 	` 문자열을 지정된 구분문자로 잘라서 , 잘려진 각 문자열을 배열에 담아서 반환
         */

        String str = "곽재우,김유신,김시민,손권,태사자";
        String[] result = str.split(",");

        // 출력 1번방법
        System.out.println(result[0]);
        System.out.println(result[1]);
        System.out.println(result[2]);
        System.out.println(result[3]);
        System.out.println(result[4]);

        // 출력 2번방법
        System.out.println(Arrays.toString(result));

        // 출력 3번 방법
        for (String value : result) {
            System.out.println(value);
        }


    }
}
