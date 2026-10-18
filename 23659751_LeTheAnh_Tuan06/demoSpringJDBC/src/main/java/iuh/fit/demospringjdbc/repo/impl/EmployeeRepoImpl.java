package iuh.fit.demospringjdbc.repo.impl;

import iuh.fit.demospringjdbc.model.Employee;
import iuh.fit.demospringjdbc.repo.EmployeeRepo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

@Repository
public class EmployeeRepoImpl implements EmployeeRepo {
    private final JdbcTemplate jdbcTemplate;

    public EmployeeRepoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public RowMapper<Employee> rowMap(){
        return(rs,numRow)->{
            Employee e= new Employee();
            e.setId(rs.getInt(1));
            e.setName(rs.getString(2));
            e.setRole(rs.getString(3));
            e.setSalary(rs.getDouble(4));
            e.setDepartment_id(rs.getInt(5));
            e.setPosition_id(rs.getInt(6));
            return e;
        };
    }

    public List<Employee> findAll() {
        String sql= "select * from employees";
        return jdbcTemplate.query(sql,(rs,rowNum)->{
            Employee e= new Employee();
            e.setId(rs.getInt(1));
            e.setName(rs.getString(2));
            e.setRole(rs.getString(3));
            e.setSalary(rs.getDouble(4));
            e.setDepartment_id(rs.getInt(5));
            e.setPosition_id(rs.getInt(6));
            return e;
        });
    }

    public Employee findById(int id) {
        String sql="select * from employees where id=?";
        return jdbcTemplate.queryForObject(sql,rowMap(),id);
    }

    public boolean deleteById(int id) {
        String sql= "delete from employees where id=?";
        return jdbcTemplate.update(sql,id) >0;

    }

    public boolean updateEmp(int id, Employee eMoi) {
        String sql= "update employees set NAME=?, ROLE=?, salary=?, department_id=?, position_id=? " +
                "WHERE id=?";
        return jdbcTemplate.update(sql, eMoi.getName(),eMoi.getRole(),
                eMoi.getSalary(),eMoi.getDepartment_id(),eMoi.getPosition_id(),id) >0;
    }

    @Override
    public boolean themEmp(Employee eMoi) {
        String sql= "insert into employees (name,role,salary,department_id,position_id) values(?,?,?,?,?)";
        return jdbcTemplate.update(sql,eMoi.getName(),eMoi.getRole(),
                eMoi.getSalary(),eMoi.getDepartment_id(),eMoi.getPosition_id()) > 0;
    }

    @Override
    public List<Employee> searchByName(String name) {
        String sql = "SELECT * FROM employees WHERE name LIKE ?";
        return jdbcTemplate.query(sql, rowMap(), "%" + name + "%");
    }

    @Override
    public List<Employee> searchBySalary(Double salary) {
        String sql = "SELECT * FROM employees WHERE salary >= ?";
        return jdbcTemplate.query(sql, rowMap(), salary);    }

    @Override
    public List<Employee> searchByPosition(int position_id) {
        String sql = "SELECT * FROM employees WHERE position_id = ?";
        return jdbcTemplate.query(sql, rowMap(), position_id);
    }
}
