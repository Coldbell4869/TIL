package soundsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringExam01 {
    public static void main(String[] args) throws Exception{
        // Bean 을 생성 (instance를 생성)
        // 의존성 주입(DI : Dependency Injection)
        // ApplicationContext를 개발자들은 DI 컨테이너라고 부른다. 또는 IoC 컨테이너라고 부른다(이쪽이 공식)
        ApplicationContext context
                = new ClassPathXmlApplicationContext("exam01.xml"); // 클래스패스에서 exam01.xml을 찾아서 일을 해라. (없으면 Exception 발생)

        // Spring은 기본적으로 객체를 싱글턴으로 관리한다. 메모리에 객체 하나만 생성한다.
        MyBean bean1 = (MyBean)context.getBean("bean1");    // id값으로 Object로 리턴받음
        MyBean bean11 = context.getBean("bean1", MyBean.class); // MyBean클래스에서 인스턴스로 가져와서 형변환할 필요가 없음.
        bean1.setName("홍길동");
        bean11.setName("둘리");

        if(bean1 == bean11){    // 같은 참조냐?
            System.out.println("bean1 == bean11");
        }
        System.out.println(bean11.getName());
        System.out.println(bean1.getName());

        MyBean bean2 = (MyBean)context.getBean("bean1");    // 얘까지 실행하면 세가지 인스턴스 변수가 같은 레퍼런스를 참조하게 됨.
        System.out.println(bean2.getName());

        // MyBean클래스 타입의 빈을 요청한다. 1개일 경우에만 오류가 발생하지 않는다.
        // NoUniqueBeanDefinitionException
//        MyBean bean5 = context.getBean(MyBean.class); // MyBean이 2개라서 어떤걸 골라야할지 몰라서 에러남.
//        System.out.println(bean5.getName());

        MyBean bean3 = (MyBean)context.getBean("bean2");
        System.out.println(bean3.getName());
        // null 나옴

//      bean3 라는 id의 빈은 설정되어 있지 않기 때문에 Exception이 발생한다.
        // NoSuchBeanDefinitionException
        MyBean bean4 = (MyBean)context.getBean("bean3");
        System.out.println(bean4.getName());
    }
}
