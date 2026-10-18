package iuh.fit.demospringjdbc.service;

import iuh.fit.demospringjdbc.model.Employee;
import iuh.fit.demospringjdbc.repo.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public List<Employee> findAll(){
        return employeeRepo.findAll();
    }
    public Employee findById(int id){
        return employeeRepo.findById(id);
    }
    public boolean deleteById(int id){
        return employeeRepo.deleteById(id);
    }
    public boolean updateEmp(int id, Employee eMoi){
        return employeeRepo.updateEmp(id,eMoi);
    }
    public boolean themEmp(Employee eMoi){
        return employeeRepo.themEmp(eMoi);
    }
    public List<Employee> searchByName(String name){
        return employeeRepo.searchByName(name);
    }

    public List<Employee> searchBySalary(Double salary){
        return employeeRepo.searchBySalary(salary);
    }

    public List<Employee> searchByPosition(int position_id){
        return employeeRepo.searchByPosition(position_id);
    }
}
