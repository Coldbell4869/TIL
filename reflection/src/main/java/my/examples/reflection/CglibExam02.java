package my.examples.reflection;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

import java.util.Date;

public class CglibExam02 {
    public static void main(String[] args){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(BoardService.class);
        enhancer.setCallback((MethodInterceptor) (obj, method, methodArgs, proxy) -> {
            if (method.getDeclaringClass() != Object.class && method.getReturnType() == Board.class) { // return 타입이 Board일 경우
                Board board = new Board();
                board.setId(100L);
                board.setName("kang");
                board.setTitle("title111");
                board.setContent("content111");
                board.setReadCount(500);
                board.setRegdate(new Date());

                return board;
            } else if(method.getReturnType().equals(Void.TYPE)){ // void 를 리턴할 경우
                System.out.println(method.getName());
                long start = System.nanoTime();
                Object result = proxy.invokeSuper(obj, methodArgs);
                System.out.println(System.nanoTime() - start);
                return result;
            } else{
                return proxy.invokeSuper(obj, methodArgs);
            }
        });

        BoardService proxy = (BoardService)enhancer.create();

        System.out.println(proxy.getBoard(null));

        Board board = new Board();
        board.setId(200L);
        board.setName("kim");
        board.setTitle("title222");
        board.setContent("content222");
        board.setReadCount(1000);
        board.setRegdate(new Date());
        proxy.addBoard(board);
    }
}
