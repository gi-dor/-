package Java.collection.map;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesApp1 {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        /*
        Properties
            - Map 인터페이스의 구현체
            - key 와 value 의 타입이 String이다
            - .properties 파일을 읽어서 설정 정보를 key, value의 형태로 저장한다


            - void load(InputStrem in) , void load(Reader reader)
                + 지정된 스트림으로 .properties 파일을 읽어서 key , value 쌍으로 분석
            - String getProperty (String key)
                + 지정된 key에 해당하는 value 반환
            - String getProperty(String key, String dsfaultValue)
                + 지정된 key에 해당하는 value반환
                + 지정된 key에 해당하는 value가 존재하지 않으면 지정된 dafaultValue 반환
             - void setProperty(String key,String value)
                + 지정된 key , value 쌍의 값을 저장
             - void store(OutputStream out , String comment)
             - void store(Writer writer , String comment)
                + 지정된 스트림으로 Properties 객체의 key , value쌍의 값 저장
         */

        Properties prop = new Properties();
        prop.load(new FileReader(
                "C:/Users/Han/IdeaProjects/HTA/out/production/HTA/Java/collection/map/config.properties"));
//        prop.load(new FileReader(
//                "C:/Users/Han/IdeaProjects/HTA/out/production/HTA/Java/collection/map/config.properties"));

        // 설정 정보 조회하기
        String ip = prop.getProperty("email.server.ip");
        String port = prop.getProperty("email.server.port");
        String user = prop.getProperty("email.server.user");
        String password = prop.getProperty("email.server.password");

        System.out.println("ip 주소 : " + ip);
        System.out.println("포트번호 : " + port);
        System.out.println("접속 아이디 : " + user);
        System.out.println("접속 비밀번호 : " + password);
    }
}
