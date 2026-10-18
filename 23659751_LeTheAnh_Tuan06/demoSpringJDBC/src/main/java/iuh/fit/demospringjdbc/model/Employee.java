package iuh.fit.demospringjdbc.model;

public class Employee {
    private Integer id;
    private String name;
    private String role;
    private double salary;
    private int department_id;
    private int position_id;

    public Employee() {
    }

    public Employee(Integer id, String name, String role, double salary, int department_id, int position_id) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.salary = salary;
        this.department_id = department_id;
        this.position_id = position_id;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public int getPosition_id() {
        return position_id;
    }

    public void setPosition_id(int position_id) {
        this.position_id = position_id;
    }
}
