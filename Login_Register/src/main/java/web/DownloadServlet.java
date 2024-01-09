package web;

import dao.FileBoardDao;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import vo.FileBoard;


@WebServlet(urlPatterns = "/file/download")
public class DownloadServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /*
         * 요청 URL
         * 		localhost/comm/file/download?no=1000000
         *
         * 요청 파라미터
         * 		no = xxxx
         * 		no는 파일 게시글 번호다
         *
         */

        // 요청 파라미터 값 조회
        try {
            int fileBoardNo = Integer.valueOf(request.getParameter("no"));

            FileBoardDao fileBoardDao = new FileBoardDao();
            FileBoard fb = fileBoardDao.getFileBoardByNo(fileBoardNo);

            String directory = "c:/workspace/files";
            String fileName = fb.getFileName();
            String realFileName = fb.getRealFileName();
            long fileSize = fb.getFileSize();

            // 응답컨텐츠의 타입을 지정한다.
            response.setContentType("application/octet-stream");

            // 응답컨텐츠의 길이를 지정한다
            response.setContentLengthLong(fileSize);

            // 응답메세지의 헤더에 다운로드되는 첨부파일의 이름을 지정한다
            // Content-Disposition은 응답 메세지의 바디부에 오는 컨텐츠의 특성을 알려주는 헤더정보
            String encodedFileName = URLEncoder.encode(realFileName, "UTF-8");
            response.setHeader("Content-Disposition", "attachement; filename=" + encodedFileName);

            // 다운로드할 파일을 읽어오는 스트림을 생성한다
            InputStream in = new FileInputStream(new File(directory, fileName));

            // 브라우저로 이진 데이터를 출력하는 스트림을 획득
            OutputStream out = response.getOutputStream();

            // InputStream으로 읽어온 데이터를 OutputStream으로 내려보낸다
            IOUtils.copy(in, out);

        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

    }

}
