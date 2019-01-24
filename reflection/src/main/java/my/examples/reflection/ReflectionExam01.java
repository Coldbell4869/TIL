package my.examples.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

// 메소드, 필드 정보를 구함
public class ReflectionExam01 {
    public static void main(String[] args) throws Exception{
        String name = "my.examples.reflection.MyBean";
        Class clazz = Class.forName(name);

        Method[] methods = clazz.getMethods();
        for(Method m : methods){
            System.out.println(m.getName());
        }

        System.out.println("----------------");
        Field[] fields = clazz.getFields();
        for(Field f : fields){
            System.out.println(f.getName());
        }
    }
}
