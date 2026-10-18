package iuh.fit.demospringdatamongodb.resource;

import iuh.fit.demospringdatamongodb.model.Department;
import iuh.fit.demospringdatamongodb.service.CompanyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentResource {
    private final CompanyService companyService;

    public DepartmentResource(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<Department> getAll() {
        return companyService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public Department getById(@PathVariable String id) {
        return companyService.getDepartmentById(id);
    }
}