package soundsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringExam01 {
    public static void main(String[] args) throws Exception{
        // Bean 을 생성 (instance를 생성)
        // 의존성 주입(DI)
        // ApplicationContext를 개발자들은 DI 컨테이너라고 부른다. IoC 컨테이너 (공식용어)
        ApplicationContext context
                = new ClassPathXmlApplicationContext("exam01.xml");

        // Spring은 기본적으로 객체를 싱글턴으로 관리한다.
        MyBean bean1 = (MyBean)context.getBean("bean1");
        MyBean bean11 = context.getBean("bean1", MyBean.class);
        bean1.setName("홍길동");
        if(bean1 == bean11){ // 같은 참조냐?
            System.out.println("bean1 == bean11");
        }
        System.out.println(bean11.getName());

        MyBean bean2 = (MyBean)context.getBean("bean1");
        System.out.println(bean2.getName());
//
//        // MyBean클래스 타입의 빈을 요청한다. 1개일 경우에만 오류가 발생하지 않는다.
//        // NoUniqueBeanDefinitionException
//        MyBean bean5 = context.getBean(MyBean.class);
//        System.out.println(bean5.getName());
//
        MyBean bean3 = (MyBean)context.getBean("bean2");
        System.out.println(bean3.getName());
//
////      bean3 라는 id의 빈은 설정되어 있지 않기 때문에 Exception이 발생한다.
//        // NoSuchBeanDefinitionException
        MyBean bean4 = (MyBean)context.getBean("bean3");
        System.out.println(bean4.getName());
    }
}
