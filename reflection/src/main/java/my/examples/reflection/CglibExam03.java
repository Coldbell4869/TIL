package my.examples.reflection;

import net.sf.cglib.beans.BeanGenerator;

import java.lang.reflect.Method;

public class CglibExam03 {
    public static void main(String[] args) throws Exception{
        BeanGenerator beanGenerator = new BeanGenerator();

        beanGenerator.addProperty("name", String.class); // name 프로퍼티를 가지는 인스턴스를 생성한다.
        Object myBean = beanGenerator.create();
        System.out.println(myBean.getClass().getName());
        Method setter = myBean.getClass().getMethod("setName", String.class);
        setter.invoke(myBean, "kim");

        Method getter = myBean.getClass().getMethod("getName");
        System.out.println(getter.invoke(myBean, null));
    }
}
