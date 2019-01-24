package my.examples.reflection;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ReflectionExam03 {
    public static void main(String[] args) throws Exception {
        Map<String, String> map =
                new HashMap<>();
        map.put("Name", "kim");
        map.put("Title", "java!!!!!!!");

        String name = "my.examples.reflection.MyBean";
        Class clazz = Class.forName(name); // 클래스 정보를 구함
        Object obj = clazz.newInstance(); // 인스턴스를 만들어라.

        // 메소드 이름만 가지고 실행.
//        String methodName = "setName";
//        Method method = clazz.getMethod(methodName, new Class[]{String.class});
//        method.invoke(obj, new Object[]{"hong"});
//
//        MyBean myBean = (MyBean)obj;
//        System.out.println(myBean.getName());


        // 자동으로 set메소드를 호출
        Set<String> keys = map.keySet();
        for(String key : keys){
            String value = map.get(key);
            String methodName = "set" + key;
            Method method = clazz.getMethod(methodName, new Class[]{String.class});
            method.invoke(obj, new Object[]{value});
        }

        // 자동으로 get을 호출
        Set<String> keys2 = map.keySet();
        for(String key : keys2){
            String value = map.get(key);
            String methodName = "get" + key;
            Method method = clazz.getMethod(methodName, null);
            String result = (String)method.invoke(obj, null);
            System.out.println(result);
        }
    }
}
