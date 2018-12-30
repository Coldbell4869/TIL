package my.examples.miniwebserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
    private int port;

    public WebServer(int port){
        this.port = port;
    }

    public void run(){
        // 접속을 대기하고 있다.
        ServerSocket serverSocket = null;
        try{
            serverSocket = new ServerSocket(port);
            while(true){
                System.out.println("접속을 대기합니다.");
                Socket socket = serverSocket.accept();  // 클라이언트가 접속할때까지 대기
                HttpHandler httpHandler = new HttpHandler(socket);
                httpHandler.start(); // 쓰레드를 실행한다.
            }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }finally{
          try{ serverSocket.close(); }catch(Exception ignore){}
        }
    }

    class HttpHandler extends Thread {
        private Socket socket;

        public HttpHandler(Socket socket) {
            this.socket = socket;
        }
        public void run(){ // 별도로 동작할 코드는 run메소드에서 작성한다.
            BufferedReader in = null;
            PrintStream out = null;
            try{
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintStream(socket.getOutputStream());

                String requestLine = in.readLine();
                String line = null;
                while((line = in.readLine()) != null){ // 빈줄까지 읽어들인다.
                    if("".equals(line)){
                        break;
                    }
                    System.out.println("헤더정보 : " + line );
                }

                out.println("HTTP/1.1 200 OK");
                out.println("content-type: text/html; charset=UTF-8");
                out.println();
                out.println("<html><h1>HELLO</H1></html>");
            }catch(Exception ex){
                ex.printStackTrace();
            }finally {
                try{ in.close(); }catch(Exception ignore){}
                try{ out.close(); }catch(Exception ignore){}
                try{ socket.close(); }catch(Exception ignore){}
            }
        }
    }
}

