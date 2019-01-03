package my.examples.miniwebserver;

public class Box {
    public synchronized void methodA(){
        for(int i = 0; i < 10; i++){
            System.out.print("A");
            try {
                Thread.sleep((int) (Math.random() * 1000));
            }catch(Exception ignore){}
        }
    } // methodA

    public synchronized void methodB(){
        for(int i = 0; i < 10; i++){
            System.out.print("B");
            try {
                Thread.sleep((int) (Math.random() * 1000));
            }catch(Exception ignore){}
        }
    } // methodA

    public synchronized void methodC(){
        for(int i = 0; i < 10; i++){
            System.out.print("C");
            try {
                Thread.sleep((int) (Math.random() * 1000));
            }catch(Exception ignore){}
        }
    } // methodA
}

