package my.examples.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionExam02 {
    public static void main(String[] args) throws Exception{
        // Object obj = new MyBean();
        String name = "my.examples.reflection.MyBean";
        Class clazz = Class.forName(name); // 클래스 정보를 구함
        Object obj = clazz.newInstance(); // 인스턴스를 만들어라.
        MyBean myBean = (MyBean)obj;

        MyApplicationContext applicationContext =
                new MyApplicationContext();
        Object obj2 = applicationContext.getBean("hello");
        MyBean mybean2 = (MyBean)obj2;
    }
}

class MyApplicationContext{
    Object obj = null;
    public MyApplicationContext() throws Exception{
        String name = "my.examples.reflection.MyBean";
        Class clazz = Class.forName(name); // 클래스 정보를 구함
        Object obj = clazz.newInstance(); // 인스턴스를 만들어라.
    }

    public Object getBean(String name){
        return obj;
    }
}
