package iuh.fit.demospringjdbc.resource;


import iuh.fit.demospringjdbc.model.Employee;
import iuh.fit.demospringjdbc.service.EmployeeService;
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
    public List<Employee> getAll(){
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        return employeeService.findById(id);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id){
        return employeeService.deleteById(id);
    }
    @PatchMapping("/{id}")
    public boolean capNhat(@PathVariable int id, @RequestBody Employee e){
        return employeeService.updateEmp(id,e);
    }
    @PostMapping
    public boolean themNV(@RequestBody Employee e){
        return employeeService.themEmp(e);
    }

    @GetMapping("/timname")
    public List<Employee> searchByName(@RequestParam String name) {
        return employeeService.searchByName(name);
    }

    @GetMapping("/salary")
    public List<Employee> searchBySalary(@RequestParam Double salary) {
        return employeeService.searchBySalary(salary);
    }

    @GetMapping("/timpositionid")
    public List<Employee> searchByPosition(@RequestParam int position_id) {
        return employeeService.searchByPosition(position_id);
    }
}
