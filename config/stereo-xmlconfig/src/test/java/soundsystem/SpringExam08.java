package soundsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import soundsystem.book.BookService;

import javax.sql.DataSource;
import java.sql.Connection;

public class SpringExam08 {
    public static void main(String[] args) throws Exception{
        ApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource ds = applicationContext.getBean(DataSource.class);
        try(Connection conn = ds.getConnection()){
            System.out.println("conn is ok!");
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
