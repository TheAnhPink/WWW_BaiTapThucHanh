package iuh.fit.demospringjdbc.repo;

import iuh.fit.demospringjdbc.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
public interface EmployeeRepo {
    List<Employee> findAll();
    Employee findById(int id);
    boolean deleteById(int id);
    boolean updateEmp(int id, Employee eMoi);
    boolean themEmp(Employee eMoi);

    List<Employee> searchByName(String name);
    List<Employee> searchBySalary(Double salary);
    List<Employee> searchByPosition(int position_id);}
