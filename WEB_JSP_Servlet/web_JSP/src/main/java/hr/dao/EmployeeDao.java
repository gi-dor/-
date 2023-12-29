package hr.dao;

import java.util.List;

import helper.JdbcTemplate;
import hr.dto.EmpListDto;
import hr.vo.Employee;

public class EmployeeDao {
	

	public List<EmpListDto> getEmployees(int start, int end){
		String sql = """
				SELECT 
					   X.EMPLOYEE_ID,
				       X.FIRST_NAME,
				       X.PHONE_NUMBER,
				       X.HIRE_DATE,
				       X.JOB_ID,
				       D.DEPARTMENT_NAME
				FROM (SELECT
						  ROW_NUMBER() OVER (ORDER BY EMPLOYEE_ID DESC) NUM,
						  EMPLOYEE_ID, FIRST_NAME, PHONE_NUMBER, HIRE_DATE,
						  JOB_ID, DEPARTMENT_ID
					  FROM  
					  		EMPLOYEES)  X, DEPARTMENTS D
				WHERE X.NUM BETWEEN ? AND ?
				AND X.DEPARTMENT_ID = D.DEPARTMENT_ID(+)
						""";
		return JdbcTemplate.selectList(sql, rs -> {
			EmpListDto dto = new EmpListDto();
			dto.setId(rs.getInt("employee_id"));
			dto.setFirstName(rs.getString("first_name"));
			dto.setPhoneNumber(rs.getString("phone_number"));
			dto.setHireDate(rs.getDate("hire_date"));
			dto.setJobId(rs.getString("job_id"));
			dto.setDepartmentName(rs.getString("department_name"));
			return dto;	
		}, start, end);
	}
	
	public int getTotalRows() {
		String sql = """
				SELECT COUNT(*) CNT
				FROM EMPLOYEES
				""";
		return  JdbcTemplate.selectOne(sql, rs-> {
			int cnt = rs.getInt("cnt");
			return cnt;
		});
	}
	
	
	public void insertEmployee(Employee emp) {
		String sql = """
				INSERT INTO EMPLOYEES
				(EMPLOYEE_ID, 
				FIRST_NAME,
				LAST_NAME,
				EMAIL,
				PHONE_NUMBER,
				HIRE_DATE,
				JOB_ID,
				SALARY,
				COMMISSION_PCT,
				DEPARTMENT_ID)
				VALUES
				(EMPLOYEES_SEQ.nextval,?,?,?,?,?,?,?,?,?)
				""";
	
		JdbcTemplate.insert(sql, emp.getFirstName(),
								 emp.getLastName(),
								 emp.getEmail(),
								 emp.getPhoneNumber(),
								 emp.getHireDate(),
								 emp.getJobId(),
								 emp.getSalary(),
								 emp.getCommissionPct(),
								 emp.getDepartmentId());
	}
}
