package iuh.fit.demospringdatajpavoithymeleaf.repo;

import iuh.fit.demospringdatajpavoithymeleaf.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee>  findByNameContaining(String name);

//    DUngf JPQL
    @Query("select e from Employee e where e.salary >= :minsal")
    List<Employee> findEmpTheoMinSalary(@Param("minsal") double salary);

    List<Employee> findEmployeeByPositionId(int PosId);
}
