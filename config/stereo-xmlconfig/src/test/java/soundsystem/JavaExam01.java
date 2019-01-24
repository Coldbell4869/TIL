package soundsystem;

public class JavaExam01 {
    public static void main(String[] args){
        Data01 d1 = new Child01();
        d1.print();
    }
}

class Data01{
    public void print(){
        System.out.println(getClass().getName());
        System.out.println("print");
    }
}

class Child01 extends Data01{
    public void print(){
        super.print();
    }
}