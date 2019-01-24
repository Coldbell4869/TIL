package my.examples.reflection;

import net.sf.cglib.proxy.Mixin;

public class CglibExam04 {
    public static void main(String[] args) throws Exception{
        // 여러개의 인터페이스를 구현하고 있는 인터페이스를 동적으로 사용하기 위해서 Mixin으로 구현할 수 있다.
        Mixin mixin = Mixin.create(
                new Class[]{ Interface1.class, Interface2.class, MixinInterface.class },
                new Object[]{ new Class1(), new Class2() }
        );
        MixinInterface mixinDelegate = (MixinInterface) mixin;
        System.out.println(mixinDelegate.getClass().getName());

        System.out.println(mixinDelegate.hello());
        System.out.println(mixinDelegate.world());
    }
}

interface Interface1 {
    String hello();
}

interface Interface2 {
    String world();
}

class Class1 implements Interface1 {
    @Override
    public String hello() {
        return "hello method!";
    }
}

class Class2 implements Interface2 {
    @Override
    public String world() {
        return "world method!";
    }
}

interface MixinInterface extends Interface1, Interface2 { }

