package iuh.fit.demospringdatajdbc.repo;

import iuh.fit.demospringdatajdbc.model.Employee;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee,Integer> {
    // Spring Data JDBC sẽ tự động sinh câu SQL cho các hàm này dựa trên tên hàm
    List<Employee> findByNameContaining(String name);
    List<Employee> findBySalaryGreaterThanEqual(Double salary);
    // ko nên vì có dấu "_" nó sẽ hiểu nhầm
//    List<Employee> findByPosition_id(int position_id);

    // cach khac: tự viết câu lệnh SQL bằng @Query
    @Query("select * from employees where position_id= :positionId")
    List<Employee> timByPosition(@Param("positionId") int positionId);

    @Query("SELECT * FROM employees WHERE name LIKE concat('%', :name, '%')")
    List<Employee> searchByNameCustom(@Param("name") String name);
}
