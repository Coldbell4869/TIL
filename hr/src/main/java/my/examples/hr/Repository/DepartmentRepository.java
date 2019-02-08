package my.examples.hr.repository;

import my.examples.hr.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

// JpaRepository<엔티티클래스명, Id타입> 를 상속받는 interface를 정의한다.
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

    @Query("SELECT d FROM Department d")
    public List<Department> getDepartments();

    @Query("SELECT d FROM Department d WHERE d.departmentname = :name")
    public List<Department> getDepartmentsByName(@Param("name") String name);

    @Query("SELECT d FROM Department d WHERE d.departmentname LIKE CONCAT('%',:name,'%')")
    public List<Department> getDepartmentsWithPartOfName(@Param("name")String name);

//    @Query("SELECT d FROM Department d WHERE d.location.city LIKE CONCAT('Seattle',:name,'')")
//    public List<Department> getDepartmentsWithPartOfName(@Param("cityname")String name);
}
