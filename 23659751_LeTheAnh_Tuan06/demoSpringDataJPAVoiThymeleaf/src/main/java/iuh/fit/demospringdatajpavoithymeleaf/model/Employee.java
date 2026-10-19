package iuh.fit.demospringdatajpavoithymeleaf.model;

import jakarta.persistence.*;

@Entity
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String role;
    private Double salary;
    @Column(name = "department_id")
    private Integer departmentId;
    @Column(name = "position_id")
    private Integer positionId;

    public Employee() {
    }

    public Employee(Integer id, String name, String role, Double salary, Integer departmentId, Integer positionId) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.salary = salary;
        this.departmentId = departmentId;
        this.positionId = positionId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }
}
