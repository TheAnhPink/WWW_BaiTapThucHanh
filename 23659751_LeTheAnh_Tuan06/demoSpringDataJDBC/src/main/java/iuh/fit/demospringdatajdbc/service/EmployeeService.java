package iuh.fit.demospringdatajdbc.service;

import iuh.fit.demospringdatajdbc.model.Employee;
import iuh.fit.demospringdatajdbc.repo.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private  EmployeeRepo employeeRepo;

    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public List<Employee> findAll() {
        return (List<Employee>) employeeRepo.findAll();
    }

    public Employee findById(int id) {
        return employeeRepo.findById(id).orElse(null);
    }

    public boolean deleteById(int id) {
        if (employeeRepo.existsById(id)) {
            employeeRepo.deleteById(id);
            return true;
        }
        return false;
    }

    // Save có thể thêm mới và cập nhật
//    snếu chưa có nó sẽ thêm còn có rồi thì sửa dữ liệu
    public Employee save(Employee e) {
        return employeeRepo.save(e);
    }

    public List<Employee> searchByName(String name) {
        return employeeRepo.findByNameContaining(name);
    }

    public List<Employee> searchBySalary(Double salary) {
        return employeeRepo.findBySalaryGreaterThanEqual(salary);
    }

    public List<Employee> searchByPosition(int positionId) {
        return employeeRepo.timByPosition(positionId);
    }
}
