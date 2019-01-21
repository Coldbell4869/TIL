package soundsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringExam02 {
    public static void main(String[] args) throws Exception{
        ApplicationContext context
                = new ClassPathXmlApplicationContext("exam02.xml"); //이 xml파일을 읽을 때 어떤 일이 일어나는지 알아야 하니깐 xml을 읽을 수 있어야 함.
        System.out.println("ApplicationContext 생성 이후.");
        MyBean bean1 = context.getBean("bean1", MyBean.class);
        System.out.println(bean1.getName());
        System.out.println(bean1.getCount());
        MyBean bean2 = context.getBean("bean1", MyBean.class);
        if(bean1 == bean2){ // 같은 참조냐?
            System.out.println("bean1 == bean2");
        }else{
            System.out.println("bean1 != bean");
        }
        MyBean bean3 = context.getBean("bean2", MyBean.class);
        System.out.println(bean3.getName() + ", " + bean3.getCount());

        MyBean bean4 = context.getBean("bean3", MyBean.class);
        System.out.println(bean4.getValue("a1"));
    }
}
