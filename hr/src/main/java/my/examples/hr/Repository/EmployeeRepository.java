package my.examples.hr.repository;

import my.examples.hr.domain.Department;
import my.examples.hr.domain.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

// JpaRepository<엔티티클래스명, Id타입> 를 상속받는 interface를 정의한다.
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
//    @Query("SELECT e FROM Employee e WHERE e.department.departmentName = :departmentName")
//    public List<Employee> getEmployeeByDepartmentName(@Param("departmentName") String departmentName);

    @Query("SELECT e FROM Employee e WHERE e.department.departmentName = :departmentName ORDER BY e.firstName")
    public Page<Employee> getEmployeeByDepartmentName(@Param("departmentName") String departmentName, Pageable pageable);
}
