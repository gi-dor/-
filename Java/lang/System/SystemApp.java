package Java.lang.System;

import java.util.Properties;

public class SystemApp {
    public static void main(String[] args) {

        /*
         * long currentTimeMillis()
         * 유닉스 타임은 1970년1월1일0시0분0초부터 현재까지의 시간을
         * 1 /1000 단위로 표현한 것
         */
        long unixTime = System.currentTimeMillis();

        System.out.println("유닉스타임 : " + unixTime);

        Properties props = System.getProperties();
        System.out.println(props);

        /*
         * String getProperty(String name)
         *
         */
        String value1 = System.getProperty("user.language");
        String value2 = System.getProperty("user.country");
        String value3 = System.getProperty("user.name");
        String value4 = System.getProperty("user.home");
        String value5 = System.getProperty("user.dir");

        System.out.println("언어 : " + value1);                //		언어 : ko
        System.out.println("국가 : " + value2);                //		국가 : KR
        System.out.println("사용자 이름: " + value3);        //		사용자 이름: Han
        System.out.println("홈 디렉토리 경러 : " + value4);    //홈 디렉토리 경러 : C:\Users\Han
        System.out.println("현재 디렉토리 : " + value5);        // C:\workspace\Java-workspace\api


        /*
         *  System.getenv(String name)
         *  지정된 이름에 해당하는 환경 변수 값 반환
         */

        String env1 = System.getenv("JAVA_HOME");
        String env2 = System.getenv("PATH");
        String env3 = System.getenv("TEMP");

        System.out.println("자바 홈 디렉토리 : " + env1);    // 자바 홈 디렉토리 : C:\Program Files\Java\jdk-17
        System.out.println("path 설정된 경로  : " + env2);
        System.out.println("임시 디렉토리 경로 : " + env3);    // 임시 디렉토리 경로 : C:\Users\Han\AppData\Local\Temp
    }
}
