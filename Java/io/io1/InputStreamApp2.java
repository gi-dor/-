package Java.io.io1;

import java.io.FileInputStream;

public class InputStreamApp2 {

    public static void main(String[] args) throws Exception {

        FileInputStream in = new FileInputStream("Java/io/io1/app3.txt");

        int len = 0;
        byte[] buf = new byte[1024];

        while ((len = in.read(buf)) != -1) {
            String text = new String(buf, 0, len);
        }
        in.close();
    }
}
