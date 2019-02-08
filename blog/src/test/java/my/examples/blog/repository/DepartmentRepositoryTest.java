package my.examples.blog.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest    // 스프링 부트에서만 사용가능한 애노테이션
public class DepartmentRepositoryTest {
//    @Autowired
//    public class DepartmentRepositoryTest // 테스트 할 대상
//    @Autowired
//    DepartmentRepository departmentRepository   // Test 할 대상

    @Test
    public void initTest(){
        // 아무런 코드가 없음. 에러가 안난다면 설정은 잘 되어 있다는 뜻.
    }


}
