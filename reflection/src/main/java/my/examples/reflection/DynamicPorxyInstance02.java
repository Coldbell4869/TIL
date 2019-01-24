package my.examples.reflection;

import java.lang.reflect.Proxy;
import java.util.Map;

public class DynamicPorxyInstance02 {
    public static void main(String[] args){
        Map proxyInstance = (Map) Proxy.newProxyInstance(
                DynamicPorxyInstance02.class.getClassLoader(),
                new Class[] { Map.class },
                (proxy, method, methodArgs) -> {
                    if (method.getName().equals("get")) {
                        return "haha";
                    } else {
                        throw new UnsupportedOperationException(
                                "Unsupported method: " + method.getName());
                    }
                });

        System.out.println(proxyInstance.getClass().getName());
        String value = (String) proxyInstance.get("hello");
        System.out.println(value);
        proxyInstance.put("hello", "world"); // exception
    }
}
