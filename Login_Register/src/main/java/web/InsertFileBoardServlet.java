package web;

import dao.FileBoardDao;
import dto.LoginUser;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import vo.FileBoard;
import vo.User;


/*
@WebServlet
    + 클래스가 HTTP 요청을 처리하는 서블릿으로 동작하게 하는 어노테이션
    + urlPatterns는 서블릿을 실행하기 위한 요청 URL 을 지정한다

@MultipartConfig
    + 멀티파트 요청을 처리할수 있는 서블릿으로 동작하게 하는 어노테이션이다
    + 어노테이션이 지정되어 있지 않으면 요청 파라미터 값을 조회할 수 없고 첨부파일 업로드도 할 수 없다

 */

@WebServlet(urlPatterns = "/file/insert")
@MultipartConfig
public class InsertFileBoardServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 요청파라미터값 조회하기
        String title = request.getParameter("title");
        String description = request.getParameter("description");

        // 업로드된 첨부파일 처리하기
        // <input type = "file" name = "upfile"> 입력필드에 대한 처리
        Part part = request.getPart("upfile");
        String fileName = System.currentTimeMillis() + part.getSubmittedFileName();
        long fileSize = part.getSize();

        // 로그인인 사용자 정보 조회하기
        HttpSession session = request.getSession();
        LoginUser loginUser = (LoginUser) session.getAttribute("LOGIN_USER");

        User user = new User();
        user.setNo(loginUser.getNo());

        // FileBoard객체를 생성해서 조회된 정보를 저장한다
        FileBoard fileBoard = new FileBoard();
        fileBoard.setTitle(title);
        fileBoard.setDescription(description);
        fileBoard.setFileName(fileName);
        fileBoard.setFileSize(fileSize);
        fileBoard.setUser(user);

        // FileBoardDao 객체생성
        FileBoardDao fileBoardDao = new FileBoardDao();

        try {
            fileBoardDao.insertFileBoard(fileBoard);
        } catch (Exception ex) {
            // TODO: handle exception
            throw new ServletException(ex);
        }

        // 업로드된 첨부파일을 원하는 폴더에 저장시킨다.
        String saveDirectory = "c:/workspace/files";
        File file = new File(saveDirectory, fileName);
        OutputStream out = new FileOutputStream(file);

        // 업로드된 첨부 파일을 읽어오는 스트림 획득
        InputStream in = part.getInputStream();

        // 기억하지마셈
        // InputStream으로 첨부파일의 정보를 읽어서 , OutputStream으로 파일을 기록한다
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = in.read(buf)) != -1) {
            out.write(buf, 0, len);
        }
        out.close();

        response.sendRedirect("list.jsp");
    }

}
