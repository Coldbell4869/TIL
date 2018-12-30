package my.examples.miniwebserver;

public class ExceptionExam {
    public static void main(String[] args) {
        int i = 10;
        int j = 0;

        try{
            int k = i/j;
            System.out.println(k);
        }catch(ArithmeticException ex){
            System.out.println("0으로 나눌 수 없습니다."+ ex.toString());
        }finally{
            System.out.println("main end.");
        }
    }
}
