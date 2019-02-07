package my.examples.hr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class HrApplication implements CommandLineRunner{
    @Autowired
    DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(HrApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if(dataSource != null)
            System.out.println(dataSource.getClass().getName());
        System.out.println("run메소드가 실행됩니다.");
    }
}

