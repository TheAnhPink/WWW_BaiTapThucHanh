package iuh.fit.demospringdatamongodb.repo;

import iuh.fit.demospringdatamongodb.model.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends MongoRepository<Department, String> {
    @Query("{ 'employees.name': { $regex: ?0, $options: 'i' } }")
    List<Department> findByEmployeeName(String name);

    @Query("{ 'employees.salary': { $gte: ?0 } }")
    List<Department> findByEmployeeSalary(Double salary);

    @Query("{ 'employees.positionId': ?0 }")
    List<Department> findByEmployeePosition(Integer positionId);
}