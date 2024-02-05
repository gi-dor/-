package dao;

import com.ibatis.sqlmap.client.SqlMapClient;
import ibatis.IbatisUtil;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import vo.Todo;

public class TodoDao {

    private SqlMapClient ibatis = IbatisUtil.getSqlMapClient();

    public void insertTodo(Todo todo) throws SQLException {
        ibatis.insert("todos.insertTodo", todo);
    }

    /**
     * 조회 범위를 전달받아 범위에 맞는 일정 목록을 반환하는 메서드
     *
     * @param param
     * @return (List < Todo >) ibatis.queryForList("todos.getTodos",param)
     * @throws SQLException
     */
    public List<Todo> getTodos(Map<String, Object> param) throws SQLException {
        return (List<Todo>) ibatis.queryForList("todos.getTodos", param);
    }

    /**
     * 모든 행의 갯수를 반환 하는 메서드
     *
     * @return (int) ibatis.queryForObject("todos.getTotalRows")
     * @throws SQLException
     */
    public int getTotalRows() throws SQLException {
        return (int) ibatis.queryForObject("todos.getTotalRows");
    }
}
