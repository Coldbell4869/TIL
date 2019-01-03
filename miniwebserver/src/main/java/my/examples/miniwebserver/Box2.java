package my.examples.miniwebserver;

import java.util.ArrayList;
import java.util.List;

public class Box2 {
    private List<String> list;

    public Box2(){
        list = new ArrayList<>();
    }

    public void methodA(){
        synchronized (list) {
            for (int i = 1; i < 1000; i++) {
                list.add(i + "");
            }
        }
    } // methodA

    public void methodB(){
        synchronized (list) {
            for (int i = 1; i < 1000; i++) {
                try {
                    list.remove(0);
                } catch (Exception ignore) {
                }
            }
        }
    } // methodA

    public void methodC(){
        synchronized (list) {
            for (int x = 0; x < 1000; x++) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    System.out.println(list.get(i));
                }
            }

        }
    } // methodA
}

