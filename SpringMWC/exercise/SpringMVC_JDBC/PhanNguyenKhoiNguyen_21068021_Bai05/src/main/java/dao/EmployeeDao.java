package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import entities.Employee;

public class EmployeeDao {
   JdbcTemplate jdbcTemplate; //JdbcTemplate is a class in Spring JDBC which simplifies JDBC operations.
   
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void saveEmployee(Employee e) {
		String query = "insert into employee(name, salary, designation) values(?, ?, ?)";
		jdbcTemplate.update(query, e.getName(), e.getSalary(), e.getDesignation());  //update() method is used to execute insert, update and delete queries.
	}
	
	public void updateEmployee(Employee e) {
		String query = "update employee set name=?, salary=?, designation=? where id=?";
		jdbcTemplate.update(query, e.getName(), e.getSalary(), e.getDesignation(), e.getId());
	}
	
	public void deleteEmployee(int id) {
		String query = "delete from Employee where Id=?";
		jdbcTemplate.update(query, new Object[] { id });
	}
	//queryForObject() method is used to fetch a single row from the database.
//	public Employee getEmployeeById(int id) {
//		String query = "select * from employee where id=?";
//		return jdbcTemplate.queryForObject(query, new Object[] { id }, new BeanPropertyRowMapper<Employee>(Employee.class));
//	}
	
	
	@SuppressWarnings("deprecation")
	public Employee getEmployeeById(int id) {
	    String query = "select * from employee where id=?";
	    return jdbcTemplate.queryForObject(query, new Object[] { id }, new RowMapper<Employee>() {  //rowMapper : cung cấp một cách để ánh xạ dữ liệu từ ResultSet vào đối tượng Employee
	        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {  //mapRow() method is used to map the ResultSet data to the Employee object.
	            Employee e = new Employee();
	            e.setId(rs.getInt(1));           
	            e.setName(rs.getString(2));    
	            e.setSalary(rs.getFloat(3));  
	            e.setDesignation(rs.getString(4));  
	            return e;
	        }
	    });
	}
	//queryForObject() method is used to fetch a single row from the database.

	
	
//	public List<Employee> getEmployees() {
//		String query = "select * from employee";
//		return jdbcTemplate.query(query, new BeanPropertyRowMapper<Employee>(Employee.class));
//	}
	//BeanPropertyRowMapper : nếu tên cột trong bảng trùng với tên thuộc tính của class Employee thì nó sẽ tự động map giữa 2 bảng
	
	
	
	//Ánh xạ dữ liệu từ ResultSet vào đối tượng Employee
	//RowMapper : cung cấp một cách để ánh xạ dữ liệu từ ResultSet vào đối tượng Employee.
	public List<Employee> getEmployees() {
		return jdbcTemplate.query("select * from employee", new RowMapper<Employee>(){ 
			public Employee mapRow(ResultSet rs, int rownumber) throws SQLException {
			Employee e = new Employee();
			e.setId(rs.getInt(1));
			e.setName(rs.getString(2));
			e.setSalary(rs.getFloat(3));
			e.setDesignation(rs.getString(4));
			return e;
		}
		});
	}
}
