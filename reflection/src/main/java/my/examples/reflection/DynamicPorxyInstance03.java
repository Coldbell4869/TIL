package my.examples.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class DynamicPorxyInstance03 {
    public static void main(String[] args){
        Map mapProxyInstance = (Map) Proxy.newProxyInstance(
                DynamicPorxyInstance03.class.getClassLoader(), new Class[] { Map.class },
                //프록시는 HashMap에 대한 메서드를 구현한다.InvocationHandler를 implements하는 TimingDynamicInvocationHandler를 사용하여
                new TimingDynamicInvocationHandler(new HashMap<>()));

        mapProxyInstance.put("hello", "world");
        System.out.println(mapProxyInstance.get("hello"));

        CharSequence csProxyInstance = (CharSequence) Proxy.newProxyInstance(
                DynamicPorxyInstance03.class.getClassLoader(),
                new Class[] { CharSequence.class },
                new TimingDynamicInvocationHandler("Hello World"));

        System.out.println(csProxyInstance.length());
    }
}


class TimingDynamicInvocationHandler implements InvocationHandler {

    private final Map<String, Method> methods = new HashMap<>();

    private Object target;

    public TimingDynamicInvocationHandler(Object target) {
        this.target = target;
        for(Method method: target.getClass().getDeclaredMethods()) {
            this.methods.put(method.getName(), method);
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        long start = System.nanoTime();
        Object result = methods.get(method.getName()).invoke(target, args);
        long elapsed = System.nanoTime() - start;

        System.out.println("Executing {} finished in {} ns - " + method.getName() + " - "+ elapsed);

        return result;
    }
}