package Java.io.io6;

import java.io.File;

public class FileApp4 {

    public static void main(String[] args) {

        File root = new File("c:/");

        // 하위 폴더명 , 파일명을 배열에 담아서 반환
//        String[] list = root.list();
//        for (String it : list) {
//            System.out.println(it);
//        }

        File[] items = root.listFiles();
        for (File item : items) {
            // 숨긴 파일인지 조사하고 , 숨긴파일을 출력되지 않게 한다
            if (item.isHidden()) {
                continue;
            }

            // 디렉토리 혹은 파일명을 조회
            String name = item.getName();
            if (item.isDirectory()) {
                System.out.println("[ " + name + " ]");
            } else {
                System.out.println(name);
            }
        }


    }
}
