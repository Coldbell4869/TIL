package my.examples.miniwebserver;

public class BoxMain {
    public static void main(String[] args){
        Box box = new Box();
        Thread t1 = new Thread(new BoxThread(box, 1));
        Thread t2 = new Thread(new BoxThread(box, 2));
        Thread t3 = new Thread(new BoxThread(box, 3));
        t1.start();
        t2.start();
        t3.start();
        System.out.println("end!");
    }
}
