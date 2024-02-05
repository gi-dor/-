package dao;

import com.ibatis.sqlmap.client.SqlMapClient;
import ibatis.IbatisUtil;
import java.sql.SQLException;
import java.util.List;
import vo.Department;
import vo.Employee;

public class HrDao {


    private SqlMapClient ibatis = IbatisUtil.getSqlMapClient();


    public List<Employee> getEmployeesByDepartmentId(int deptId) throws SQLException {
        return (List<Employee>) ibatis.queryForList("hr.getEmployeesByDepartmentId", deptId);
    }

    public List<Department> getAllDepartments() throws SQLException {
        return (List<Department>) ibatis.queryForList("hr.getAllDepartments");
    }
}

