package Java.net.net4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server {

    private Map<Integer, Handler> map = new HashMap<Integer, Handler>();


    public Server() {
        // 요청번호를 key Handler구현 객체를 value 로 구성해서 Map객체에 저장
        map.put(Cmd.REQ_FILE_LIST, new ServerFileListHandler());
        map.put(Cmd.REQ_UPLOAD, new ServerFileUploadHandler());
        map.put(Cmd.REQ_DOWNLOAD, new ServerFileDownloadHandler());
    }

    /*
    클라이언트가 서버로 보내는메세지
    [REQ_FILE_LIST]
    [REQ_DOWNLOAD][doc.pdf]
    [REQ_UPLOAD][a.png][22345][xxxxxxxxxxxxx]
   */
    public void startup() throws IOException {
        System.out.println("파일서버가 기동됨");
        ServerSocket serverSocket = new ServerSocket(30000);

        while (true) {
            System.out.println("파일서버가 클라이어트의 요청을 대기중");
            Socket socket = serverSocket.accept();
            System.out.println("파일서버가 클라이언트의 요청을 접수받음");

            System.out.println("파일서버가 클라이언트와 통신할 스트림을 생성함");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            System.out.println("파일서버가 클라이언트의 요청을 분석함");
            // cmd는 1, 2, 3 중의 하나다
            // 3은 Cmd.REQ_FILE_LIST 요청이다
            // 2는 Cmd.REQ_DOWNLOAD 요청이다
            // 1은 Cmd.REQ_UPLOAD 요청이다
            // 클라이언트가 서버로 보낸 메세지에서 요청명령어 (1,2,3,중 하나)를 읽어온다
            int cmd = in.readInt();
            System.out.println("클라이언트 요청 : " + cmd);
            // Map 객체에서 cmd에 해당하는 Handler 객체를 가져온다

            // 클라이언트가 서버로 보낸 메세지의 첫번쨰 부분은 항상요청명려어다
            // 서버는 메시시에서 요청 명령어를 읽어서 Handler 구현 객체를 Map에 가져온다
            Handler handler = map.get(cmd);
            System.out.println("조회된 Handler 구현객체 : " + handler.getClass().getName());
            // 획득된 Handler 객체의 hanlde() 메소드를 실행해서 클라이언트의 요청을 처리한다
            handler.handle(in, out);
        }

    }


    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.startup();
    }

}