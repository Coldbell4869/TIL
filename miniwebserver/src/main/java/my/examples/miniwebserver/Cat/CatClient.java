package my.examples.miniwebserver.Cat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class CatClient {
    private String ip;
    private int port;

    public CatClient(String ip, int port){
        this.ip = ip;
        this.port = port;
    }

    public void run(){
        Socket socket = null;
        CatUser catUser = null;
        BufferedReader br = null;

        try{
            br = new BufferedReader(new InputStreamReader(System.in));
            socket = new Socket(ip, port);
            catUser = new CatUser(socket);

            System.out.println("닉네임을 입력하세요.");
            String nickName = br.readLine();
            catUser.setNickName(nickName);
            catUser.write(nickName);
            System.out.println("닉네임 : "+ nickName);
            System.out.println("/help로 명령어 확인이 가능합니다.");


            CatClientHandler catClientHandler = new CatClientHandler(catUser);
            catClientHandler.start();

            while(true){
                String line = br.readLine();
                if(line.equals("/quit")){
                    System.exit(0);
                }
                catUser.write(line);
            }

        }catch(Exception ex){
            System.out.println("접속이 끊어졌습니다.");
        }finally{
            catUser.close();
        }
    }
}
