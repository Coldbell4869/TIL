package my.examples.miniwebserver.Cat;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * 챗서버 클래스이다. 소켓 통신을 하기때문에 포트번호가 있어야 하고,
 * 챗하우스를 통해 채팅 서비스를 제공하기때문에 챗하우스를 갖고있어야 한디./
 */

public class CatServer {
    private int port;
    private CatHouse catHouse;

    public CatServer(int port){
        this.port = port;
        catHouse = new CatHouse();
    }

    // 서버 실행 메소드. 서버가 run 하면 서버소켓을 열고 accept할 대기를 시작한다.
    // 이는 서버에서 유저가 쓴 채팅 내용을 받고, 유저에게 보내는 두개의 일을 동시에 하기 위한 쓰레드 중 받는 쪽이다.
    public void run(){
        ServerSocket serverSocket = null;
        try{
            serverSocket = new ServerSocket(port);
            while(true){
                Socket socket = serverSocket.accept();
                CatServerHandler catServerHandler = new CatServerHandler(socket, catHouse);
                catServerHandler.start();
            }
        }catch (Exception ex) {
            System.out.println("오류 발생");
        }finally {
            try { serverSocket.close(); } catch (Exception ignore){}
        }
    }
}
