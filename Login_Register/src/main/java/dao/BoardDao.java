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
        ibatis.insert("insertBoard", board);

    }

    /**
     * 게시글 전채 행 갯수 반환
     *
     * @return 전체 행 갯수
     * @throws SQLException
     */
    public int getTotalRows() throws SQLException {
        return (Integer) ibatis.queryForObject("getTotalRows");

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
        return (List<Board>) ibatis.queryForList("getBoards", param);
    }


}
