package my.examples.hr.repository;

import my.examples.hr.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// JpaRepository<엔티티클래스명, Id타입> 를 상속받는 interface를 정의한다.
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{
}
