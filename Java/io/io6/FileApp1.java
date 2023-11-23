package Java.io.io6;

import java.io.File;
import java.util.Date;

public class FileApp1 {

    public static void main(String[] args) {
        File file = new File("Java/io/io6/FileApp.java");

        String filename = file.getName();
        String path = file.getPath();

        long length = file.length();
        long lastModifiedUnixTime = file.lastModified();

        String path2 = file.getParent();
        String absolutePath = file.getAbsolutePath();

        System.out.println("파일명 : " + filename);
        System.out.println("전체경로 : " + path);
        System.out.println("길이 : " + length);
        System.out.println("최종 수정일자 : " + new Date(lastModifiedUnixTime));
        System.out.println("경로 : " + path2);
        System.out.println("절대경로 : " + absolutePath);
    }
}
