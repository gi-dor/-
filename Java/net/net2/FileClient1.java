package Java.net.net2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class FileClient1 {

    public static void main(String[] args) throws IOException {

        System.out.println("### 파일 클라이언트 기동됨....");
        System.out.println("### 파일 서버에 연결 요청을보냄....");
        Socket socket = new Socket("192.168.0.7", 30000);
        System.out.println("### 파일 서버와 연결이 완료됨.....");

        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream());

        // 업로드할 파일을 표현하는 File 객체 생성
        File file = new File("Java/net/net2/space.jpg");

        // 업로드할 파일을 읽어오는 FileInputStream 객체 생성
        FileInputStream fis = new FileInputStream(file);

        //  업로드할 파일명과 파일사이즈를 조회
        String filename = file.getName();
        long size = file.length();

        // 파일명과 파일사이즈를 파일서버로 보낸다
        out.writeUTF(filename);
        out.writeLong(size);

        // 파일 데이터를 파일서버로 보내기
        System.out.println("### 파일 데이터를 파이러버로 전송하기 시작함");
        int len = 0;
        byte[] buf = new byte[100];
        while ((len = fis.read(buf)) != -1) {
            out.write(buf, 0, len);
        }
        fis.close();
        System.out.println("### 파일데이터를 파일서버로 전송하기 완료함...");

    }
}
