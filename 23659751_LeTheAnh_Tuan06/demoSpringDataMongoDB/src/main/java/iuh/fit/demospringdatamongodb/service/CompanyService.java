package iuh.fit.demospringdatamongodb.service;

import iuh.fit.demospringdatamongodb.model.Department;
import iuh.fit.demospringdatamongodb.model.Employee;
import iuh.fit.demospringdatamongodb.model.Position;
import iuh.fit.demospringdatamongodb.repo.DepartmentRepository;
import iuh.fit.demospringdatamongodb.repo.PositionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {
    private final DepartmentRepository departmentRepo;
    private final PositionRepository positionRepo;

    public CompanyService(DepartmentRepository departmentRepo, PositionRepository positionRepo) {
        this.departmentRepo = departmentRepo;
        this.positionRepo = positionRepo;
    }

    public List<Employee> getAllEmployees() {
        List<Department> depts = departmentRepo.findAll();
        List<Employee> allEmployees = new ArrayList<>();
        for (Department d : depts) {
            if (d.getEmployees() != null) {
                allEmployees.addAll(d.getEmployees());
            }
        }
        return allEmployees;
    }

    public Department addEmployeeToDepartment(String deptId, Employee emp) {
        Department dept = departmentRepo.findById(deptId).orElse(null);
        if (dept != null) {
            if (dept.getEmployees() == null) {
                dept.setEmployees(new ArrayList<>());
            }
            dept.getEmployees().add(emp);
            return departmentRepo.save(dept);
        }
        return null;
    }

    public Department updateEmployee(String deptId, Integer empId, Employee empMoi) {
        Department dept = departmentRepo.findById(deptId).orElse(null);
        if (dept != null && dept.getEmployees() != null) {
            for (Employee e : dept.getEmployees()) {
                if (e.getEmployeeId().equals(empId)) {
                    e.setName(empMoi.getName());
                    e.setRole(empMoi.getRole());
                    e.setAge(empMoi.getAge());
                    e.setSalary(empMoi.getSalary());
                    e.setPositionId(empMoi.getPositionId());
                    break;
                }
            }
            return departmentRepo.save(dept);
        }
        return null;
    }

    public Department deleteEmployee(String deptId, Integer empId) {
        Department dept = departmentRepo.findById(deptId).orElse(null);
        if (dept != null && dept.getEmployees() != null) {
            dept.getEmployees().removeIf(e -> e.getEmployeeId().equals(empId));
            return departmentRepo.save(dept);
        }
        return null;
    }

    public Employee searchById(Integer empId) {
        List<Employee> all = getAllEmployees();
        for (Employee e : all) {
            if (e.getEmployeeId().equals(empId)) {
                return e;
            }
        }
        return null;
    }

    public List<Employee> searchByName(String name) {
        return extractEmployees(departmentRepo.findByEmployeeName(name));
    }

    public List<Employee> searchBySalary(Double salary) {
        return extractEmployees(departmentRepo.findByEmployeeSalary(salary));
    }

    public List<Employee> searchByPosition(Integer positionId) {
        return extractEmployees(departmentRepo.findByEmployeePosition(positionId));
    }

    private List<Employee> extractEmployees(List<Department> depts) {
        List<Employee> result = new ArrayList<>();
        for (Department d : depts) {
            if (d.getEmployees() != null) {
                result.addAll(d.getEmployees());
            }
        }
        return result;
    }

    public List<Department> getAllDepartments() {
        return departmentRepo.findAll();
    }

    public Department getDepartmentById(String id) {
        return departmentRepo.findById(id).orElse(null);
    }

    public List<Position> getAllPositions() {
        return positionRepo.findAll();
    }
}