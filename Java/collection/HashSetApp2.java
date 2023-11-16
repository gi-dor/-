package Java.collection;

import java.util.HashSet;
import java.util.Objects;

public class HashSetApp2 {

    public static void main(String[] args) {

        HashSet<User> set = new HashSet<>();

        set.add(new User("kim", "김유신"));
        set.add(new User("Han", "한명회"));
        set.add(new User("Han", "한명회"));
        set.add(new User("Han", "한명회"));
        set.add(new User("ryu", "류승룡"));
        set.add(new User("shin", "신라"));
        set.add(new User("kahn", "칸 케식"));
        set.add(new User("ahn", "안중근"));

        for (User u : set) {
            System.out.println(u.id + ", " + u.name + ", " + u);
        }

    }

    static class User {
        String id;
        String name;

        public User(String id, String name) {
            this.id = id;
            this.name = name;
        }

        /*
        hashCode() 와 equals() 메서드를 재정의해서
        id 값이 같은 User 객체는 같은 객체로 판단하도록 했다.
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return Objects.equals(id, user.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);    // id로만 hashCode 만들어짐 , id가 같다면 hashCode가 같다는것을 의미함
        }
    }
}

