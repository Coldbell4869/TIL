package my.examples.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

public class DynamicPorxyInstance01 {
    public static void main(String[] args){
        Map proxyInstance = (Map) Proxy.newProxyInstance(
                // 클래스 정보를 읽어 들임 - getClassLoader
                DynamicPorxyInstance01.class.getClassLoader(),
                new Class[] { Map.class },
                new DynamicInvocationHandler());
        System.out.println(proxyInstance.getClass().getName());
        proxyInstance.put("hello", "world");
        // 인스턴스가 존재하지 않아도 동적으로 인스턴스가 생성됨.
        System.out.println(proxyInstance.get("hello"));
    }
}

// 람다 인터페이스 : 메서드가 하나뿐인 인터페이스
class DynamicInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        System.out.println("메소드 실행 : " +  method.getName());
        return "haha";
    }
}