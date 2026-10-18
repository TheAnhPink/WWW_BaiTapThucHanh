package iuh.fit.demospringdatajdbc.resource;

import iuh.fit.demospringdatajdbc.model.Employee;
import iuh.fit.demospringdatajdbc.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeResource {
    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping
    public List<Employee> getAll() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeService.findById(id);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id) {
        return employeeService.deleteById(id);
    }

    // Dùng chung hàm save cho cả thrrm và Cập nhật
    @PostMapping
    public Employee save(@RequestBody Employee e) {
        return employeeService.save(e);
    }

    @GetMapping("/search/name")
    public List<Employee> searchByName(@RequestParam String name) {
        return employeeService.searchByName(name);
    }

    @GetMapping("/search/salary")
    public List<Employee> searchBySalary(@RequestParam Double salary) {
        return employeeService.searchBySalary(salary);
    }

    @GetMapping("/search/position")
    public List<Employee> searchByPosition(@RequestParam int positionId) {
        return employeeService.searchByPosition(positionId);
    }
}
