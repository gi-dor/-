package Java.collection;

import java.util.TreeSet;

public class TreeSetApp1 {
    public static void main(String[] args) {
        /*
        TreeSet<E>
            - Set<E> 구현 클래스
            - 중복된 객체의 저장을 허용하지 않느다
            - 객체가 저장될 때 오름차순으로 정렬되어 저장된다
            - TreeSet에 저장하는 객체는 반드시 Comparable<E>를 인터페이스를 구현한 객체여야 한다
            - String Wrapper 클래스는 Comparable<E> 인터페이스를 구현하고 있다
         */

        TreeSet<String> set = new TreeSet<String>();
        set.add("나타");
        set.add("가네샤");
        set.add("소패왕");
        set.add("봉추");
        set.add("현덕");

        // 자음 순서로 정렬된 걸 확인할수 있음
        for (String name : set) {
            System.out.println(name);
        }
    }
}
