package dao;

import com.ibatis.sqlmap.client.SqlMapClient;
import ibatis.IbatisUtil;
import java.sql.SQLException;
import java.util.List;
import vo.TodoCategory;

public class TodoCategoryDao {

    private SqlMapClient ibatis = IbatisUtil.getSqlMapClient();

    /**
     * getAllCategories() 메서드는 Todocategory에 이름과 번호를 전체 조회한다
     *
     * @return List로 목록해서 반환
     * @throws SQLException
     */
    public List<TodoCategory> getAllCategories() throws SQLException {
        return (List<TodoCategory>) ibatis.queryForList("todo-categories.getAllCategories");
    }


}
