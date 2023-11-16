package Java.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListApp2 {

    public static void main(String[] args) {

        // new 키워드를 이용해서 List 인터페이스를 구현한 ArrayList 객체 생성
        List<String> names = new ArrayList<String>();

        names.add("여와");
        names.add("헌원");
        names.add("신농");
        names.add("치우");

        // Arrays 클래스 정적메서드 asList(T.....t)
        List<String> names2 = Arrays.asList("항우", "유방", "사마의", "사마착");

        // List 인터페이스의 정적 메서드 of(E  e)를 이용해 List 인터페이스 구현객체 생성
        List<String> names3 = List.of("항우", "유방", "사마의", "사마착");


    }
}
