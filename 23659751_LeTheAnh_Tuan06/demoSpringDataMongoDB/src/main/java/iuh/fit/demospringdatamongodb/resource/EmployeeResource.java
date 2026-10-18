package iuh.fit.demospringdatamongodb.resource;

import iuh.fit.demospringdatamongodb.model.Department;
import iuh.fit.demospringdatamongodb.model.Employee;
import iuh.fit.demospringdatamongodb.service.CompanyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeResource {
    private final CompanyService companyService;

    public EmployeeResource(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<Employee> getAll() {
        return companyService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Integer id) {
        return companyService.searchById(id);
    }

    @PostMapping("/department/{deptId}")
    public Department create(@PathVariable String deptId, @RequestBody Employee emp) {
        return companyService.addEmployeeToDepartment(deptId, emp);
    }

    @PutMapping("/department/{deptId}/employee/{empId}")
    public Department update(@PathVariable String deptId, @PathVariable Integer empId, @RequestBody Employee emp) {
        return companyService.updateEmployee(deptId, empId, emp);
    }

    @DeleteMapping("/department/{deptId}/employee/{empId}")
    public Department delete(@PathVariable String deptId, @PathVariable Integer empId) {
        return companyService.deleteEmployee(deptId, empId);
    }

    @GetMapping("/search/name")
    public List<Employee> searchByName(@RequestParam String name) {
        return companyService.searchByName(name);
    }

    @GetMapping("/search/salary")
    public List<Employee> searchBySalary(@RequestParam Double salary) {
        return companyService.searchBySalary(salary);
    }

    @GetMapping("/search/position")
    public List<Employee> searchByPosition(@RequestParam Integer positionId) {
        return companyService.searchByPosition(positionId);
    }
}