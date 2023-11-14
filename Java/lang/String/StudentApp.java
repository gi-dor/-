package Java.lang.String;

import java.util.Arrays;

public class StudentApp {
    public static void main(String[] args) {

        Student[] arr = {
                new Student(10, "나타"),
                new Student(4, "치도"),
                new Student(1, "카타나"),
                new Student(7, "쯔바이"),
                new Student(3, "윙드후사르"),
                new Student(5, "케식")
        };

        Arrays.sort(arr);

        for (Student value : arr) {
            System.out.println(value.no + " " + value.name);
        }

    }
}
