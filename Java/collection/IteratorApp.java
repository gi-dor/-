package Java.collection;


import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteratorApp {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("진충 장창", "유림 표기", "윙드 후사르");

        System.out.println("###  일반 for문을 사용");

        // 아쉽게도 일반 for문은 List에만 쓸수 있다 Set은 불가
        int size = list.size();
        for (int index = 0; index < size; index++) {
            String name = list.get(index);
            System.out.println(name);
        }

        System.out.println();
        System.out.println("###  향상된 for문을 사용");
// 밑에 iterator 쓰는것보다 향상된 for문이 쉽고 간단하다
        for (String name : list) {
            System.out.println(name);
        }

        System.out.println();
        System.out.println("### Iterator 사용");

// 삭제가 필요할 때나 쓰자
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String name = it.next();
            System.out.println(name);
        }

        System.out.println();
        System.out.println("### Stream 사용");
        list.stream().forEach(name -> System.out.println(name));
    }
}
