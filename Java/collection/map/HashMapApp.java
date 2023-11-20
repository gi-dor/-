package Java.collection.map;

import java.util.HashMap;
import java.util.Map;

public class HashMapApp {

    public static void main(String[] args) {

        /*
        Map <K , V >
            - key , value의 쌍으로 객체를 저장할수 있는 객체
            - 메서드
                . put( k key , v value)
                    Map 객체에 key, value의 쌍으로 객체를 저장시킨다
                . get(K key)
                    Map 객체에 key에 해당하는 value 객체를 조회
                    key가 존재하지 않으면 null 반환
                . remove(Object key)
                    Map 객체에 key에 해당하는 Entry를 삭제한다
                . boolean containsKey(Object key)
                    지정된 key가 존재하는지 조회한다
                . set<key> keySet()
                    Map의 모든 key를 Set 객체에 담아서 반환
                . Set<Entry <K,V>> entrySey()
                    Map에 저장된 모든 Entry 객체를 Set 객체에 담아서 반환

            - 주요 구현 클래스
            . HashMap   - 가장많이 사용되는 Map의 인터페이스 구현 클래스
            . HashTable - key 와 value로 null값을 허용하지 않음
            . TreeMap - key를 오름차순으로 정렬해서 관리한다
         */

        // key : 아이디  , value : 고갱명의 쌍으로 Entry가 구성되는 HashMap객체 생성하기
        Map<String, String> map1 = new HashMap<String, String>();

        // Map 객체에 새로운 Entry 저장
        map1.put("hong", "홍길동");
        map1.put("kim", "김유신");
        map1.put("Gil", "길태미");
        map1.put("Chuck", "척계광");

        System.out.println(map1);

        String value1 = map1.get("Gil");
        String value2 = map1.get("Chuck");
        String value3 = map1.get("Han");

        System.out.println(value1);
        System.out.println(value2);
        System.out.println(value3);

        // map 객체에서 지정된 key에 해당하는 Entry 삭제
        map1.remove("hong");

        // 이미 존재하는 key로 다시 값을 저장하면 기존 값을 덮어쓴다
        map1.put("kim", "김좌진");

        System.out.println(map1);   // {Chuck=척계광, Gil=길태미, kim=김좌진}


    }
}
