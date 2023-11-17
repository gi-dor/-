package Java.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorApp2 {
    public static void main(String[] args) {

        // List는 중복 상관 안함, 순서 있음
        List<String> list = new ArrayList<>();
        list.add("칸 케식");
        list.add("철부도");
        list.add("철부도");
        list.add("척가군");
        list.add("비화군");
        list.add("비화군");
        list.add("신책");

        // list객체에서 처음으로 발견된 객체만 삭제
        list.remove("철부도");
        System.out.println("### 일반 출력");
        System.out.println(list);   // [칸 케식, 철부도, 척가군, 비화군, 비화군, 신책]

        System.out.println();
        System.out.println("### 일반 for문");

        for (String name : list) {
            System.out.println(name);
        }

        System.out.println();
        System.out.println("### 향상된 for문");
        // 향상 for문으로 ArrayList에 저장된 요소 반복해서 조회
        //  for문으로 반복 하는동안 컬렉션 저장된 객체 삭제 안된다잉
        for (String name : list) {
//            if (name.equals("비화군")) {
//                list.remove(name);  // Exception in thread "main" java.util.ConcurrentModificationException
//            }
            System.out.println(name);
        }

        System.out.println();
        System.out.println("### Iterator ");
        Iterator<String> it = list.iterator();

        // 삭제를 위해 Iterator 사용
        // Iterator 구현객체를 이용해 ArrayList 요소 반복해서 조회

        while (it.hasNext()) {
            String name = it.next();
            if ("비화군".equals(name)) {
                it.remove();
            }
        }
        System.out.println(list);

//        System.out.println("### 삭제 없이 일반 조화");
//        while (it.hasNext()) {    // boolean hasNext() 읽을 요소가 있는지 확인하기
//            String name = it.next();    // Object next() 다음 요소 읽기
//            System.out.println(name);
//        }
    }
}
