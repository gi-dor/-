package Java.collection;

import java.util.HashSet;
import java.util.stream.Stream;

public class HashSetApp1 {
    public static void main(String[] args) {

        /*
        HashSet<E>
            - Set<E> 인터페이스를 구현한 자료구조 구현 클래스
            - 중복된 객체의 저장을 허용하지 않는 자료구조 구현 클래스
            - 객체의 동일성 비교를 구현하기 위해 equals() , hashcode() 메서드를
            - 재 정의할 필요가 있다 (HashSet<E> 에 저장되는 객체가 구현 해야함)
            - String Wrapper 클래스는 equals() 와 hashCode()가 이미 재정의 되어있다
            */

        // String 객체를 저장하는 HashSet 객체 생성
        HashSet<String> set = new HashSet<String>();

        // boolean add(E e) 메서드를 사용해 HashSet 객체에 String 객체에 저장하기
        set.add("하나");
        set.add("둘");
        set.add("셋");
        set.add("넷");
        set.add("다섯");
        set.add("여섯");
        set.add("여섯");  // 중복 저장안된
        set.add("여섯");  // 중복 저장안된
        set.add("여섯");  // 중복 저장안된

        // int size() 메서드를 사용해 HahSet 객체에 저장된 객체 갯수 조회
        int size = set.size();
        System.out.println("저장된 객체의 갯수 : " + size); // 6 출력됨

        // 향상된 for문을 사용해 HashSet 객체에 저장된 객체들을 하나씩 처리하기
        // HashSet은 index가 없다 , 일반 for문으로 HashSet객체에 저장된 값들을 처리할수 있다

        for (String name : set) {
            System.out.println(name);
        }

        // Stream 을 사용해서 HashSet객체에 저장된 객체들을 하나씩 처리

        System.out.println("### Stream을 활용해 HashSet객체에 저장된 객체 처리");
        Stream<String> stream = set.stream();
        stream.forEach((String value) -> System.out.println(value));
//        public void Consumer<String>(){
//            public void accept(String value){
//                System.out.println(value);
//            }
//        });

        // boolean contains(Object o)를 사용해 객체의 저장여부를 조회
        boolean isExist = set.contains("둘");
        System.out.println("존재여부 : " + isExist);

        // boolean isEmpty() 를 사용해 HashSet객체가 비어있는지 조회
        boolean isEmpty = set.isEmpty();
        System.out.println("비어있는가 ? :" + isEmpty);

        // void clear() HashSet객체에 저장된 모든 객체 삭제하기
        set.clear();

        System.out.println("비어있는가 2 ? : " + set.isEmpty());
    }
}
