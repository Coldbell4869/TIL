package soundsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;

public class SpringExam09 {
    public static void main(String[] args) throws Exception{
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(DataSourceConfig.class);
        DataSource ds = applicationContext.getBean(DataSource.class);
        try(Connection conn = ds.getConnection()){
            System.out.println("conn is ok!");
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
