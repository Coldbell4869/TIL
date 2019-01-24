package my.examples.reflection;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;

import java.util.Date;

public class CglibExam01 {
    public static void main(String[] args){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(BoardService.class);
        final Board board = new Board();
        board.setId(100L);
        board.setName("kang");
        board.setTitle("title111");
        board.setContent("content111");
        board.setReadCount(500);
        board.setRegdate(new Date());
//        enhancer.setCallback((FixedValue) () -> board);
        enhancer.setCallback(new FixedValue(){
            @Override
            public Object loadObject() throws Exception {
                System.out.println("method call!!!!");
                return board;
            }
        });
        BoardService proxy = (BoardService) enhancer.create();
        System.out.println(proxy.getClass().getName());

        Board result = proxy.getBoard(null);

        // 기존 에 BoardService에 저장되어 있는 메서드가 출력되지 않고 프록시된 board가 출력된다.
        System.out.println(result);
    }
}
