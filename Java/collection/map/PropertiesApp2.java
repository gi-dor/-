package Java.collection.map;

import java.io.FileReader;
import java.text.MessageFormat;
import java.util.Properties;

public class PropertiesApp2 {

    public static void main(String[] args) throws Exception {

        Properties prop = new Properties();
        prop.load(new FileReader(
                "C:/Users/Han/IdeaProjects/HTA/out/production/HTA/Java/collection/map/config.properties"));

        /*
        MessageFormat
            - 사용자에게 표시될 메시지를 생성하는 클래스
            - 지정된 문자열을 텍스트 패턴의 적절한 위치에 삽입
                MessageFormat.format("{0} 님 안녕하세요. 고객님의 등급은 {1} 입니다" , name , grade );

            - 메서드
                String MessageFormat.format(String pattern ,  Object....atgs)
                - 패턴 문자열의 지정된 위치에 값을 삽입 시킨 문자열을 반환
         */

        String grade = "gold";
        int orderPrice = 200000;

        String key = MessageFormat.format("customer.{0}.depositRate", grade);

        System.out.println(key);
        String value = prop.getProperty(key);
        double depositRate = Double.parseDouble(value);

        int point = (int) (orderPrice * depositRate);

        System.out.println("적립포인트 : " + point);

    }


}
