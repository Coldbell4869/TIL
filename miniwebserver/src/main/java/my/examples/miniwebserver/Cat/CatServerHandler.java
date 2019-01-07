package my.examples.miniwebserver.Cat;

import java.net.Socket;
import java.util.List;

/**
 * 채팅서버를 제어하는 컨트롤러, 핸들러 클래스이다.
 * 쓰레드를 상속받아 챗서버에서 쓰레드를 생성하여 따로 돌게 한다.
 * 챗하우스와 소켓을 생성자로 가지며 서버에서 이런저런 일을 처리하는 클래스.
 */

public class CatServerHandler extends Thread {
    private CatHouse catHouse;
    private Socket socket;
    private boolean inRoom;

    public CatServerHandler(Socket socket, CatHouse catHouse){
        this.catHouse = catHouse;
        this.socket=socket;
        inRoom = false;
    }

    // run() 메소드를 오버라이드해서 서버쪽에서 대기하는 쓰레드와는 다른 쓰레드에서 유저의 행동을 받는 역할인듯?
    @Override
    public void run() {
        CatUser catUser = new CatUser(socket);
        String nickname = catUser.read();
        String roomName="";
        catUser.setNickName(nickname);
        System.out.println("message : " + nickname);

        catHouse.addLobbyUser(catUser);
        try{
            while(true){
                String message = catUser.read();

                if(!inRoom){

                    switch (message){
                        case "/help":{
                            catUser.write(" --- 로비 명령어 --- \n /help 명령어 확인 \n /create : 방을 만들고 들어갑니다. " +
                                    "\n /list : 방 목록을 방 번호와 함께 보여줍니다. \n /join 해당 번호의 방으로 들어갑니다. " +
                                    "\n /delete 방에 아무도 없을 때, 해당 번호의 방을 폭파합니다. \n /who 전체 유저를 보여줍니다. \n /quit 채팅 프로그램을 종료합니다. " +
                                    "\n --- 채팅방 내 명령어 --- \n /who 채팅방 안에 있는 사람들을 보여줍니다. \n /out 채팅방에서 나옵니다. \n ");
                            break;
                        }
                        case "/create":{
                            String flag ="";
                            String password;
                            catUser.write("비밀방을 만드시겠습니까 ? (y/n)");
                            flag = catUser.read().toUpperCase();
                            if(flag.equals("Y")){
                                catUser.write("방 제목을 입력하세요 : ");
                                roomName = catUser.read();
                                catUser.write(roomName + " 방의 비밀번호를 설정하세요 . :");
                                password = catUser.read();
                                catHouse.createPasswordRoom(catUser,roomName,password);

                            }else if(flag.equals("N")){
                                catUser.write("방 제목을 입력하세요 : ");
                                roomName = catUser.read();
                                catHouse.createRoom(catUser,roomName);

                            }else{
                                catUser.write("방을 만들 수 없습니다.");
                                break;
                            }
                            catUser.write(roomName+" 에 입장 하셨습니다.");
                            inRoom =true;
                            break;
                        }
                        case "/join":{
                            List<CatRoom> rooms = catHouse.getRooms();
                            String strRoomNum="";
                            String password;
                            int roomNum=0;
                            RoomList(catUser, rooms);
                            catUser.write("입장할 방 번호를 입력하세요. : ");
                            strRoomNum = catUser.read();
                            roomNum = Integer.parseInt(strRoomNum);
                            if(rooms.get(roomNum).getPassword()!=null){
                                catUser.write("비밀번호를 입력하세요. : ");
                                password = catUser.read();
                                if(rooms.get(roomNum).getPassword().equals(password)){
                                    catHouse.joinRoom(roomNum, catUser,password);
                                }else{
                                    catUser.write("비밀번호가 틀렸습니다. 로비로 돌아갑니다. \n /help 로 명령어를 확인하실 수 있습니다.");
                                    break;
                                }
                            }else {
                                catHouse.joinRoom(roomNum, catUser);
                            }
                            catUser.write(rooms.get(roomNum).getTitle()+" 방에 입장 하셨습니다.");
                            inRoom =true;
                            break;
                        }
                        case "/list":{
                            List<CatRoom> rooms = catHouse.getRooms();
                            RoomList(catUser, rooms);
                            break;
                        }
                        case "/delete":{
                            List<CatRoom> rooms = catHouse.getRooms();

                            int i=0;
                            int j=0;
                            for(CatRoom cr:rooms){
                                catUser.write(i+" : "+cr.getTitle());
                                i++;
                            }
                            catUser.write("폭파시킬 방 번호를 입력하세요 : ");
                            String strRoomNum="";
                            int roomNum = 0;
                            strRoomNum = catUser.read();
                            roomNum = Integer.parseInt(strRoomNum);

                            if(rooms.get(roomNum).getRoom().size() == 0){
                                rooms.remove(roomNum);
                                catUser.write(roomNum+" 번 방이 폭파되었습니다.");
                                RoomList(catUser, rooms);
                            }else{
                                catUser.write("방에 사람이 있습니다.");
                            }

                            break;

                        }

                        case "/who": {
                            List<CatUser> lobby = catHouse.getLobby();
                            catUser.write(" --- 전체 채팅 유저 목록 --- ");
                            for (CatUser cu : lobby) {
                                catUser.write(cu.getNickName());
                            }
                            catUser.write("총 " + lobby.size() + " 명의 유저가 채팅중입니다.");
                        }
                    }
                }else{//방안에 있을 때
                    List<CatUser> catUsers = catHouse.getUser(catUser);
                    for(CatUser cu:catUsers){
                        if(message.equals("/out")){
                            catUsers.remove(catUser);
                            inRoom = false;
                            catUser.write( "채팅방에서 나왔습니다. 로비로 돌아갑니다. \n/help 로 명령어를 확인할 수 있습니다.");
                            break;
                        }else if(message.equals("/who")){
                            catUser.write(" --- '" + roomName + "' 방 유저 목록 --- ");
                            for (CatUser ru : catUsers) {
                                catUser.write(ru.getNickName());
                            }
                            catUser.write("총 " + catUsers.size() + " 명의 유저가 " +roomName + " 방에 있습니다.");
                        }

                        cu.write(catUser.getNickName()+" : "+message);
                    }

                }
            }

        }catch(Exception ex){
            catHouse.exit(catUser);
        }
    }

    private void RoomList(CatUser catUser, List<CatRoom> rooms) {
        /*
        아래 코드들이 중복이 되어 나타나서 따로 메서드를 생성했습니다^^7
         */
        int i=0;
        catUser.write(" --- 현재 열려있는 방 목록 --- ");
        for(CatRoom cr:rooms){
            catUser.write(i+" : "+cr.getTitle());
            i++;
        }
    }
}
