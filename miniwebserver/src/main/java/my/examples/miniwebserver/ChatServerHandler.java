package my.examples.miniwebserver;

import java.net.Socket;
import java.util.List;

public class ChatServerHandler extends Thread {
    private Socket socket;
    private ChatHouse chatHouse;
    public boolean inRoom;

    public ChatServerHandler(Socket socket, ChatHouse chatHouse){
        this.socket = socket;
        this.chatHouse = chatHouse;
        inRoom = false;
    }
    @Override
    public void run() {
            ChatUser chatUser = new ChatUser(socket);
            String nickname = chatUser.read();
            chatUser.setNickname(nickname);
            System.out.println("message : " + nickname);

            chatHouse.addChatUser(chatUser);

            try {
                while (true) {
                    String message = chatUser.read();
                    System.out.println("message : " + message);
                    if(!inRoom){ // 로비에 있을 경우
                        if(message.indexOf("/help") == 0) {
                            chatUser.write(" /help 명령어 확인 \n /create [방 제목] : 방을 만들어 들어갑니다. \n /list : 방 목록을 방 번호와 함께 보여줍니다. \n " +
                                    "/join [방 번호] 해당 번호의 방으로 들어갑니다. \n /out (방 안에서 입력 시) 채팅방에서 나옵니다.");
                        }
                        if(message.indexOf("/create") == 0){

                            String title = message.substring(message.indexOf(" ") +1);
                            chatHouse.createRoom(chatUser, title);
                            chatUser.write(title + " 방에 입장하셨습니다.");
                            inRoom = true;
                        }else if(message.indexOf("/list") == 0){
                                List<ChatRoom> chatRooms = chatHouse.getChatRooms();
                                int i = 0;
                                for(ChatRoom cr : chatRooms){
                                    chatUser.write(i + " : " + cr.getTitle());
                                    i++;
                            }
                        }else if(message.indexOf("/quit") == 0){
                            chatHouse.exit(chatUser);
                        }else if(message.indexOf("/join") == 0){
                            String strRoomNum = message.substring(message.indexOf(" ") +1);
                            int roomNum = Integer.parseInt(strRoomNum);
                            chatHouse.joinRoom(roomNum, chatUser);
                            chatUser.write(roomNum +"번 방에 입장하셨습니다.");
                            inRoom = true;
                        }
                    }else{ // 방안에 있을 경우
                        List<ChatUser> chatUsers = chatHouse.getUser(chatUser);
                        for(ChatUser cu : chatUsers){
                            if(message.indexOf("/out")==0){
                                chatUsers.remove(chatUser);
                                inRoom = false;
                                chatUser.write( "채팅방에서 나왔습니다. /help 로 명령어를 확인할 수 있습니다.");
                                break;
                            }
                            cu.write(chatUser.getNickname() + " : " + message);
                        }
                    }
                }
            }catch(Exception ex){
                chatHouse.exit(chatUser);
            }
        }
    }