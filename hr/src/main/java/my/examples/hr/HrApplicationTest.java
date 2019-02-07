package my.examples.hr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;


@SpringBootApplication
public class HrApplicationTest implements CommandLineRunner {
    @Autowired
    DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(HrApplicationTest.class, args);
    }

    @Override
    public void run(String... args) throws Exception {  // 가변형필드
        System.out.println("run 메소드가 실행됩니다.");
    }
}

