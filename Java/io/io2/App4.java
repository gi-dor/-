package Java.io.io2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.commons.io.IOUtils;

public class App4 {

    public static void main(String[] args) throws Exception {

        String src = "C:\\Users\\Han\\Downloads/space.jpg";
        String dest = "C:\\Users\\Han\\Downloads/back_space.jpg";

        // apache- commons-io 라이브러리 사용해서 읽고 쓰기

        FileInputStream in = new FileInputStream(src);
        FileOutputStream out = new FileOutputStream(dest);

        IOUtils.copy(in, out);

    }
}
