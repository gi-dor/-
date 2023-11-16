package Java.collection;

import java.util.ArrayList;

public class ArrayListApp1 {
    public static void main(String[] args) {

        /*
        ArrayList<E>
            - List<E> 인터페이스를 구현한 클래스
            - 가변길이 배열을 활용해 List<E> 인터페이스를 구현했따
            - 순서가 보장되는 자료구조 구현 클래스다
            - 가장많이 사용되는 자료구 구현 클래스다
         */

        // String 객체를 여러개 저장할수 있는 ArrayList 객체를 생성했다
        ArrayList<String> list = new ArrayList<String>();

        // boolean add (E e); - ArrayList 객체에 순서대로 객체를 저장 , 맨마지막 번쨰 객체 다음에 저장
        list.add("나타");
        list.add("시바");
        list.add("아수라");
        list.add("가네샤");
        list.add("헌원");
        list.add("여와");
        list.add("치우");
        list.add("치우");
        list.add("치우");

        // int size() : ArrayList 객체에 저장된 객체의 갯수 반환
        int size = list.size();
        System.out.println("저장된 객체의 갯수 : " + size);

        // 중복까지 허용 해서 카운팅 하네

        // 향상된 for each 문으로 ArrayList 객체에 저장된 String 객체 처리하기
        for (String str : list) {
            System.out.println(str);
        }
        // 순서대로 저장하고 , 순서대로 출력함
        // 중복 신경안씀
        // 정렬 신경안씀

    }
}
