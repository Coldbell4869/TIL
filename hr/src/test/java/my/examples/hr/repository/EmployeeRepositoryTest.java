package my.examples.hr.repository;

import my.examples.hr.domain.Department;
import my.examples.hr.domain.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeRepositoryTest {
    @Autowired
    EmployeeRepository employeeRepository;// test할 대상

    @Test
    public void initTest() {
        // 아무런 코드가 없음. 에러가 안난다면 설정은 잘되어 있다는 뜻.
    }

    @Test
    public void getEmployees() throws Exception {
        List<Employee> all = employeeRepository.findAll();
        for (Employee e : all) {
            System.out.println(e.getFirstName() + " " + e.getLastName() + " : " + e.getEmail());
        }
    }

    @Test
    public void getDepartmentsByName() throws Exception{
        Pageable pageable = PageRequest.of(1, 3);
        Page<Employee> employeePage = employeeRepository.getEmployeeByDepartmentName("Sales", pageable);

        System.out.println(employeePage.getTotalElements());
        System.out.println(employeePage.getTotalPages());
        for(Employee e : employeePage.getContent()){
            System.out.println(e.getFirstName() + " " + e.getLastName() + " : " + e.getEmail());
        }
    }

}