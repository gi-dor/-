package Java.exception.exception1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class App2 {

    public static void main(String[] args) {

        /*
        FileNotFoundEexcption
         */

        try {
            Properties prop = new Properties();
            prop.load(new FileReader("config.properties"));
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
            System.out.println("파일을 찾을수 없다");
        } catch (IOException ex) {
            System.out.println(ex);

        }
        System.out.println("");
    }
//        prop.load(new FileReader("config.properties"));
    // 처리 되지 않은예외 : java.io.FileNoException
}


