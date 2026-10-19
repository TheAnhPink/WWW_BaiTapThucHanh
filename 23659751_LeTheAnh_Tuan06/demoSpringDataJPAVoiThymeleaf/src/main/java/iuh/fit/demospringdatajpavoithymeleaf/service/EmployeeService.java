package iuh.fit.demospringdatajpavoithymeleaf.service;

import iuh.fit.demospringdatajpavoithymeleaf.repo.EmployeeRepository;
import iuh.fit.demospringdatajpavoithymeleaf.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    public Employee findById(int id){
        return employeeRepository.findById(id).orElse(null);
    }

    public boolean deleteById(int id){
        if(!employeeRepository.existsById(id)){
            return false;
        }
        employeeRepository.deleteById(id);
        return true;
    }
    public Employee save(Employee e){
        return employeeRepository.save(e);
    }

    public List<Employee> findByname(String name){
        return employeeRepository.findByNameContaining(name);
    }

    public List<Employee> findEmpTheoMinLuong(double sal){
        return employeeRepository.findEmpTheoMinSalary(sal);
    }

    public List<Employee> findEmpTheoPos(int posid){
        return employeeRepository.findEmployeeByPositionId(posid);
    }

}
