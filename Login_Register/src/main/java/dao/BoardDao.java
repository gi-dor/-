package dao;

import com.ibatis.sqlmap.client.SqlMapClient;
import ibatis.IbatisUtil;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import vo.Board;

public class BoardDao {

    private SqlMapClient ibatis = IbatisUtil.getSqlMapClient();

    /**
     * 신규 게시글 정보가 포함된 Board 객체를 전달받아 게시글 정보를 테이블에 저장한다
     *
     * @param board 신규 게시글 정보가 포함된 Board 객체
     * @throws SQLException
     */
    public void insertBoard(Board board) throws SQLException {
        ibatis.insert("boards.insertBoard", board);

    }

    /**
     * 게시글 전채 행 갯수 반환
     *
     * @return 전체 행 갯수
     * @throws SQLException
     */
    public int getTotalRows() throws SQLException {
        return (Integer) ibatis.queryForObject("boards.getTotalRows");

    }

    /**
     * 게시글 목록을 반환
     *
     * @param param
     * @return 게시글 목록
     * @throws SQLException
     */

    @SuppressWarnings("unckecked")
    public List<Board> getBoards(Map<String, Object> param) throws SQLException {
        return (List<Board>) ibatis.queryForList("boards.getBoards", param);
    }

    /**
     * 지정된 게시글 번호에 해당하는 게시글 상세정보를 조회해서 반환
     *
     * @param no 조회할 게시글 번호
     * @return 게시글 정보를 포함하는 Board객체
     * @throws SQLException
     */

    public Board getBoardByNo(int no) throws SQLException {
        return (Board) ibatis.queryForObject("boards.getBoardByNo", no);
    }

    /**
     * 변경된 내용이 포함된 정보를 전달받아 테이블에 번영
     *
     * @param board 변경된 내용이 포함 Board객체
     * @throws SQLException
     */
    public void updateBoard(Board board) throws SQLException {
        ibatis.update("boards.updateBoard", board);
    }

}
