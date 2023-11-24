package Java.io.io4;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputApp1 {

    public static void main(String[] args) throws IOException {

        String name = "galaxy22";
        String company = "samsung";
        int price = 1000000;
        double dis = 0.01;

        DataOutputStream out = new DataOutputStream(
                new FileOutputStream("Java/io/io4/sample.jpg"));

        out.writeUTF(name);
        out.writeUTF(company);


    }
}
