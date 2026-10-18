package iuh.fit.demospringdatajpa.service;

import iuh.fit.demospringdatajpa.model.Employee;
import iuh.fit.demospringdatajpa.repo.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
    public List<Employee> findAll() {
        return employeeRepo.findAll();
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

    public Employee save(Employee e) {
        return employeeRepo.save(e);
    }

    // Các hàm tìm kiếm
    public List<Employee> searchByName(String name) {
        return employeeRepo.findByNameContaining(name);
    }

    public List<Employee> searchBySalary(Double salary) {
        return employeeRepo.findBySalaryGreaterThanEqual(salary);
    }

    public List<Employee> searchByPosition(int positionId) {
        return employeeRepo.searchByPosition(positionId);
    }
}
