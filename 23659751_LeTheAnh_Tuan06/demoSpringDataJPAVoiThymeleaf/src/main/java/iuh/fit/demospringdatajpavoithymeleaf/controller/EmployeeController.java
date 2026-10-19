package iuh.fit.demospringdatajpavoithymeleaf.controller;

import iuh.fit.demospringdatajpavoithymeleaf.model.Employee;
import iuh.fit.demospringdatajpavoithymeleaf.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String getAllNV(Model model){
        List<Employee> ds= employeeService.findAll();
        model.addAttribute("dsnv",ds);
        return "listemp";
    }
    @GetMapping("/search")
    public String getById(@RequestParam("id") int id,Model model){
        Employee e= employeeService.findById(id);
        model.addAttribute("dsnv",e);
        return "listemp";
    }
}

