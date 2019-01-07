package my.examples.miniwebserver.Cat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 * 채팅에 참여하는 유저 한명한명에 대한 클래스
 * 챗 유저가 필요한것은 무엇?
 * 닉네임과 채팅 유저로서 메시지를 보내는 기능, 메시지를 받는 기능
 * 그리고 이를 가능케하는 소켓이 있어야 함.
 */

public class CatUser {
    private String nickName;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    // 소켓 프로그래밍을 하려면 챗유저가 소켓을 반드시 가져야 하고 소켓은 getInputStream()과
    // getOutStream() 메소드로 소켓 바이트 통신을 한다.
    // RuntimeException이 발생하기때문에 예외처리해주어야 함.
   public CatUser(Socket socket){
        this.socket = socket;
        try{
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        }catch(Exception ex){
            throw new RuntimeException("CatUser생성시 오류");
        }
    }

    // 소켓을 열었으면 닫아줘야함. 열때랑 똑같이 Exception 처리를 해주어야 한다.
    public void close() {
        try { in.close(); } catch (Exception ignore) {}
        try { out.close(); } catch (Exception ignore) {}
        try { socket.close(); } catch (Exception ignore) {}
        }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Socket getSocket() {
        return socket;
    }

    // 소켓을 set 할 일이 없음.
//    public void setSocket(Socket socket) {
//        this.socket = socket;
//    }
    public DataInputStream getIn() {
        return in;
    }

    public void setIn(DataInputStream in) {
        this.in = in;
    }

    public DataOutputStream getOut() {
        return out;
    }

    public void setOut(DataOutputStream out) {
        this.out = out;
    }

    // 유저가 메시지를 입력하면 writeUTF() 메소드로 받아서 flush() 메소드로 out시킨다.
    public void write(String msg) {
       try {
           out.writeUTF(msg);
           out.flush();
       } catch (Exception ex) {
           throw new RuntimeException("메시지 전송 실패");
       }
    }

    // 유저가 서버로부터 메시지를 받으면 readUTF()메소드로 받아서 in 시킨다.
    public String read() {
        try {
            return in.readUTF();
        } catch (Exception ex) {
            throw new RuntimeException("메시지 읽기 실패");
        }
    }
}
