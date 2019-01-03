package my.examples.miniwebserver;

public class BoxThread implements Runnable{
    private Box box;
    private int num;

    public BoxThread(Box box, int num){
        this.box = box;
        this.num = num;
    }

    @Override
    public void run() {
        if(num == 1)
            box.methodA();
        else if(num == 2)
            box.methodB();
        else if(num == 3)
            box.methodC();
    }
}
