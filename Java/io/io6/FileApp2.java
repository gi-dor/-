package Java.io.io6;

import java.io.File;
import java.io.IOException;

public class FileApp2 {

    public static void main(String[] args) throws IOException {

        // 현재 존재하지 않는 파일이나 디렉토리에 대해서 File객체를 생성 할 수 있다.
        // createNewFile() 메서드는 사이즈가 0 인 파일 생성

        // mkdir() 메서드는 디렉토리 생성
        // mkdirs() 메서드는 한번에 하위 디렉토리까지 포함시켜서 생성
        // delete() 메서드는 파일 , 디렉토리를 삭제
        // 디렉토리는 디렉토리 안에 파일이나 하위 디렉토리가 있으면 삭제가 안된다

        File file1 = new File("Java/io/io6/FileApp1.java");
        File file2 = new File("Java/io/io6", "FileApp1.java");
        File file3 = new File(new File("Java/io/io6"), "FileApp1.java");

        // 새 파일 만들기

        file1.createNewFile();
        file2.createNewFile();
        file3.createNewFile();

        // 디렉토리 만들기
        File dir1 = new File("Java/io/io6/app");
        File dir2 = new File("Java/io/io6/app/sample/files");

        dir1.mkdir();
        dir2.mkdirs();

        // 파일 삭제하기
        file1.delete();

        // 디렉토리 삭제하기
        dir2.delete();          // "Java/io/io6/app/sample/files" 경로에서
        // files가 삭제되고 Java/io/io6/app/sample 가 남아있다.

        dir1.delete();  // 디렉토리를 삭제하기 위해서는 디렉토리 내부에 아무것도 없어야 한다,.
    }
}
